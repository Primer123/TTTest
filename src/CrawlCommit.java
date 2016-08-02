import java.io.BufferedReader;
import java.io.File;
import java.io.InputStreamReader;

public class CrawlCommit {
	public static void main(String[] args){
		String fileName = "";
		int addLine = 0;
		int deleteLine = 0;
		int fileNumber = 0;
		String author = "";
		String email = "";
		String date = "";
		boolean judge = false;
		int diffCount = 0;
		try {
			Process process = Runtime.getRuntime().exec("git show bae3490e18dd67c71c98dc037d36f91d2424e8e0",null,new File("C:/Users/i331307/mysql/141250216_cseiii/AwesomeProject"));
			BufferedReader reader = new BufferedReader(new InputStreamReader(process.getInputStream(),"utf-8"));
			String str = "";
			while((str = reader.readLine()) != null){
				if(str.startsWith("diff")){
					diffCount ++;
					if(diffCount > 1){
						System.out.println(fileName + ":" + addLine + "," + deleteLine);
					}
					fileName = str.split(" a/")[1].split(" b/")[0];
					addLine = 0;
					deleteLine = 0;
					judge = false;
					fileNumber ++;
				}else{
					if(str.startsWith("Author:")){
						author = str.split(" ")[1];
						email = str.split(" ")[2].substring(1, str.split(" ")[2].length() - 1);
						System.out.println(author + ":" + email);
					}
					if(str.startsWith("Date:")){
						str = str.replaceAll("\\s+", " ");
						date = str.split(" ")[5] + "-" + Enum.valueOf(MonthOfDate.class, str.split(" ")[2]).getValue() + "-" + str.split(" ")[3] + "T" + str.split(" ")[4] + ".000" + str.split(" ")[6].substring(0, 3);
						System.out.println(date);
					}
					if(str.startsWith("@@")){
						judge = true;
					}
					if(judge){
						if(str.startsWith("+")){
							addLine ++;
						}else if(str.startsWith("-")){
							deleteLine ++;
						}
					}
				}
			}
			if(diffCount >= 1){
				System.out.println(fileName + ":" + addLine + "," + deleteLine);
			}
			diffCount = 0;
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(fileNumber);
	}
}