import fr.simplifia.input.locale.LocaleExtractor;
import fr.simplifia.input.validator.SmpInputValidator;
import fr.simplifia.input.validator.impl.SmpInputValidatorFactory;
import fr.simplifia.transform.SmpDataTransformer;

import java.util.Locale;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Main {

    public static void main(final String[] arg) {
        final Scanner scanInput = new Scanner(System.in);
        System.out.println("Enter your locale (fr,en,de...): ");
        Pattern regex = Pattern.compile("[a-zA-Z]*");
        final String localeRead = scanInput.nextLine();
        System.out.println("Your locale is : "+localeRead);
        if(regex.matcher(localeRead).matches()) {
        final Locale locale = LocaleExtractor.toLocale(localeRead);

        System.out.println("Enter your text : ");
        final String input = scanInput.nextLine();
        System.out.println("Your Text is : "+input);
        scanInput.close();
        if(regex.matcher(localeRead).matches()) {
        
        final SmpInputValidator validator = SmpInputValidatorFactory.fromLocale(locale);
        final SmpDataTransformer transformer = new SmpDataTransformer(validator);
        final String transformedInput = transformer.transform(input);
        System.out.println("Your locale is : "+localeRead+" and your Text is : "+input);
        System.out.println(transformedInput);}
        else {
        	System.out.println("Special Characters not allowed");
        }
        }
        else {
        	System.out.println("Special Characters not allowed");
        }
    }
}
