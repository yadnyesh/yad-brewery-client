package io.yadnyesh.yadbreweryclient.client;

import io.yadnyesh.yadbreweryclient.model.BeerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Slf4j
class BreweryClientTest {
	
	@Autowired
	BreweryClient breweryClient;
	
	@Test
	void getBeerById() {
		BeerDto beerDto = breweryClient.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
	}
	
	@Test
	void testSaveNewBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		URI uri = breweryClient.saveNewBeer(beerDto);
		assertNotNull(uri);
		log.info(uri.toString());
	}
	
	@Test
	void testUpdateBeer() {
		BeerDto beerDto = BeerDto.builder().beerName("New Beer").build();
		breweryClient.updateBeer(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void testDeleteBeer() {
		breweryClient.deleteBeerById(UUID.randomUUID());
	}
	
}