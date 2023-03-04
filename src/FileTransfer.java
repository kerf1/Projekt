import java.io.*;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;
public class FileTransfer {
    public static  void saveListToFile(ArrayList<Person> contactsArrayList) throws IOException {
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
    public static  void loadListFromFile(ArrayList<Person> contactsArrayList) throws FileNotFoundException {
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
}
