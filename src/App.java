import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Properties;
import java.util.stream.Collectors;

/**
 * 
 */

/**
 * @author tomka
 *
 */
public class App {
	static EndPoint endPoint;
    static CasheServer casheServer;
    static Video video;
    static Request request;
   
	public static List<String> generalSettings;
	public static List<String> videoSizes;
	public static List<String> endPointsList;
	
	public static void main(String[] args)  {
		

		try {
			File dir = new File(".");
			File fin = new File(dir.getCanonicalPath() + File.separator + "me_at_the_zoo.in");
			readFile(fin);
			
		} catch (IOException e) {

			e.printStackTrace();
		}
	}
	
	
	private static void readFile(File fin) throws IOException {
		FileInputStream fis = new FileInputStream(fin);

		BufferedReader br = new BufferedReader(new InputStreamReader(fis));
		generalSettings = br.lines()
                .skip(0)
                .limit(1)
                .collect(Collectors.toList());

		List<String> videoSizes = br.lines()
                .skip(0)
                .limit(1)
                .collect(Collectors.toList());
		
		int videoN = getGeneralSettings(generalSettings.get(0),0);
		video =new Video(videoN,getIntParamList(videoSizes.get(0)));
		int endN = getGeneralSettings(generalSettings.get(0),1);
		EndPoint.endPointN = endN;
		int reqN = getGeneralSettings(generalSettings.get(0),2);
		request = new Request(reqN);
		int casheN = getGeneralSettings(generalSettings.get(0),3);
		int casheS = getGeneralSettings(generalSettings.get(0),4);
		casheServer = new CasheServer(casheN,casheS);
		
		  //HashMap<Integer, String> hmap = new HashMap<Integer, String>();

	      /*Adding elements to HashMap*/
	    //  hmap.put(12, "Chaitanya");
		
		//latensy
		//while (br.readLine() != null&&getParamSize(br.readLine().toString())==2) {
		List<String> endPointsList = br.lines()
				//.filter(predicate)
              // .skip(0)
               //.limit(1)
               .collect(Collectors.toList());
		//.filter(p -> p.getAge() > 18)
       // .map(person -> new Student(person));
		System.out.println(endPointsList.toString());
		int countN = getGeneralSettings(endPointsList.get(0),1);
		List<String> endPointsList2 = br.lines()
                .limit(countN)
                .collect(Collectors.toList());
		System.out.println(endPointsList2.toString());
		//}
		//request
	/*	while (br.readLine() != null&&getParamSize(br.readLine().toString())==3) {
		List<String> endPointsList = br.lines()
               .skip(0)
               .collect(Collectors.toList());
		
		int countN = getGeneralSettings(endPointsList.get(0),1);
		List<String> endPointsList2 = br.lines()
                .skip(0)
                .collect(Collectors.toList());
		}*/

	 
		br.close();
		Test();
	}
	
	public static Integer getGeneralSettings(String line, int index){
		String[] params = line.split("\\s+");
		return Integer.valueOf(params[index]);	
	}
	
	public static int getParamSize(String line){
		String[] params = line.split("\\s+");
		return params.length;	
	}
	
	public static List<Integer> getIntParamList(String line){
		String[] params = line.split("\\s+");
		List<Integer> listSizes = new ArrayList<Integer>() ;
		for(int i=0;i<params.length;i++){
			listSizes.add(Integer.valueOf(params[i]));	
		}	
		return listSizes;
	}
	
	public static void Test(){
		System.out.println("Video number is: "+ video.videoN +" Sizes: "+ video.videoSize.size());
		System.out.println("Cashe number is: "+ casheServer.cacheServersN +" Sizes: "+ casheServer.cacheSize);
		System.out.println("EndPoint number is: "+ endPoint.endPointN );
		System.out.println("Request number is: "+ request.requestN );
		
	}
	

}
