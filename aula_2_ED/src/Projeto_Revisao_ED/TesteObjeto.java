package Projeto_Revisao_ED;

public class TesteObjeto {
    public static void main(String[] args) throws Exception {
        VetorObjeto vetor = new VetorObjeto(5);

        Contato contato1 = new Contato("Andre","12345678","email@conta.com");
        Contato contato2 = new Contato("Pedro","12345678","email@conta.com");
        Contato contato3 = new Contato("Thiago","12345678","email@conta.com");
        Contato contato4 = new Contato("João","12345678","email@conta.com");

        vetor.adiciona(contato1);
        vetor.adiciona(contato2);
        vetor.adiciona(contato3);
        vetor.adiciona(contato4);

        System.out.println(vetor);

    }
}
