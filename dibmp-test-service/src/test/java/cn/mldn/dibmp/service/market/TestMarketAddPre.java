package cn.mldn.dibmp.service.market;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.ccc.service.IGoodsService;
import cn.mldn.dibmp.ccc.service.ISubtypeService;
import cn.mldn.dibmp.ccc.service.IWitemService;
import cn.mldn.dibmp.vo.Goods;
@ContextConfiguration(locations = { "classpath:spring/spring-*.xml" })
@RunWith(SpringJUnit4ClassRunner.class)
public class TestMarketAddPre {
	@Resource
	private IWitemService witemService;
	@Resource
	private ISubtypeService subtypeService;
	@Resource
	private IGoodsService goodsService;
	@Test
	public void testAddPre() {
		System.err.println(witemService.list());
	}
	@Test
	public void testFindByWiid() {
		System.err.println(subtypeService.findByWiid(1L));
	}
	@Test
	public void testGoodsAdd() {
		Goods vo=new Goods();
		vo.setName("Mac");
		vo.setWiid(2L);
		vo.setStid(8L);
		vo.setPrice(13300.0);
		vo.setWeight(3000.0);
		vo.setPhoto("nophoto.jpg");
		vo.setNote("很贵的电脑");
		System.err.println(goodsService.add(vo, "mldn-market"));
	}
	@Test
	public void testList() {
		System.err.println(goodsService.list("name", "多", 1L, 3));
	}
}
