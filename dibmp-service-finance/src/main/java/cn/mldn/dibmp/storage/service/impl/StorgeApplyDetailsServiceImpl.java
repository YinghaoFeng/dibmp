package cn.mldn.dibmp.storage.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.dao.IStorageApplyDetailsDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageApplyDetails;
import cn.mldn.dibmp.wt.service.IStorgeApplyDetailsService;
@Service
public class StorgeApplyDetailsServiceImpl extends AbstractStirageService implements IStorgeApplyDetailsService{
	@Resource
	private IStorageApplyDetailsDAO storageApplyDetailsDAO;
	@Resource
	private IStorageApplyDAO storagerApplyDAO;
	@Override
	public boolean add(StorageApplyDetails vo) {
		return storageApplyDetailsDAO.doCreate(vo);
	}
	@Override
	public boolean editSaid(Long said,Integer status) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("status", status);
		map.put("said", said);
		return storagerApplyDAO.doEditStatus(map);
	}
	@Override
	public List<StorageApplyDetails> findBySadid(Long sadid) {
		return storageApplyDetailsDAO.findBySaid(sadid);
	}

	@Override
	public Map<String, Object> listGoodsBack(Long said) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		map.put("allApply", storagerApplyDAO.findBySaid(said));
		map.put("SumNums", super.HandingBigDecimal(storageApplyDetailsDAO.findSumPrice(said)));//查询所有单价
		return map;
	}
	@Override
	public Map<String, Object> listEditNum(Long said) {
		 Map<String, Object> map = super.StringObjectMap();
		 List<StorageApplyDetails> allGoogs = storageApplyDetailsDAO.findBySaid(said);
		 map.put("allApplyDetails", allGoogs);
		 return map;
	}
	
	
}
