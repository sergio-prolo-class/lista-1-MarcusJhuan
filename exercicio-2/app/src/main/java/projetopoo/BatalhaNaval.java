package projetopoo;

import java.util.Random;

public class BatalhaNaval {
    private static final int TAMANHO_TABULEIRO = 10;
    private static final char AGUA = '.';
    private static final Random random = new Random();

    public static void main(String[] args) {
        char[][] tabuleiro = new char[TAMANHO_TABULEIRO][TAMANHO_TABULEIRO];
        inicializarTabuleiro(tabuleiro);

        posicionarNavio(tabuleiro, 'P', 5);
        posicionarNavio(tabuleiro, 'E', 4);
        posicionarNavio(tabuleiro, 'C', 3);
        posicionarNavio(tabuleiro, 'S', 3);
        posicionarNavio(tabuleiro, 'N', 2);

        imprimirTabuleiro(tabuleiro);
    }

    private static void inicializarTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                tabuleiro[i][j] = AGUA;
            }
        }
    }

    private static void posicionarNavio(char[][] tabuleiro, char simbolo, int tamanho) {
        boolean posicionado = false;

        while (!posicionado) {
            int linha = random.nextInt(TAMANHO_TABULEIRO);
            int coluna = random.nextInt(TAMANHO_TABULEIRO);
            boolean horizontal = random.nextBoolean();

            if (validarPosicao(tabuleiro, linha, coluna, tamanho, horizontal)) {
                for (int i = 0; i < tamanho; i++) {
                    if (horizontal) {
                        tabuleiro[linha][coluna + i] = simbolo;
                    } else {
                        tabuleiro[linha + i][coluna] = simbolo;
                    }
                }
                posicionado = true;
            }
        }
    }

    private static boolean validarPosicao(char[][] tabuleiro, int linha, int coluna, int tamanho, boolean horizontal) {
        if (horizontal) {
            if (coluna + tamanho > TAMANHO_TABULEIRO) return false;
            for (int i = 0; i < tamanho; i++) {
                if (tabuleiro[linha][coluna + i] != AGUA) return false;
            }
        } else {
            if (linha + tamanho > TAMANHO_TABULEIRO) return false;
            for (int i = 0; i < tamanho; i++) {
                if (tabuleiro[linha + i][coluna] != AGUA) return false;
            }
        }
        return true;
    }

    private static void imprimirTabuleiro(char[][] tabuleiro) {
        for (int i = 0; i < TAMANHO_TABULEIRO; i++) {
            for (int j = 0; j < TAMANHO_TABULEIRO; j++) {
                System.out.print(tabuleiro[i][j]); // Sem espaço!
            }
            System.out.println();
        }
    }
}