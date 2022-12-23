package com.fc.bus.busDailyLog.service;

import cn.hutool.core.util.StrUtil;
import com.fc.bus.model.auto.BusCopyFile;
import com.fc.bus.model.auto.BusCopyFileExample;
import com.fc.bus.util.CalendarUtil;
import com.fc.bus.util.ExportPOIUtil;
import com.fc.bus.util.WeatherUtil;
import com.fc.v2.common.base.BaseService;
import com.fc.v2.common.support.ConvertUtil;
import com.fc.v2.mapper.auto.BusCopyFileMapper;
import com.fc.v2.model.custom.Tablepar;
import com.fc.v2.util.DateUtils;
import com.fc.v2.util.SnowflakeIdWorker;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.apache.poi.xwpf.usermodel.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * 施工日志拷贝 BusCopyFileService
 * @Title: BusCopyFileService.java 
 * @Package com.fc.v2.service 
 * @author fuce_自动生成
 * @email ${email}
 * @date 2021-07-22 10:41:06  
 **/
@Service
public class BusCopyFileService implements BaseService<BusCopyFile, BusCopyFileExample>{
	@Autowired
	private BusCopyFileMapper busCopyFileMapper;
	
      	   	      	      	      	
	/**
	 * 分页查询
	 * @param pageNum
	 * @param pageSize
	 * @return
	 */
	 public PageInfo<BusCopyFile> list(Tablepar tablepar,BusCopyFile busCopyFile){
	        BusCopyFileExample testExample=new BusCopyFileExample();
			//搜索
			if(StrUtil.isNotEmpty(tablepar.getSearchText())) {//小窗体
	        	testExample.createCriteria().andLikeQuery2(tablepar.getSearchText());
	        }else {//大搜索
	        	testExample.createCriteria().andLikeQuery(busCopyFile);
	        }
			//表格排序
			//if(StrUtil.isNotEmpty(tablepar.getOrderByColumn())) {
	        //	testExample.setOrderByClause(StringUtils.toUnderScoreCase(tablepar.getOrderByColumn()) +" "+tablepar.getIsAsc());
	        //}else{
	        //	testExample.setOrderByClause("id ASC");
	        //}
	        PageHelper.startPage(tablepar.getPage(), tablepar.getLimit());
	        List<BusCopyFile> list= busCopyFileMapper.selectByExample(testExample);
	        PageInfo<BusCopyFile> pageInfo = new PageInfo<BusCopyFile>(list);
	        return  pageInfo;
	 }

	@Override
	public int deleteByPrimaryKey(String ids) {
				
			List<String> lista=ConvertUtil.toListStrArray(ids);
			BusCopyFileExample example=new BusCopyFileExample();
			example.createCriteria().andIdIn(lista);
			return busCopyFileMapper.deleteByExample(example);
			
				
	}
	
	
	@Override
	public BusCopyFile selectByPrimaryKey(String id) {
				
			return busCopyFileMapper.selectByPrimaryKey(id);
				
	}

	
	@Override
	public int updateByPrimaryKeySelective(BusCopyFile record) {
		return busCopyFileMapper.updateByPrimaryKeySelective(record);
	}
	
	
	/**
	 * 添加
	 */
	@Override
	public int insertSelective(BusCopyFile record) {
				
		//添加雪花主键id
		record.setId(SnowflakeIdWorker.getUUID());
			
				
		return busCopyFileMapper.insertSelective(record);
	}
	
	
	@Override
	public int updateByExampleSelective(BusCopyFile record, BusCopyFileExample example) {
		
		return busCopyFileMapper.updateByExampleSelective(record, example);
	}

	
	@Override
	public int updateByExample(BusCopyFile record, BusCopyFileExample example) {
		
		return busCopyFileMapper.updateByExample(record, example);
	}

	@Override
	public List<BusCopyFile> selectByExample(BusCopyFileExample example) {
		
		return busCopyFileMapper.selectByExample(example);
	}

	
	@Override
	public long countByExample(BusCopyFileExample example) {
		
		return busCopyFileMapper.countByExample(example);
	}

	
	@Override
	public int deleteByExample(BusCopyFileExample example) {
		
		return busCopyFileMapper.deleteByExample(example);
	}

