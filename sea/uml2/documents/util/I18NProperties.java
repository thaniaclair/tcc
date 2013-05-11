package documents.util;

import java.util.Locale;
import java.util.MissingResourceException;
import java.util.ResourceBundle;

public class I18NProperties
{

    /**
     * The system language.
     */
    private static String language;

    /**
     * The system country.
     */
    private static String country;

    /**
     * The local instance.
     */
    private static Locale locale;

    /**
     * The resource bundle.
     */
    private static ResourceBundle resourceBundle;

    /**
     * The path where is the I18n class.
     */
    private static final String I18N_CLASS_PATH = new String("documents.util.I18NProperties");

    /**
     * Initializes the instance variables.
     * 
     * @param args
     */
    public static void initialize(String... args)
    {
        if ((args != null) && (args.length == 2) && (args[0] != null) && (args[1] != null))
        {
            language = new String(args[0]);
            country = new String(args[1]);
            locale = new Locale(language, country);
        }
        else
        {
            language = new String("pt");
            country = new String("BR");
            locale = new Locale(language, country);
        }
        resourceBundle = ResourceBundle.getBundle(I18N_CLASS_PATH, locale);
    }

    /**
     * Gets the value associated with the key passed via parameter.
     * 
     * @param key The keyword to looking for.
     * @return A String with the value.
     */
    public static String getString(String key)
    {
        String value = new String("");
        try
        {
            value = resourceBundle.getString(key);
        }
        catch (MissingResourceException exception)
        {
            System.err.println(new StringBuilder("I18NProperties :: getString ").append(exception));
        }
        return value;
    }
}
