package com.doing.stocktrend.bean;

import java.util.Date;

public class Stock {
    /**
     * 股票实体类
     */
    private String DateType;
    private Date HdDate;
    private String Hkcode;
    private String SCode;    /** 股票代码 */
    private String SName;    /** 股票名称 */
    private String HYName; /** 股票行业 */
    private String HYCode;
    private String ORIGINALCODE;
    private String DQName;
    private String DQCode;
    private String ORIGINALCODE_DQ;
    private int JG_SUM;
    private double SharesRate;   /** 股票涨幅 % */
    private double NewPrice;    /** 收盘价格 */
    private double Zdf;/** 股票今日涨幅 */
    private String Market;
    private long ShareHold;    /** 股票持股数 */
    private double ShareSZ;/** 股票持股市值*/
    private double LTZB;
    private double ZZB;
    private double LTSZ;
    private double ZSZ;
    private int ShareHold_Before_One;
    private int ShareSZ_Before_One;
    /** 股票增长持股数 % */
    private long ShareHold_Chg_One;
    /** 股票增长市值 */
    private double ShareSZ_Chg_One;
    private double ShareSZ_Chg_Rate_One;
    private double LTZB_One;
    private double ZZB_One;
    public void setDateType(String DateType) {
        this.DateType = DateType;
    }
    public String getDateType() {
        return DateType;
    }

    public void setHdDate(Date HdDate) {
        this.HdDate = HdDate;
    }
    public Date getHdDate() {
        return HdDate;
    }

    public void setHkcode(String Hkcode) {
        this.Hkcode = Hkcode;
    }
    public String getHkcode() {
        return Hkcode;
    }

    public void setSCode(String SCode) {
        this.SCode = SCode;
    }
    public String getSCode() {
        return SCode;
    }

    public void setSName(String SName) {
        this.SName = SName;
    }
    public String getSName() {
        return SName;
    }

    public void setHYName(String HYName) {
        this.HYName = HYName;
    }
    public String getHYName() {
        return HYName;
    }

    public void setHYCode(String HYCode) {
        this.HYCode = HYCode;
    }
    public String getHYCode() {
        return HYCode;
    }

    public void setORIGINALCODE(String ORIGINALCODE) {
        this.ORIGINALCODE = ORIGINALCODE;
    }
    public String getORIGINALCODE() {
        return ORIGINALCODE;
    }

    public void setDQName(String DQName) {
        this.DQName = DQName;
    }
    public String getDQName() {
        return DQName;
    }

    public void setDQCode(String DQCode) {
        this.DQCode = DQCode;
    }
    public String getDQCode() {
        return DQCode;
    }

    public void setORIGINALCODE_DQ(String ORIGINALCODE_DQ) {
        this.ORIGINALCODE_DQ = ORIGINALCODE_DQ;
    }
    public String getORIGINALCODE_DQ() {
        return ORIGINALCODE_DQ;
    }

    public void setJG_SUM(int JG_SUM) {
        this.JG_SUM = JG_SUM;
    }
    public int getJG_SUM() {
        return JG_SUM;
    }

    public void setSharesRate(double SharesRate) {
        this.SharesRate = SharesRate;
    }
    public double getSharesRate() {
        return SharesRate;
    }

    public void setNewPrice(double NewPrice) {
        this.NewPrice = NewPrice;
    }
    public double getNewPrice() {
        return NewPrice;
    }

    public void setZdf(double Zdf) {
        this.Zdf = Zdf;
    }
    public double getZdf() {
        return Zdf;
    }

    public void setMarket(String Market) {
        this.Market = Market;
    }
    public String getMarket() {
        return Market;
    }

    public void setShareHold(long ShareHold) {
        this.ShareHold = ShareHold;
    }
    public long getShareHold() {
        return ShareHold;
    }

    public void setShareSZ(double ShareSZ) {
        this.ShareSZ = ShareSZ;
    }
    public double getShareSZ() {
        return ShareSZ;
    }

    public void setLTZB(double LTZB) {
        this.LTZB = LTZB;
    }
    public double getLTZB() {
        return LTZB;
    }

    public void setZZB(double ZZB) {
        this.ZZB = ZZB;
    }
    public double getZZB() {
        return ZZB;
    }

    public void setLTSZ(double LTSZ) {
        this.LTSZ = LTSZ;
    }
    public double getLTSZ() {
        return LTSZ;
    }

    public void setZSZ(double ZSZ) {
        this.ZSZ = ZSZ;
    }
    public double getZSZ() {
        return ZSZ;
    }

    public void setShareHold_Before_One(int ShareHold_Before_One) {
        this.ShareHold_Before_One = ShareHold_Before_One;
    }
    public int getShareHold_Before_One() {
        return ShareHold_Before_One;
    }

