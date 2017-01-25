
import java.util.Arrays;
import java.util.List;
import org.apache.log4j.Logger;

/**
 *
 * @author leho
 */
public class TryCatch {
    private static final Logger LOGGER = Logger.getLogger(TryCatch.class);
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        List<Integer> listToBatch = Arrays.asList(1,2,3,4,5,6,7);
        
//        for(int i= 0; i<10;i++){
            try{
                System.out.println(listToBatch.get(10));
            } catch (Exception e){
                LOGGER.error(e);
            }
            
            try{
                System.out.println(listToBatch.get(1));
            } catch (Exception e){
                LOGGER.error(e);
            }
//        }
    }
    
}
