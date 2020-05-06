package com.kgc.pinyougou.service;

import com.kgc.pinyougou.domain.Brand;
import com.kgc.pinyougou.domain.Specification;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ServiceApplicationTests {

	@Autowired(required = false)
	SpecificationService specificationService;

	@Test
	public void contextLoads() {
		Specification specification=new Specification();
		specification.setSpecName("aa");
		specificationService.insertSpecification(specification);

		System.out.println(specification);
	}

}
