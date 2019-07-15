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
	public static String temp;
	public static void serverCall()
	{
		//Get data from server
		try {
			Socket serverData = new Socket(SERVER, PORT); //connects to the server and port
			BufferedReader byteData = new BufferedReader
					(new InputStreamReader(serverData.getInputStream())); //created bufferedreader(?) from the server
			 while (true) {
		          if ( (temp = byteData.readLine()).indexOf("*") > -1) {
		             break; //if the bufferedreader encounters a "*", the reader stops(?)
		          }
		       }
		} catch (UnknownHostException e) {
			System.out.println("UnknownHostException");
			e.printStackTrace();
		} catch (IOException e) {
			System.out.println("IOException");
			e.printStackTrace();
		}
	}
	public String toString()
	{
		//Returns the time in String form.
		ClockInitialize c = new ClockInitialize();
		c.serverCall(); //initialize and call the server
		return temp;//i'll need to replace this
	}
}
