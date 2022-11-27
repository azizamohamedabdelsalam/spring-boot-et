package com.cd.fawatery.stockheaderlistpercsmapi.data;

import com.cd.fawatery.stockheaderlistpercsmapi.model.StockHeader;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.util.List;

public interface StockHeaderListRepository extends MongoRepository<StockHeader,String> {
    List<StockHeader> findBycsmNo(String csmNo);
}
