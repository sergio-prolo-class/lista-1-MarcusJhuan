package projetopoo;
public class ResistorDecoder {
    public static void main(String[] args) {
        if (args.length < 3 || args.length > 4) {
            System.out.println("Uso correto:");
            System.out.println("4 faixas: java ResistorDecoder <cor1> <cor2> <cor3> [cor4]");
            System.out.println("Cores validas: preto, marrom, vermelho, laranja, amarelo, verde, azul, violeta, cinza, branco, dourado, prata");
            return;
        }

        try {
            int digito1 = getValorCor(args[0]);
            int digito2 = getValorCor(args[1]);
            double multiplicador = getMultiplicador(args[2]);
            String tolerancia = getTolerancia(args.length > 3 ? args[3] : "dourado");

            double resistencia = (digito1 * 10 + digito2) * multiplicador;

            System.out.print("Resistencia: ");
            printResistenciaFormatada(resistencia);
            System.out.println(" Ohms " + tolerancia);

        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    private static int getValorCor(String cor) {
        return switch (cor.toLowerCase()) {
            case "preto" -> 0;
            case "marrom" -> 1;
            case "vermelho" -> 2;
            case "laranja" -> 3;
            case "amarelo" -> 4;
            case "verde" -> 5;
            case "azul" -> 6;
            case "violeta" -> 7;
            case "cinza" -> 8;
            case "branco" -> 9;
            default -> throw new IllegalArgumentException("Cor invalida: " + cor);
        };
    }

    private static double getMultiplicador(String cor) {
        return switch (cor.toLowerCase()) {
            case "preto" -> 1;
            case "marrom" -> 10;
            case "vermelho" -> 100;
            case "laranja" -> 1_000;
            case "amarelo" -> 10_000;
            case "verde" -> 100_000;
            case "azul" -> 1_000_000;
            case "violeta" -> 10_000_000;
            case "cinza" -> 100_000_000;
            case "branco" -> 1_000_000_000;
            case "dourado" -> 0.1;
            case "prata" -> 0.01;
            default -> throw new IllegalArgumentException("Multiplicador invalido: " + cor);
        };
    }

    private static String getTolerancia(String cor) {
        return switch (cor.toLowerCase()) {
            case "marrom" -> "±1%";
            case "vermelho" -> "±2%";
            case "verde" -> "±0.5%";
            case "azul" -> "±0.25%";
            case "violeta" -> "±0.1%";
            case "cinza" -> "±0.05%";
            case "dourado" -> "±5%";
            case "prata" -> "±10%";
            default -> "±20%"; // Tolerância padrão se não especificada
        };
    }

    private static void printResistenciaFormatada(double resistencia) {
        if (resistencia >= 1_000_000) {
            System.out.printf("%.1f M", resistencia / 1_000_000);
        } else if (resistencia >= 1_000) {
            System.out.printf("%.1f k", resistencia / 1_000);
        } else {
            System.out.printf("%.1f", resistencia);
        }
    }
}