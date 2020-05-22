import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable
{
  private int minute, hour, day, month, year;

  public Date(){
    Calendar now = GregorianCalendar.getInstance();
    minute = now.MINUTE;
    hour = now.HOUR_OF_DAY;
    day = now.DAY_OF_MONTH;
    month = now.MONTH;
    year = now.YEAR;
  }

  public Date(int min, int h, int d, int m, int y){
    minute = min;
    hour = h;
    day = d;
    month = m;
    year = y;
  }

  public Date(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  public int getMinute()
  {
    return minute;
  }

  public void setMinute(int minute)
  {
    this.minute = minute;
  }

  public int getHour()
  {
    return hour;
  }

  public void setHour(int hour)
  {
    this.hour = hour;
  }

  public int getDay()
  {
    return day;
  }

  public void setDay(int day)
  {
    this.day = day;
  }

  public int getMonth()
  {
    return month;
  }

  public void setMonth(int month)
  {
    this.month = month;
  }

  public int getYear()
  {
    return year;
  }

  public void setYear(int year)
  {
    this.year = year;
  }

  public String toString(){
    DecimalFormat time = new DecimalFormat("#0");
    return time.format(year) + "-" + time.format(month) + "-" + time.format(day) + " " + time.format(hour) + ":" + time.format(minute);
  }

  public Date copy(){
    return new Date(minute, hour, day, month, year);
  }
}
