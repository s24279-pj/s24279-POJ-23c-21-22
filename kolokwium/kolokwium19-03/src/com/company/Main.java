package com.company;

public class Main {
            public static void main(String[] args) {
                String[] tablica = {"1","6","1"};
                System.out.println(sum(tablica));
            }

            public static String sum(String[] array) {
                int sum = 0;
                for(String element:tablica){
                    sum+=Integer.parseInt(element);
                }
                return sum;
            }
    }
}
