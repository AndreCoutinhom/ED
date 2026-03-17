package coleta_sangue;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        // Estrutura básica para interação com usuário:

        Scanner scan = new Scanner(System.in);

        System.out.println("Boas vindas ao controle de senhas para coleta de sangue no Hospital Benossi! O que quer fazer agora? (Digite o número referente à opção)");
        System.out.println("1 - Solicitar nova senha");
        System.out.println("2 - Excluir uma senha");
        System.out.println("3 - Listar todas as senhas");
        System.out.println("4 - Ver quem é o próximo da fila");

        String opcaoSelecionada = scan.nextLine();

        switch (opcaoSelecionada){
            case "1":
                System.out.println("Solicitando nova senha");
                break;
            case "2":
                System.out.println("Excluindo senha");
                break;
            case "3":
                System.out.println("Retornando senhas");
                break;
            case "4":
                System.out.println("Retornando o próximo da fila");
                break;
            default:
                System.out.println("Opção inválida");
        }


    }
}
