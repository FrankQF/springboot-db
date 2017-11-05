package com.frank.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.frank.entity.Person;
import com.frank.service.DemoService;

@RestController
public class MyController {
	@Autowired
	DemoService demoService;
	
	@RequestMapping("/rollback")//此处要加@RequestBody 否则接收不到person的json请求
	public Person rollback(@RequestBody Person person){ //1
		return demoService.savePersonWithRollBack(person);
	}
	
	@RequestMapping("/norollback")
	public Person noRollback(@RequestBody Person person){//2
		return demoService.savePersonWithoutRollBack(person);
		
	}

}
