package collection;

import java.util.*;
import java.util.function.Consumer;

public class Departments {


    public static void main(String[] args) {
        List<String > list = new ArrayList<>();
        list.add("22");
        list.add("7777");
        list.add("10");
        list.add("5");
        list.add("455555");

     /*   Comparator<String> eee = new Comparator<String>() {
            @Override
            public int compare(String o1, String o2) {

                return o2.length()-o1.length();
            }
        };*/

        Consumer<String> consumer  = new Consumer<String>() {
            @Override
            public void accept(String s) {

              return;
            }
        } ;




         //Comparator<String> eee = (left, right)-> right.length()-left.length();



       // Collections.sort(list, eee);

        System.out.println(list);



    }

    public static List<String> fillGaps(List<String> deps) {
        Set<String> tmp = new TreeSet<>() ;
        for (String value : deps) {
            String start = "";
            for (String el : value.split("/")) {
                start += el;
                tmp.add( start);
                start += "/";
            }
        }
        List<String> lst = new ArrayList<>(tmp);
             return  lst;
    }

    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
    }

    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
    }
}