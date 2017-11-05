package cn.mldn.dibmp.storage.service.test;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.storage.service.IStorgeApplyService;
import cn.mldn.dibmp.vo.StorageApply;
import junit.framework.TestCase;

@ContextConfiguration(locations = {"classpath:spring/spring-*.xml"})
@RunWith(SpringJUnit4ClassRunner.class)
public class StorageApplyServiceText {
	@Resource
	private IStorgeApplyService applyService;
	@Test
	public void addText() {
		 StorageApply sa = new StorageApply();
		 sa.setAppmid("nihaoss");
		 sa.setCid(5L);
		 sa.setNote("结束吧dd");
		 sa.setPid(62L);
		 sa.setSaid(71L);
		 sa.setStatus(52);
		 sa.setTitle("sndishiss");
		 sa.setWid(01L);
		 sa.setWiid(02L);
		 boolean flag = applyService.add(sa);
		 System.err.println("添加" + flag);
		 TestCase.assertTrue(flag);
	}
}
