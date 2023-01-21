package lt.code.academy.homework;

import org.apache.commons.codec.digest.DigestUtils;
import java.util.Map;
import java.util.Scanner;


public class Login {
    private Map<Integer, LoginStudentRec> loginStudentRecs; //??
    private LoginWrRd loginWrRd;

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
            case "1" -> System.out.println("registracija");
            case "2" -> System.out.println("Prisijungimas");
            case "3" -> System.out.println("Iseiti");
            default -> System.out.println("Tokio pasirinkimo nėra");
        }
    }
    //case2
    private void loginStudent(Scanner scanner)  {
        System.out.println("Įveskite savostudento numerį");
        int studentNumber = scanner.nextInt();
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

        loginStudentRec = new LoginStudentRec(studentNumber, name, surname, DigestUtils.sha512Hex(password));
    }
    private void regMenu() {
        System.out.println("""
                1. Studento registracija
                2. Prisijungimas
                3. Baigti darbą
                """);
    }
}
