package com.dfs_java;


public class Main {
    public static void main(String[] args) {
        // Création de 10 étudiants avec des prénoms différents
        java.util.ArrayList<Student> students = new java.util.ArrayList<>();
        String[] names = {"Alice", "Bob", "Chloe", "David", "Emma", "Felix", "Grace", "Hugo", "Iris", "Jules"};
        for (String name : names) {
            students.add(new Student(name));
        }

        // Calcul des moyennes pour chaque étudiant
        students.forEach(Student::calculateAverages);

        // Affichage des étudiants et de leurs moyennes
        students.forEach(System.out::println);

        // Streams : vérifier que personne n'a moins de 5 de moyenne générale
        boolean allAbove5 = students.stream().allMatch(s -> s.getTotalAverage() >= 5);
        System.out.println("\nTout le monde a au moins 5 de moyenne générale : " + allAbove5);

        // Vérifier qu'au moins un étudiant a plus de 10
        boolean atLeastOneAbove10 = students.stream().anyMatch(s -> s.getTotalAverage() > 10);
        System.out.println("Au moins un étudiant a plus de 10 de moyenne générale : " + atLeastOneAbove10);

        // Trouver l'étudiant avec la meilleure moyenne
        Student best = students.stream().max(java.util.Comparator.comparingDouble(Student::getTotalAverage)).orElse(null);
        if (best != null) {
            System.out.println("\nMeilleur étudiant : " + best.getName() + " avec " + String.format("%.2f", best.getTotalAverage()));
        }

        // Calcul de la moyenne de classe
        double classAverage = students.stream().mapToDouble(Student::getTotalAverage).average().orElse(0);
        System.out.println("Moyenne de classe : " + String.format("%.2f", classAverage));

        // Map prénom -> moyenne de maths
        java.util.Map<String, Double> mathAverages = new java.util.HashMap<>();
        students.forEach(s -> mathAverages.put(s.getName(), s.getMathAverage()));
        System.out.println("\nMoyenne de maths par étudiant :");
        mathAverages.forEach((k, v) -> System.out.println(k + " : " + String.format("%.2f", v)));

    }
}