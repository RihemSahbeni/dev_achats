package tn.esprit.rh.achat.services;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;
import tn.esprit.rh.achat.entities.Stock;
import tn.esprit.rh.achat.repositories.StockRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@SpringBootTest
@ExtendWith(MockitoExtension.class)
class StockServiceImplMock {

    @Mock
    StockRepository stockRepository;
    @InjectMocks
    StockServiceImpl StI;

    Stock stock = new Stock("libelleStock1", 10, 3);
    List<Stock> listStocks = new ArrayList<Stock>() {
        {
            add(new Stock("libelleStock2", 20, 5));
            add(new Stock("libelleStock3", 30, 8));
        }
    };


    @Test
    void retrieveStock() {
        Mockito.when(stockRepository.findById(Mockito.anyLong())).thenReturn(Optional.of(stock));
        Stock stock1 = StI.retrieveStock(0L);
        Assertions.assertNotNull(stock1);
    }

    @Test
    void retrieveAllStocks() {
        Mockito.when(stockRepository.findAll()).thenReturn(listStocks);
        List<Stock> list = StI.retrieveAllStocks();
        Assertions.assertNotNull(list);
    }
}