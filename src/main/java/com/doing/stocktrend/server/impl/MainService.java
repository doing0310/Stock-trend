package com.doing.stocktrend.server.impl;

import com.doing.stocktrend.bean.Stock;
import com.doing.stocktrend.bean.Stock2;
import com.doing.stocktrend.mapper.MainMapper;
import com.doing.stocktrend.server.IMainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MainService implements IMainService {

    @Autowired
    private MainMapper mainMapper;

    @Override
    public void insertStock(Stock stock) {
        mainMapper.insertStock(stock);
    }
    @Override
    public void deleteStock() {
        mainMapper.deleteStock();
    }

    @Override
    public void deleteStock2() {
        mainMapper.deleteStock2();
    }

    @Override
    public void insertStock2(Stock2 stock) {
        mainMapper.insertStock2(stock);
    }
}
