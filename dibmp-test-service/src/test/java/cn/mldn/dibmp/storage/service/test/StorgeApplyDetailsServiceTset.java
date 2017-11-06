package cn.mldn.dibmp.storage.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.storage.service.IStorgeApplyDetailsService;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import junit.framework.TestCase;

@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StorgeApplyDetailsServiceTset {
	@Resource
	private IStorgeApplyDetailsService detailsService;
	@Test
	public void addText() {
		StorageApplyDetails details = new StorageApplyDetails();
		details.setGid(4L);
		details.setName("你好");
		details.setNum(5);
		details.setPrice(5.02);
		details.setSadid(6L);
		details.setWeight(2.5);
		boolean flag = detailsService.add(details);
		TestCase.assertTrue(flag);
		System.out.println("添加 ++ " + flag) ;
	}
	@Test
	public void findBySadidTest() {
		System.err.println("查询内容 ++ " + detailsService.findBySadid(2L));
		System.out.println("************");
	}

}