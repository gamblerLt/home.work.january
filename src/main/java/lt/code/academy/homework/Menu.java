package lt.code.academy.homework;

import java.util.Scanner;

public class Menu {


    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("\nPasirinkite vieną iš meniu punktų:\n");

        Menu menu = new Menu();

        String menuAction;
        do {
            menu.menu();
            menuAction = scanner.nextLine();

            menu.selectmenuAction(menuAction, scanner);
        }while(!menuAction.equals("5"));
    }

    private void selectmenuAction(String menuAction, Scanner scanner) {
        switch (menuAction) {
            //case "1" -> selectmenuAction(scanner);
            case "2" -> System.out.println("Įveskite vardą");
            case "3" -> System.out.println("Įveskite pavardę");
            case "4" -> System.out.println("Pradėti testą");
            case "5" -> System.out.println("Rezultatas");
            default -> System.out.println("Šis veiksmas nėra numatytas.");
        }
    }

    private void menu(){
        System.out.println("""
                1. - Iveskite savo duomenis
                2. - Spręskite testą
                3. - Įveskite pavardę
                4. - Pradėti testą
                5. - Rezultatas
                """);
    }
}
/*public class TaskFiveAn {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        TaskFiveAn task = new TaskFiveAn();
        List<String> words = new ArrayList<>();

        String action;
        do{
            task.menu();
            action = scanner.nextLine();
            task.selectAction(action, words, scanner);
        } while(!action.equals(("5")));
            }
            private  void selectAction(String action, List<String> words, Scanner sc){
        switch (action){
            case "1" -> addWord(words, sc);
            case "2" -> findWord(words, sc);
            case "3" -> deleteWord(words, sc);
            case "4" -> words.clear();
            case "5" -> System.out.println("Darbo pabaiga");
            default -> System.out.println("Tokio veiksmo nėra");
        }
            }
            private void addWord(List<String> words, Scanner sc) {
                System.out.println("Įveskite žodį");
                words.add(sc.nextLine());
        }
            private void findWord(List<String> words, Scanner sc){
              System.out.println("Įveskite iškomą žodį");
              String word = sc.nextLine();

              int index = words.indexOf(word);

                //-1 kai neranda
                if(index < 0){
                    System.out.println("Tokio žodžio nėra");
                }else{
                    System.out.printf("Žodžio %s indeksas yra: %s%n ", word, index);
                }
            }
            private void deleteWord(List<String> words, Scanner sc){
                System.out.println("Įveskite žodį, kurį trinsite");
                String word = sc.nextLine();

                if(words.remove(word)){
                    System.out.println("Žodis ištrintas");
                }else{
                    System.out.println("Tokio =od=io neradau");
                }
            }

    private void menu(){
        System.out.println("""
                1. - Įvesti žodį
                2. - Rasti žodį
                3. - Trinti žodį
                4. - Išvalyti sąrašą
                5. Baigti programą.
                """);

    }
}*/