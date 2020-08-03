package readability;

import readability.elements.Paragraph;
import readability.ScoreIndex.*;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Scanner;

public class Main {

    public static String readFileAsString(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }

    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String wholeString = readFileAsString(args[0]);
            Paragraph para = new Paragraph();
            para.setPara(wholeString);
            para.displayCounts();
            System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
            String choice = scanner.next();

            switch (choice) {
                case ("ARI"):
                    Context strategy1 = new Context(new ARIScore(), para);
                    System.out.println("Automated Readability Index: " + strategy1.getScore() + " (about " + strategy1.getAge() + " year olds.)");
                    break;

                case ("FK"):
                    Context strategy2 = new Context(new FKRScore(), para);
                    System.out.println("Flesch–Kincaid readability tests: " + strategy2.getScore() + " (about " + strategy2.getAge() + " year olds.)");
                    break;

                case ("SMOG"):
                    Context strategy3 = new Context(new SMOGScore(), para);
                    System.out.println("Simple Measure of Gobbledygook: " + strategy3.getScore() + " (about " + strategy3.getAge() + " year olds.)");
                    break;

                case ("CL"):
                    Context strategy4 = new Context(new SMOGScore(), para);
                    System.out.println("Coleman–Liau index: " + strategy4.getScore() + " (about " + strategy4.getAge() + " year olds.)");
                    break;

                case ("all"):
                    double sum = 0;
                    Context strategy = new Context(new ARIScore(), para);
                    sum += Double.parseDouble(strategy.getAge());
                    System.out.println("\nAutomated Readability Index: " + strategy.getScore() + " (about " + strategy.getAge() + " year olds.)");
                    strategy = new Context(new FKRScore(), para);
                    sum += Double.parseDouble(strategy.getAge());
                    System.out.println("\nFlesch–Kincaid readability tests: " + strategy.getScore() + " (about " + strategy.getAge() + " year olds.)");
                    strategy = new Context(new SMOGScore(), para);
                    sum += Double.parseDouble(strategy.getAge());
                    System.out.println("\nSimple Measure of Gobbledygook: " + strategy.getScore() + " (about " + strategy.getAge() + " year olds.)");
                    strategy = new Context(new SMOGScore(), para);
                    sum += Double.parseDouble(strategy.getAge());
                    System.out.println("\nColeman–Liau index: " + strategy.getScore() + " (about " + strategy.getAge() + " year olds.)");

                    System.out.println("\nThis text should be understood in average by " + (sum / 4) + " year olds.");
                    break;
            }
        }
        catch (IOException e) {
            System.out.println("Cannot read file: " + e.getMessage());
        }
    }
}
