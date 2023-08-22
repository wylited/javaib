package tech.wyli.javaib;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        boolean isRunning = true;

        while (isRunning) {
            System.out.println("Select the input temperature unit:");
            System.out.println("1. Celsius");
            System.out.println("2. Kelvin");
            System.out.println("3. Fahrenheit");
            System.out.print("Enter your choice: ");

            int inputChoice = scanner.nextInt();

            System.out.println("Select the output temperature unit:");
            System.out.println("1. Celsius");
            System.out.println("2. Kelvin");
            System.out.println("3. Fahrenheit");
            System.out.print("Enter your choice: ");

            int outputChoice = scanner.nextInt();

            System.out.print("Enter the temperature: ");
            double temperature = scanner.nextDouble();

            double result = convertTemperature(temperature, inputChoice, outputChoice);
            String inputUnit = getTemperatureUnit(inputChoice);
            String outputUnit = getTemperatureUnit(outputChoice);

            System.out.println("The temperature in " + outputUnit + " is: " + result);
            System.out.println("Would you like to convert another temperature? (y/n)");

            String answer = scanner.next();

            if (answer.equals("n")) {
                isRunning = false;
            }
        }

        scanner.close();
    }

    public static double convertTemperature(double temperature, int inputChoice, int outputChoice) {
        double result = 0.0;

        switch (inputChoice) {
            case 1: // Celsius
                switch (outputChoice) {
                    case 1: // Celsius
                        result = temperature;
                        break;
                    case 2: // Kelvin
                        result = temperature + 273.15;
                        break;
                    case 3: // Fahrenheit
                        result = (temperature * 9 / 5) + 32;
                        break;
                }
                break;
            case 2: // Kelvin
                switch (outputChoice) {
                    case 1: // Celsius
                        result = temperature - 273.15;
                        break;
                    case 2: // Kelvin
                        result = temperature;
                        break;
                    case 3: // Fahrenheit
                        result = (temperature - 273.15) * 9 / 5 + 32;
                        break;
                }
                break;
            case 3: // Fahrenheit
                switch (outputChoice) {
                    case 1: // Celsius
                        result = (temperature - 32) * 5 / 9;
                        break;
                    case 2: // Kelvin
                        result = (temperature - 32) * 5 / 9 + 273.15;
                        break;
                    case 3: // Fahrenheit
                        result = temperature;
                        break;
                }
                break;
        }

        return result;
    }

    public static String getTemperatureUnit(int choice) {
        switch (choice) {
            case 1:
                return "Celsius";
            case 2:
                return "Kelvin";
            case 3:
                return "Fahrenheit";
            default:
                return "";
        }
    }
}
