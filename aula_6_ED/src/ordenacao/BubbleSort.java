package ordenacao;

public class BubbleSort {
    public static void main(String[] args) {
        int[] vetor = new int[10];

        for(int i = 0; i < vetor.length; i++) {
            vetor[i] = (int) (Math.random() * vetor.length);
            System.out.print(vetor[i]);
            System.out.print(" ");
        }

        int aux;
        for (int i = 0; i < vetor.length; i++) {
            for (int j = i + 1; j < vetor.length; j++) {
                if (vetor[i] > vetor[j]) {
                    aux = vetor[j];
                    vetor[j] = vetor[i];
                    vetor[i] = aux;
                }
            }
        }

        System.out.println("");
        System.out.println("Vetor ordenado: ");

        for(int i = 0; i < vetor.length; i++) {
           System.out.print(vetor[i]);
            System.out.print(" ");
        }

    }
}
