package com.service;

import com.dao.SaleDAO;
import com.dto.FinalStatisticSaleForPeriod;
import com.dto.StatisticOnSaleDTO;
import com.dto.util.PaginationBuilder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional(readOnly = true)
public class SaleServiceImpl implements SaleService {

    @Autowired
    private SaleDAO saleDAO;


    @Override
    public List<StatisticOnSaleDTO> getStatisticOnSale(PaginationBuilder paginationBuilder) {
        return saleDAO.getStatisticOnSale(paginationBuilder);
    }

    @Override
    public FinalStatisticSaleForPeriod getFinalStatisticSaleForPeriod() {
        return saleDAO.getFinalStatisticSaleForPeriod();
    }

    @Override
    public int numberItemsTheSaleRangeReport() {
        return saleDAO.numberItemsTheSaleRangeReport();
    }

    @Override
    @Transactional
    public void aggregateSalesOfProductInTheLastHour() {
        saleDAO.aggregateSalesOfProductInTheLastHour();
    }

}
