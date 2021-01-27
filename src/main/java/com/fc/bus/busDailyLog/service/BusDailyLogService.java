package com.fc.bus.busDailyLog.service;

import cn.hutool.core.util.StrUtil;
import com.fc.v2.mapper.auto.BusDailyLogMapper;
import com.fc.bus.model.auto.BusDailyLog;
import com.fc.bus.model.auto.BusDailyLogExample;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

/**
 * 施工日志表 BusDailyLogService
 * @Title: BusDailyLogService.java 
 * @Package com.fc.v2.service 
 * @author cc_自动生成
 * @email ${email}
 * @date 2021-01-26 16:43:19  
 **/
@Service
public class BusDailyLogService implements BaseService<BusDailyLog, BusDailyLogExample>{
	@Autowired
	private BusDailyLogMapper busDailyLogMapper;
	
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      	
	/**
	 * 分页查询
	 * @param tablepar
	 * @param busDailyLog
	 * @return
	 */
	 public PageInfo<BusDailyLog> list(Tablepar tablepar,BusDailyLog busDailyLog){
	        BusDailyLogExample testExample=new BusDailyLogExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(busDailyLog);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("ID ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<BusDailyLog> list= busDailyLogMapper.selectByExample(testExample);
	        PageInfo<BusDailyLog> pageInfo = new PageInfo<BusDailyLog>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			BusDailyLogExample example=new BusDailyLogExample();
			example.createCriteria().andIDIn(lista);
			return busDailyLogMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public BusDailyLog selectByPrimaryKey(String id) {
				
			return busDailyLogMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(BusDailyLog record) {
		return busDailyLogMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(BusDailyLog record) {
				
		//添加雪花主键id
		record.setID(SnowflakeIdWorker.getUUID());
			
				
		return busDailyLogMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(BusDailyLog record, BusDailyLogExample example) {
		
		return busDailyLogMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(BusDailyLog record, BusDailyLogExample example) {
		
		return busDailyLogMapper.updateByExample(record, example);
	}

	@Override
	public List<BusDailyLog> selectByExample(BusDailyLogExample example) {
		
		return busDailyLogMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(BusDailyLogExample example) {
		
		return busDailyLogMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(BusDailyLogExample example) {
		
		return busDailyLogMapper.deleteByExample(example);
	}


	public List<Map<String, String>> queryListByIDs(List<String> ids)
	{
		List<Map<String, String>> list= busDailyLogMapper.queryListByIDs(ids);
		return list;
	}
}
