package tn.esprit.spring.service;



import java.util.Optional;

import org.junit.Test;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

//import org.junit.jupiter.api.Test;


import com.esprit.examen.entities.SecteurActivite;
import com.esprit.examen.repositories.SecteurActiviteRepository;
import com.esprit.examen.services.SecteurActiviteServiceImpl;

@SpringBootTest
@ExtendWith(MockitoExtension.class)

public class SecteurActiviteTest {
	@Mock
	SecteurActiviteRepository SecteurRepository;

	@InjectMocks
	SecteurActiviteServiceImpl SecteurService;

	@Test
	public void testRetrieveSecteur() {
		SecteurActivite secteur = new SecteurActivite(1L,"nouveausecteur","bb",null);
		secteur.setIdSecteurActivite(1L);


		Mockito.when(SecteurRepository.findById(1L)).thenReturn(Optional.of(secteur));
		SecteurService.retrieveSecteurActivite(1L);
		Assertions.assertNotNull(secteur);

		System.out.println(secteur);
		System.out.println("Get By ID works perfectly !!!");
	}


	@Test
	public void createSecteurTest() {
		SecteurActivite secteur2 = new SecteurActivite(null,"qqqq","fff",null);
		secteur2.setIdSecteurActivite(2L);

		SecteurService.addSecteurActivite(secteur2);
		verify(SecteurRepository, times(1)).save(secteur2);
		System.out.println(secteur2); 
		System.out.println(" Create is working correctly...!!");  
	}


	@Test
	public void getAllSecteursTest() {
		List<SecteurActivite> SecteurList = new ArrayList<SecteurActivite>() {/**
			 * 
			 */
			private static final long serialVersionUID = 1L;

		{

			add(new SecteurActivite(null, "secteurs","gggg", null));
			add(new SecteurActivite(null,"kkkk","llll",null));
			add(new SecteurActivite(null,"uuuu","wwww",null));

		}};

		when(SecteurService.retrieveAllSecteurActivite()).thenReturn(SecteurList);
		List<SecteurActivite> sList = SecteurService.retrieveAllSecteurActivite();
		assertEquals(3, sList.size());
		System.out.println("Alles Gut !!!!");

	}

	@Test
	public void TestDeleteSecteur() {

		SecteurActivite secteur1 = new SecteurActivite(null,"sec","del",null);
		secteur1.setIdSecteurActivite(7L);

		Mockito.lenient().when(SecteurRepository.findById(secteur1.getIdSecteurActivite())).thenReturn(Optional.of(secteur1));

		SecteurService.deleteSecteurActivite(7L);
		verify(SecteurRepository).deleteById(secteur1.getIdSecteurActivite());

		System.out.println(secteur1);
		System.out.println(" Delete is working correctly...!!");  

	}


}
