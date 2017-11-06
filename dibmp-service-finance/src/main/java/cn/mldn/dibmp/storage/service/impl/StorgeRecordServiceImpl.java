package cn.mldn.dibmp.storage.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageRecordDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.storage.service.IStorgeRecordService;
import cn.mldn.dibmp.vo.StorageRecord;
@Service
public class StorgeRecordServiceImpl extends AbstractStirageService implements IStorgeRecordService {
	@Resource
	private IStorageRecordDAO storageRecordDAO;
	@Override
	public boolean add(StorageRecord vo) {
		return storageRecordDAO.doCreate(vo);
	}

	@Override
	public List<StorageRecord> rdList() {
		return storageRecordDAO.findAll();
	}

}
