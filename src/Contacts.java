import java.util.*;
import java.io.*;
public class Contacts {
    private static final String PROMPT = ">";
    private static boolean runSwitch = true;
    private static ArrayList<Person> contactsArrayList = new ArrayList<Person>();
    private static String getSignature(int i) {
            StringTokenizer splitString = new StringTokenizer(contactsArrayList.get(i).toString(), "|");
            splitString.nextToken();
            splitString.nextToken();
            String personSignature = splitString.nextToken();
        return personSignature;
    }
    public static void addContact(){
        Scanner userInput = new Scanner(System.in);
        Adress adressObject = new Adress();
        Person personObject = new Person();

        System.out.println("Förnamn: ");
        personObject.setFirstName(userInput.nextLine());
        System.out.println("Efternamn: ");
        personObject.setLastName(userInput.nextLine());
        personObject.generateSignature();
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
    public static void searchContact() {
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
    public static void sortListByFirstName() {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getFirstName().compareTo(person2.getFirstName());
            }
        });
    }
    public static void sortListByLastName(){
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
    public static void sortListBySignature() {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                return person1.getSignature().compareTo(person2.getSignature());
            }
        });
        }
    public static void sortListByLength() {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person p1, Person p2) {
                return p1.getLength()-p2.getLength();
            }
        });
    }
    public static void makeListToRandomOrder() {
        contactsArrayList.sort(new Comparator<Person>() {
            @Override
            public int compare(Person person1, Person person2) {
                Random randomAnsware = new Random();
                return randomAnsware.nextInt();
            }
        });
    }
    public static void saveListToFile() throws IOException {
        //System.out.println(contactsArrayList.size());

        Scanner input = new Scanner(System.in);
        System.out.print("Ange namn på filen: ");
        String fileName = input.nextLine();
        FileWriter fw = new FileWriter(fileName);
        BufferedWriter bw = new BufferedWriter(fw);
        PrintWriter output = new PrintWriter(bw);

        for (int i = 0; i < contactsArrayList.size(); i++) {
            output.println(contactsArrayList.get(i));
        }
        output.close();
    }
    public static void loadListFromFile() throws FileNotFoundException {
        String path;
        /*
        if(args.length == 0){
            path = "C:/Users/hanne/Desktop/JavaI/Lektioner/6/Upg2/src/wordlist1.txt";
        }else{
            path = args[0];
        }
        */
        /*
        Scanner userInput = new Scanner(System.in);
        */

        path = "C:\\Users\\hanne\\Desktop\\JavaI\\Projekt\\data.txt";
        Scanner file = new Scanner(new File(path));

        while (file.hasNextLine()){
            //String firsName = file.next();
            //String lastName = file.next();
            //int length = Integer.parseInt(file.next());
            StringTokenizer fileInput = new StringTokenizer(file.nextLine(),"|");
            while (fileInput.hasMoreTokens()){
                Person personObjekt = new Person();
                Adress adressObjekt = new Adress();

                personObjekt.setFirstName(fileInput.nextToken());
                personObjekt.setLastName(fileInput.nextToken());
                personObjekt.setSignature(fileInput.nextToken());
                //personObjekt.generateSignature();
                //String signature = fileInput.nextToken();
                personObjekt.setLength(Integer.parseInt(fileInput.nextToken()));
                adressObjekt.setPostAdress(fileInput.nextToken());
                adressObjekt.setPostNumber(fileInput.nextToken());
                adressObjekt.setPostCity(fileInput.nextToken());
                personObjekt.setAdress(adressObjekt);
                contactsArrayList.add(personObjekt);
            }
        }
        file.close();
    }
    public String generateSignature(){
        String signatureFirst = Person.getFirstName().toLowerCase();
        String signatureLast = Person.getLastName().toLowerCase();
        while (signatureFirst.length() < 3)
            signatureFirst = signatureFirst + "x";
        while (signatureLast.length() < 3)
            signatureLast = signatureLast + "x";
        //String signature = signatureFirst.substring(0,3) + signatureLast.substring(0,3);

        return signatureFirst.substring(0,3) + signatureLast.substring(0,3);
    }
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
    public static void switchMenu () throws IOException {
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
                        searchContact();
                    }
                    case 4 -> {
                        sortListByFirstName();
                    }
                    case 5 -> {
                        sortListByLastName();
                    }
                    case 6 ->{
                        sortListBySignature();
                    }
                    case 7 ->{
                        sortListByLength();
                    }
                    case 8 -> {
                        makeListToRandomOrder();
                    }
                    case 9 ->
                        saveListToFile();
                    case 10 -> {
                        loadListFromFile();
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
    public static void main (String[]args) throws IOException {
        switchMenu();
    }

}