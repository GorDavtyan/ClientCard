package clientCard.validation;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneNumberValidation {
    private String phoneNumber;

    public PhoneNumberValidation(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }


    /**
     * Validates the phone number based on a list of area codes read from a file.
     * The phone number must start with one of the area codes and have exactly 6 digits afterwards.
     * If the phone number is not valid, an exception is thrown.
     */
    public void phoneNumberValidation() {
        BufferedReader br = null;
        try {
            String path = "/home/gor/Desktop/BankAccount/src/clientCard/validation/codePhoneNumber.txt";
            String line;
            br = new BufferedReader(new FileReader(path));
            boolean test1 = false;
            while ((line = br.readLine()) != null) {
                String test = "^" + line + "([0-9]{6})$";
                Pattern pattern = Pattern.compile(test);
                Matcher matcher = pattern.matcher(phoneNumber);
                if (matcher.matches()) {
                    test1 = true;
                    break;
                }
            }
            if (test1 == false) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Invalid phone number");
        }
    }

}
