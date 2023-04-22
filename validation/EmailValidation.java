package clientCard.validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class EmailValidation {
    private String mail;

    /**
     * Constructs an EmailValidation object with the specified email address.
     *
     * @param mail the email address to validate
     */
    public EmailValidation(String mail) {
        this.mail = mail;
    }


    /**
     * Calls the validation methods to check if the email address is valid.
     */
    public void validmail() {
        validationSymbolDog();
        checkDomen();
    }

    /**
     * Validates the email address using a regular expression pattern.
     * If the email address does not match the pattern, an exception is thrown.
     */
    public void validationSymbolDog() {
        String test1 = "^[A-z0-9]+([_!#$%&’*+/=?`{|}~^.-][A-z0-9]+)*(?!.*([_!#$%&’*+/=?`{|}~^.-])\\1)*@[A-z0-9]+\\.[A-z0-9]+(\\.[A-z0-9]+)*$";
        Pattern pattern = Pattern.compile(test1);
        Matcher matcher = pattern.matcher(mail);
        try {
            if (!matcher.matches()) {
                throw new Exception();
            }
        } catch (Exception e) {
            System.out.println("No such email exists");
        }
    }

    /**
     * Checks whether the domain of the email address is in a list of valid domains.
     * If the domain is not in the list, an exception is thrown.
     */
    public void checkDomen() {
        BufferedReader br = null;
        try {
            String path = "/home/gor/Desktop/BankAccount/src/clientCard/emailDomain.txt";
            br = new BufferedReader(new FileReader(path));
            String domen = mail.substring(mail.indexOf('@') + 1, mail.length());
            String line;
            boolean test = false;
            while ((line = br.readLine()) != null) {
                if (line.equals(domen)) {
                    test = true;
                    break;
                }
            }
            if (test == false) {
                throw new Exception();
            }
            br.close();
        } catch (Exception ex) {
            System.out.println("No such domain exists");
        }
    }
}

    

