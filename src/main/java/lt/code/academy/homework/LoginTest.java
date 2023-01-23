package lt.code.academy.homework;

import org.json.simple.JSONObject;

import java.io.FileWriter;
import java.util.Scanner;

public class LoginTest {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        System.out.println("Iveskite savo varda");
        String name = scanner.nextLine();

        JSONObject obj = new JSONObject();

        obj.put("name", name);

        try {
            FileWriter file = new FileWriter("data.json");
            file.write(obj.toJSONString());
            file.close();

            System.out.println("Successfully wrote data to file");
        } catch (Exception e) {
            e.printStackTrace();
        }

        scanner.close();
    }


}

/*
* import java.io.FileWriter;
import java.util.Scanner;

import org.json.simple.JSONObject;

public class Main {

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);

		System.out.println("Please enter your name:");
		String name = scanner.nextLine();

		System.out.println("Please enter your age:");
		int age = scanner.nextInt();

		JSONObject obj = new JSONObject();
		obj.put("name", name);
		obj.put("age", age);

		try {
			FileWriter file = new FileWriter("data.json");
			file.write(obj.toJSONString());
			file.close();

			System.out.println("Successfully wrote data to file");
		} catch (Exception e) {
			e.printStackTrace();
		}

		scanner.close();
	}*/