import java.io.File;

public class PullRepository {
	public static void main(String[] args){
		File file = new File("C:/Users/i331307/mysql/141250216_cseiii/AwesomeProject");
		if(!file.exists() && !file.isDirectory()){
			file.mkdir();
			try {
				Process process = Runtime.getRuntime().exec("git clone http://114.55.35.12/141250216_cseiii/AwesomeProject.git " + file.toString());
				process.waitFor();
				System.out.println("HAHA");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}else{
			try {
				Process process = Runtime.getRuntime().exec("git pull http://114.55.35.12/141250216_cseiii/AwesomeProject.git",null,file);
				process.waitFor();
				System.out.println("HAH~~~");
			} catch (Exception e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}