package lista;

import java.util.Scanner;

public class Exemplo_Lista_Duplamente_Encadeada {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);
        ListaDuplaEncadeada lista = new ListaDuplaEncadeada();
        String elemento = null;
        String opcao = null;
        int posicao = 0;

        do {
            System.out.println("\nEscolha a opção:\n");
            System.out.println("1 -> Adicionar elemento ");
            System.out.println("1.1 -> Adicionar elemento na posição específica ");
            System.out.println("2 -> Excluir elemento na posição específica ");
            System.out.println("3 -> Excluir elemento ");
            System.out.println("4 -> Exibir o elemento Anterior (Antecessor) ");
            System.out.println("5 -> Consultar a posição de um elemento ");
            System.out.println("6 -> Consultar um elemento de uma posição ");
            System.out.println("7 -> Consultar o tamanho da Lista ");
            System.out.println("8 -> Exibir o primeiro elemento da Lista ");
            System.out.println("9 -> Exibir o último elemento da Lista ");
            System.out.println("10 -> Exibir o maior elemento da Lista ");
            System.out.println("0 -> Exibir a Lista Completa ");
            System.out.println("s -> Sair da Aplicação ");

            opcao = entrada.next();

            if (opcao.equals("1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.adicionar(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("1.1")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.adicionar(elemento, posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("2")) {
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.removeIndex(posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("3")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.removeElemento(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("4")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.antecessor(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("5")) {
                System.out.println("\nInforme o valor do elemento");
                elemento = entrada.next();
                try {
                    lista.posicao(elemento);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("6")) {
                System.out.println("\nInforme a posição do elemento");
                posicao = entrada.nextInt();
                try {
                    lista.BuscaPosicao(posicao);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("6")) {
                try {
                    System.out.println("O tamanho da lista é: " + lista.tamanhoLista());
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("8")) {
                try {
                    lista.primeiroLista();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("9")) {
                try {
                    lista.ultimoLista();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("10")) {
                try {
                    lista.maior();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else if (opcao.equals("0")) {
                try {
                    lista.exibir();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            } else {
                System.out.println("Opção inválida");
            }
        }
        while (opcao != "s");
    }

}