package com.fc.bus.model.auto;

import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModelProperty;

import java.io.Serializable;

public class BusDailyLog implements Serializable {
    private static final long serialVersionUID = 1L;

	
	@ApiModelProperty(value = "主键")
	private String iD;
	
	@ApiModelProperty(value = "日报日期")
	private String rBRQ;
	
	@ApiModelProperty(value = "星期几")
	private String xQJ;
	
	@ApiModelProperty(value = "天气")
	private String tQ;
	
	@ApiModelProperty(value = "施工部位")
	private String sGBW;
	
	@ApiModelProperty(value = "施工内容")
	private String sGNR;
	
	@ApiModelProperty(value = "形象进度")
	private String xXJD;
	
	@ApiModelProperty(value = "施工人员")
	private String sGRY;
	
	@ApiModelProperty(value = "施工进度")
	private String sGJD;
	
	@ApiModelProperty(value = "技术质量记录")
	private String jSZLJL;
	
	@ApiModelProperty(value = "进场材料记录")
	private String jCCLJL;
	
	@ApiModelProperty(value = "工程负责人")
	private String gCFZR;
	
	@ApiModelProperty(value = "记录人")
	private String jLR;
	
	@ApiModelProperty(value = "添加时间")
	private String tJSJ;
	
	@JsonProperty("iD")
	public String getID() {
		return iD;
	}

	public void setID(String iD) {
		this.iD =  iD;
	}
	@JsonProperty("rBRQ")
	public String getRBRQ() {
		return rBRQ;
	}

	public void setRBRQ(String rBRQ) {
		this.rBRQ =  rBRQ;
	}
	@JsonProperty("xQJ")
	public String getXQJ() {
		return xQJ;
	}

	public void setXQJ(String xQJ) {
		this.xQJ =  xQJ;
	}
	@JsonProperty("tQ")
	public String getTQ() {
		return tQ;
	}

	public void setTQ(String tQ) {
		this.tQ =  tQ;
	}
	@JsonProperty("sGBW")
	public String getSGBW() {
		return sGBW;
	}

	public void setSGBW(String sGBW) {
		this.sGBW =  sGBW;
	}
	@JsonProperty("sGNR")
	public String getSGNR() {
		return sGNR;
	}

	public void setSGNR(String sGNR) {
		this.sGNR =  sGNR;
	}
	@JsonProperty("xXJD")
	public String getXXJD() {
		return xXJD;
	}

	public void setXXJD(String xXJD) {
		this.xXJD =  xXJD;
	}
	@JsonProperty("sGRY")
	public String getSGRY() {
		return sGRY;
	}

	public void setSGRY(String sGRY) {
		this.sGRY =  sGRY;
	}
	@JsonProperty("sGJD")
	public String getSGJD() {
		return sGJD;
	}

	public void setSGJD(String sGJD) {
		this.sGJD =  sGJD;
	}
	@JsonProperty("jSZLJL")
	public String getJSZLJL() {
		return jSZLJL;
	}

	public void setJSZLJL(String jSZLJL) {
		this.jSZLJL =  jSZLJL;
	}
	@JsonProperty("jCCLJL")
	public String getJCCLJL() {
		return jCCLJL;
	}

	public void setJCCLJL(String jCCLJL) {
		this.jCCLJL =  jCCLJL;
	}
	@JsonProperty("gCFZR")
	public String getGCFZR() {
		return gCFZR;
	}

	public void setGCFZR(String gCFZR) {
		this.gCFZR =  gCFZR;
	}
	@JsonProperty("jLR")
	public String getJLR() {
		return jLR;
	}

	public void setJLR(String jLR) {
		this.jLR =  jLR;
	}
	@JsonProperty("tJSJ")
	public String getTJSJ() {
		return tJSJ;
	}

	public void setTJSJ(String tJSJ) {
		this.tJSJ =  tJSJ;
	}

																												
	public BusDailyLog(String iD,String rBRQ,String xQJ,String tQ,String sGBW,String sGNR,String xXJD,String sGRY,String sGJD,String jSZLJL,String jCCLJL,String gCFZR,String jLR,String tJSJ) {
				
		this.iD = iD;
				
		this.rBRQ = rBRQ;
				
		this.xQJ = xQJ;
				
		this.tQ = tQ;
				
		this.sGBW = sGBW;
				
		this.sGNR = sGNR;
				
		this.xXJD = xXJD;
				
		this.sGRY = sGRY;
				
		this.sGJD = sGJD;
				
		this.jSZLJL = jSZLJL;
				
		this.jCCLJL = jCCLJL;
				
		this.gCFZR = gCFZR;
				
		this.jLR = jLR;
				
		this.tJSJ = tJSJ;
				
	}

	public BusDailyLog() {
	    super();
	}

	

}