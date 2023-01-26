package lt.code.academy.homework;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;
import org.json.simple.JSONObject;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class QuestionsMain {

    private static final String STUDENT_ANSWERS_FILE = "C:\\Users\\Kompiuteris\\Documents" +
            "\\GitHub\\WurkHome\\home.work.january\\src\\main\\java\\lt\\code\\academy" +
            "\\homework\\files\\student_answers_file.json";

    public static void main(String[] args) {

        List<Integer> studentAnswers = new ArrayList<>();

        Scanner scq = new Scanner(System.in);
        System.out.println("Kiek bus 2 * 1");
        int studentAnswerInputOne = scq.nextInt();
        System.out.println("Kiek bus 2 * 2");
        int studentAnswerInputTwo = scq.nextInt();
        System.out.println("Kiek bus 2 * 3");
        int studentAnswerInputThree = scq.nextInt();
        System.out.println("Kiek bus 2 * 4");
        int studentAnswerInputFour = scq.nextInt();
        System.out.println("Kiek bus 2 * 5");
        int studentAnswerInputFive = scq.nextInt();
        System.out.println("Kiek bus 2 * 6");
        int studentAnswerInputSix = scq.nextInt();
        System.out.println("Kiek bus 2 * 7");
        int studentAnswerInputSeven = scq.nextInt();
        System.out.println("Kiek bus 2 * 8");
        int studentAnswerInputEight = scq.nextInt();
        System.out.println("Kiek bus 2 * 9");
        int studentAnswerInputNine = scq.nextInt();
        System.out.println("Kiek bus 2 * 10");
        int studentAnswerInputTen = scq.nextInt();

        JSONObject objectSt = new JSONObject();

        objectSt.put("1 answer", studentAnswerInputOne);
        objectSt.put("2 answer", studentAnswerInputTwo);
        objectSt.put("3 answer", studentAnswerInputThree);
        objectSt.put("4 answer", studentAnswerInputFour);
        objectSt.put("5 answer", studentAnswerInputFive);
        objectSt.put("6 answer", studentAnswerInputSix);
        objectSt.put("7 answer", studentAnswerInputSeven);
        objectSt.put("8 answer", studentAnswerInputEight);
        objectSt.put("9 answer", studentAnswerInputNine);
        objectSt.put("10 answer", studentAnswerInputTen);

        ObjectMapper mapper = new ObjectMapper();

        ObjectWriter writer = mapper.writer(SerializationFeature.INDENT_OUTPUT);

        try {
            writer.writeValue(new File(STUDENT_ANSWERS_FILE), objectSt);
            System.out.println("Sėkmingai įrašyra");
        } catch (IOException e) {
            System.out.println("Įrašymo klaida į failą" + STUDENT_ANSWERS_FILE + " " + e.getMessage());

        }
    }
}


