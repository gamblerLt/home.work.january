package lt.code.academy.homework.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class StudentToMain {
    private static final String STUDENT_REC_FILE = "student_rec_file.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);

       StudentRec student = new StudentRec("Numeris", "Vardas", "Pavarde");

        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite studento numerį");
        String stNumb = scanner.nextLine();
        System.out.println("Įveskite savo vardą");
        String stName = scanner.nextLine();
        System.out.println("Įveskite savo pavardę");
        String stSurname = scanner.nextLine();

        try {
            File file = new File(STUDENT_REC_FILE);
            if (!file.exists()) {
                file.createNewFile();
            }


            mapper.writeValue(file, List.of(stNumb, stName, stSurname));

          //  System.out.println(student);


        } catch (IOException e) {
            System.out.println("Failo sukūrimo klaida: " + e.getMessage());
        }
    }
}
