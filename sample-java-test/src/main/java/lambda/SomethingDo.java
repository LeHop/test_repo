package lambda;

/**
 *
 * @author hoppe
 */
public class SomethingDo {

    public static void main(String[] args) throws InterruptedException {
        Something something = new Something();
        
        Converter<String, String> converter = something::startWith;
        String converted = converter.convert("Java");
        System.out.println("1: "+converted);
        
        int num =1;
        Converter<Integer, String> stringConverter = (from) -> String.valueOf(from+num);
        converted = stringConverter.convert(2);
        System.out.println("2: "+converted);
    }
}
