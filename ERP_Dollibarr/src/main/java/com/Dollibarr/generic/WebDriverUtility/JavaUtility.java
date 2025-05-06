package com.Dollibarr.generic.WebDriverUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility 
{
public int getRandomNumber()
{
	Random r=new Random();
	int rNumber = r.nextInt(100000);
	return rNumber;
}
public String getSystemDateInFormatDDMMYYY()
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	String actDate = sim.format(date);
	return actDate;	
}
public String getSystemDateInFormatYYYYMMDD()
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String actDate = sim.format(date);
	return actDate;	
}
public String getSystemDateInFormatMMDDYYYY()
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
	String actDate = sim.format(date);
	return actDate;	
}
public String detRequiredDateInFormatDDMMYYYY(int days)
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("dd-MM-yyyy");
	sim.format(date);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
    String reqDate = sim.format(cal.getTime());
    return reqDate;
}
public String detRequiredDateInFormatYYYYMMDD(int days)
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	sim.format(date);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
    String reqDate = sim.format(cal.getTime());
    return reqDate;
}
public String detRequiredDateInFormatMDDMYYYY(int days)
{
	Date date=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("MM-dd-yyyy");
	sim.format(date);
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH,days);
    String reqDate = sim.format(cal.getTime());
    return reqDate;
}

}
