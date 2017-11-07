package cn.mldn.dibmp.storage.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.storage.service.IStorgeRecordService;
import cn.mldn.dibmp.vo.StorageRecord;
import junit.framework.TestCase;
@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StorgeRecordServiceTest {
	@Resource
	private IStorgeRecordService RecordService;
	@Test
	public void addTest() {
		StorageRecord vo = new StorageRecord();
		vo.setGid(1L);
		vo.setInmid("jiujiu");
		vo.setName("nishipa");
		vo.setNum(5);
		vo.setPrice(53.26);
		vo.setSaid(5L);
		vo.setStatus(6);
		vo.setWeight(56.3);
		boolean flage = RecordService.add(vo);
		System.out.println("增加数据 + " + flage);
		TestCase.assertTrue(flage);
	}
	@Test
	public void rdListTest() {
		System.err.println("列表显示 + " + RecordService.listRecord("title", "b", 2L, 5));
		System.out.println("-=");
	}
	
}
