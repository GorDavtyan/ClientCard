package clientCard.validation;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PasportVaidation {
    private String pasportSeria;
    private String creationDate;
    private String endDate;


    public String getPasportSeria() {
        return pasportSeria;
    }

    public void setPasportSeria(String pasportSeria) {
        this.pasportSeria = pasportSeria;
    }

    public String getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(String creationDate) {
        this.creationDate = creationDate;
    }

    public String getEndDate() {
        return endDate;
    }

    public void setEndDate(String endDate) {
        this.endDate = endDate;
    }

    /**
     * Constructor for Passport Validation.
     *
     * @param pasportSeria the passport serial number
     * @param creationDate  the creation date of the passport
     * @param endDate       the expiration date of the passport
     */
    public PasportVaidation(String pasportSeria, String creationDate, String endDate) {
        this.pasportSeria = pasportSeria;
        this.creationDate = creationDate;
        this.endDate = endDate;
    }

    public void pasportValic() {
        dedlinePasport();
        chekSerriaPasport();
    }

    /**
     * Check the passport serial number format.
     */
    public void chekSerriaPasport() {
        String test = "[A][N][0-9]{7}";
        Pattern pattern = Pattern.compile(test);
        Matcher matcher = pattern.matcher(pasportSeria);
        try {
            throw new Exception();
        } catch (Exception ex) {
            System.out.println("incorrecd seria number");
        }
    }

    /**
     * Check the expiration date of the passport.
     */
    public void dedlinePasport() {
        final int TIMEALOWED = 10;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate creatYear = LocalDate.parse(creationDate, formatter);
        LocalDate endYear = LocalDate.parse(endDate, formatter);
        LocalDate today = LocalDate.now();
        try {
            if ((today.compareTo(endYear) > 0 || endYear.compareTo(creatYear) > TIMEALOWED)) {
                throw new Exception();
            }
        } catch (Exception ex) {
            System.out.println("Passport has expired");
        }
    }
}
