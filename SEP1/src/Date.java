import java.io.Serializable;
import java.text.DecimalFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
/*** A class containing the basic fields of a date
 * @author Tamás Péter, Michal Pupák, Alexandru Mihail Teodosiu
 * @version 1.0
 * */
public class Date implements Serializable
{
  private static final long serialVersionUID = -5219952105955470173L;
  private int day, month, year;
  private String timeInterval;
  private String date;

  /**
   * Constructor initializing the date
   * @param d the day of the month (int)
   * @param m the month of the year (int)
   * @param y the year
   * @param timeInterval the time interval in string format
   */
  public Date(int d, int m, int y, String timeInterval){
    day = d;
    month = m;
    year = y;
    this.timeInterval = timeInterval;
    date = ""+day+"/"+month+"/"+year;
  }


/**
 * Constructor initializing the date
 * @param d the day of the month (int)
 * @param m the month of the year (int)
 * @param y the year
 * */
  public Date(int d, int m, int y){
    day = d;
    month = m;
    year = y;
  }

  /**
   * Returns the details of the date object
   * @return returns the details of the date object
   */
  public String getDate(){
    return date;
  }

  /**
   *
   * @return returns the day
   */
  public int getDay()
  {
    return day;
  }

  /**
    Sets the day to the parameters value
   */
  public void setDay(int day)
  {
    this.day = day;
  }

  /**
   *
   * @return returns the month
   */
  public int getMonth()
  {
    return month;
  }


  /**
   Sets the month to the parameters value
   */
  public void setMonth(int month)
  {
    this.month = month;
  }

  /**
   *
   * @return returns the year
   */
  public int getYear()
  {
    return year;
  }


  /**
  Sets the year to the parameters value
   */
  public void setYear(int year)
  {
    this.year = year;
  }

  /**
   * returns the time interval in string format
   * @return the time interval in string format
   */
  public String getTimeInterval(){
    return timeInterval;
  }


  /**
   * Returns the details of the date object
   * @return returns the details of the date object
   */
  public String toString(){
    DecimalFormat time = new DecimalFormat("#0");
    return time.format(day)+ "-"  + "-" + time.format(month) + time.format(year) +" "+timeInterval;
  }

  /**
   * Compares the date with another date
   * @param obj the date object to compare with
   * @return true if the dates are the same, false if not
   */
  public boolean equals(Object obj){
    if (!(obj instanceof Date)){
      return false;
    }
    return day==((Date) obj).day && month == ((Date) obj).month && year == ((Date) obj).year
        && timeInterval.equals(((Date) obj).timeInterval);
  }
}
