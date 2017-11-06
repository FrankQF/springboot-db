package com.frank.dao;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.core.ValueOperations;
import org.springframework.stereotype.Repository;

import com.frank.entity.Person;

@Repository
public class PersonDao {
	
	@Autowired
	StringRedisTemplate stringRedisTemplate; //1已经配置好，直接注入
	
	@Resource(name="stringRedisTemplate")
	ValueOperations<String,String> valOpsStr; //3 指定stringRedisTemplate，可注入基于字符串的简单属性操作方法
	
	
	@Autowired
	RedisTemplate<Object, Object> redisTemplate; // 已经配置RedisTemplate，此处 直接注入
	
	@Resource(name="redisTemplate")
	ValueOperations<Object, Object> valOps; //4 可注入基于对象的简单属性操作方法
	
	public void stringRedisTemplateDemo(){ //5 set存储字符串类型
		valOpsStr.set("xx", "yy");
	}
	
	
	public void save(Person person){ //6 set方法 存储对象类型
		valOps.set(person.getId(),person);
	}
	
	public String getString(){//7 get方法获取字符串
		return valOpsStr.get("xx");
	}
	 
	public Person getPerson(){//8 get方法获得对象
		return (Person) valOps.get("1");
	}

}