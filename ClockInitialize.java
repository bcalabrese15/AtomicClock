package AtomicClockPackage;

import java.net.Socket;

import java.util.Arrays;
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
	public static String timeString;
	public static void serverCall()
	{
		//Get data from server
		try {
			Socket serverData = new Socket(SERVER, PORT); //connects to the server and port
			BufferedReader byteData = new BufferedReader
					(new InputStreamReader(serverData.getInputStream())); //creates a buffered reader which reads the output from the server
			 while (true) {
		          if ((timeString = byteData.readLine()).indexOf("*") > -1) {//sometimes this line doesn't work for some reason. I believe it's a server-side issue
		             break; //if the bufferedreader encounters a "*", the reader stops reading the input
		          }
		       }
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}//try/catch for possible exceptions from the server
	}
	public String toString()
	{
		//Returns the time in String form.
		ClockInitialize c = new ClockInitialize();
		c.serverCall(); //initialize and call the server
		char[] timeArray = Arrays.copyOfRange(timeString.toCharArray(), 15, 23);
		if(timeArray[0] == '1' && (int) timeArray[1] > 2)//converting from military to AM/PM
		{
			timeArray[0] = '0';
			int temp = (int) timeArray[1];
			temp = temp - 2;//this seems messy but I don't know how to do it another way
			timeArray[1] = (char) temp;
			String time = new String(timeArray);
			return time + " PM UTC"; 
		}
		String time = new String(timeArray);
		return time + " AM UTC";
	}
	public static void main(String args[])
	{
		ClockInitialize clock = new ClockInitialize();//initializes clock object
		System.out.println(clock.toString());//prints
	}
}
