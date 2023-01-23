package lt.code.academy.homework;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Map;
import java.util.Objects;
import java.util.Scanner;


public class Login {
    private final Map<String, LoginStudentRec> loginStudentRecs; //??
    private final LoginWrRd loginWrRd;

    public Login() {
        loginWrRd = new LoginWrRd();
        loginStudentRecs = loginWrRd.getLgrStudents();
    }
    public static void main(String[] args) {
        Login login = new Login();
        Scanner scanner = new Scanner(System.in);

        String line;
        do {
            login.regMenu();
            line = scanner.nextLine();
            login.studentSelect(scanner, line);
            }while (!line.equals(3));
    }
    private void studentSelect(Scanner scanner, String action) {
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
        System.out.println("Įveskite savo studento numerį");
        String studentNumber = scanner.nextLine();
        LoginStudentRec loginStudentRec = loginStudentRecs.get(studentNumber);
        if(studentNumber == null) {
            System.out.println("Tokio studento numerio neradome. Registruokitės");
            return;
        }

        System.out.println("Įveskite slaptažodį: ");
        String password = scanner.nextLine();
        if(!loginStudentRec.password().equals(DigestUtils.sha512Hex(password))) {
            System.out.println("Neteisingas slaptažodis, bandykite dar kartą: ");
            return;
        }
                System.out.println("Jūs sėkmingai prisingėte kaip " + studentNumber); // + name
    }
    private  void registration(Scanner scanner) {
        LoginStudentRec loginStudentRec;
        String studentNumber;

        do {
            System.out.println("Įveskite studento numerį: ");
            studentNumber = scanner.nextLine();
            loginStudentRec = loginStudentRecs.get(studentNumber);
            if(loginStudentRec !=null) {
                System.out.println("Toks vartotojas jau egzistuoja!");
            }
        }while (loginStudentRec != null);

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

        new LoginStudentRec(studentNumber, name, surname, DigestUtils.sha512Hex(password));
        loginStudentRecs.put(studentNumber, loginStudentRec);
    }
    private void regMenu() {
        System.out.println("""
                1. Studento registracija
                2. Prisijungimas
                3. Baigti darbą
                """);
    }
}
