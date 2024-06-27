package com.example.demo;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;




class DemoApplicationTests {
	private Calculator c=new Calculator();

	@Test
	void contextLoads()
	{
	}
    @Test

	void doSum()
	{
		int excepted=30;
		int actual=c.add(10,20);
		assertThat(actual).isEqualTo(excepted);
	}
	@Test
	void doPro()
	{
		int excepted=30;
		int actual=c.pro(3,10);
		assertThat(actual).isEqualTo(excepted);
	}
	@Test
	void compareTwoNum(){
		Boolean actual=c.compareTo(3,3);
		assertThat(actual).isTrue();
	}



}
