package projetopoo;
public class FigurasAscii {
    public static void main(String[] args) {
        if (args.length < 2) {
            System.out.println("Uso correto:");
            System.out.println("Triangulo: java FigurasAscii triangulo <tamanho>");
            System.out.println("Losango: java FigurasAscii losango <tamanho_impar>");
            System.out.println("Retangulo: java FigurasAscii retangulo <largura> <altura>");
            return;
        }

        String tipo = args[0].toLowerCase();

        try {
            switch(tipo) {
                case "triangulo":
                    int tamanhoTri = Integer.parseInt(args[1]);
                    imprimirTriangulo(tamanhoTri);
                    break;

                case "losango":
                    int tamanhoLos = Integer.parseInt(args[1]);
                    if(tamanhoLos % 2 == 0) {
                        System.out.println("O tamanho do losango deve ser impar!");
                        return;
                    }
                    imprimirLosango(tamanhoLos);
                    break;

                case "retangulo":
                    int largura = Integer.parseInt(args[1]);
                    int altura = Integer.parseInt(args[2]);
                    imprimirRetanguloVazado(largura, altura);
                    break;

                default:
                    System.out.println("Tipo invalido! Use: triangulo, losango ou retangulo");
            }
        } catch(NumberFormatException e) {
            System.out.println("Dimensoes devem ser numeros inteiros!");
        }
    }

    private static void imprimirTriangulo(int tamanho) {
        for(int i = 1; i <= tamanho; i++) {
            for(int j = 0; j < i; j++) {
                System.out.print("*");
            }
            System.out.println();
        }
    }

    private static void imprimirLosango(int tamanho) {
        int meio = tamanho / 2;
        for(int i = 0; i < tamanho; i++) {
            int espacos = Math.abs(meio - i);
            int estrelas = tamanho - 2 * espacos;

            for(int j = 0; j < espacos; j++) System.out.print(" ");
            for(int j = 0; j < estrelas; j++) System.out.print("*");

            System.out.println();
        }
    }

    private static void imprimirRetanguloVazado(int largura, int altura) {
        for(int i = 0; i < altura; i++) {
            for(int j = 0; j < largura; j++) {
                if(i == 0 || i == altura-1 || j == 0 || j == largura-1) {
                    System.out.print("*");
                } else {
                    System.out.print(" ");
                }
            }
            System.out.println();
        }
    }
}