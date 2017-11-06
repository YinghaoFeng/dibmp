package cn.mldn.dibmp.service.test;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.vo.Citem;
import cn.mldn.dibmp.vo.Customer;
import cn.mldn.dibmp.yaojia.service.ISaleService;
import junit.framework.TestCase;

@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)

public class TestCustomerService extends TestCase {
	
    @Resource
    private ISaleService saleService;
    @Test
    public void testAdd() {
      Customer vo = new Customer();
      vo.setName("ceshi1");
      vo.setPhone("12");
      vo.setAddress("ceshi2");
      vo.setNote("note");
      TestCase.assertTrue(saleService.add(vo));
      
    }
    @Test
    public void testAddpre() {
    	Map<String,Object> map  = this.saleService.getAddPre();
    	//TestCase.assertNotNull(map);
    	System.err.println(map);
    	//System.err.println(map.get("allProvinces"));
    	//System.out.println(map.get("allCsources"));
    	//System.err.println(map.get("AllCitems"));
    }
	@Test
	public void testCustomerList() {
		Map<String,Object> map = this.saleService.listC(1L,5,"","");
		//TestCase.assertNotNull(map);
		
		//List<Customer> allCustomers = (List<Customer>)map.get("allCustomers");
		//List<Citem> allCitems = (List<Citem>) map.get("allCitems");
		long splitCount = (long) map.get("allSpiltCount");
		TestCase.assertTrue(splitCount>0L);
		//System.err.println(allCustomers);
		//System.err.println(allCitems);
		System.err.println(splitCount);
		
	}
}
