package lt.code.academy.homework;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.ObjectInputStream;


public class QuestionShow {
    public static void main(String[] args) {

        try(ObjectInputStream ois = new ObjectInputStream(new FileInputStream("questionsAndCorrectAnswers.json"))) {
            Question question;
            while ((question = (Question) ois.readObject()) != null) {
                System.out.println(question);
            }
        }catch (EOFException e) {
            System.out.println("Failo nuskaitymas: " + e.getMessage());
        }catch (Exception ee) {
            System.out.println("Nepavyko nuskaityti failo: " + ee.getMessage());
        }
    }
}
