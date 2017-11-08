package cn.mldn.dibmp.service.impl;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.ccc.service.IStorgeApplyService;
import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.vo.StorageApply;
@Service
public class StorageApplyServiceImpl implements IStorgeApplyService{

	@Resource
	private IStorageApplyDAO storagerApplyDAO;
	@Override
	public boolean add(StorageApply vo,String mid) {
		vo.setStatus(0);//待提交
		vo.setAppmid(mid);//申请人
		return storagerApplyDAO.doCreate(vo);
	}

}
