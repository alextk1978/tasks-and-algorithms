package tasks;

import java.util.Scanner;
import java.util.function.Function;

/**
 * @author Alexey Tkachenko
 */
public class Emailing {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String sender = scanner.nextLine();
        String receiver = scanner.nextLine();
        String signature = scanner.nextLine();

        Function<String, String> emailFormatter = text -> sender.trim() + "|" + receiver.trim() + "|" +
                text.trim() + "|" + signature.trim();

        System.out.println(emailFormatter.apply(scanner.nextLine()));
    }
}
