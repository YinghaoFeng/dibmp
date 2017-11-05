package cn.mldn.dibmp.storage.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.storage.service.IStorgeApplyService;
import cn.mldn.dibmp.vo.StorageApply;
@Service
public class StorgeApplyServiceImpl extends AbstractStirageService implements IStorgeApplyService{
	@Resource
	private IStorageApplyDAO storagerApplyDAO;
	@Override
	public boolean add(StorageApply vo) {
		return storagerApplyDAO.doCreate(vo);
	}
	
	@Override
	public List<StorageApply> saList() {
		
		return storagerApplyDAO.findAll();
	}
	@Override
	public boolean updateStatus(Long said, Integer status) {
		Map<String, Object> map = super.StringObjectMap();
		map.put("status", status);
		map.put("said", said);
		return storagerApplyDAO.doEditStatus(map);
	}

}
