package com.fc.bus.util;

import com.alibaba.fastjson.JSONObject;
import com.fc.bus.model.auto.BusDailyLog;
import com.fc.v2.util.StringUtils;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.util.ArrayList;
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
            doc = Jsoup.connect("http://www.tianqihoubao.com/lishi/jinan/month/"+month+".html").timeout(4000).get();
        }catch(IOException e){
            e.printStackTrace();
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
}
