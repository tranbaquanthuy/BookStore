package Connection;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;

public class CheckInternet extends Thread {
	boolean isRunning = true;
	public void run()
	   {
	while(isRunning == true)
	{
    try {
		sleep(5000);
	} catch (InterruptedException e1) {
		// TODO Auto-generated catch block
		e1.printStackTrace();
	}
	try {
        final URL url = new URL("http://www.google.com");
        final URLConnection conn = url.openConnection();
        conn.connect();
        conn.getInputStream().close();
        System.out.println("Connected");
    } catch (MalformedURLException e) {
    	System.out.println("Disconnected 2");
    } catch (IOException e2) {
    	 System.out.println("Disconnected");
    }
	   }
	   }
}
