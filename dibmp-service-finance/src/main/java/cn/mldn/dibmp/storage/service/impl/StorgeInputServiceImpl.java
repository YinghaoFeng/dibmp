package cn.mldn.dibmp.storage.service.impl;


import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.dao.IStorageApplyDetailsDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.wt.service.IStorgeInputService;
@Service
public class StorgeInputServiceImpl extends AbstractStirageService implements IStorgeInputService {
	@Resource
	private IStorageApplyDAO applyDAO;
	@Resource
	private IStorageApplyDetailsDAO applyDetailsDAO;
	@Override
	public Map<String, Object> listInputBcke(Long said) {
		 Map<String, Object> map = super.StringObjectMap();
		 map.put("applyAll", applyDAO.findBySaid(said));
		 map.put("details", applyDetailsDAO.findBySaid(said));
		return map;
	}
	
	@SuppressWarnings("unlikely-arg-type")
	@Override
	public boolean isSaidVo(Long said) {
		 StorageApply apply = applyDAO.findBySaid(said);
		 if("".equals(apply)||apply == null) {
			 return false;
		 }
		return true;
	}
}
