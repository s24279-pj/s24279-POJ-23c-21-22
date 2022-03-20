package com.company;

public class Main {
            public static void main(String[] args) {
                String[] tablica = {"1","6","1"};
                System.out.println(sum(tablica));
            }

            public static int sum(String[] array) {
                int[] tablica = new int[0];
                int sum = 0;
                for(int i = 0; i < tablica.length; i++){
                    sum+=Integer.parseInt((i));
                }
                return sum;
            }
    }
}
