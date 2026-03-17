package estrutura_estatica;

public class Main {
    public static void main(String[] args) {
        Pilha<Integer> pilha = new Pilha<Integer>();

        for (int i = 1; i <= 10; i++) {
            pilha.empilha(i);
        }

        System.out.println("Verifica se a Pilha está vazia: " + pilha.estaVazia());

        System.out.println("Dados da Pilha: " + pilha.toString());

        System.out.println("Quantidade de Dados na Pilha: " + pilha.tamanho());

        System.out.println("Informação no Topo da Pilha: " + pilha.topo());

        pilha.desempilha();

        System.out.println(pilha.topo());

    }
}
