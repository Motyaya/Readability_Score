package readability;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        File file = new File("./" + args[0]);
        double words=0, texts=0, sullables=0, polysyllables=0;
        int characters=0;
        try( Scanner fileScanner = new Scanner(file)) {
            while (fileScanner.hasNext()) {
                String string = fileScanner.next();
                words++;
                characters += string.length();
                sullables+=countSyllables(string);
                if (countSyllables(string)>2) polysyllables++;
                if (string.matches("[\\w]+!|[\\w]+\\.|[\\w]+\\?")) {
                    texts++;
                } else if (!fileScanner.hasNext() && !string.matches("[\\w]+!|[\\w]+\\.|[\\w]+\\?")) {
                    texts++;
                }
            }
        }
        catch (FileNotFoundException e){
            System.out.println("No file found: " + file);
        }
        System.out.println("Words: " + words);
        System.out.println("Sentences: " + texts);
        System.out.println("Characters: "+characters);
        System.out.println("Syllables: " + sullables);
        System.out.println("Polysyllables: " + polysyllables);
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter the score you want to calculate (ARI, FK, SMOG, CL, all): ");
        String choose = scanner.next();
        switch (choose){
            case "ARI": {
                ARI(characters,words,texts);
                break;
            }
            case "FK": {
                FK(words,texts,sullables);
                break;
            }
            case "SMOG": {
                SMOG(polysyllables,texts);
                break;
            }
            case "CL": {
                CL(characters,words,texts);
                break;
            }
            case "all": {
               double rez = ARI(characters,words,texts);
                rez += FK(words,texts,sullables);
                rez += SMOG(polysyllables,texts);
                rez += CL(characters,words,texts);
                rez = rez/4;
                System.out.printf("This text should be understood in average by %.2f year olds.",rez);
                break;
            }
        }
    }

    private static double CL(int characters, double words, double texts) {
        double score = 0.0588*characters/words*100-0.296*texts/words*100-15.8;
        int round = (int) Math.round(score);
        int year=0;
        switch (round){
            case 1:{
                year = 6;
                System.out.printf("Coleman–Liau index: %.2f (about 6 year olds).%n",score);
                break;
            }
            case 2:{
                year = 7;
                System.out.printf("Coleman–Liau index: %.2f (about 7 year olds).%n",score);
                break;
            }
            case 3:{
                year = 9;
                System.out.printf("Coleman–Liau index: %.2f(about 9 year olds).%n",score);
                break;
            }
            case 4:{
                year = 10;
                System.out.printf("Coleman–Liau index: %.2f (about 10 year olds).%n",score);
                break;
            }
            case 5:{
                year = 11;
                System.out.printf("Coleman–Liau index: %.2f (about 11 year olds).%n",score);
                break;
            }
            case 6:{
                year = 12;
                System.out.printf("Coleman–Liau index: %.2f (about 12 year olds).%n",score);
                break;
            }
            case 7:{
                year = 13;
                System.out.printf("Coleman–Liau index: %.2f (about 13 year olds).%n",score);
                break;
            }
            case 8:{
                year = 14;
                System.out.printf("Coleman–Liau index: %.2f (about 14 year olds).%n",score);
                break;
            }
            case 9:{
                year = 15;
                System.out.printf("Coleman–Liau index: %.2f (about 15 year olds).%n",score);
                break;
            }
            case 10:{
                year = 16;
                System.out.printf("Coleman–Liau index: %.2f (about 16 year olds).%n",score);
                break;
            }
            case 11:{
                year = 17;
                System.out.printf("Coleman–Liau index: %.2f (about 17 year olds).%n",score);
                break;
            }
            case 12:{
                year =18;
                System.out.printf("Coleman–Liau index: %.2f (about 18 year olds).%n",score);
                break;
            }
            case 13:{
                year = 24;
                System.out.printf("Coleman–Liau index: %.2f (about 24 year olds).%n",score);
                break;
            }
            case 14:{
                year = 24;
                System.out.printf("Coleman–Liau index: %.2f (about 24+ year olds).%n",score);
                break;
            }
        }
        return year;
    }

    private static double SMOG(double polysyllables, double texts) {
        double score = 1.043*Math.sqrt(polysyllables*30/texts)+3.1291;
        int round = (int) Math.round(score);
        int year=0;
        switch (round){
            case 1:{
                year = 6;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 6 year olds).%n",score);
                break;
            }
            case 2:{
                year = 7;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 7 year olds).%n",score);
                break;
            }
            case 3:{
                year = 9;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 9 year olds).%n",score);
                break;
            }
            case 4:{
                year = 10;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 10 year olds).%n",score);
                break;
            }
            case 5:{
                year = 11;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 11 year olds).%n",score);
                break;
            }
            case 6:{
                year = 12;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 12 year olds).%n",score);
                break;
            }
            case 7:{
                year = 13;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 13 year olds).%n",score);
                break;
            }
            case 8:{
                year = 14;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 14 year olds).%n",score);
                break;
            }
            case 9:{
                year = 15;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 15 year olds).%n",score);
                break;
            }
            case 10:{
                year = 16;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 16 year olds).%n",score);
                break;
            }
            case 11:{
                year = 17;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 17 year olds).%n",score);
                break;
            }
            case 12:{
                year =18;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 18 year olds).%n",score);
                break;
            }
            case 13:{
                year = 24;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 24 year olds).%n",score);
                break;
            }
            case 14:{
                year = 24;
                System.out.printf("Simple Measure of Gobbledygook: %.2f (about 24+ year olds).%n",score);
                break;
            }
        }
        return year;
    }

    private static double FK(double words, double texts, double sullables) {
        double score = 0.39*words/texts + 11.8*sullables/words-15.59;
        int round = (int) Math.round(score);
        int year=0;
        switch (round){
            case 1:{
                year = 6;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 6 year olds).%n",score);
                break;
            }
            case 2:{
                year = 7;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 7 year olds).%n",score);
                break;
            }
            case 3:{
                year = 9;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 9 year olds).%n",score);
                break;
            }
            case 4:{
                year = 10;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 10 year olds).%n",score);
                break;
            }
            case 5:{
                year = 11;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 11 year olds).%n",score);
                break;
            }
            case 6:{
                year = 12;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 12 year olds).%n",score);
                break;
            }
            case 7:{
                year = 13;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 13 year olds).%n",score);
                break;
            }
            case 8:{
                year = 14;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 14 year olds).%n",score);
                break;
            }
            case 9:{
                year = 15;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 15 year olds).%n",score);
                break;
            }
            case 10:{
                year = 16;
                System.out.printf("Flesch–Kincaid readability tests: %.2f(about 16 year olds).%n",score);
                break;
            }
            case 11:{
                year = 17;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 17 year olds).%n",score);
                break;
            }
            case 12:{
                year =18;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 18 year olds).%n",score);
                break;
            }
            case 13:{
                year = 24;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 24 year olds).%n",score);
                break;
            }
            case 14:{
                year = 24;
                System.out.printf("Flesch–Kincaid readability tests: %.2f (about 24+ year olds).%n",score);
                break;
            }
        }
        return year;
    }

    private static double ARI(int characters, double words, double texts) {
        double score = 4.71*characters/words + 0.5*words/texts-21.43;

        int round = (int) Math.round(score);
        int year=0;
        switch (round){
            case 1:{
                year = 6;
                System.out.printf("Automated Readability Index: %.2f (about 6 year olds). %n", score);
                break;
            }
            case 2:{
                year = 7;
                System.out.printf("Automated Readability Index: %.2f  (about 7 year olds).%n", score);
                break;
            }
            case 3:{
                year = 9;
                System.out.printf("Automated Readability Index: %.2f (about 9 year olds).%n",score);
                break;
            }
            case 4:{
                year = 10;
                System.out.printf("Automated Readability Index: %.2f (about 10 year olds).%n",score);
                break;
            }
            case 5:{
                year = 11;
                System.out.printf("Automated Readability Index: %.2f (about 11 year olds).%n",score);
                break;
            }
            case 6:{
                year = 12;
                System.out.printf("Automated Readability Index: %.2f (about 12 year olds).%n",score);
                break;
            }
            case 7:{
                year = 13;
                System.out.printf("Automated Readability Index: %.2f (about 13 year olds).%n", score);
                break;
            }
            case 8:{
                year = 14;
                System.out.printf("Automated Readability Index: %.2f (about 14 year olds).%n",score);
                break;
            }
            case 9:{
                year = 15;
                System.out.printf("Automated Readability Index: %.2f (about 15 year olds).%n",score);
                break;
            }
            case 10:{
                year = 16;
                System.out.printf("Automated Readability Index: %.2f (about 16 year olds).%n",score);
                break;
            }
            case 11:{
                year = 17;
                System.out.printf("Automated Readability Index: %.2f (about 17 year olds).%n",score);
                break;
            }
            case 12:{
                year =18;
                 System.out.printf("Automated Readability Index: %.2f (about 18 year olds).%n",score);
                break;
            }
            case 13:{
                year = 24;
                System.out.printf("Automated Readability Index: %.2f  (about 24 year olds). %n",score);
                break;
            }
            case 14:{
                year = 24;
                System.out.printf("Automated Readability Index: %.2f (about 24+ year olds).%n",score);
                break;
            }
        }
        return year;
    }

    public static int countSyllables(String word)
    {
        //TODO: Implement this method so that you can call it from the
        //getNumSyllables method in BasicDocument (module 1) and
        //EfficientDocument (module 2).
        int count = 0;
        word = word.toLowerCase();

        if (word.charAt(word.length()-1) == 'e') {
            if (silente(word)){
                String newword = word.substring(0, word.length()-1);
                count = count + countit(newword);
            } else {
                count++;
            }
        } else {
            count = count + countit(word);
        }
        return count;
    }

    public static int countit(String word) {
        int count = 0;
        Pattern splitter = Pattern.compile("[^aeiouy]*[aeiouy]+");
        Matcher m = splitter.matcher(word);

        while (m.find()) {
            count++;
        }
        return count;
    }

    public static boolean silente(String word) {
        word = word.substring(0, word.length()-1);

        Pattern yup = Pattern.compile("[aeiouy]");
        Matcher m = yup.matcher(word);

        if (m.find()) {
            return true;
        } else
            return false;
    }

}
