package tp.epita;

import org.apache.commons.lang3.StringUtils;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        System.out.println(isAllLowerOrUpperCase("HELLO"));
        System.out.println(isAllLowerOrUpperCase("HeLlo"));
        System.out.println(isAllLowerOrUpperCase("hello"));
        System.out.println(isAllLowerOrUpperCase("hello@you!"));
    }

    public static boolean isAllLowerOrUpperCase(String input){
        return StringUtils.isAllUpperCase(input) || StringUtils.isAllLowerCase(input);
    }
}
