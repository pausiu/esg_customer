package com.esg.customer;

import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.fasterxml.jackson.databind.ObjectMapper;

import java.util.HashMap;
import java.util.Map;

import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.*;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;

@WebMvcTest
public class CustomerApplicationTests {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CustomerRepository customerRepository;
    
    @Test
    public void createCustomerByJSON() throws Exception{

    	Map<String, Object> object = new HashMap<>();
    	object.put("customerRef", "CS1");
		object.put("customerName", "Peter");
		object.put("addressLine1", "22");
		object.put("addressLine2", "Willow Close");
		object.put("town", "Hinckley");
		object.put("county", "Leicestershire");
		object.put("country", "UK");
		object.put("postcode", "LE10 2JY");
		ObjectMapper mapper = new ObjectMapper();
		String JSON = mapper.writeValueAsString(object);
    	
        ResultActions response = mockMvc.perform(post("/createCustomer")
            .contentType(MediaType.APPLICATION_JSON)
            .content(JSON));
        
        response.andDo(print()).andExpect(status().isCreated());
    }

    @Test
    public void getCustomerById() throws Exception{

    	mockMvc.perform( MockMvcRequestBuilders
    		      .get("/getCustomer/{id}", "CS1")
    		      .accept(MediaType.APPLICATION_JSON))
    	      .andDo(print())
    	      .andExpect(status().isOk())
    	      .andExpect(MockMvcResultMatchers.jsonPath("$.customerRef").value("CS1"));
    }

}