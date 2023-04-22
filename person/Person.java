package clientCard.person;
public abstract class Person {

    private String firsName;
    private String lastName;
    private String PassportNumber;
    private String socCard;
    private String emailAddres;
    protected enum Gender {
        male, femal;
    }


    public String getFirsName() {
        return firsName;
    }

    public void setFirsName(String firsName) {
        this.firsName = firsName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPassportNumber() {
        return PassportNumber;
    }

    public void setPassportNumber(String passportNumber) {
        PassportNumber = passportNumber;
    }

    public String getSocCard() {
        return socCard;
    }

    public void setSocCard(String socCard) {
        this.socCard = socCard;
    }

    public String getEmailAddres() {
        return emailAddres;
    }

    public void setEmailAddres(String emailAddres) {
        this.emailAddres = emailAddres;
    }
}
