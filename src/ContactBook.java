import java.util.*;
import java.io.*;
import java.util.ArrayList;
public class ContactBook {
    protected static ArrayList contactsArrayList = new ArrayList();
    private static final String PROMPT = ">";
    private static boolean runSwitch = true;
    public static void addContact(){
        Scanner userInput = new Scanner(System.in);
        Adress adressObject = new Adress();
        Person personObject = new Person();

        System.out.println("Förnamn: ");
        personObject.setFirstName(userInput.nextLine());
        System.out.println("Efternamn: ");
        personObject.setLastName(userInput.nextLine());

        //String sign = personObject.generateSignature();
        personObject.setSignature(personObject.generateSignature());

        System.out.println("Längd: ");
        personObject.setLength(Integer.parseInt(userInput.nextLine()));
        System.out.println("Postadress: ");
        adressObject.setPostAdress(userInput.nextLine());
        System.out.println("Postnummer: ");
        adressObject.setPostNumber(userInput.nextLine());
        System.out.println("Postort: ");
        adressObject.setPostCity(userInput.nextLine());

        personObject.setAdress(adressObject);
        contactsArrayList.add(personObject);
        printList(contactsArrayList);
    }
    public static void searchContact(ArrayList<Person> contactsArrayList) {
        System.out.print("Sök efter en person(signatur): ");
        Scanner userInput = new Scanner(System.in);
        String searchSignature = userInput.nextLine();
        //contactsArrayList

        //StringTokenizer splitString = new StringTokenizer(contactsArrayList.toString(), "|");

        for(int i = 0; i < contactsArrayList.size(); i++){
            StringTokenizer splitString = new StringTokenizer(contactsArrayList.get(i).toString(), "|");
            splitString.nextToken();
            splitString.nextToken();
            String personSignature = splitString.nextToken();
            if (personSignature.contains(searchSignature)) {
                contactsArrayList.remove(i);
                //contactsArrayList.remove(i);

                //String word = contactsArrayList.get(i).toString();
                //System.out.print("Vill du ta bort " + contactsArrayList.get(i) + "? J/N: ");
                //String userAnswer = userInput.next().toUpperCase();
                //System.out.println(userAnswer);
                //System.out.println(i);
                //System.out.println(test);
                //if(userAnswer.equals('J')){
                //}
            }
        }
    }
    public static void sortListByFirstName(ArrayList<Person> contactsArrayList) {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getFirstName().compareTo(person2.getFirstName());
            }
        });
    }
    public static void sortListByLastName(ArrayList<Person> contactsArrayList){
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                int retur = person1.getLastName().compareTo(person2.getLastName());
                if(retur == 0)
                    retur = person1.getFirstName().compareTo(person2.getFirstName());
                return retur;
            }
        });
    }
    public static void sortListBySignature(ArrayList<Person> contactsArrayList) {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getSignature().compareTo(person2.getSignature());
            }
        });
        }
    public static void sortListByLength(ArrayList<Person> contactsArrayList) {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getLength()-p2.getLength();
            }
        });
    }
    public static void makeListToRandomOrder(ArrayList<Person> contactsArrayList) {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                Random randomAnsware = new Random();
                return randomAnsware.nextInt();
            }
        });
    }
    /*
    public String generateSignature(){
        StringBuilder signatureFirst = new StringBuilder(Person.getFirstName().toLowerCase());
        StringBuilder signatureLast = new StringBuilder(Person.getLastName().toLowerCase());
        System.out.println(signatureFirst);
        System.out.println(signatureLast);
        while (signatureFirst.length() < 3)
            signatureFirst.append("x");
        while (signatureLast.length() < 3)
            signatureLast.append("x");

        String signature = String.valueOf(signatureFirst.append(signatureLast + "00"));

            for (int i = 0; i < contactsArrayList.size(); i++){
                if(signature.equals(getSignature(i)) ) {
                    System.out.println(getSignature(i));
                    int newEndingDigits = Integer.parseInt(signature.substring(signature.length()-2, signature.length()) + 1);
                    signature = signatureFirst.substring(0,3) + signatureLast.substring(0,3) + newEndingDigits;
                }
            }
        return signature;
    }
    */
    /*
    public String generateSignature() {
        String signatureFirst = Person.getFirstName().toLowerCase();
        String signatureLast = Person.getLastName().toLowerCase();
        while (signatureFirst.length() < 3)
            signatureFirst = signatureFirst + "x";
        while (signatureLast.length() < 3)
            signatureLast = signatureLast + "x";
        String signature = signatureFirst.substring(0, 3) + signatureLast.substring(0, 3);

        return signature;
    }

     */
    public static void printMenu() {
        System.out.println(
        "1 - Lägg till en person\n" +
        "2 - Skriv ut listan med personer\n" +
        "3 - Sök en person i listan\n" +
        "4 - Sortera på förnamn\n" +
        "5 - Sortera på efternamn\n" +
        "6 - Sortera på signatur\n" +
        "7 - Sortera på längd\n" +
        "8 - Slumpa ordningen\n" +
        "9 - Sara listan till en textfil. Låt användaren ange filnamn.\n" +
        "10 - Läsa listan från en textfil. Låt användaren ange filnamn.\n" +
        "0 - Avsluta");
    }
    public static void printList(ArrayList<Person> contactsArrayList){
        int trigger = 0;
        for (int i = 0; i < contactsArrayList.size(); i++) {
            System.out.println(contactsArrayList.get(i));
        }
    }
    public static void runMenu() throws IOException {
            Scanner userInput = new Scanner(System.in);
            do {
                printMenu();
                System.out.print(PROMPT);
                int choice = Integer.parseInt(userInput.next());
                switch (choice) {
                    case 1 -> {
                        addContact();
                    }
                    case 2 -> {
                        printList(contactsArrayList);
                    }
                    case 3 -> {
                        searchContact(contactsArrayList);
                    }
                    case 4 -> {
                        sortListByFirstName(contactsArrayList);
                    }
                    case 5 -> {
                        sortListByLastName(contactsArrayList);
                    }
                    case 6 ->{
                        sortListBySignature(contactsArrayList);
                    }
                    case 7 ->{
                        sortListByLength(contactsArrayList);
                    }
                    case 8 -> {
                        makeListToRandomOrder(contactsArrayList);
                    }
                    case 9 ->
                        FileTransfer.saveListToFile(contactsArrayList);
                    case 10 -> {
                        FileTransfer.loadListFromFile(contactsArrayList);
                    }
                    case 0 -> {
                        System.out.println("Kontaktboken avslutas");
                        runSwitch = false;
                    }
                    default -> throw new IllegalStateException("Unexpected value: " + choice);
                }
            }
            while (runSwitch);
            System.exit(0);
    }
}