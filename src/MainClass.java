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
            AnagramRepository anagramRepository = AnagramRepository.initAnagramRepository();
            HashMap<Anagram, Integer> repo = anagramRepository.getRepo();
            Integer integer = repo.get(new Anagram(str));
            System.out.println(integer);
        } while (!str.equals("dupa"));
    }
}
