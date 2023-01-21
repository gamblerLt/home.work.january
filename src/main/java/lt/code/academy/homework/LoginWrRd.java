package lt.code.academy.homework;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LoginWrRd {
    private static final String FILE_NAME = "students.json";
    Map<Integer, LoginStudentRec> getLgrStudents() {
        Map<Integer, LoginStudentRec> lgrStudents = new HashMap<>();
        try (ObjectInput obIn = new ObjectInputStream(new FileInputStream(FILE_NAME))) {
            while (true) {
                LoginStudentRec loginStudentRec = (LoginStudentRec) obIn.readObject();
                lgrStudents.put(loginStudentRec.studentNumber(), loginStudentRec);
            }
//EOFE gaudo klaidas su ivedimu
        } catch (EOFException eofe) {
            System.out.println("Err.Input.Streem: " + eofe.getMessage());
        } catch (Exception e) {
            System.out.println("Klaida: " + e.getMessage());
        }
        return lgrStudents;
    }

    void storeStudents(Map<Integer, LoginStudentRec> loginStudentRec) {
        try(ObjectOutput objectOutput = new ObjectOutputStream(new FileOutputStream(FILE_NAME))) {

        }catch (IOException e) {
            System.out.println("Įrašymo klaida: " + e.getMessage());
        }
    }

}