	/*
	 * @Author WanCC
	 * @Date 2021/7/22 10:55
	 * @Description  获取上传文件处理下载
	 */
	public int copyFile(BusCopyFile busCopyFile,String tQ_Area, HttpServletResponse response)
	{
		try
		{
			response.setContentType("text/html;charset=UTF-8");
			// 清空response
			response.reset();
			// 设置response的Header，防止中文乱码...
			String fileName = ExportPOIUtil.getFileNameEncoder("施工日志copy"+ DateUtils.getDate()) + "." + "doc";
			response.setHeader("Content-Disposition", "attachment; filename=" + fileName);
			response.addHeader("Pargam", "no-cache");
			response.addHeader("Cache-Control", "no-cache");
			// 设置强制下载不打开
			//response.setContentType("application/force-download");
		}
		catch (IOException ex)
		{
			ex.printStackTrace();
		}
		try{

			XWPFDocument doc = getBuild(busCopyFile,tQ_Area);
//			String destPath="施工日志copy"+ DateUtils.getDate()+".docx";
//			FileOutputStream outStream = null;
//			outStream = new FileOutputStream(destPath);
//			doc.write(outStream);
//			outStream.close();

			//写入到response中实现下载
			OutputStream outputStream = response.getOutputStream();
			if(doc!=null){
				doc.write(outputStream);
			}

			outputStream.flush();
			outputStream.close();
			System.out.println("*****合成成功********");
		}catch(Exception e){
			e.printStackTrace();
		}
		return 0;
	}
	public static XWPFDocument getBuild(BusCopyFile busCopyFile,String tQ_Area){
		XWPFDocument doc = null;
		try{
			File file = new File(busCopyFile.getFileLocation());
			if(!file.exists()){
				return doc;
			}
			InputStream inputStream = new FileInputStream(file);
			doc = new XWPFDocument(inputStream);
			List<XWPFTable> tables = doc.getTables();
			List<XWPFTableRow> rows;
			List<XWPFTableCell> cells;

			for (int i=0;i<tables.size();i++) {
				if(i+busCopyFile.getTcts() < tables.size()){
					parseNewValue(tables.get(i),tables.get(i+busCopyFile.getTcts()),tQ_Area);
				}else{
					parseNewValue(tables.get(i),busCopyFile,tQ_Area);
				}
                /*
                for (XWPFTableRow row : rows) {
                    //获取行对应的单元格
                    cells = row.getTableCells();
                    for (XWPFTableCell cell : cells) {
                        System.out.println(cell.getText());;
                    }
                }

                 */
			}
			//doc.write(inputStream);
		}catch(Exception e){
			e.printStackTrace();
		}
		return doc;
	}
	private static void parseNewValue(XWPFTable tableOld,XWPFTable tableNew,String tQ_Area)
	{
		//获取表格对应的行
		List<XWPFTableRow> rows = tableNew.getRows();
		List<XWPFTableCell> cells = rows.get(0).getTableCells();
		XWPFTableCell cell0 = cells.get(0);
		XWPFTableCell cell1 = cells.get(1);

		List<XWPFTableRow> rowsOld = tableOld.getRows();
		List<XWPFTableCell> cellsOld = rowsOld.get(0).getTableCells();
		System.out.println("old = "+cellsOld.get(0).getText());
		System.out.println("old = "+cellsOld.get(1).getText());
		replaceValue(cellsOld.get(0),cell0.getText());
		replaceValue(cellsOld.get(1),cell1.getText());

		System.out.println("new = "+cellsOld.get(0).getText());
		System.out.println("new = "+cellsOld.get(1).getText());
	}

	private static void parseNewValue(XWPFTable tableOld, BusCopyFile busCopyFile,String tQ_Area)
	{
		List<XWPFTableRow> rowsOld = tableOld.getRows();
		List<XWPFTableCell> cellsOld = rowsOld.get(0).getTableCells();
		String cell0OldValue = cellsOld.get(0).getText();
		String[] rqs = cell0OldValue.split("  ");
		String strDate = rqs[0];
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");// 定义日期格式
		Date date = null;
		try {
			date = format.parse(strDate);// 将字符串转换为日期
		} catch (ParseException e) {
			System.out.println("输入的日期格式不合理！");
		}
		String accDate = getAfterDay(date,busCopyFile.getTcts());
		String week = CalendarUtil.getWeek(accDate);
		String cell0NewValue = accDate+"  "+week;
		String cell1NewValue = WeatherUtil.getWeatherByDay(accDate,tQ_Area);


		System.out.println("old = "+cellsOld.get(0).getText());
		System.out.println("old = "+cellsOld.get(1).getText());
		replaceValue(cellsOld.get(0),cell0NewValue);
		replaceValue(cellsOld.get(1),cell1NewValue);

		System.out.println("new = "+cellsOld.get(0).getText());
		System.out.println("new = "+cellsOld.get(1).getText());

	}
	public  static void replaceValue(XWPFTableCell cell,String aftertext){
		//1. 替换段落中的指定文字
		List<XWPFParagraph> itPara = cell.getParagraphs();
		cell.removeParagraph(0);
		XWPFParagraph newPara = cell.addParagraph();
		XWPFRun run = newPara.insertNewRun(0);
		run.setText(aftertext);
		run.setFontSize(12);
		newPara.setAlignment(ParagraphAlignment.CENTER);
	}

	public static String getAfterDay(Date date,int after) {
		SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date); // 设置时间
		calendar.set(Calendar.DAY_OF_MONTH, calendar.get(Calendar.DAY_OF_MONTH) + after); //
		date = calendar.getTime();
		String accDate = format.format(date);
		return accDate;
	}
}
