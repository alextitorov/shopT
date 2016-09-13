package com.service;


import com.dto.SaleProductInRangeDetailed;
import com.dto.TotalSaleReport;

import java.util.List;

public interface SaleService {
    public List<SaleProductInRangeDetailed> saleListInRange();
    public List<SaleProductInRangeDetailed> saleListInRangePagination(int pageId, int maxResults);
    public List<TotalSaleReport> totalSaleReport();
    public int numberItemsTheSaleRangeReport();
}

