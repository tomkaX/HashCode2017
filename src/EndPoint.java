import java.util.List;
import java.util.Properties;

/**
 * 
 */

/**
 * @author macbook
 *
 */
public class EndPoint {
	public static int endPointN;
	static int latensy;
	static List<Integer> videoSize;
	
	Properties prop ;
	
	public EndPoint(String id, String casheId, String latency){
		prop = new Properties();
		prop.setProperty("id", id);
		prop.setProperty("casheId", casheId);
		prop.setProperty("latensy", latency);
	
	}

}
