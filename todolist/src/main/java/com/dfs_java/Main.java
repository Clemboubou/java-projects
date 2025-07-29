package com.dfs_java;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        java.util.ArrayList<String> jeux = new java.util.ArrayList<>();
        System.out.println("Quelles sont vos jeux vidéos favoris ?");
        int i = 0;
        while (jeux.size() < 5) {
            System.out.print((i+1) + ". ");
            jeux.add(scanner.nextLine());
            i++;
        }
        while (true) {
            System.out.print("Voulez-vous ajouter un autre jeu ? (o/n) : ");
            String reponse = scanner.nextLine().trim().toLowerCase();
            if (reponse.equals("o")) {
                System.out.print((jeux.size()+1) + ". ");
                jeux.add(scanner.nextLine());
            } else if (reponse.equals("n")) {
                break;
            } else {
                System.out.println("Réponse invalide. Veuillez répondre par 'o' ou 'n'.");
            }
        }
        System.out.println("\nVos jeux vidéos favoris sont :");
        for (int j = 0; j < jeux.size(); j++) {
            System.out.println((j+1) + ". " + jeux.get(j));
        }
        scanner.close();
    }
}