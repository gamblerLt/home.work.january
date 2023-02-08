package lt.code.academy.homework.questions;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class QuestionWriter {

    private static final String QUESTION_FILE_NAME = "question.json";

    public static void main(String[] args) {
        Question question = new Question();
        question.setQuestion1("Koks miestas yra Lietuvos sostinė?");
        question.setAnswers1(List.of("Vilnius", "Kaunas", "Klaipėda"));
        question.setCorrectAnswersIndex1(0);
        question.setQuestion2("Kiek bus 2 * 2?");
        question.setAnswers2(List.of("Vienas", "Keturi", "Penki"));
        question.setCorrectAnswersIndex2(1);
        question.setQuestion3("Kas yra žuvis?");
        question.setAnswers3(List.of("Augalas", "Oras", "Vandens gyvūnas"));
        question.setCorrectAnswersIndex3(2);
        question.setQuestion4("Kas yra tornadas?");
        question.setAnswers4(List.of("Įrankis", "Gamtos reiškinys", "Automobilis"));
        question.setCorrectAnswersIndex4(1);
        question.setQuestion5("Kas čia praleista A-?-C ?");
        question.setAnswers5(List.of("B", "G", "Z"));
        question.setCorrectAnswersIndex5(0);
        question.setQuestion6("Lietuva yra:");
        question.setAnswers6(List.of("Amerikoje", "Afrikoje", "Europoje"));
        question.setCorrectAnswersIndex6(2);
        question.setQuestion7("Kiek bus 5 * 2?");
        question.setAnswers7(List.of("Trys", "Dešimt", "Penkiolika"));
        question.setCorrectAnswersIndex7(1);
        question.setQuestion8("Kur gyvena pelėda?");
        question.setAnswers8(List.of("Garaže", "Parduotuvėje", "Drevėje"));
        question.setCorrectAnswersIndex8(2);
        question.setQuestion9("Kas yra vanduo?");
        question.setAnswers9(List.of("Skystis", "Metalas", "Oras"));
        question.setCorrectAnswersIndex9(0);
        question.setQuestion10("Kas yra vasara?");
        question.setAnswers10(List.of("Rūbas", "Ežeras", "Metų laikas"));
        question.setCorrectAnswersIndex10(2);


        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);

        try {
            objectMapper.writeValue(new File(QUESTION_FILE_NAME), question);

        } catch (JsonGenerationException e) {
            System.out.println("Failo kurimo klaida" + e.getMessage());
        } catch (JsonMappingException e) {
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Kita klaida" + e.getMessage());
        }
    }
}
