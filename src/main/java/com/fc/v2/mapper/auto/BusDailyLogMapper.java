package com.fc.v2.mapper.auto;


import com.fc.bus.model.auto.BusDailyLog;
import com.fc.bus.model.auto.BusDailyLogExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工日志表 BusDailyLogMapper
 * @author cc_自动生成
 * @email ${email}
 * @date 2021-01-26 16:43:19
 */
public interface BusDailyLogMapper {
      	   	      	      	      	      	      	      	      	      	      	      	      	      	      	      
    long countByExample(BusDailyLogExample example);

    int deleteByExample(BusDailyLogExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(BusDailyLog record);

    int insertSelective(BusDailyLog record);

    List<BusDailyLog> selectByExample(BusDailyLogExample example);
		
    BusDailyLog selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") BusDailyLog record, @Param("example") BusDailyLogExample example);

    int updateByExample(@Param("record") BusDailyLog record, @Param("example") BusDailyLogExample example); 
		
    int updateByPrimaryKeySelective(BusDailyLog record);

    int updateByPrimaryKey(BusDailyLog record);
  	  	
}