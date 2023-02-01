package lt.code.academy.homework.student;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentToMain {
    private static final String STUDENT_REC_FILE = "student_rec_file.json";

    public static void main(String[] args) {

        ObjectMapper mapper = new ObjectMapper();
        mapper.enable(SerializationFeature.INDENT_OUTPUT);


        Scanner scanner = new Scanner(System.in);
        System.out.println("Įveskite studento numerį");
        String stNumber = scanner.nextLine();
        System.out.println("Įveskite savo vardą");
        String stName = scanner.nextLine();
        System.out.println("Įveskite savo pavardę");
        String stSurname = scanner.nextLine();

        StudentRec studentRec = new StudentRec(stNumber, stName, stSurname);
       // studentRec.getStudentName();
      //  studentRec.getStudentSurname();

        List<String>students = new ArrayList<>();
        students.add(stNumber);
        students.add(stName);
        students.add(stSurname);

        /// cia kurti klausimus

        System.out.println("2*1=");
        int answerOne = scanner.nextInt();
        System.out.println("2*2=");
        int answerTwo = scanner.nextInt();
        System.out.println("2*3=");
        int answerThree = scanner.nextInt();
        System.out.println("2*4=");
        int answerFour = scanner.nextInt();
        System.out.println("2*5=");
        int answerFive = scanner.nextInt();
        System.out.println("2*6=");
        int answerSix = scanner.nextInt();
        System.out.println("2*7=");
        int answerSeven = scanner.nextInt();
        System.out.println("2*8=");
        int answerEight = scanner.nextInt();
        System.out.println("2*9=");
        int answerNine = scanner.nextInt();
        System.out.println("2*10=");
        int answerTen = scanner.nextInt();

        StudentInput studentInput = new StudentInput(answerOne, answerTwo, answerThree, answerFour,
                answerFive,answerSix, answerSeven, answerEight, answerNine, answerTen);

        List<Integer> studentAnswerInputs = new ArrayList<>();
        studentAnswerInputs.add(answerOne);
        studentAnswerInputs.add(answerTwo);
        studentAnswerInputs.add(answerThree);
        studentAnswerInputs.add(answerFour);
        studentAnswerInputs.add(answerFive);
        studentAnswerInputs.add(answerSix);
        studentAnswerInputs.add(answerSeven);
        studentAnswerInputs.add(answerEight);
        studentAnswerInputs.add(answerNine);
        studentAnswerInputs.add(answerTen);

        try {
            File file = new File(STUDENT_REC_FILE);
            mapper.writeValue(file, List.of(studentRec, studentInput));
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Failo sukūrimo klaida: " + e.getMessage());
        }
    }
}
