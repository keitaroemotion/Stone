package lib;

import java.util.*;
import java.util.stream.*;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.charset.Charset;
/*
 * Stone.java
 *
 * class to support immutable collection handling 
 * 
 * @author kei sugano
 * 
 *
 */
public class Stone {

    public static <T> List<T> newList(T e){
        List<T> list = new ArrayList<T>(){{ add(e); }};
        return list;
    }

    public static <T> List<T> newList(T e, T e2){
        return push(newList(e), e2);
    }

    public static <T> List<List<T>> SplitList(List<T> list, Integer i){
       List<List<T>> l = new ArrayList<List<T>>();
       return splitListSubRoutine(l, list,  0, list.size()/i, i);
    }

    public static <T> List<List<T>> splitListSubRoutine(List<List<T>> list, List<T> li,  Integer start, Integer end, Integer i){
        return end - li.size() < li.size()/i ? 
            splitListSubRoutine(push(list, li.subList(start, end < li.size() ? end : li.size())), li, end, (end+1)+li.size()/i , i )  : list ;
    }
 
    public static <T> List<T> newList(T e, T e2, T e3){
        return push(newList(e, e2), e3);
    }

    public static <T> List<T> newList(T e, T e2, T e3, T e4){
        return push(newList(e, e2, e3), e4);
    }

    public static <T> List<T> newList(T e, T e2, T e3, T e4, T e5){
        return push(newList(e, e2, e3, e4), e5);
    }

    public static <T> List<T> newList(T e, T e2, T e3, T e4, T e5, T e6){
        return push(newList(e, e2, e3, e4, e5), e6);
    }

    public static <T> List<T> toList(Stream<T> s) {
        return s.collect(Collectors.toList());
    }

    public static List<Integer> getOddList(List<Integer> list){
        return toList(list.stream().filter(u -> u%2 == 1));
    }

    public static List<Integer> getEvenList(List<Integer> list){
        return toList(list.stream().filter(u -> u%2 == 0));
    }

    public static List<Integer> rangeList(Integer start, Integer end, Integer i, List<Integer> list){
        return end > i ? rangeList(start, end, i+1, push(list,start + i)) : list;
    }

    public static <T> List<T> concatList(List<T> list1, List<T> list2){
        List<T> _list = new ArrayList<T>();
        _list.addAll(list1);
        _list.addAll(list2);
        return _list;
    }
  
    public static <T> List<T> toList(T[] args){
        return Arrays.asList(args);
    }
 
    public static <T> List<T> push(List<T> list, T elem){
        List<T> _list = new ArrayList<T>();
        for(T t : list)
           _list.add(t);
        _list.add(elem);
        return _list;
    } 
    
    public static <T> T get(List<T> list, Integer i){
        return list.get(i);
    }

    public static List<String> readFile(String file) {
        try{
            return Stone.toList(new String(Files.readAllBytes(Paths.get(file))).split("\n"));
        }catch(IOException e){
            return new ArrayList<String>();
        }
    }

    public static <T> void puts(T text){
        System.out.println(text);
    }

    public static <T> void puts(List<T> list){
        System.out.print("[");
        for(T t : list)
            System.out.print(t.toString() + ",");
        System.out.print("]");
        System.out.println("");
    }

    public static Path getFile(String filename){
        return Paths.get(filename);
    }

    public static void writeToFile(String filename, String text){
        try {
            Files.write(getFile(filename), newList(text), Charset.forName("UTF-8"));
        }catch(IOException e){

        }
    }

    public static <T> void putsLazy(List<T> list){
        try{
            for(T t : list){
                System.out.print(t.toString()+" ");
                Thread.sleep(50);
            }
            System.out.println("");
        }catch(InterruptedException e){

        }
    }
}

