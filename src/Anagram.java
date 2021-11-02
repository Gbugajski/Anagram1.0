import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

public class Anagram {
    HashMap<Character, Integer> set;


    public Anagram(String str1, String str2, String str3){
        this.set = new HashMap<>();
        String superstr = str1 + str2 + str3;
        for (char ch: superstr.toCharArray()) {
            addSetValue(ch);
        }

    }
    public Anagram(int int1, int int2, int int3){
        this.set = new HashMap<>();
        String str1 = DigiDictTools.intToStr(int1);
        String str2 = DigiDictTools.intToStr(int2);
        String str3 = DigiDictTools.intToStr(int3);
        String superstr = str1 + str2 + str3;
        for (char ch: superstr.toCharArray()) {
            addSetValue(ch);
        }

    }

    public Anagram(String str){
        this(str, "", "");
    }


    public HashMap<Character, Integer> getSet() {
        return set;
    }

    public Anagram getAnagramByString(String str){
        return null;
    }

    private void addSetValue(char ch){
        if (set.containsKey((Character) ch)) { set.replace(ch,set.get(ch)+1);}
        else set.put(ch, 1);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Anagram anagram = (Anagram) o;
        return Objects.equals(set, anagram.set);
    }

    @Override
    public int hashCode() {
        return Objects.hash(set);
    }
}
