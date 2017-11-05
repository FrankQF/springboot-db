package com.frank.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.frank.dao.PersonRepository;
import com.frank.entity.Person;

@Service
public class DemoServiceImpl implements DemoService {
	@Autowired
	PersonRepository personRepository; //1直接注入Bean
	
//	@Transactional(rollbackFor={IllegalArgumentException.class}) //2
	public Person savePersonWithRollBack(Person person){
		Person p =personRepository.save(person);

		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞已存在，数据将回滚"); //3throw异常，事务回滚
		}
		return p;
	}

	@Transactional(noRollbackFor={IllegalArgumentException.class}) //4设置不回滚数据
	public Person savePersonWithoutRollBack(Person person){
		Person p =personRepository.save(person);
		
		if(person.getName().equals("汪云飞")){
			throw new IllegalArgumentException("汪云飞虽已存在，数据将不会回滚");
		}
		return p;
	}
}
