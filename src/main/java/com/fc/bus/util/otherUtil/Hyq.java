package com.fc.bus.util.otherUtil;

/**
 * @author Wan CC
 * @create 2021-04-22 15:09
 * @Description: 查询成分列表中是否含有禁用成分
 */
public class Hyq
{
    public static void main(String[] args)
    {
        //成分查询网址
        //http://ftba.nmpa.gov.cn:8181/ftban/fw.jsp
        String [] forbiddenStr = getForbidden();
        String [] testStr = setTestStr();
        stringArrayCompare(forbiddenStr,testStr);
    }
    public static String[] getForbidden(){
        String [] forbiddenStr = new String[]{"维A酸","水杨酸","二羟基丙酮","视黄醇","邻苯二甲酸盐",
                                              "Beta hydroxy acidβ","羟基酸",
                                              "BHA","丁基羟基茴香醚",
                                              "Differin(adapelene)","达芙文","阿达帕林","丙二醇","edta凝胶",
                                              "Retin-A","Renova(tretinoin)","维甲酸润肤霜",
                                              "Retinoic acid","视黄酸","维甲酸",
                                              "Retinol","视黄醇","维生素A",
                                              "Retinyl linoleate","维他命A亚油酸酯","A酯","视黄醇亚油酸酯",
                                              "Retinyl palmitate","棕榈酸视黄酯",
                                              "Salicylic acid","水杨酸",
                                              "Tazorac and avage(Tazarotene)","他扎罗汀","盐酸关附甲素",
                                              "Tretinoin","维甲酸","氢醌","hydroquinon",
                                              "雷廷-A","Retin-A","四环素","tetracycline",
                                              "维甲","Retinoid","水杨酸","SalicylicAcid",
                                              "二羟基丙酮","dihydroxyacetone",
                                              "视黄醇","Retinols",
                                              "邻苯二甲酸","Phthalates","甲基异噻米唑啉酮",
                                              "二羟基丙酮","过氧化苯","铝","铅","汞","砷",
                                              "维A醇","对羟苯甲酸","乙醇","环五聚二甲基硅氧烷",
                                              "二苯酮类","烟酰胺","邻苯二甲酸盐","AHA","苯甲醇",
                                              "甲氧基肉桂酸乙基乙酯","曲酸","甲基异噻唑啉酮",
                                              "呲硫","二乙醇胺","过氧苯甲酰","二苯酮","水杨酸","水杨酸乙基乙酯",
                                              "樟脑","对苯二胺","间苯二酚","三氯","甲苯","冬青"};
        return forbiddenStr;
    }
    public static String[] setTestStr(){
        String [] testStr = new String[]{"水","环五聚二甲基硅氧烷","(三乙氧基辛基硅烷,氢氧化铝,CI 77891)","椰油酸癸酯","(环五聚二甲基硅氧烷,聚二甲基硅氧烷,聚二甲基硅氧烷/乙烯基聚二甲基硅氧烷交联聚合物,氢化蓖麻油异硬脂酸酯)","丁二醇","(月桂基 PEG-9 聚二甲基硅氧乙基聚二甲基硅氧烷,生育酚（维生素E）)","(碳酸二辛酯,生育酚（维生素E）)","(环五聚二甲基硅氧烷,丙烯酸（酯）类/聚二甲基硅氧烷共聚物)","三甲基硅烷氧基硅酸酯","苯基聚三甲基硅氧烷","1,2-戊二醇","二硬脂二甲铵锂蒙脱石","(合成氟金云母,三乙氧基辛基硅烷)","(CI 77492,三乙氧基辛基硅烷)","硅石","聚甘油-3 聚二甲基硅羟乙基聚二甲基硅氧烷","(聚甲基硅倍半氧烷,异十二烷)","硫酸镁","(苯氧乙醇,乙基己基甘油)","PEG-10 聚二甲基硅氧烷","(CI 77491,三乙氧基辛基硅烷)","(CI 77499,三乙氧基辛基硅烷)","（日用）香精","EDTA 二钠","(辛酸/癸酸甘油三酯,东当归（ANGELICA ACUTILOBA）根提取物,人参（PANAX GINSENG）根提取物,银杏（GINKGO BILOBA）叶提取物,赤芝（GANODERMA LUCIDUM）茎提取物,桃（PRUNUS PERSICA）核仁提取物,刺五加（ACANTHOPANAX SENTICOSUS）根提取物,鹿茸提取物)","(丁二醇,麦芽糊精,水,库拉索芦荟（ALOE BARBADENSIS）叶提取物)"};
        return testStr;
    }

    public static boolean stringArrayCompare(String[] forbiddenStr, String[] testStr)
    {
        boolean flag = false;
        for(int i = 0; i < forbiddenStr.length; i++){
            for(int j = 0; j < testStr.length; j++){
                if(forbiddenStr[i].equals(testStr[j])){
                    flag = true;
                    System.out.println("禁止使用，含有"+testStr[j]);
                    break;
                }else if(testStr[j].contains(forbiddenStr[i])){
                    flag = true;
                    System.out.println("不能使用，含有"+testStr[j]+",类似"+forbiddenStr[i]);
                    break;
                }else{
                    flag = false;
                }
            }
        }
        if(!flag){
            System.out.println("可以考虑");
        }
        return flag;
    }
}
