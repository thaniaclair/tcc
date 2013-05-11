package documents.util;

public class I18NPrinter
{

    /**
     * Prints the message.
     * 
     * @param key
     */
    public static void printMessage(String key)
    {
        System.out.println(I18NProperties.getString(key));
    }

}
