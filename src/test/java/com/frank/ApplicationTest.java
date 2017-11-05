package com.frank;

import static org.junit.Assert.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.frank.config.CalcuConf;
import com.frank.config.Calculate;


@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = MainApplication.class) //1
@WebAppConfiguration
public abstract class ApplicationTest {
/*//	@Autowired
	//要测试的Spring注入类
	@InjectMocks
	Calculate calculate;
	//测试注入类的依赖
	@Mock
	CalcuConf calcuConf;*/
	
/*    @Before  
    public void setUp() {  
        MockitoAnnotations.initMocks(this);//对测试注入类的依赖进行绑定
        //模拟测试类依赖的返回
        when(calcuConf.salt()).thenReturn(2);  
    }  
	
	@Test
	public void testCalcu() {
		assertEquals(4, calculate.add(1,1));
	}*/
	
}
