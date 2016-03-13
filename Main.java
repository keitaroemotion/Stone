import java.util.*;

public class Main{

    public static void main(String args[]){
        Stone.puts(Stone.get(Stone.push(Stone.toList(args), "aaa"), 0));
        immutableListTest(args);
        concatListTest();
    }

    private static <T> void immutableListTest(String args[]){
       List<String> immutableList = Stone.toList(args);
       immutableList = Stone.push(immutableList, "hahaha");
       for(String t: immutableList)
           Stone.puts(t);
    }

    public static void concatListTest(){
        List<Integer> _list1 = new ArrayList<Integer>(){{add(1); }};
        Stone.puts(Stone.concatList(Stone.newList(1, 2), Stone.newList(3)));
        Stone.puts(Stone.concatList(Stone.newList(4,5,6), Stone.newList(7)));
        Stone.puts(Stone.concatList(Stone.newList("a","b","c","d","e", "f"), Stone.newList("i")));
    }

}

