import java.util.*;
import lib.Stone;

public class ListSplitExample{

    public static void main(String args[]) {
       Stone.SplitList(Stone.rangeList(1,1005,0, new ArrayList<Integer>()), 3).forEach(x -> Stone.puts(x));
    }
}

