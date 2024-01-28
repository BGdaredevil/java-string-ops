import java.util.ArrayList;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input");

//        reverseStrings(sc);
//        strRepeater(sc);
//        substrings(sc);
//        textFilter(sc);
//        separateDigits(sc);
//        validUsernames(sc);
//        extractFileName(sc);
//        cypherCaesar(sc);
            multiplyBigInt(sc);

    }

    private static void multiplyBigInt(Scanner sc) {

    }

    private static void cypherCaesar(Scanner sc) {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder(input.length());

        for (char item : input.toCharArray()) {
            result.append((char) ((int) item + 3));
        }
        System.out.println(result);
    }

    private static void extractFileName(Scanner sc) {
        String input = sc.nextLine();
        Pattern pattern = Pattern.compile("(?<=\\\\)(?<fileName>[\\w.]+)(?>\\.)(?<ext>[a-zA-Z]+$)");
        Matcher matcher = pattern.matcher(input);

        if (matcher.find()) {
            String fileName = matcher.group("fileName");
            String ext = matcher.group("ext");

            System.out.println("File name: " + fileName);
            System.out.println("File extension: " + ext);
        }

    }

    private static void validUsernames(Scanner sc) {
        String[] input = sc.nextLine().split(", ");
        StringBuilder result = new StringBuilder();

        for (String username : input) {
            if (username.length() < 3 || username.length() > 16) {
                continue;
            }

            if (!username.matches("^[\\w-]+$")) {
                continue;
            }

            result.append(username).append('\n');
        }

        System.out.println(result);
    }

    private static void separateDigits(Scanner sc) {
        String input = sc.nextLine();

        // solution one
        // System.out.println(input.replaceAll("[^\\d]", ""));
        // System.out.println(input.replaceAll("[^a-zA-Z]", ""));
        // System.out.println(input.replaceAll("\\w", ""));

        ArrayList<Character> digits = new ArrayList<>();
        ArrayList<Character> letters = new ArrayList<>();
        ArrayList<Character> chars = new ArrayList<>();

        for (char item : input.toCharArray()) {
            if (Character.isDigit(item)) {
                digits.add(item);
                continue;
            }

            if (Character.isAlphabetic(item)) {
                letters.add(item);
                continue;
            }

            chars.add(item);
        }

        System.out.println(digits.stream().map(c -> Character.toString(c)).collect(Collectors.joining("")));
        System.out.println(letters.stream().map(c -> Character.toString(c)).collect(Collectors.joining("")));
        System.out.println(chars.stream().map(c -> Character.toString(c)).collect(Collectors.joining("")));
    }

    private static void textFilter(Scanner sc) {
        String[] bannedWords = sc.nextLine().split(", ");
        StringBuilder multilineInput = new StringBuilder();

        while (sc.hasNextLine()) {
            String line = sc.nextLine();
            multilineInput.append(line).append(" ");
        }

        String result = multilineInput.toString().trim();

        for (String bannedWord : bannedWords) {
            result = result.replaceAll(bannedWord, "*".repeat(bannedWord.length()));
        }

        System.out.println(result);
    }

    private static void substrings(Scanner sc) {
        String target = sc.nextLine();
        String result = sc.nextLine();

        while (result.contains(target)) {
            result = result.replaceAll(target, "");
        }

        System.out.println(result);

    }

    private static void strRepeater(Scanner sc) {
        String[] input = sc.nextLine().split(" ");
        StringBuilder result = new StringBuilder();
        result.append('\n');
        for (String item : input) {
            result.append(item.repeat(item.length()));
        }

        System.out.println(result);
    }

    private static void reverseStrings(Scanner sc) {
        StringBuilder output = new StringBuilder();
        String command = sc.nextLine();

        while (!command.equals("end")) {
            String reverted = new StringBuffer(command).reverse().toString();
            output.append(command).append(" = ").append(reverted).append('\n');
            command = sc.nextLine();
        }

        System.out.println(output);
    }
}