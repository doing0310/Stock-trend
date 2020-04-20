package com.doing.stocktrend.mapper;

import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.bean.Stock2;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface MainMapper {

    void insertStock(Stock stock);

    void deleteStock();

    void deleteStock2();

    void insertStock2(Stock2 stock);
}
