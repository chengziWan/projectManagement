package com.fc.bus.util;

/**
 * @author Wan CC
 * @create 2021-01-29 15:19
 * @Description:
 */
public class Test
{
    public static void main(String[] args)
    {
        double month=10000;
        double jian1=791.65;
        double jian2=1000;
        for(int i=1;i<=12;i++){
            aaa(month,jian1,jian2,i);
        }
    }
    /*
     * @Author WanCC
     * @Date 2021/1/29 15:36
     * @Description  按月换算后的综合所得税率表

                    级数	应纳税所得额	税率（%）	速算扣除数
                    1	不超过3000元的	3	0
                    2	超过3000元至12000元的部分	10	210
                    3	超过12000元至25000元的部分	20	1410
                    4	超过25000元至35000元的部分	25	2660
                    5	超过35000元至55000元的部分	30	4410
                    6	超过55000元至80000元的部分	35	7160
                    7	超过80000元的部分	45	15160

     */
    public static void aaa(double month, double jian1, double jian2, int count){
        double sum = 0;
        sum=(month-jian1-jian2)*count;
        double sf=0;
        double gs=0;
        if((sum-60000)<=36000){
            gs = (month-jian1-jian2-5000)*0.03;
            System.out.println("count="+count+",jb="+month+",sf="+sf+",gs="+gs);
        }else if((sum-60000)<=144000){
            gs = (sum-60000)*0.1;
            System.out.println("count="+count+",jb="+month+",sf="+sf+",gs="+gs);
        }else if(sum<=300000){
            System.out.println("count="+count+",jb="+month+",sf="+sf+",gs="+gs);
        }
    }
}
