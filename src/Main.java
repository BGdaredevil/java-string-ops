import java.util.Scanner;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("input");

//        reverseStrings(sc);
//        strRepeater(sc);
//        substrings(sc);
        textFilter(sc);

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