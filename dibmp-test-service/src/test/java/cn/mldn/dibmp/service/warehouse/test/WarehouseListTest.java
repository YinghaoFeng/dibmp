package cn.mldn.dibmp.service.warehouse.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.fyh.service.IWarehouseService;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class WarehouseListTest {
	@Resource
	private IWarehouseService warehouseService;
	@Test
	public void testWarehouseService() {
		
		System.err.println(warehouseService.listByWitem(1L));
	}

}
