import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable
{
  private int day, month, year;
  private String timeInterval;

  public Date(int d, int m, int y, String timeInterval){
    day = d;
    month = m;
    year = y;
    this.timeInterval = timeInterval;
  }

  public Date(int d, int m, int y){
    day = d;
    month = m;
    year = y;
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

  public String getTimeInterval(){
    return timeInterval;
  }

  public String toString(){
    DecimalFormat time = new DecimalFormat("#0");
    return time.format(day)+ "-"  + "-" + time.format(month) + time.format(year) +" "+timeInterval;
  }

  public Date copy(){
    return new Date(day, month, year, timeInterval);
  }
}
