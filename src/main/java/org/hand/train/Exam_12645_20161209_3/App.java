package org.hand.train.Exam_12645_20161209_3;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.Scanner;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	System.out.print("请输入日期：");
    	Scanner input=new Scanner(System.in);
    	String date=null;
    	int year=0,month=0,dayOfMonth=0;
    	try{
    		date=input.next("\\d{4}-[01]\\d-[0123]\\d");
    		String[] numStr=date.split("-");
    		year=Integer.parseInt(numStr[0]);
    		month=Integer.parseInt(numStr[1]);
    		dayOfMonth=Integer.parseInt(numStr[2]);
    	}catch(Exception ex){
    		System.out.println("输入格式错误，请重新输入");
    		System.exit(0);
    	}
    	int dayOfYear=getDayofYear(year,month,dayOfMonth);
        System.out.println("你输入的日期为当年的第"+dayOfYear+"天");
    }
    
    public static int getDayofYear(int year, int month, int dayOfMonth) {  
    	int dayOfYear=0;
    	for(int i=1;i<month;i++){
    		dayOfYear+=getNumberOfDaysInMonth(year,month);
    	}
        return dayOfYear + dayOfMonth;
    }
    
    /**获取月份的天数**/
    public static int getNumberOfDaysInMonth(int year,int month){
        if(month==1||month==3||month==5||month==7||month==8||month==10||month==12)
            return 31;
        if(month==4||month==6||month==9||month==11)
            return 30;
        if(month==2)
            return isLeapYear(year)?29:28;
        return 0;
    }
    
    /**判断是否是闰年**/
    public static boolean isLeapYear(int year){
        return year%400==0||(year%4==0&&year%100!=0);
    }
}
