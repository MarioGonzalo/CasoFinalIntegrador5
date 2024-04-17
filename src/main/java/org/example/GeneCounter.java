package org.example;

public class GeneCounter {

    // Función recursiva para contar los genes en la cadena de ADN
    public static int countGenes(String dna) {
        // Caso base: si la cadena de ADN es demasiado corta, no hay genes
        if (dna.length() < 3) {
            return 0;
        }

        int indexATG = dna.indexOf("ATG"); // Buscar la primera marca de inicio de gen "ATG"
        if (indexATG == -1) {
            return 0; // Si no se encuentra "ATG", no hay más genes
        }

        // Buscar el próximo codón de parada después de "ATG"
        int indexStopCodon = findStopCodon(dna, indexATG + 3);
        if (indexStopCodon == -1) {
            // Si no se encuentra ningún codón de parada, la búsqueda termina aquí
            return 0;
        }

        // Se encontró un gen, incrementar el contador y continuar la búsqueda recursiva
        return 1 + countGenes(dna.substring(indexStopCodon + 3));
    }

    // Función para encontrar el próximo codón de parada después de una posición dada
    private static int findStopCodon(String dna, int startIndex) {
        // Definir los codones de parada (TAG, TAA, TGA)
        String[] stopCodons = {"TAG", "TAA", "TGA"};

        // Buscar el próximo codón de parada después de startIndex
        int minIndex = dna.length(); // Inicializar con un valor grande
        for (String codon : stopCodons) {
            int index = dna.indexOf(codon, startIndex);
            if (index != -1 && (index - startIndex) % 3 == 0) {
                // Si se encuentra un codón de parada y está en la posición correcta
                minIndex = Math.min(minIndex, index);
            }
        }

        // Si no se encontró ningún codón de parada, devolver -1
        if (minIndex == dna.length()) {
            return -1;
        }

        return minIndex; // Devolver el índice del codón de parada encontrado
    }
}

