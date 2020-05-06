package com.kgc.pinyougou;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouUserWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouUserWebApplication.class, args);
	}

}
