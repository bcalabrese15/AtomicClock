package AtomicClockPackage;

import java.net.Socket;
import java.net.UnknownHostException;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ClockInitialize
//Initialized the clock by gathering data from the publicly available NIST server
//DO NOT EXCEED 1 QUERY EVERY 4 SECONDS
{
	public static final String SERVER = "129.6.15.29";//NIST, Gaithersburg, Maryland, time-b-g.nist.gov 
	public static final int PORT = 13;
	public static void serverCall()
	{
		//Get data from server
		try {
			Socket serverData = new Socket(SERVER, PORT);
			BufferedReader byteData = new BufferedReader
					(new InputStreamReader(serverData.getInputStream()));
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
		
		//Do I need a return statement? Maybe
	}
	public String toString()
	{
		//Returns the time in String form.
		return "a";
	}
}
