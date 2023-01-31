package lt.code.academy.homework;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import lt.code.academy.homework.answers.AnswerWriter;
import org.json.simple.JSONObject;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class StudentMain {

    private static final String STUDENT_FILE_NAME = "student_file.json";
    private static final String ANSWER_FILE_NAME = "correct_answers.json";

    public static void main(String[] args) {

        StudentMain studentMain = new StudentMain();
       // AnswerWriter answerWriter = new AnswerWriter();
        //answerWriter.objectAn(); // apsiraudonaves
       // Student student = new Student();


        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite studento numerį");
        String studentNumber = scanner.nextLine();
        System.out.println("Įveskite savo vardą");
        String name = scanner.nextLine();
        System.out.println("Įveskite savo pavardę");
        String surname = scanner.nextLine();

        System.out.println("Kiek bus 2 * 1");
        int studentAnswerInputOne = scanner.nextInt();
        System.out.println("Kiek bus 2 * 2");
        int studentAnswerInputTwo = scanner.nextInt();
        System.out.println("Kiek bus 2 * 3");
        int studentAnswerInputThree = scanner.nextInt();
        System.out.println("Kiek bus 2 * 4");
        int studentAnswerInputFour = scanner.nextInt();
        System.out.println("Kiek bus 2 * 5");
        int studentAnswerInputFive = scanner.nextInt();
        System.out.println("Kiek bus 2 * 6");
        int studentAnswerInputSix = scanner.nextInt();
        System.out.println("Kiek bus 2 * 7");
        int studentAnswerInputSeven = scanner.nextInt();
        System.out.println("Kiek bus 2 * 8");
        int studentAnswerInputEight = scanner.nextInt();
        System.out.println("Kiek bus 2 * 9");
        int studentAnswerInputNine = scanner.nextInt();
        System.out.println("Kiek bus 2 * 10");
        int studentAnswerInputTen = scanner.nextInt();

      //  mapper.writeValue(stringUser, User.class);


        JSONObject object = new JSONObject();

        object.put("Studento numeris", studentNumber);
        object.put("Studento vardas", name);
        object.put("Studento pavardė", surname);

        JSONObject objectSt = new JSONObject();

        objectSt.put("1 answer:", studentAnswerInputOne);
        objectSt.put("2 answer:", studentAnswerInputTwo);
        objectSt.put("3 answer:", studentAnswerInputThree);
        objectSt.put("4 answer:", studentAnswerInputFour);
        objectSt.put("5 answer:", studentAnswerInputFive);
        objectSt.put("6 answer:", studentAnswerInputSix);
        objectSt.put("7 answer:", studentAnswerInputSeven);
        objectSt.put("8 answer:", studentAnswerInputEight);
        objectSt.put("9 answer:", studentAnswerInputNine);
        objectSt.put("10 answer:", studentAnswerInputTen);

        try {
            File file = new File(STUDENT_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

            mapper.writeValue(file, List.of(object, objectSt));
            String answers = mapper.writeValueAsString(objectSt);

            System.out.println("Studento atsakymai:");

            //isvedam duomenis i mapa
            Map<String, Object> map = mapper.readValue(answers, new TypeReference<>() {
            });
            System.out.println(map.get("1 answer:"));
            System.out.println(map.get("2 answer:"));
            System.out.println(map.get("3 answer:"));
            System.out.println(map.get("4 answer:"));
            System.out.println(map.get("5 answer:"));
            System.out.println(map.get("6 answer:"));
            System.out.println(map.get("7 answer"));
            System.out.println(map.get("8 answer:"));
            System.out.println(map.get("9 answer:"));
            System.out.println(map.get("10 answer:"));



        } catch (IOException e) {
            System.out.println("Klaida: " + e.getMessage());

        }
        System.out.println("Teisingi atsakymai: ");

        JSONObject objectAn = new JSONObject();
        try {
            File file = new File(ANSWER_FILE_NAME);
            mapper.writeValue(file, List.of(objectAn));
            String correctAnswers = mapper.writeValueAsString(objectAn);
            Map<String, Object> map = mapper.readValue(correctAnswers, new TypeReference<>() {
            });

            System.out.println(map.get("1 answer:"));
            System.out.println(map.get("2 answer:"));
            System.out.println(map.get("3 answer:"));
            System.out.println(map.get("4 answer:"));
            System.out.println(map.get("5 answer:"));
            System.out.println(map.get("6 answer:"));
            System.out.println(map.get("7 answer:"));
            System.out.println(map.get("8 answer:"));
            System.out.println(map.get("9 answer:"));
            System.out.println(map.get("10 answer:"));


        } catch (IOException e) {
            System.out.println("Klaida: " + e.getMessage());
        }
    }
}
