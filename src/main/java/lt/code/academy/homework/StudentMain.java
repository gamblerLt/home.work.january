package lt.code.academy.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.Map;
import java.util.Scanner;


public class StudentMain {

    //StudentMain studentMain = new StudentMain();
    private static final String STUDENT_FILE_NAME = "C:\\Users\\Kompiuteris\\Documents\\GitHub\\WurkHome\\home.work.january\\src\\main\\java\\lt\\code\\academy\\homework\\files\\student_file.json";

    private Map<String, Student> students;

    public static void main(String[] args) {


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

        ObjectWriter writer = mapper.writer(SerializationFeature.INDENT_OUTPUT);

        try {
           writer.writeValue(new File(STUDENT_FILE_NAME),object);
            System.out.println("Sėkmingai įrašyra");
        } catch (IOException e) {
            System.out.println("Įrašymo klaida į failą" + STUDENT_FILE_NAME +" " + e.getMessage());
        }
    }
}
