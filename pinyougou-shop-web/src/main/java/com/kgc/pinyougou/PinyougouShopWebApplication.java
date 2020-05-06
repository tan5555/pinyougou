package com.kgc.pinyougou;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouShopWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouShopWebApplication.class, args);
	}

}
