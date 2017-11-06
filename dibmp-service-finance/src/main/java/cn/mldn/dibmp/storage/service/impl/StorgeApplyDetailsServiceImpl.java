package cn.mldn.dibmp.storage.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDetailsDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.storage.service.IStorgeApplyDetailsService;
import cn.mldn.dibmp.vo.StorageApplyDetails;
@Service
public class StorgeApplyDetailsServiceImpl extends AbstractStirageService implements IStorgeApplyDetailsService{
	@Resource
	private IStorageApplyDetailsDAO storageApplyDetailsDAO;
	
	@Override
	public boolean add(StorageApplyDetails vo) {
		return storageApplyDetailsDAO.doCreate(vo);
	}
	@Override
	public StorageApplyDetails findBySadid(Long sadid) {
		return storageApplyDetailsDAO.findBySadid(sadid);
	}
	

}
