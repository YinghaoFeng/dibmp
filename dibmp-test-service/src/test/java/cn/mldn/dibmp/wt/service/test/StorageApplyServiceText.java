package cn.mldn.dibmp.wt.service.test;

import java.util.Map;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.wt.service.IStorgeApplyService;
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
		 sa.setStatus(0);
		 sa.setTitle("sndishiss");
		 sa.setWid(01L);
		 sa.setWiid(02L);
		 boolean flag = applyService.add(sa);
		 System.err.println("添加" + flag);
		 TestCase.assertTrue(flag);
	}
	
	@Test
	public void updateStatusTest(){
		boolean flag = applyService.updateStatus(3L, 1);
		TestCase.assertTrue(flag);
		System.err.println("修改状态 ++ " + flag);
	}
	@Test
	public void SplitFontTest() {
		 Map<String, Object> as = applyService.listSplitFont("title","",1L,5);
		System.err.println("分页显示 findSplit + " + as.get("findSplit"));
		System.err.println("分页显示 CountSplit + " + as.get("CountSplit"));
		System.err.println("分页显示 CountSplit + " + as.get("SumPrice"));
		
	}
}
