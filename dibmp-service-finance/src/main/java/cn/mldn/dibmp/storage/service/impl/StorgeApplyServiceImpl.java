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
import cn.mldn.dibmp.wt.service.IStorgeApplyService;
import cn.mldn.util.service.abs.AbstractService;
@Service
public class StorgeApplyServiceImpl extends AbstractStirageService implements IStorgeApplyService{
	@Resource
	private IStorageApplyDAO storagerApplyDAO;
	@Resource
	private IStorageApplyDetailsDAO applyDetailsDAO;
	@Override
	public boolean add(StorageApply vo) {
		return storagerApplyDAO.doCreate(vo);
	}
	@Override
	public boolean updateStatus(Long said, Integer status) {
		Map<String, Object> map = super.StringObjectMap();
		if(said == null || status ==null) {
			return false;
		}
		map.put("status",status);
		map.put("said", said);
		return storagerApplyDAO.doEditStatus(map);
	}

	@Override
	public Map<String,Object> listSplitFont(String column, String keyWord, Long currentPage, Integer lineSize) {
		Map<String,Object> map = super.StringObjectMap();
		if(super.isEmptyString(column, keyWord)) {
			map.put("column",null);
		}else {
			map.put("column",column);
			map.put("keyWord","%"+keyWord+"%");
		}
		map.put("startPage",(currentPage-1)*lineSize);
		map.put("lineSize", lineSize);
		Map<String,Object> maps = new HashMap<String,Object>();
		Map<Long, Object> sumMap = super.LongObjectMap();
		Map<Long, Object> countMap = super.LongObjectMap();
		List<StorageApply> apply = storagerApplyDAO.findSplit(map);
		Iterator<StorageApply> rs = apply.iterator();
		while(rs.hasNext()){
			StorageApply sApply = new StorageApply();
			sApply = rs.next(); 
			countMap.put(sApply.getSaid(),applyDetailsDAO.findCountNum(sApply.getSaid()));	  
			sumMap.put(sApply.getSaid(),super.HandingBigDecimal(applyDetailsDAO.findSumPrice(sApply.getSaid())));
		}
		maps.put("findSplit",apply);	//商品信息
		maps.put("CountNum",countMap);	//商品数量
		maps.put("SumPrice",sumMap);	//商品价格
		maps.put("CountSplit",storagerApplyDAO.CountSplit(map));
		return maps;
	}
	@Override
	public Map<String, Object> getWarehouseGoodsBySaid(Long said) {
		Map<String, Object> map = super.StringObjectMap();
		map.put("apply", storagerApplyDAO.findBySaid(said));
		map.put("sum", super.HandingBigDecimal(applyDetailsDAO.findSumPrice(said))) ;
		map.put("applyDetails", applyDetailsDAO.findBySaid(said));
		return map;
	}

}
