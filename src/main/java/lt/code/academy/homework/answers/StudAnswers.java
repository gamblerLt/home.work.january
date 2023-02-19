package lt.code.academy.homework.answers;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.ObjectWriter;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudAnswers {

    private static final String STUDENT_ANSWERS_FILE = "student_answers_file.json";
    private static final String STUDENT_FILE = "student_file.json";

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite ID");
        String studentId = scanner.nextLine();
        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();
        System.out.println("Iveskite savo pavarde");
        String surName = scanner.nextLine();

        System.out.println();

        List<Integer> studentAnswers = new ArrayList<>();

        System.out.println("Kiek bus 2 * 1");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 2");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 3");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 4");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 5");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 6");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 7");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 8");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 9");
        studentAnswers.add(scanner.nextInt());
        System.out.println("Kiek bus 2 * 10");
        studentAnswers.add(scanner.nextInt());

        ObjectMapper objectMapper = new ObjectMapper();
        ObjectWriter writer = objectMapper.writer(SerializationFeature.INDENT_OUTPUT);

        Person person = new Person(studentId, name,surName);

        StudentTest studentTest = new StudentTest();
        studentTest.setStudentTest(studentAnswers);


        try {
            File file = new File(STUDENT_ANSWERS_FILE);
            writer.writeValue(new File(STUDENT_ANSWERS_FILE), studentTest);
            objectMapper.writeValue(new File(STUDENT_FILE), person);
           // File file2 = new File(STUDENT_FILE);

            System.out.println("Sėkmingai įrašyra");


        } catch (IOException e) {
            System.out.println("Įrašymo klaida į failą" + STUDENT_ANSWERS_FILE + " " + e.getMessage());



        }
        //System.out.println(STUDENT_ANSWERS_FILE);
    }

}
class StudentTest {

    private List<Integer> studentTest;

    public  List<Integer>getStudentTest() {
        return studentTest;
    }

    public void setStudentTest(List<Integer> studentTest) {
        this.studentTest = studentTest;
    }
}
class Student{
    private String studentId;
    private String name;
    private String surName;

    public Student(String studentId, String name, String surName) {
        this.studentId = studentId;
        this.name = name;
        this.surName = surName;
    }

    public String getStudentId() {
        return studentId;
    }

    public void setStudentId(String studentId) {
        this.studentId = studentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}

class Person {
    private String id;
    private String name;
    private String surName;

    public Person(String id, String name, String surName) {
        this.id = id;
        this.name = name;
        this.surName = surName;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurName() {
        return surName;
    }

    public void setSurName(String surName) {
        this.surName = surName;
    }
}
