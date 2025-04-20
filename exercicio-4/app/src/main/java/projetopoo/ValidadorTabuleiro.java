package projetopoo;

import java.util.HashMap;
import java.util.Scanner;

public class ValidadorTabuleiro {
    private static final int TAMANHO = 10;
    private static final HashMap<Character, Integer> NAVIOS = new HashMap<>();

    static {
        NAVIOS.put('P', 5);  // Porta-aviões
        NAVIOS.put('E', 4);  // Encouraçado
        NAVIOS.put('C', 3);  // Cruzador
        NAVIOS.put('S', 3);  // Submarino
        NAVIOS.put('N', 2);  // Contratorpedeiro
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] tabuleiro = new char[TAMANHO][TAMANHO];
        int linhaAtual = 0;

        while (scanner.hasNextLine() && linhaAtual < TAMANHO) {
            String linha = scanner.nextLine().replaceAll("\\s+", ""); // Remove espaços
            if (linha.length() != TAMANHO) {
                System.out.println("Tabuleiro invalido: não tem a dimensao correta de 10x10 casas");
                return;
            }
            tabuleiro[linhaAtual] = linha.toCharArray();
            linhaAtual++;
        }

        if (linhaAtual != TAMANHO) {
            System.out.println("Tabuleiro invalido: não tem a dimensao correta de 10x10 casas");
            return;
        }

        HashMap<Character, Integer> contagem = new HashMap<>();
        for (int i = 0; i < TAMANHO; i++) {
            for (int j = 0; j < TAMANHO; j++) {
                char c = tabuleiro[i][j];
                if (c != '.' && !NAVIOS.containsKey(c)) {
                    System.out.println("Tabuleiro invalido: inclui navios desconhecidos");
                    return;
                }
                if (c != '.') {
                    contagem.put(c, contagem.getOrDefault(c, 0) + 1);
                }
            }
        }

        for (char tipo : NAVIOS.keySet()) {
            int quantidadeEsperada = NAVIOS.get(tipo);
            int quantidadeReal = contagem.getOrDefault(tipo, 0);

            if (quantidadeReal == 0) {
                System.out.println("Tabuleiro invalido: não inclui um navio de cada tipo");
                return;
            } else if (quantidadeReal != quantidadeEsperada) {
                System.out.println("Tabuleiro invalido: inclui multiplos navios do mesmo tipo");
                return;
            }
        }

        System.out.println("Tabuleiro valido");
    }
}