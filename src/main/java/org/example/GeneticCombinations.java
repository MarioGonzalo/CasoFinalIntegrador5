package org.example;
import java.util.ArrayList;
import java.util.List;

public class GeneticCombinations {

    // Función recursiva para generar todas las combinaciones genéticas posibles
    public static List<String> generateGeneticCombinations(String[] genes) {
        List<String> combinations = new ArrayList<>();
        generateCombinationsRecursive(genes, 0, "", combinations);
        return combinations;
    }

    // Función auxiliar recursiva para generar combinaciones genéticas
    private static void generateCombinationsRecursive(String[] genes, int index, String currentCombination, List<String> combinations) {
        // Caso base: si hemos llegado al final de los genes, añadir la combinación actual a la lista de combinaciones
        if (index == genes.length) {
            combinations.add(currentCombination);
            return;
        }

        // Para cada alelo del gen en la posición actual, generar combinaciones con los alelos de los genes restantes
        for (char allele : genes[index].toCharArray()) {
            generateCombinationsRecursive(genes, index + 1, currentCombination + allele, combinations);
        }
    }


}