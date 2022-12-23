package com.fc.bus.util.otherUtil;

import com.fc.bus.model.auto.BusCopyFile;
import com.fc.bus.util.CalendarUtil;
import com.fc.bus.util.WeatherUtil;
import org.apache.poi.xwpf.usermodel.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

/**
 * @author Wan CC
 * @create 2021-07-22 11:12
 * @Description:
 */
public class TestDocument
{
    public static void main(String[] args)
    {
        String tQ_Area = "jinan";
        BusCopyFile busCopyFile = new BusCopyFile();
        busCopyFile.setFileLocation("C:\\Users\\19820\\Desktop\\11号楼施工日志202103.docx");
        busCopyFile.setTcts(2);
        getBuild(busCopyFile,tQ_Area);
    }
    public static void getBuild(BusCopyFile busCopyFile,String tQ_Area){

        try{
            File file = new File(busCopyFile.getFileLocation());
            InputStream inputStream = new FileInputStream(file);
            XWPFDocument doc = new XWPFDocument(inputStream);
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
            System.out.println("*****合成成功********");
        }catch(Exception e){
            e.printStackTrace();
        }
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
        String text;
        List<XWPFRun> run;
        cell.removeParagraph(0);
        XWPFParagraph newPara = cell.addParagraph();
        newPara.insertNewRun(0).setText(aftertext);
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
