package com;

import java.math.BigDecimal;

public interface PricingService {
 void setDataAccess(DataAccess dataAccess);
 BigDecimal getPrice(String sku) throws Exception; 
}
