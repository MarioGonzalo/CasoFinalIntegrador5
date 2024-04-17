package org.example;


import java.util.List;

public class Main {
    public static void main(String[] args) {
        String dnaSequence = "ATGCGTAGTAAATGCCCTAG"; // Ejemplo de cadena de ADN
        int geneCount = GeneCounter.countGenes(dnaSequence);
        System.out.println("Número de genes encontrados: " + geneCount);

        String[] genes = {"Aa", "Bb", "Cc"};

        // Generar todas las combinaciones genéticas posibles
        List<String> combinations = GeneticCombinations.generateGeneticCombinations(genes);

        // Imprimir las combinaciones generadas
        System.out.println("Combinaciones genéticas posibles:");
        for (String combination : combinations) {
            System.out.println(combination);
        }
    }
}