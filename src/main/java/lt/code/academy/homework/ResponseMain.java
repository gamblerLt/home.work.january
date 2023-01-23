package lt.code.academy.homework;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ResponseMain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        List<Integer>responses = new ArrayList<>();
       // StudentResponse studentResponse = new StudentResponse(responses.add());
        while (true) {
            System.out.println("įveskite atsakymą");
            int response = scanner.nextInt();
            if(response == 0) {
                break;
            }
            responses.add(response);
        }
        System.out.println("Jūsų įvesti atsakymai yra: ");

        for (int i = 0; i < responses.size(); i++) {

            System.out.println(responses.get(i) + " ");
        }


    }
}

/*public class BufferedReaderExample {
	public static void main(String[] args) {
		try (BufferedReader br = new BufferedReader(new FileReader("example.txt"))) {
			String line;
			while((line = br.readLine()) != null) {
				System.out.println(line);
			}
		} catch(IOException e) {
			System.out.println("Cannot read file " + e.getMessage());
		}
	}
}
*/

//cia reikia issivesti klausimus ir prasyti ivesti atsakymus

//turi buti i lista sudedami atsakymai po viena


//write few object to json file
//		mapper.writeValue(file, List.of(user, secondUser, objectUser));

/*import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<Integer> list = new ArrayList<>();
        while (true) {
            System.out.println("Enter a number (enter 0 to stop): ");
            int num = sc.nextInt();
            if (num == 0) {
                break;
            }
            list.add(num);
        }
        System.out.println("The numbers in the arraylist are: ");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i) + " ");
        }
    }
}*/