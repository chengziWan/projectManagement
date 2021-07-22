package com.fc.bus.util;

import com.alibaba.fastjson.JSONObject;
import com.fc.bus.model.auto.BusDailyLog;
import com.fc.v2.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.net.SocketTimeoutException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author Wan CC
 * @create 2021-01-27 15:31
 * @Description:
 */
public class WeatherUtil
{
    public static void main(String[] args)
    {
            getWeatherByYearMonth("202101");
    }

    public static List<BusDailyLog> getWeatherByYearMonth(String month)
    {

        List<BusDailyLog> list = new ArrayList<>();
        Document doc = null;
        try{
            //https://www.cnblogs.com/interdrp/p/9275303.html  可能会超时
            //doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/month/"+month+".html").timeout(10000).get();
            doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/month/"+month+".html")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
                    .header("Connection", "close")//如果是这种方式，这里务必带上
                    .timeout(8000)//超时时间
                    .get();
        }catch(SocketTimeoutException e){
            try{
                doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/month/"+month+".html")
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
                        .header("Connection", "close")//如果是这种方式，这里务必带上
                        .timeout(8000)//超时时间
                        .get();
            }catch(IOException ioException){
                ioException.printStackTrace();
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }

        Elements elementsByTag = doc.getElementById("content").getElementsByTag("tr");
        Elements elementsByTag1 = doc.getElementById("content").getElementsByTag("b");

        for(Element el : elementsByTag)
        {
            String weather = "";
            Elements elementsByTag2 = el.getElementsByTag("td");
            for(Element etd:elementsByTag2){
                String text1 = etd.text();
                if(text1.indexOf("℃")<=0){
                    text1 = text1.substring(0,(text1.indexOf("/")<0?text1.length():text1.indexOf("/")));
                }else{
                    text1 = text1+" ";
                }

                //System.out.println(text1);
                weather += text1;
            }
            //System.out.println(weather);
            BusDailyLog busDailyLog = new BusDailyLog();
            String rBRQ=weather.substring(0,11);
            busDailyLog.setRBRQ(rBRQ);
            String week = CalendarUtil.getWeek(rBRQ);
            if(StringUtils.isEmpty(week)){
                continue;
            }
            busDailyLog.setXQJ(week);
            busDailyLog.setTQ(weather.substring(11));

            list.add(busDailyLog);
        }
        System.out.println(JSONObject.toJSONString(list));
        return list;
    }

    public static String getWeatherByDay(String accDate)
    {
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日");// 定义日期格式
        Date date = null;
        try {
            date = format.parse(accDate);// 将字符串转换为日期
        } catch (ParseException e) {
            System.out.println("输入的日期格式不合理！");
        }
        SimpleDateFormat format2 = new SimpleDateFormat("yyyyMMdd");
        String accDate2 = format2.format(date);
        String weather = "";
        Document doc = null;
        try{
            //http://www.tianqihoubao.com/lishi/jinan/20210301.html
            //doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/month/"+month+".html").timeout(10000).get();
            doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/"+accDate2+".html")
                    .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
                    .header("Connection", "close")//如果是这种方式，这里务必带上
                    .timeout(8000)//超时时间
                    .get();
        }catch(SocketTimeoutException e){
            try{
                doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/"+accDate2+".html")
                        .header("User-Agent", "Mozilla/5.0 (Windows NT 6.1; Win64; x64; rv:49.0) Gecko/20100101 Firefox/49.0")
                        .header("Connection", "close")//如果是这种方式，这里务必带上
                        .timeout(8000)//超时时间
                        .get();
            }catch(IOException ioException){
                ioException.printStackTrace();
            }
        }catch(Exception ee){
            ee.printStackTrace();
        }

        Elements elementsByTag = doc.getElementById("content").getElementsByTag("tr");
        String td1 = elementsByTag.get(1).getElementsByTag("td").get(1).text();
        String td21 = elementsByTag.get(2).getElementsByTag("td").get(1).text();
        String td22 = elementsByTag.get(2).getElementsByTag("td").get(2).text();
        String td3 = elementsByTag.get(3).getElementsByTag("td").get(1).text();
        weather = td1+" "+td21+" / "+td22+" "+td3;

       return weather;
    }
}
