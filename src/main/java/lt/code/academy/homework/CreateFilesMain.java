package lt.code.academy.homework;

import java.io.File;
import java.io.IOException;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateFilesMain {
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        CreateFilesMain createFilesMain = new CreateFilesMain();
        //createFilesMain.write();
        //createFilesMain.read();
        Question createQuOne = new Question(1, "2 * 2 = ", 4);
        Question createQuTwo = new Question(2, "3 * 3 = ", 9);
        Question createQuThree = new Question(3, "1 * 1 = ", 1);
        Question createQuFour = new Question(4, "5 * 5 = ", 25);
        Question createQuFive = new Question(5, "4 * 4 = ", 16);

        File file = null;
        try {
            file = new File("questionsAndCorrectAnswers.json");
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Turime problemų su failu: " + e.getMessage());
        }
        try {
            mapper.writeValue(file, createQuOne);
            mapper.writeValue(file, createQuTwo);
            mapper.writeValue(file, createQuThree);
            mapper.writeValue(file, createQuFour);
            mapper.writeValue(file, createQuFive);
            
        } catch (IOException e) {

            System.out.println("Turime problemų su įrašymu: " + e.getMessage());
        }
    }
}
