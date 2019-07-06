package AtomicClockPackage;

import java.net.Socket;

public class ClockInitialize
//Initialized the clock by gathering data from the publicly available NIST server
//DO NOT EXCEED 1 QUERY EVERY 4 SECONDS
{
	public static final String SERVER = "129.6.15.29";//NIST, Gaithersburg, Maryland, time-b-g.nist.gov 
	public static final int PORT = 13;
	public static void serverCall()
	{
		//Get data from server
		//Do I need a return statement? Maybe
	}
	public String toString()
	{
		//Returns the time in String form.
		return "a";
	}
}
