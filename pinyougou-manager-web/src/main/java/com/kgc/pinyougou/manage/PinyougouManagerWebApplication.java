package com.kgc.pinyougou.manage;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouManagerWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouManagerWebApplication.class, args);
	}

}
