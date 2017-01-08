package reliaSmartSwitchRaspPi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
//import javax.imageio.IIOException;

public class SmartSwitchRaspPi 
	{
	public static void main(String[] args) throws Exception 
		{
		// TODO Auto-generated method stub
		int Cnt=0;
		String httpGetReturn = null;
		System.out.println("Starting ...");
		
		SmartSwitchGPIO SSGPIO = new SmartSwitchGPIO();
		SSGPIO.GPIOInit();
		
		
		while (true)
			{
			System.out.println("Loop " + Cnt);
			Cnt++;
			httpGetReturn = null;
			try
				{
				httpGetReturn = httpGet();
				}
			catch (IOException e)
				{
				
				}
			finally
				{
				if (httpGetReturn != null) 
					{
				    System.out.println("httpGet " + httpGetReturn);
				    }	
				}
			
			SmartSwitchSystemInfo.readSystemInfo();
			
			SSGPIO.GPIOTest();
			
			Thread.sleep(3000);
			}

		}
	
	public static String httpGet() throws IOException 
		{
		URL url = new URL("http://Thomass-iMac:8080/reliaSmartSwitchWebServer/services/SwitchIf");
		StringBuilder sb = new StringBuilder();
		HttpURLConnection conn = null;
		  
		try 
			{
		    conn = (HttpURLConnection) url.openConnection();
		    // conn.setRequestMethod("HEAD");
		    int code = conn.getResponseCode();
		    System.out.println("Response:" + code);
		    // You can determine on HTTP return code received. 200 is success.
		    if (conn != null) 
		    	{
				if (conn.getResponseCode() == 200) 
					{    
					// Buffer the result into a string
					BufferedReader rd = new BufferedReader(new InputStreamReader(conn.getInputStream()));
					String line;
					while ((line = rd.readLine()) != null) 
						{
					    sb.append(line);
					    }
					rd.close();
				    }
				conn.disconnect();
		        }
		    } 
		catch (MalformedURLException e) 
			{
		    // TODO Auto-generated catch block
		    System.out.println("HttpURLConnection threw MalformedURLException ");
		    // e.printStackTrace();
		    } 
		catch (IOException e) 
			{
		    // TODO Auto-generated catch block
		    System.out.println("HttpURLConnection threw IOException ");
		    // e.printStackTrace();
		    } 
		finally 
			{
			return sb.toString();
			}
		}
	
}

// *********************** END OF FILE *************************