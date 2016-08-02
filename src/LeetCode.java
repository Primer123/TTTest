import java.awt.datatransfer.StringSelection;
import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class LeetCode {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		LeetCode leetCode = new LeetCode();
		System.out.println(leetCode.reverse(1));
	}

	public boolean isPowerOfTwo(int n) {
        String string = "";
        string = Integer.toBinaryString(n);
        String reverse = "";
        
        for(int i = string.length() - 1 ; i >= 0 ; i --){
        	reverse = reverse + string.charAt(i);
        }
        Double d = Math.pow(2, 31);
        System.out.println(d.intValue());
        int result = 0;
        for(int i = 0 ; i < reverse.length() ; i ++){
        	if(reverse.charAt(i) == '1'){
        		result = result + (int)Math.pow(2, 31 - i);
        	}
        }

        System.out.println(result);
        return true;
    }
	
	public int reverse(int x) {
		try {
			URL url = new URL("https://www.google.com/");
			HttpURLConnection urlConnection = (HttpURLConnection) url.openConnection();
			BufferedReader reader = new BufferedReader(new InputStreamReader(urlConnection.getInputStream(),"utf-8"));
			String string = "";
			while((string = reader.readLine()) != null){
				System.out.println(string);
			}
			System.out.println(reader.readLine());
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
        return 0;
    }
}

