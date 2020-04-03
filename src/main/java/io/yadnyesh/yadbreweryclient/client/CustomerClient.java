package io.yadnyesh.yadbreweryclient.client;

import io.yadnyesh.yadbreweryclient.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.net.URI;
import java.util.UUID;

@Component
@ConfigurationProperties(prefix = "yad.brewery", ignoreUnknownFields = false)
public class CustomerClient {
	
	public final String CUSTOMER_PATH_V1 = "/api/v1/customer/";
	
	private String apihost;
	
	@Autowired
	private RestTemplate restTemplate;
	
	
	public void setApihost(String apihost) {
		this.apihost = apihost;
	}
	
	public CustomerDto getCustomerById(UUID customerId) {
		return restTemplate.getForObject(apihost+ CUSTOMER_PATH_V1 + customerId.toString(), CustomerDto.class);
	}
	
	public URI saveNewCustomer(CustomerDto customerDto) {
		return  restTemplate.postForLocation(apihost + CUSTOMER_PATH_V1, customerDto);
	}
	
	public void updateCustomer(UUID customerId, CustomerDto customerDto) {
		restTemplate.put(apihost + CUSTOMER_PATH_V1 + customerId, customerDto);
	}
	
	public void deleteCustomer(UUID customerId) {
		restTemplate.delete(apihost + CUSTOMER_PATH_V1 + customerId);
	}
}
