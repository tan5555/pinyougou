package com.kgc.pinyougou.portal;

import com.alibaba.dubbo.spring.boot.annotation.EnableDubboConfiguration;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@EnableDubboConfiguration
public class PinyougouPortalWebApplication {

	public static void main(String[] args) {
		SpringApplication.run(PinyougouPortalWebApplication.class, args);
	}

}
