package io.yadnyesh.yadbreweryclient.client;

import io.yadnyesh.yadbreweryclient.model.CustomerDto;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URI;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertNotNull;

@SpringBootTest
@Slf4j
public class CustomerClientTest {
	
	@Autowired
	CustomerClient customerClient;
	
	@Test
	void getCustomerById() {
		CustomerDto dto = customerClient.getCustomerById(UUID.randomUUID());
		assertNotNull(dto);
	}
	
	@Test
	void testSaveNewCustomer() {
		//given
		CustomerDto customerDto = CustomerDto.builder().name("Joe").build();
		
		URI uri = customerClient.saveNewCustomer(customerDto);
		assertNotNull(uri);
		log.info(uri.toString());
		
	}
	
	@Test
	void testUpdateCustomer() {
		CustomerDto customerDto = CustomerDto.builder().name("Jim").build();
		customerClient.updateCustomer(UUID.randomUUID(), customerDto);
		
	}
	
	@Test
	void testDeleteCustomer() {
		customerClient.deleteCustomer(UUID.randomUUID());
	}
}
