import java.util.*;
import java.lang.Thread;
import java.util.concurrent.TimeUnit;
import lib.Stone;
import java.util.concurrent.ExecutorService;

public class Main{

    public static void main(String args[]) {
        multiThreadExample();
    }

    private static void displayFileContent(String param){
        new Thread(() -> { Stone.putsLazy(Stone.readFile(param)); }).start();
    }

    private static void multiThreadExample() {
        Stone.newList("etc/1", "etc/2").forEach( x -> displayFileContent(x));
    }

}

