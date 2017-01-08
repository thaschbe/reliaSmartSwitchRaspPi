package reliaSmartSwitchRaspPi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
//import javax.imageio.IIOException;

public class SmartSwitchRaspPi {

	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
		int Cnt=0;
		String httpGetReturn;
		System.out.println("Starting ...");
		while (true)
			{
			System.out.println("Loop " + Cnt);
			Cnt++;
			httpGetReturn = httpGet();
			System.out.println("httpGet " + httpGetReturn);
			SmartSwitchSystemInfo.readSystemInfo();
			Thread.sleep(3000);
			}

	}
	
	public static String httpGet() throws IOException {
		  URL url = new URL("http://localhost:8080/reliaSmartSwitchWebServer/services/SwitchIf");
		  HttpURLConnection conn =
		      (HttpURLConnection) url.openConnection();

		  if (conn.getResponseCode() != 200) {
		    throw new IOException(conn.getResponseMessage());
		  }

		  // Buffer the result into a string
		  BufferedReader rd = new BufferedReader(
		      new InputStreamReader(conn.getInputStream()));
		  StringBuilder sb = new StringBuilder();
		  String line;
		  while ((line = rd.readLine()) != null) {
		    sb.append(line);
		  }
		  rd.close();

		  conn.disconnect();
		  return sb.toString();
		}
}

// *********************** END OF FILE *************************