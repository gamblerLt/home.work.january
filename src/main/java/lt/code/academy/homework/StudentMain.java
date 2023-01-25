package lt.code.academy.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class StudentMain {
    private static final String STUDENT_FILE_NAME = "C:\\Users\\Kompiuteris\\Documents\\GitHub\\WurkHome\\home.work.january\\src\\main\\java\\lt\\code\\academy\\homework\\files\\student_file.json";


    private Map<String, Student> students; //??

    public static void main(String[] args) {

        //StudentMain studentMain = new StudentMain();
        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite studento numerį");
        String studNumb = scanner.nextLine();
        System.out.println("Įveskite savo vardą");
        String studName = scanner.nextLine();
        System.out.println("Įveskite savo pavardę");
        String studSurname = scanner.nextLine();

        JSONObject object = new JSONObject();

        object.put("Student number", studNumb);
        object.put("Student name", studName);
        object.put("Student surname", studSurname);

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            FileWriter fileWriter = new FileWriter(STUDENT_FILE_NAME);
            fileWriter.write(object.toJSONString());
            //fileWriter.close();

            System.out.println("Sėkmingai įrašyra");
        } catch (IOException e) {
            System.out.println("Įrašymo klaida į failą" + STUDENT_FILE_NAME +" " + e.getMessage());
        }
    }
}



       /* String line;
        do {
            login.regMenu();
            line = scanner.nextLine();
            login.studentSelect(scanner, line);
            }while (!line.equals(3));
    }*/

    /*public class LoginTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();

        JSONObject obj = new JSONObject();

        obj.put("name", name);

        try {
            FileWriter file = new FileWriter("data.json");
            file.write(obj.toJSONString());
            file.close();

            System.out.println("Successfully wrote data to file");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }


}*/

    /*private void studentSelect(Scanner scanner, String action) {
        switch (action) {
            case "1" -> registration(scanner);
            case "2" -> loginStudent(scanner);
            case "3" -> {
                loginWrRd.storeStudents(loginStudentRecs);
                System.out.println("KAs cia dabar");

            }
            default -> System.out.println("Tokio pasirinkimo nėra");
        }
    }
    //case2
    private void loginStudent(Scanner scanner)  {
        System.out.println("Įveskite savostudento numerį");
        int studentNumber = scanner.nextInt();
        LoginStudentRec loginStudentRec = loginStudentRecs.get(studentNumber);
        if(studentNumber != studentNumber) { //cia kazkas neg gal true reikia
            System.out.println("Tokio studento numerio neradome. Registruokitės");
            return;
        }

        System.out.println("Įveskite slaptažodį: ");
        String password = scanner.nextLine();
        if(!loginStudentRec.password().equals(DigestUtils.sha512Hex(password))) {
            System.out.println("Neteisingas slaptažodis, bandykite dar kartą: ");
            return;
        }
                System.out.println("Jūs sėkmingai prisingėte kaip "); // + name
    }
    private  void registration(Scanner scanner) {
        LoginStudentRec loginStudentRec;
        int studentNumber;

        do {
            System.out.println("Įveskite studento numerį: ");
            studentNumber = scanner.nextInt();
            loginStudentRec = loginStudentRecs.get(studentNumber);
            if(loginStudentRec !=null) {
                System.out.println("Toks vartotojas jau egzistuoja!");
            }
        }while (loginStudentRec == null);
        System.out.println("Įveskite vardą");
        String name = scanner.nextLine();
        System.out.println("Įveskite pavardę");
        String surname = scanner.nextLine();
        System.out.println("Įveskite slaptažodį");
        String password = scanner.nextLine();

        String repeatPassword;

        do {
            System.out.println("Pakartokite slaptažodį: ");
            repeatPassword = scanner.nextLine();
        }while (!repeatPassword.equals(password));

        loginStudentRec = new LoginStudentRec(studentNumber, name, surname, DigestUtils.sha512Hex(password));
    }
    private void regMenu() {
        System.out.println("""
                1. Studento registracija
                2. Prisijungimas
                3. Baigti darbą
      }          """);
    }
}*/

