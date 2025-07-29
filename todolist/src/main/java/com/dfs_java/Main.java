package com.dfs_java;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] jeux = new String[5];
        System.out.println("Quelles sont vos jeux vidéos favoris ?");
        for (int i = 0; i < 5; i++) {
            System.out.print((i+1) + ". ");
            jeux[i] = scanner.nextLine();
        }
        System.out.println("\nVos jeux vidéos favoris sont :");
        for (int i = 0; i < 5; i++) {
            System.out.println((i+1) + ". " + jeux[i]);
        }
        scanner.close();
    }
}