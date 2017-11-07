package cn.mldn.dibmp.service.city.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.ccc.service.ICityService;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class CityServiceTest {
	@Resource
	private ICityService cityService;
	@Test
	public void testCityList() {
		System.err.println(cityService.listByProvince(2L));
	}

}
