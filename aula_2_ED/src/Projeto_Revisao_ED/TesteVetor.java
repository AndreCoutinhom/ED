package Projeto_Revisao_ED;

public class TesteVetor {
    public static void main(String[] args) throws Exception {
        Vetor vetor = new Vetor(5); // Criamos um vetor com 4 espaços disponíveis para strings.

        // Adicionamos os elementos.
        vetor.adiciona("Água");
        vetor.adiciona("Terra");
        vetor.adiciona("Fogo");
        vetor.adiciona("Ar");
        vetor.adiciona("Zero");
        vetor.adiciona("Gelo");


        System.out.println("Os elementos da natureza pela ordem da lenda de Aang: " + vetor.toString());

        // Busca pelo primeiro método
        System.out.println("Buscando pelo quarto elemento: " + vetor.busca(3));
        // A chamada abaixo é para testar erros. Qualquer comando depois dela não será executado se ela for.
        // System.out.println("Buscando pelo quinto elemento: " + vetor.busca(5));

        // Busca pelo segundo método
        System.out.println("Buscando pela posição da água: " + vetor.busca1("Água"));

        vetor.adicionaInicio(0, "Avatar");

        vetor.alteraConteudo("Magma", 4);

        System.out.println("Depois que o Aang chegou: " + vetor.toString());


    }
}
