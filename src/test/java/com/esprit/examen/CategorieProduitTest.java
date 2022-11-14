package com.esprit.examen;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import com.esprit.examen.entities.CategorieProduit;
import com.esprit.examen.repositories.CategorieProduitRepository;
import com.esprit.examen.services.CategorieProduitServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;



import lombok.extern.slf4j.Slf4j;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.mockito.ArgumentMatchers;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.MockitoJUnitRunner;


import java.util.Optional;

import static org.mockito.Matchers.anyLong;
import static org.mockito.ArgumentMatchers.*;

import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.anyInt;
import static org.mockito.Mockito.mock;

import static org.hamcrest.CoreMatchers.is;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.mockito.BDDMockito.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;


@Slf4j
@SpringBootTest
@RunWith(MockitoJUnitRunner.class)
public class CategorieProduitTest {

    @Mock
    CategorieProduitRepository catrepo;
    @InjectMocks
    CategorieProduitServiceImpl catserv;

    @Test
    public void addCategorieProduitTest() {
        CategorieProduit categorieproduit = new CategorieProduit();
        categorieproduit.setCodeCategorie("120");//test

        Mockito.when(catrepo.save(ArgumentMatchers.any(CategorieProduit.class))).thenReturn(categorieproduit );

        CategorieProduit cat_save = catserv.addCategorieProduit((categorieproduit));

        assertThat(cat_save.getCodeCategorie()).isSameAs(cat_save.getCodeCategorie());
        verify(catrepo).save(cat_save);
    }


    @Test
    public void RetrieveAll() {
        List<CategorieProduit> categories = new ArrayList<>();
        categories.add(new CategorieProduit());

        when(catrepo.findAll()).thenReturn(categories);

        List<CategorieProduit> expected = catserv.retrieveAllCategorieProduits();

        assertEquals(expected, categories);
        verify(catrepo).findAll();
    }

    @Test
    public void DeleteCategorieProduitIfExistTest() {
        CategorieProduit categorie = new CategorieProduit();
        categorie.setIdCategorieProduit(1L);
        categorie.setCodeCategorie("120");
        categorie.setLibelleCategorie("libelle2");


        Mockito.when(catrepo.findById(categorie.getIdCategorieProduit())).thenReturn(Optional.of(categorie));
        catserv.deleteCategorieProduit(categorie.getIdCategorieProduit());
        verify(catrepo).deleteById(categorie.getIdCategorieProduit());
    };

    @Test()
    public void delete_categorie_produit_doesnt_exist() {
        CategorieProduit categorie = new CategorieProduit ();
        categorie.setIdCategorieProduit(1L);
        categorie.setCodeCategorie("120");
        categorie.setLibelleCategorie("libelle2");
        given(catrepo.findById(anyLong())).willReturn(Optional.ofNullable(null));
        catrepo.deleteById(categorie.getIdCategorieProduit());
    }

}
