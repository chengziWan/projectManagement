package com.fc.bus.model.auto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BusCopyFile implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String id;
	
	@ApiModelProperty(value = "模板位置")
	private String fileLocation;
	
	@ApiModelProperty(value = "推迟天数")
	private Integer tcts;
	
	@JsonProperty("id")
	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id =  id;
	}
	@JsonProperty("fileLocation")
	public String getFileLocation() {
		return fileLocation;
	}

	public void setFileLocation(String fileLocation) {
		this.fileLocation =  fileLocation;
	}
	@JsonProperty("tcts")
	public Integer getTcts() {
		return tcts;
	}

	public void setTcts(Integer tcts) {
		this.tcts =  tcts;
	}

						
	public BusCopyFile(String id,String fileLocation,Integer tcts) {
				
		this.id = id;
				
		this.fileLocation = fileLocation;
				
		this.tcts = tcts;
				
	}

	public BusCopyFile() {
	    super();
	}

	

}