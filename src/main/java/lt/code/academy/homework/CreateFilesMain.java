package lt.code.academy.homework;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

import com.fasterxml.jackson.databind.ObjectMapper;

public class CreateFilesMain {

    private static final String QUESTION_FILE_NAME = "questions.json";
    public static void main(String[] args) {
        ObjectMapper mapper = new ObjectMapper();
        //CreateFilesMain createFilesMain = new CreateFilesMain();
        //createFilesMain.write();
        //createFilesMain.read();
        Question createQuOne = new Question(1, "2 * 1 = ", 2);
        Question createQuTwo = new Question(2, "3 * 3 = ", 9);
        Question createQuThree = new Question(3, "1 * 1 = ", 1);
        Question createQuFour = new Question(4, "5 * 5 = ", 25);
        Question createQuFive = new Question(5, "4 * 4 = ", 16);

        File file = null;
        try {
            file = new File(QUESTION_FILE_NAME);
            if (!file.exists()) {
                file.createNewFile();
            }

        } catch (IOException e) {
            System.out.println("Turime problemų su failu: " + e.getMessage());
        }
        //irasyti keleta objektu i faila
        try {
            mapper.writeValue(file, List.of(createQuOne, createQuTwo,createQuThree, createQuFour, createQuFive));

        } catch (IOException e) {

            System.out.println("Turime problemų su įrašymu: " + e.getMessage());
        }
    }

    private void readQuestion() {
        try (BufferedReader br = new BufferedReader(new FileReader(QUESTION_FILE_NAME))) {
            //nuskaitomas failas:
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);

            }
        }catch (IOException e) {
            System.out.println("Nuskaitymas iš failo: " + e.getMessage());
        }
    }
    /*private void filUpPersons() {
        try (BufferedReader br = new BufferedReader(new FileReader(PERSON_FILE_NAME))) {
            //nuskaitome faila:
            String line;
            while ((line = br.readLine()) != null) {
                if (line.startsWith(ID)) {
                    continue;
                }

                String[] splits = line.split(REGEX);
                if (splits.length < 3) {
                    continue;
                }
                int id = Integer.parseInt(splits[0]);
                if (persons.get(id) == null) {

                    persons.put(id, new Person(id, splits[1].trim(), splits[2].trim()));
                }
            }

        } catch (IOException e) {
            System.out.println("Negaliu skaityti failo" + PERSON_FILE_NAME + e.getMessage());
        }
    }*/

}
