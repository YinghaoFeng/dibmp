package cn.mldn.dibmp.dao;

import java.util.List;
import java.util.Map;

import cn.mldn.dibmp.vo.Goods;

public interface IGoodsDAO {
	
	public boolean doCreate(Goods vo);
	
//	public List<Goods> findAll(Long currentPage,Integer lineSize);
	
	public List<Goods> findAllSplit(Map<String,Object> params);
	
//	public Long getAllCount();
	
	public Long getSplitCount(Map<String,Object> params);
}
