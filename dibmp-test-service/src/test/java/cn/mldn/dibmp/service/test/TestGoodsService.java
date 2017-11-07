package cn.mldn.dibmp.service.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.service.ISaleService;
import junit.framework.TestCase;


/**
 * 商品信息测试类
 * @author yaojia
 *
 */
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestGoodsService extends TestCase {
	
	private Logger logger = LoggerFactory.getLogger(TestGoodsService.class);
	
	@Resource
	private ISaleService saleService;

	/**
	 * 测试分页
	 */
	@Test
	public void testGoodsList() {
		Map<String,Object> map= this.saleService.list("", "", 1l, 5);
		Assert.assertNotNull(map);
		Assert.assertTrue(map.size()>0);
		System.err.println(this.saleService.list("", "", 1L, 5));
	}
	
	/**
	 * 则是
	 */
	@Test
	public void testfindGoodsDetailsById() {
		System.err.println(this.saleService.findGoodsDetailsById(1l));
		Assert.assertNotNull(this.saleService.findGoodsDetailsById(1l));
	}
	
	@Test
	public void testfindGoodsStorageAndApply() {
		System.err.println(this.saleService.findGoodsStorageApply(1L));
	}
	
	@Test
	public void testfindGoodsStorageDetails() {
		System.err.println(this.saleService.findGoodsStorageDetails(1l));
	}
	
	@Test
	public void testfindfindGoodsStorageDetails() {
		System.err.println(this.saleService.findGoodsStorageDetails(1L));
		Assert.assertNotNull(this.saleService.findGoodsStorageDetails(1L));
	}
	
	@Test
	public void testfindAllCustomerByCmid() {
		System.err.println(this.saleService.findAllUnStorageGoods("cc"));
	}
}
