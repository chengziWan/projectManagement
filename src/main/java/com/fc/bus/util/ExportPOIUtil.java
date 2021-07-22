package com.fc.bus.util;

import com.fc.v2.util.DateUtils;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.xwpf.usermodel.*;
import org.apache.xmlbeans.XmlOptions;
import org.openxmlformats.schemas.wordprocessingml.x2006.main.CTBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.util.*;

/**
 * @author Wan CC
 * @create 2021-01-27 11:13
 * @Description: https://blog.csdn.net/qq_34545192/article/details/77847849
 */
public class ExportPOIUtil
{

    public static void mainTest2 (String[] args) throws Exception {
        File newFile = new File("D:/aaa/all.doc");
        List<File> srcfile = new ArrayList<>();

        File file1 = new File("D:/aaa/施工日志2020年12月10日.doc");
        File file2 = new File("D:/aaa/施工日志2020年12月11日.doc");
        srcfile.add(file1);
        srcfile.add(file2);

        try {
            OutputStream dest = new FileOutputStream(newFile);
            ArrayList<XWPFDocument> documentList = new ArrayList<>();
            XWPFDocument doc = null;
            for (int i = 0; i < srcfile.size(); i++) {
                FileInputStream in = new FileInputStream(srcfile.get(i).getPath());
                OPCPackage open = OPCPackage.open(in);
                XWPFDocument document = new XWPFDocument(open);
                documentList.add(document);
            }
            for (int i = 0; i < documentList.size(); i++) {
                doc = documentList.get(0);
                if(i == 0){//首页直接分页，不再插入首页文档内容
                    //documentList.get(i).createParagraph().createRun().addBreak(BreakType.PAGE);
                    //                    appendBody(doc,documentList.get(i));
                }else if(i == documentList.size()-1){//尾页不再分页，直接插入最后文档内容
                    appendBody(doc,documentList.get(i));
                }else{
                    //documentList.get(i).createParagraph().createRun().addBreak(BreakType.PAGE);
                    appendBody(doc,documentList.get(i));
                }
            }
            doc.write(dest);
            System.out.println("*****合成成功********");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void appendBody(XWPFDocument src, XWPFDocument append) throws Exception {
        CTBody src1Body = src.getDocument().getBody();
        CTBody src2Body = append.getDocument().getBody();

        List<XWPFPictureData> allPictures = append.getAllPictures();
        // 记录图片合并前及合并后的ID
        Map<String,String> map = new HashMap<String,String>();
        for (XWPFPictureData picture : allPictures) {
            String before = append.getRelationId(picture);
            //将原文档中的图片加入到目标文档中
            String after = src.addPictureData(picture.getData(), Document.PICTURE_TYPE_PNG);
            map.put(before, after);
        }
        appendBody(src1Body, src2Body,map);
    }

    public static void appendBody(CTBody src, CTBody append,Map<String,String> map) throws Exception {
        XmlOptions optionsOuter = new XmlOptions();
        optionsOuter.setSaveOuter();
        String appendString = append.xmlText(optionsOuter);

        String srcString = src.xmlText();
        String prefix = srcString.substring(0,srcString.indexOf(">")+1);
        String mainPart = srcString.substring(srcString.indexOf(">")+1,srcString.lastIndexOf("<"));
        String sufix = srcString.substring( srcString.lastIndexOf("<") );
        String addPart = appendString.substring(appendString.indexOf(">") + 1, appendString.lastIndexOf("<"));
        if (map != null && !map.isEmpty()) {
            //对xml字符串中图片ID进行替换
            for (Map.Entry<String, String> set : map.entrySet()) {
                addPart = addPart.replace(set.getKey(), set.getValue());
            }
        }
        //将两个文档的xml内容进行拼接
        CTBody makeBody = CTBody.Factory.parse(prefix+mainPart+addPart+sufix);
        src.set(makeBody);
    }

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

        //getBuild("static/exportModel/dailyLog/dailyModel.doc",contentMapList);

    }

    public static void getBuild(String  tmpFile, List<Map<String, String>> contentMapList, HttpServletResponse response){
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            // 清空response
            response.reset();
            // 设置response的Header，防止中文乱码...
            String fileName = getFileNameEncoder("施工日志"+ DateUtils.getDate()) + "." + "doc";
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
            //File newFile = new File("D:/aaa/all.doc");
            //OutputStream dest = new FileOutputStream(newFile);
            XWPFDocument doc = new XWPFDocument();
            for(int i=0;i<contentMapList.size();i++){
                Map<String, String> contentMap = contentMapList.get(i);
                XWPFDocument appendDoc = getBuild(tmpFile, contentMap);
                if(i==0){
                    doc = appendDoc;
                }else{
                    appendBody(doc,appendDoc);
                }

            }
            //doc.write(dest);

            //写入到response中实现下载
            OutputStream outputStream = response.getOutputStream();
            doc.write(outputStream);
            outputStream.flush();
            outputStream.close();
            System.out.println("*****合成成功********");
        }catch(Exception e){
            e.printStackTrace();
        }
    }
    public static XWPFDocument getBuild(String  tmpFile, Map<String, String> contentMap)
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
                            //System.out.println("text="+aftertext);
                            for (Map.Entry<String, String> e : contentMap.entrySet()) {
                                if (cell.getText().contains("${" + e.getKey() + "}")) {
                                    aftertext = aftertext.replace("${" + e.getKey() + "}",e.getValue());
                                }
                            }
                            //System.out.println("aftertext="+aftertext);
                            run.get(ii).setText(aftertext,0);
                        }
                    }
                }
            }
        }
        return document;
    }
    //以字节码的方式下载
    public static HttpServletResponse download(byte[] bytes, String fileName, String fileExt, HttpServletResponse response )
    {
        try
        {
            response.setContentType("text/html;charset=UTF-8");
            // 清空response
            response.reset();
            // 设置response的Header，防止中文乱码...
            fileName = getFileNameEncoder(fileName) + "." + fileExt;
            response.setHeader("Content-Disposition", "attachment; filename=" + fileName);

            response.addHeader("Content-Length", "" + bytes.length);
            OutputStream toClient = new BufferedOutputStream(response.getOutputStream());
            response.setContentType("application/octet-stream");
            toClient.write(bytes);
            toClient.flush();
            toClient.close();
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

        return response;
    }
    public static String getFileNameEncoder(String fileName) throws UnsupportedEncodingException
    {
        if (false)//isMSIE
        {
            //IE浏览器的乱码问题解决
            return URLEncoder.encode(fileName, "UTF-8");
        }
        else
        {
            //万能乱码问题解决
            return new String(fileName.getBytes("UTF-8"), "ISO-8859-1");
        }
    }
}
