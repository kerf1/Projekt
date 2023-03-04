import java.util.StringTokenizer;
public class Person extends ContactBook {
    protected  String firstName;
    protected String lastName;
    private String signature;
    private int length;
    protected Adress adress;
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
    public String getLastName() {
        return lastName;
    }
    public String getSignature() {
        return signature;
    }
    public String getSignature(int i) {
        StringTokenizer splitString = new StringTokenizer(contactsArrayList.get(i).toString(), "|");
        splitString.nextToken();
        splitString.nextToken();
        String personSignature = splitString.nextToken();
        System.out.println(contactsArrayList.get(i));
        return personSignature;
    }
    public int getLength() {
        return length;
    }
    public Adress getAdress() {
        return adress;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName.substring(0,1).toUpperCase() + firstName.substring(1, firstName.length());
    }
    public void setLastName(String lastName) {
        this.lastName = lastName.substring(0,1).toUpperCase() + lastName.substring(1, lastName.length());
    }
    public void setSignature(String signature) {
        this.signature = signature;
    }
    public void setLength(int length) {
        this.length = length;
    }
    public void setAdress(Adress adress) {
        this.adress = adress;
    }
    public String generateSignature() {
        StringBuilder signatureFirst = new StringBuilder(getFirstName().toLowerCase());
        StringBuilder signatureLast = new StringBuilder(getLastName().toLowerCase());
        while (signatureFirst.length() < 3)
            signatureFirst.append("x");
        while (signatureLast.length() < 3)
            signatureLast.append("x");

        StringBuilder signature = new StringBuilder(signatureFirst.substring(0,3) + (signatureLast.substring(0,3) + "01"));

        for (int i = 0; i < contactsArrayList.size(); i++) {
            if (signature.toString().equals(getSignature(i))) {
                int endingDigits = Integer.parseInt((signature.substring(signature.length() - 2, signature.length())));
                signature.delete(signature.length() - 2, signature.length());
                endingDigits = endingDigits + 1;
                signature.append(String.format("%02d", endingDigits));
            }
        }
        return signature.toString();
    }
    /*
    public String generateSignature(){
        String signatureFirst = getFirstName().toLowerCase();
        String signatureLast = getLastName().toLowerCase();
        while (signatureFirst.length() < 3)
            signatureFirst += "x";
        while (signatureLast.length() < 3)
            signatureLast += "x";
        signature = signatureFirst.substring(0,3) + signatureLast.substring(0,3) + 00;

        return signature;
    }

     */
    @Override
    public String toString() {
        return getFirstName() + "|" + getLastName() + "|" + getSignature() + "|" + getLength() + "|" + getAdress();
    }
}