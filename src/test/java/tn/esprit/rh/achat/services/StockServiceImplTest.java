/*package tn.esprit.rh.achat.services;


import org.junit.jupiter.api.MethodOrderer.OrderAnnotation;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
@SpringBootTest
@TestMethodOrder(OrderAnnotation.class)
class StockServiceImplTest {

    @Autowired
    IStockService St;

    @Test
    @Order(1)
    void retrieveAllStocks() {
        List<Stock> listUsers = St.retrieveAllStocks();
        assertEquals(0, listUsers.size());
    }

    @Test
    void addStock() {
        Stock s1 = new Stock();
        s1.setLibelleStock("stock test");
        s1.setQte(10);
        s1.setQteMin(100);
        Stock savedStock1= St.addStock(s1);
        assertEquals(s1.getLibelleStock(), savedStock1.getLibelleStock());
    }

    @Test
    void deleteStock() {
        St.deleteStock(0L);
    }

    @Test
    void updateStock() {
        Stock s1= St.retrieveStock(0L);
        s1.setQte(100);
        Stock updatedStock1= St.updateStock(s1);
        assertEquals(s1.getQte(), updatedStock1.getQte());
    }

    @Test
    void retrieveStock() {
        St.retrieveStock(0L);
    }

    @Test
    void retrieveStatusStock() {
        St.retrieveStatusStock();
    }


}*/



