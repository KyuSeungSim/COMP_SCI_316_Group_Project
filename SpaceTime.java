/*
 * Project: Class Assignment Week 13
 * Group: 11
 * Name: Nicholas Daniels, KyuSeung Sim
 * Class: COMP SCI 316-0800
 * Date: DEC 01 2020
 */

public class SpaceTime implements Comparable<SpaceTime>{
	
	double x;
	double y;
	double z;
	int hour;
	int minute;
	int second;
	
	public SpaceTime(double x, double y, double z, int hour, int minute, int second) {
		this.x = x;
		this.y = y;
		this.z = z;
	    this.hour = hour;
	    this.minute = minute; 
	    this.second = second; 
	}

	
	// validate and set hour 
	public void setHour(int hour) {
		if (hour < 0 || hour >= 24) {
			throw new IllegalArgumentException("hour must be 0-23");
		}

		this.hour = hour;
	} 

	// validate and set minute 
	public void setMinute(int minute) {
	      if (minute < 0 || minute >= 60) {
	         throw new IllegalArgumentException("minute must be 0-59");
	      }

	      this.minute = minute; 
	   } 

	   // validate and set second 
	   public void setSecond(int second) {
	      if (second < 0 || second >= 60) {
	         throw new IllegalArgumentException("second must be 0-59");
	      }

	      this.second = second;
	   } 
	   
	   // get x value    
	   public double getX() {return x;}
	   
	   // get y value    
	   public double getY() {return y;}
	   
	   // get z value    
	   public double getZ() {return z;}
	   
	   // get hour value    
	   public int getHour() {return hour;}

	   // get minute value      
	   public int getMinute() {return minute;} 

	   // get second value      
	   public int getSecond() {return second;}   
	   
	   // convert to String in standard-time format (H:MM:SS AM or PM)
	   public String toString() {
		      return String.format("%s %s %s  %d:%02d:%02d %s", getX(), getY(), getZ(),
		         ((getHour() == 0 || getHour() == 12) ? 12 : getHour() % 12),
		         getMinute(), getSecond(), (getHour() < 12 ? "AM" : "PM"));
	   }

	@Override
	public int compareTo(SpaceTime sp) {
		
		if(x != 0) {
			return this.x <= sp.x ? 1 : -1;
		}

		if(y != 0) {
			return this.y <= sp.y ? 1 : -1;
		}
		
		if(z != 0) {
			return this.z <= sp.z ? 1 : -1;
		}
		
		if(hour != 0) {
			return this.hour <= sp.hour ? 1 : -1;
		}
		
		if(minute != 0) {
			return this.minute <= sp.minute ? 1 : -1;
		}
		
		return this.second <= sp.second ? 1 : -1;
   }
}
