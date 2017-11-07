package cn.mldn.dibmp.storage.service.impl;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import cn.mldn.dibmp.dao.IStorageApplyDAO;
import cn.mldn.dibmp.dao.IStorageApplyDetailsDAO;
import cn.mldn.dibmp.dao.IStorageRecordDAO;
import cn.mldn.dibmp.service.abc.AbstractStirageService;
import cn.mldn.dibmp.storage.service.IStorgeRecordService;
import cn.mldn.dibmp.vo.StorageApply;
import cn.mldn.dibmp.vo.StorageRecord;
@Service
public class StorgeRecordServiceImpl extends AbstractStirageService implements IStorgeRecordService {
	@Resource
	private IStorageRecordDAO storageRecordDAO;
	@Resource
	private IStorageApplyDAO applyDAO;
	@Resource
	private IStorageApplyDetailsDAO applyDetailsDAO;
	@Override
	public boolean add(StorageRecord vo) {
		return storageRecordDAO.doCreate(vo);
	}

	@Override
	public Map<String, Object> listRecord(String column,String keyWord,Long currentPage,Integer lineSize) {
		HashMap<String, Object> map = new HashMap<String,Object>();
		if(super.isEmptyString(column, keyWord)) {
			map.put("keyWord", null);
		}else {
			map.put("column", column);
			map.put("keyWord", "%"+keyWord+"%");
		}
			map.put("startPage", (currentPage-1)*lineSize);
			map.put("lineSize", lineSize);
		List<StorageRecord> recordList = storageRecordDAO.findSplit(map);
		Iterator<StorageRecord> recordIter = recordList.iterator();
		HashMap<String, Object> maps = new HashMap<String,Object>();
		if(recordIter.hasNext()) {
			 StorageRecord renext = recordIter.next();
			 maps.put("apply", applyDAO.findBySaid(renext.getSaid()));
			 maps.put("SumPrice", applyDetailsDAO.findSumPrice(renext.getSaid()));
			 maps.put("CountNum", applyDetailsDAO.findCountNum(renext.getSaid()));
		}
		maps.put("allRecord", recordList);
		maps.put("CountRecord", storageRecordDAO.getCountSplit(map));
		return maps;
	}

}
