package lt.code.academy.homework.test;

import lt.code.academy.homework.StudentMain;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;
import java.util.Objects;

public class Main {
    private static final String ANSWER_FILE_NAME = "correct_answers.json";
    public static void main(String[] args) {
        Main main = new Main();
        List<String> names = List.of(); //tuscias listas

        //nuskaityti failo eilutes: 222, vardas, pavarde (id vardas, pavarde
        try (BufferedReader br = new BufferedReader(new FileReader(ANSWER_FILE_NAME))) {
            names = br.lines()
                    //.filter(l -> !l.startsWith("id"))
                    //.map(main::collectName)
                    //.filter(Objects::nonNull)
                    //.distinct()
                    .sorted()
                    .toList();

        } catch (IOException e) {
            System.out.println(e.getMessage());
        }
        //reikia prafiltruoti pirm,a eilute
        names.forEach((System.out::println));

    }
    private String collectName(String line) {
        String[] items = line.split(", ");
        if (items.length < 2) {
            return null;
        }
        return items[0];
    }
}
