import java.util.HashMap;
import java.util.Scanner;

public class MainClass {
    public static void main(String[] args) {
//        Anagram anagram = new Anagram(1, 2, 3);
//        System.out.println(anagram.getSet().toString());
//        System.out.println(anagram.hashCode());
        String str = null;
        do {
            System.out.println("Napisz anagram:");
            Scanner scanner = new Scanner(System.in);
            str = scanner.nextLine();
            Anagram anagram = new Anagram(str);
            anagram.countNumbers();

            System.out.println(anagram.toReadable());
        } while (!str.equals("dupa"));
    }
}
