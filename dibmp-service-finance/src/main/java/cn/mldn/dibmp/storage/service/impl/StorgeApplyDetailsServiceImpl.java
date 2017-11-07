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
import cn.mldn.dibmp.storage.service.IStorgeApplyDetailsService;
import cn.mldn.dibmp.vo.StorageApplyDetails;
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
	public List<StorageApplyDetails> findBySadid(Long sadid) {
		return storageApplyDetailsDAO.findBySaid(sadid);
	}

	@Override
	public Map<String, Object> listGoodsBack(Long said) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		List<StorageApplyDetails> allGoogs = storageApplyDetailsDAO.findBySaid(said);
		Iterator<StorageApplyDetails> goods = allGoogs.iterator();
		if(goods.hasNext()) {
			StorageApplyDetails applyDetails = goods.next();
			System.err.println("**** Sadid() 的值 **** " + applyDetails.getSadid());
			map.put("SumNum", storageApplyDetailsDAO.findSumSadid(applyDetails.getSadid()));
			map.put("allApply", storagerApplyDAO.findBySaid(applyDetails.getSadid()));
		}
		map.put("SumNums", storageApplyDetailsDAO.findSumPrice(said));
		map.put("allApplyDetails", allGoogs);
		return map;
	}

}
