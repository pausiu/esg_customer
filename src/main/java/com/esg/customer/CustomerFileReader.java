package com.esg.customer;

import java.io.BufferedReader;
import java.io.FileReader;
import java.net.URI;
import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CustomerFileReader {

	public static void readFromFile() throws Exception {
		
		String filename = "D:\\customer.csv";
		final String DELIMITER = ",";
		String line = "";
		BufferedReader fileReader = new BufferedReader(new FileReader(filename));
	    RestTemplate restTemplate = new RestTemplate();

		while ((line = fileReader.readLine()) != null)
		{
		    String[] tokens = line.split(DELIMITER);
		    
		    Map<String, Object> object = new HashMap<>();
		    object.put("customerRef", tokens[0]);
		    object.put("customerName", tokens[1]);
		    object.put("addressLine1", tokens[2]);
		    object.put("addressLine2", tokens[3]);
		    object.put("town", tokens[4]);
		    object.put("county", tokens[5]);
		    object.put("country", tokens[6]);
		    object.put("postcode", tokens[7]);

		    ObjectMapper mapper = new ObjectMapper();
		    String JSONValue = mapper.writeValueAsString(object);

		    HttpHeaders httpHeaders = new HttpHeaders();
		    httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		    HttpEntity<String> entity = new HttpEntity<String>(JSONValue, httpHeaders);
		    ResponseEntity<String> response = restTemplate.postForEntity(new URI("http://localhost:8080/createCustomer"), entity, String.class);
	        System.out.println("JSON:" + JSONValue);
	        System.out.println("HTTP Response:" + response);
		}
		fileReader.close();
		
		ResponseEntity<Customer> responseEntity = restTemplate.getForEntity(new URI("http://localhost:8080/getCustomer/CS1"), Customer.class);
		Customer customer = responseEntity.getBody();
		System.out.println("Customer: " + customer);
		
	}
}
