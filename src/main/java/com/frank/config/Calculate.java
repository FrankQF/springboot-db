package com.frank.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Calculate {
	
	@Autowired
	CalcuConf calcuConf;

	public int add(int a,int b) {
		return a+b+calcuConf.salt();
	}
}
