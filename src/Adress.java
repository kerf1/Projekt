public class Adress extends Contacts {
    private String postAdress;
    private String postNumber;
    private String postCity;

    public Adress(String postAdress, String postNumber, String postCity){
        this.postAdress = postAdress;
        this.postNumber = postNumber;
        this.postCity = postCity;
    }

    public Adress(){
        this.postAdress = "Postadress";
        this.postNumber = "Postnummer";
        this.postCity = "Postort";
    }

    public String getPostAdress() {
        return postAdress;
    }

    public void setPostAdress(String postAdress) {
        this.postAdress = postAdress;
    }

    public String getPostNumber() {
        return postNumber;
    }

    public void setPostNumber(String postNumber) {
        this.postNumber = postNumber;
    }

    public String getPostCity() {
        return postCity;
    }

    public void setPostCity(String postCity) {
        this.postCity = postCity;
    }

    @Override
    public String toString() {
        return getPostAdress() + "|" + getPostNumber() + "|" + getPostCity();
    }
}
