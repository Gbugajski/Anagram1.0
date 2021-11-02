import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class AnagramRepository {

    private HashMap<Anagram, Integer> repo;
    private static AnagramRepository instance;

    private AnagramRepository(){
        repo = new HashMap<>();
        for (int i = 1; i < 10; i++) {
            for (int j = i; j < 10; j++) {
                for (int k = j; k < 10; k++) {
                    Anagram anagram = new Anagram(i,j,k);
                    repo.put(anagram, 100*i+10*j+k);
                }
            }
        }
    }
    public static AnagramRepository initAnagramRepository(){
        if (instance==null) { instance = new AnagramRepository();}
        return instance;
    }

    public HashMap<Anagram, Integer> getRepo() {
        return repo;
    }
}
