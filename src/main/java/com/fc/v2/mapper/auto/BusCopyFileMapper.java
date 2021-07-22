package com.fc.v2.mapper.auto;

import com.fc.bus.model.auto.BusCopyFile;
import com.fc.bus.model.auto.BusCopyFileExample;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 施工日志拷贝 BusCopyFileMapper
 * @author fuce_自动生成
 * @email ${email}
 * @date 2021-07-22 10:41:06
 */
public interface BusCopyFileMapper {
      	   	      	      	      
    long countByExample(BusCopyFileExample example);

    int deleteByExample(BusCopyFileExample example);
		
    int deleteByPrimaryKey(String id);
		
    int insert(BusCopyFile record);

    int insertSelective(BusCopyFile record);

    List<BusCopyFile> selectByExample(BusCopyFileExample example);
		
    BusCopyFile selectByPrimaryKey(String id);
		
    int updateByExampleSelective(@Param("record") BusCopyFile record, @Param("example") BusCopyFileExample example);

    int updateByExample(@Param("record") BusCopyFile record, @Param("example") BusCopyFileExample example); 
		
    int updateByPrimaryKeySelective(BusCopyFile record);

    int updateByPrimaryKey(BusCopyFile record);
  	  	
}