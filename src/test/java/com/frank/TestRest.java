package com.frank;

import static org.junit.Assert.assertTrue;

import org.json.JSONObject;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.client.RestTemplate;

import com.frank.entity.PersonEntity;

public class TestRest extends ApplicationTest{

    @Autowired
    RestTemplate restTemplate;
	
    @Test
	public  void testHandler() {
        String url = "http://localhost:8080/api/person";
//        PersonEntity json = restTemplate.getForObject(url, PersonEntity.class);
        PersonEntity json = restTemplate.getForEntity(url, PersonEntity.class).getBody();

        System.out.println(json.toString());
        assertTrue(true);
	}
}
