package com.fc.bus.util;

import org.apache.poi.xwpf.usermodel.*;

import java.io.*;
import java.util.*;

/**
 * @author Wan CC
 * @create 2021-01-27 11:13
 * @Description: https://blog.csdn.net/qq_34545192/article/details/77847849
 */
public class ExportPOIUtil
{

    public static void main(String[] args) {
        List<Map<String,String>> contentMapList = new ArrayList<>();
        for(int i=0;i<3;i++){
            Map map=new HashMap();
            map.put("rBRQ","2018-5-28");
            map.put("xQJ","一");
            map.put("tQ","晴朗");
            map.put("sGBW","地面");
            map.put("sGNR","地面");
            map.put("xXJD","一半");
            map.put("sGRY","崽崽"+i);
            map.put("sGJD","1.地面一半");
            map.put("jSZLJL","无");
            map.put("jCCLJL","无");
            map.put("gCFZR","无");
            map.put("jLR","崽崽"+i);
            map.put("tJSJ","分分"+i);
            contentMapList.add(map);
        }
        getBuild("static/exportModel/dailyLog/dailyModel.doc",contentMapList,"D:/aaa.doc");
    }

    public static void getBuild(String  tmpFile, List<Map<String, String>> contentMapList, String exportFile){
        int i=0;
        for(Map<String, String> contentMap:contentMapList){
            getBuild(tmpFile, contentMap, "D:/aa"+(++i)+".doc");
        }
    }
    public static void getBuild(String  tmpFile, Map<String, String> contentMap, String exportFile)
    {
        InputStream inputStream = ExportPOIUtil.class.getClassLoader().getResourceAsStream(tmpFile);
        XWPFDocument document = null;
        try {
            document = new XWPFDocument(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
        }
        //2. 替换表格中的指定文字
        Iterator<XWPFTable> itTable = document.getTablesIterator();
        XWPFTable table;
        int rowsCount;
        while (itTable.hasNext()) {
            table = itTable.next();
            rowsCount = table.getNumberOfRows();
            for (int i = 0; i < rowsCount; i++) {
                XWPFTableRow row = table.getRow(i);
                List<XWPFTableCell> cells = row.getTableCells();
                for (XWPFTableCell cell : cells) {
                    //1. 替换段落中的指定文字
                    List<XWPFParagraph> itPara = cell.getParagraphs();
                    String text;
                    List<XWPFRun> run;
                    for(XWPFParagraph paragraph:itPara){
                        run = paragraph.getRuns();
                        for (int ii = 0, runSie = run.size(); ii < runSie; ii++){
                            text = run.get(ii).getText(run.get(ii).getTextPosition());
                            String aftertext = text;
                            System.out.println("text="+aftertext);
                            for (Map.Entry<String, String> e : contentMap.entrySet()) {
                                if (cell.getText().contains("${" + e.getKey() + "}")) {
                                    aftertext = aftertext.replace("${" + e.getKey() + "}",e.getValue());
                                }
                            }
                            System.out.println("aftertext="+aftertext);
                            run.get(ii).setText(aftertext,0);
                        }
                    }
                }
            }
        }

        //导出到文件
        try {
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            document.write(byteArrayOutputStream);
            OutputStream outputStream = new FileOutputStream(exportFile);
            outputStream.write(byteArrayOutputStream.toByteArray());
            outputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
