package com.doing.stocktrend.Buildingtables;

import java.io.File;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 *
 * DB_URL 数据库url 注:应以'/'结尾 而且不应该带数据库名
 * DATABASE 数据库名
 * IS_CREATE_DATABASE 是否创建数据库 如果true且数据库存在会发生Exception异常
 * USER 账号
 * PASS 密码
 * FILE_PATH 要生成数据库表的Bean文件所在的文件夹
 * map key是数据库表名，value是字段名数组
 * IS_Alter_TABLE 是否修改数据库名
 * IS_CREATE_TABLE  是否新建表
 *
 * @author doing
 * 有bugger需要改进
 */
public class Instance {

    private static final String JDBC_DRIVER = "com.mysql.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/";
    private static final String DATABASE = "testdb";
    private static final boolean IS_CREATE_DATABASE = false;
    private static final boolean IS_Dentify_TABLE = true;
    private static final boolean IS_CREATE_TABLE = true;
    private static final String USER = "root";
    private static final String PASS = "root";
    private static final String FILE_PATH = "D:\\work\\idea\\IntelliJIDEAPlace\\back\\stock-trend\\src\\main\\java\\com\\doing\\stocktrend\\bean";
    private static StringBuffer sb = new StringBuffer();
    private static Map<String, List<String[]>> map = new HashMap();
    private static int index;


    public static void main(String[] args) throws Exception {
        Class.forName(JDBC_DRIVER);
        //是否要创建数据库
        if(IS_CREATE_DATABASE){
            String sql = "create database "+DATABASE+" character set utf8 collate utf8_general_ci";
            if(!executeUpdate(DB_URL, sql)){
                System.err.println("创建数据库失败.");
                throw new Exception();
            }
        }
        //将实体bean文件遍历 然后逐一添加到容器当中
        File file = new File(FILE_PATH);
        File[] files = file.listFiles();
        int ch;
        for (File f : files) {
            if(f.isFile() && f.getName().endsWith(".java")){
                FileReader fileReader = new FileReader(f);
                sb.delete(0,sb.length());
                index = 0;
                while ((ch=fileReader.read())!=-1){
                    sb.append((char)ch);
                }
                try {
                    //调用jx方法，把bean的信息添加到map集合当中去；
                    jx();
                } catch (Exception e){
                    System.err.println("文件:"+f.getName()+"不是Bean");
                }

                fileReader.close();
            }
        }
        //遍历map集合的key获得表名，通过表名来建表
        for (String s : map.keySet()) {
            if (IS_CREATE_TABLE) {
                String sql = createSQL(s);

                if(!executeUpdate(DB_URL+DATABASE,sql)){
                    System.err.println("创建"+s+"表失败:"+sql);
                }
            }
            System.out.println("用户不创建"+s+"表");
        }

        /**
         * create by: chen
         * description:  批量修改数据库表名
         * create time: 2019/9/25
         */
        for (String s : map.keySet()){
            if (IS_Dentify_TABLE){
                String sql ="ALTER  TABLE "+s+" RENAME TO "+"t_"+s.toLowerCase();
                if (!executeUpdate(DB_URL+DATABASE,sql)){
                    System.out.println("修改"+s+"表失败:"+sql);
                }

            }
        }

    }

    /**
     * change方法用于修改domain类型对应的数据库类型
     * @param s 接收的bean文件 属性类型
     * @return 数据库要创建的类型
     */
    public static String change(String s){
        switch (s){
            case "java.util.Date":
                s ="date";
                break;
            case "long":
            case "Long":
                s = "BIGINT";
                break;
            case "String":
            case "BigDecimal":
                s = "VARCHAR(255)";
                break;
        }
        return s;
    }

    /**
     * createSQL 方法为生成数据库的建表语句 可以根据需要修改
     * @param s 数据表名
     * @return 创建数据表的SQL语句
     */
    public static String createSQL(String s){
        String sql = "CREATE TABLE "+s+" (";

        List<String[]> list = map.get(s);

        String[] id = deleteId(list);
        sql += id[1]+" "+id[0]+" not NULL AUTO_INCREMENT,";
        for (String[] strs : list) {
            sql +=strs[1]+" "+strs[0]+",";
        }

        sql += "PRIMARY KEY ( "+id[1]+" )";
        sql+= ")";
        return sql;
    }

    public static String[] deleteId(List<String[]> list){
        for (int i=0;i<list.size();i++) {
            if(list.get(i)[1].equalsIgnoreCase("id")){
                return list.remove(i);
            }
        }
        return list.remove(0);
    }

    public static void jx() throws Exception {
        //获得表名称
        String tableName = jxStr("public class ", " ", null);
        if(tableName!=null){
            ArrayList<String[]> list = new ArrayList<>();
            //获得字段名称数组
            String str;
            while ((str=jxStr("private ", ";", "class "))!=null){
                str = removeRedundantSpaces(str);
                String[] split = str.split(" ");
                if(split.length==2){
                    list.add(new String[]{change(split[0]), split[1]});
                }
            }
            //添加到map里
            map.put(removeRedundantSpaces(tableName), list);
        }
    }
    /**
     * create by: chen
     * description: 改方法是删除冗余空间的
     * create time: 2019/10/10
     */
    public static String removeRedundantSpaces(String s){
        s = s.trim();
        return s.replaceAll("\\s+", " ");
    }


    public static String jxStr(String startStr, String endStr, String abnormal) throws Exception {
        String str = sb.toString();
        if(abnormal!=null && str.indexOf(abnormal, index)!=-1){
            throw new Exception();
        }
        int i = str.indexOf(startStr, index);
        if(i!=-1){
            int i1 = str.indexOf(endStr, i+startStr.length());
            if(i1!=-1){
                index = i1+endStr.length();
                return str.substring(i + startStr.length(), i1);
            }
        }
        return null;
    }

    public static boolean executeUpdate(String dbUrl,String sql) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = DriverManager.getConnection(dbUrl+DATABASE, USER, PASS);
            stmt = conn.createStatement();
            System.out.println(111);
            stmt.executeUpdate(sql);
        } catch (Exception e) {
            return false;
        }finally {
            if(conn!=null){
                try {
                    conn.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
            if(stmt!=null){
                try {
                    stmt.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }
        }
        return true;
    }

}