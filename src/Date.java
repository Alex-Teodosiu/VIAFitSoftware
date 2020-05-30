import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;

public class Date implements Serializable
{
  private static final long serialVersionUID = -5219952105955470173L;
  private int day, month, year;
  private String timeInterval;
  private String date;

  public Date(int d, int m, int y, String timeInterval){
    day = d;
    month = m;
    year = y;
    this.timeInterval = timeInterval;
    date = ""+day+"/"+month+"/"+year;
  }

  public Date(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  public String getDate(){
    return date;
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

  public boolean equals(Object obj){
    if (!(obj instanceof Date)){
      return false;
    }
    return day==((Date) obj).day && month == ((Date) obj).month && year == ((Date) obj).year
        && timeInterval.equals(((Date) obj).timeInterval);
  }
}
