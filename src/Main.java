import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
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
//        multiplyBigInt(sc);
//        replaceRepeatingChars(sc);
//        extractInfo(sc);
        sumAsci(sc);

    }

    private static void sumAsci(Scanner sc) {
        char first = sc.nextLine().charAt(0);
        char second = sc.nextLine().charAt(0);
        char[] input = sc.nextLine().toCharArray();
        int result = 0;

        for (char item : input) {
            if (item > first && item < second) {
                result += item;
            }
        }

        System.out.println(result);
    }

    private static void extractInfo(Scanner sc) {
        Pattern namePattern = Pattern.compile("(?>@)(?<name>[A-Za-z]+)(?>\\|)");
        Pattern age = Pattern.compile("(?>#)(?<age>[\\d]+)(?>\\*)");
        int count = Integer.parseInt(sc.nextLine());
        StringBuilder result = new StringBuilder();

        while (count > 0) {
            count--;
            String input = sc.nextLine();
            Matcher nameMatcher = namePattern.matcher(input);
            Matcher ageMatcher = age.matcher(input);

            if (nameMatcher.find()) {
                if (ageMatcher.find()) {
                    result.append(String.format("%s is %s years old.\n", nameMatcher.group("name"), ageMatcher.group("age")));
                }
            }
        }

        System.out.println(result);
    }

    private static void replaceRepeatingChars(Scanner sc) {
        String input = sc.nextLine();
        StringBuilder result = new StringBuilder();
        for (char letter : input.toCharArray()) {
            if (result.isEmpty()) {
                result.append(letter);
                continue;
            }

            char prev = result.charAt(result.length() - 1);
            if (prev != letter) {
                result.append(letter);
            }
        }
        System.out.println(result);
    }

    private static void multiplyBigInt(Scanner sc) {
        int[] digits = Arrays.stream(sc.nextLine().split("")).mapToInt(Integer::parseInt).toArray();
        int multiplier = Integer.parseInt(sc.nextLine());

        if (multiplier == 0) {
            System.out.println(0);
            return;
        }

        StringBuilder result = new StringBuilder(digits.length);

        int carryOver = 0;

        for (int i = digits.length - 1; i >= 0; i--) {
            int lastDigit = digits[i];
            int product = lastDigit * multiplier + carryOver;

            int productLastDigit = product % 10;
            carryOver = (product - productLastDigit) / 10;
            result.append(productLastDigit);
        }

        if (carryOver > 0) {
            result.append(carryOver);
        }

        System.out.println(result.reverse());
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