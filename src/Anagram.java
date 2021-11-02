import java.util.HashMap;
import java.util.Objects;
import java.util.stream.Stream;

public class Anagram {
    HashMap<Character, Integer> set;
    HashMap<Character, Integer> setTemp;
    HashMap<Integer,Integer> counting;


    public Anagram(String str1, String str2, String str3){
        this.set = new HashMap<>();
        this.setTemp = new HashMap<>();
        String superstr = str1 + str2 + str3;
        for (char ch: superstr.toCharArray()) {
            addSetValue(ch);
            addSetTempValue(ch);
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
    private void addSetTempValue(char ch){
        if (setTemp.containsKey((Character) ch)) { setTemp.replace(ch,setTemp.get(ch)+1);}
        else setTemp.put(ch, 1);
    }
    private void flushLetter(char ch, int i){
        for (int j = 0; j < i; j++) {
            setTemp.replace(ch,setTemp.get(ch)-1);
        }
    }
    private int countNumber(char ch, int i){
        int howManyTimes = 0;
        while (setTemp.containsKey((Character) ch) && setTemp.get(ch)!=0)
        { setTemp.replace(ch,setTemp.get(ch)-1); counting.replace(i,counting.get(i)+1);
        howManyTimes++;}
        return howManyTimes;
    }

    public void countNumbers(){
        this.counting = new HashMap<>();
        counting.put(1,0);
        counting.put(2,0);
        counting.put(3,0);
        counting.put(4,0);
        counting.put(5,0);
        counting.put(6,0);
        counting.put(7,0);
        counting.put(8,0);
        counting.put(9,0);
        int i=0;
        //SIX -> X
        i = countNumber('x',6);
        flushLetter('s',i);
        flushLetter('i',i);
        //TWO -> W
        i = countNumber('w',2);
        flushLetter('t',i);
        flushLetter('o',i);
        //Seven -> S
        i = countNumber('s',7);
        flushLetter('e',i);
        flushLetter('v',i);
        flushLetter('e',i);
        flushLetter('n',i);
        //FIVE -> V
        i = countNumber('v',5);
        flushLetter('f',i);
        flushLetter('i',i);
        flushLetter('e',i);
        //FOUR -> F
        i = countNumber('f',4);
        flushLetter('o',i);
        flushLetter('u',i);
        flushLetter('r',i);
        //ONE - O
        i = countNumber('o',1);
        flushLetter('n',i);
        flushLetter('e',i);
        //NINE -> N
        i = countNumber('n',9);
        flushLetter('i',i);
        flushLetter('n',i);
        flushLetter('e',i);
        counting.replace(9,counting.get(9)/2);
        //THREE -> R
        i = countNumber('r',3);
        flushLetter('t',i);
        flushLetter('h',i);
        flushLetter('e',i);
        flushLetter('e',i);
        //EIGHT -> H
        i = countNumber('h',8);
        flushLetter('e',i);
        flushLetter('i',i);
        flushLetter('g',i);
        flushLetter('t',i);
    }

    public HashMap<Integer, Integer> getCounting() {
        return counting;
    }

    public void setCounting(HashMap<Integer, Integer> counting) {
        this.counting = counting;
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

    public int toReadable(){
        String str="";
        for (int num = 1; num < 10; num++) {


            for (int j = 0; j < counting.get(num); j++) {
                str+= String.valueOf(num);
            }
        }
        return Integer.valueOf(str);
    }
}
