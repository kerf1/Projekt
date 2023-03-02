public class Person extends Contacts {
    private String firstName;
    private String lastName;
    private String signature;
    private int length;
    protected Adress adress;



    public Adress getAdress() {
        return adress;
    }

    public void setAdress(Adress adress) {
        this.adress = adress;
    }

    public Person(String firstName, String lastName, String signature, int length, Adress adress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.signature = signature;
        this.length = length;
        this.adress = adress;
    }

    public Person() {
        this.firstName = "Förnamn";
        this.lastName = "Efternamn";
        //this.signature = "Signatur";
        //this.signature = generateSignature(getFirstName(), getLastName());
        this.length = 0;
        this.adress = new Adress();
    }

    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1, firstName.length());
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1, lastName.length());
    }
    public String getSignature() {
        return signature;
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public int getLength() {
        return length;
    }
    public void setLength(int length) {
        this.length = length;
    }
/*
    public String generateSignature(){
        String signatureFirst = getFirstName().toLowerCase();
        String signatureLast = getLastName().toLowerCase();
        while (signatureFirst.length() < 3)
            signatureFirst = signatureFirst + "x";
        while (signatureLast.length() < 3)
            signatureLast = signatureLast + "x";
        signature = signatureFirst.substring(0,3) + signatureLast.substring(0,3);

        return signature;
    }
*/

    @Override
    public String toString() {
        return getFirstName() + "|" + getLastName() + "|" + getSignature() + "|" + getLength() + "|" + getAdress();
    }

    public void getAdress(Adress adressObject) {
        this.adress = adress;
    }
}