    public void setShareSZ_Before_One(int ShareSZ_Before_One) {
        this.ShareSZ_Before_One = ShareSZ_Before_One;
    }
    public int getShareSZ_Before_One() {
        return ShareSZ_Before_One;
    }

    public void setShareHold_Chg_One(long ShareHold_Chg_One) {
        this.ShareHold_Chg_One = ShareHold_Chg_One;
    }
    public long getShareHold_Chg_One() {
        return ShareHold_Chg_One;
    }

    public void setShareSZ_Chg_One(double ShareSZ_Chg_One) {
        this.ShareSZ_Chg_One = ShareSZ_Chg_One;
    }
    public double getShareSZ_Chg_One() {
        return ShareSZ_Chg_One;
    }

    public void setShareSZ_Chg_Rate_One(double ShareSZ_Chg_Rate_One) {
        this.ShareSZ_Chg_Rate_One = ShareSZ_Chg_Rate_One;
    }
    public double getShareSZ_Chg_Rate_One() {
        return ShareSZ_Chg_Rate_One;
    }

    public void setLTZB_One(double LTZB_One) {
        this.LTZB_One = LTZB_One;
    }
    public double getLTZB_One() {
        return LTZB_One;
    }

    public void setZZB_One(double ZZB_One) {
        this.ZZB_One = ZZB_One;
    }
    public double getZZB_One() {
        return ZZB_One;
    }

    public Stock() {
    }

    public Stock(String dateType, Date hdDate, String hkcode, String SCode, String SName, String HYName, String HYCode, String ORIGINALCODE, String DQName, String DQCode, String ORIGINALCODE_DQ, int JG_SUM, double sharesRate, double newPrice, double zdf, String market, long shareHold, double shareSZ, double LTZB, double ZZB, double LTSZ, double ZSZ, int shareHold_Before_One, int shareSZ_Before_One, long shareHold_Chg_One, double shareSZ_Chg_One, double shareSZ_Chg_Rate_One, double LTZB_One, double ZZB_One) {
        DateType = dateType;
        HdDate = hdDate;
        Hkcode = hkcode;
        this.SCode = SCode;
        this.SName = SName;
        this.HYName = HYName;
        this.HYCode = HYCode;
        this.ORIGINALCODE = ORIGINALCODE;
        this.DQName = DQName;
        this.DQCode = DQCode;
        this.ORIGINALCODE_DQ = ORIGINALCODE_DQ;
        this.JG_SUM = JG_SUM;
        SharesRate = sharesRate;
        NewPrice = newPrice;
        Zdf = zdf;
        Market = market;
        ShareHold = shareHold;
        ShareSZ = shareSZ;
        this.LTZB = LTZB;
        this.ZZB = ZZB;
        this.LTSZ = LTSZ;
        this.ZSZ = ZSZ;
        ShareHold_Before_One = shareHold_Before_One;
        ShareSZ_Before_One = shareSZ_Before_One;
        ShareHold_Chg_One = shareHold_Chg_One;
        ShareSZ_Chg_One = shareSZ_Chg_One;
        ShareSZ_Chg_Rate_One = shareSZ_Chg_Rate_One;
        this.LTZB_One = LTZB_One;
        this.ZZB_One = ZZB_One;
    }

    @Override
    public String toString() {
        return "Stock{" +
                "DateType='" + DateType + '\'' +
                ", HdDate=" + HdDate +
                ", Hkcode='" + Hkcode + '\'' +
                ", SCode='" + SCode + '\'' +
                ", SName='" + SName + '\'' +
                ", HYName='" + HYName + '\'' +
                ", HYCode='" + HYCode + '\'' +
                ", ORIGINALCODE='" + ORIGINALCODE + '\'' +
                ", DQName='" + DQName + '\'' +
                ", DQCode='" + DQCode + '\'' +
                ", ORIGINALCODE_DQ='" + ORIGINALCODE_DQ + '\'' +
                ", JG_SUM=" + JG_SUM +
                ", SharesRate=" + SharesRate +
                ", NewPrice=" + NewPrice +
                ", Zdf=" + Zdf +
                ", Market='" + Market + '\'' +
                ", ShareHold=" + ShareHold +
                ", ShareSZ=" + ShareSZ +
                ", LTZB=" + LTZB +
                ", ZZB=" + ZZB +
                ", LTSZ=" + LTSZ +
                ", ZSZ=" + ZSZ +
                ", ShareHold_Before_One=" + ShareHold_Before_One +
                ", ShareSZ_Before_One=" + ShareSZ_Before_One +
                ", ShareHold_Chg_One=" + ShareHold_Chg_One +
                ", ShareSZ_Chg_One=" + ShareSZ_Chg_One +
                ", ShareSZ_Chg_Rate_One=" + ShareSZ_Chg_Rate_One +
                ", LTZB_One=" + LTZB_One +
                ", ZZB_One=" + ZZB_One +
                '}';
    }
}