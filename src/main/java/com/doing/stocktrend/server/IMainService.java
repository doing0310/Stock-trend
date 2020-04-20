package com.doing.stocktrend.server;

import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.bean.Stock2;

import java.util.List;

public interface IMainService {
    void insertStock(Stock stock);

    void deleteStock();

    void deleteStock2();

    void insertStock2(Stock2 stock);
}
