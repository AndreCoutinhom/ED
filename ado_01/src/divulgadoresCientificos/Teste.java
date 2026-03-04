package divulgadoresCientificos;

// Classe de teste com as funções principais

public class Teste {
    public static void main(String[] args) throws  Exception {
        // Novo vetor. A capacidade só deve ser maior que zero. Os métodos em vetor já aumentam a capacidade conforme o número de elementos adicionados.
        Vetor vetor = new Vetor(1);

        // Divulgadores científicos e seus dados declarados.
        Divulgador divulgador1 = new Divulgador(
                "Atila Iamarino",
                "Atila Iamarino",
                "https://lattes.cnpq.br/4978322672579487",
                "Ciências Biológicas",
                "Youtube",
                "1,71 milhões"
        );

        Divulgador divulgador2 = new Divulgador(
                "Ana Bonassa",
                "Nunca vi 1 cientista",
                "https://lattes.cnpq.br/4947742884022371",
                "Fisiologia",
                "Youtube",
                "540 mil"
        );

        Divulgador divulgador3 = new Divulgador(
                "Laura Marise",
                "Nunca vi 1 cientista",
                "https://lattes.cnpq.br/2603023551856235",
                "Biociências e Biotecnologia Aplicadas à Farmácia",
                "Youtube",
                "540 mil"
        );

        Divulgador divulgador4 = new Divulgador(
                "Carlos Seraphim",
                "Endócrino e talks com Dr. Carlos Seraphim",
                "https://lattes.cnpq.br/3272685919486334",
                "Medicina; Endocrinologia",
                "Youtube",
                "109 mil"
        );

        Divulgador divulgador5 = new Divulgador(
                "Igor Eckert",
                "igoreckert",
                "https://lattes.cnpq.br/6630037564221555",
                "Nutrição; Estudos clínicos",
                "Instagram",
                "300 mil"
        );

        Divulgador divulgador6 = new Divulgador(
                "Altay de Souza",
                "Naruhodo",
                "https://lattes.cnpq.br/8948217221748469",
                "Psicologia Experimental",
                "Spotify",
                "19 mil"
        );

        Divulgador divulgador7 = new Divulgador(
                "Camila Laranjeira",
                "Peixe Babel",
                "https://lattes.cnpq.br/1641872523529515",
                "Ciências da Computação",
                "Youtube",
                "88,1 mil"
        );

        Divulgador divulgador8 = new Divulgador(
                "Virginia Mota",
                "Peixe Babel",
                "https://lattes.cnpq.br/3250170839435251",
                "Ciências da Computação",
                "Youtube",
                "88,1 mil"
        );

        Divulgador divulgador9 = new Divulgador(
                "Tito Aureliano",
                "Colecionadores de Ossos",
                "https://lattes.cnpq.br/3666297020355529",
                "Geopaleontologia",
                "Youtube",
                "76,5 mil"
        );

        Divulgador divulgador10 = new Divulgador(
                "Aline Ghilardi",
                "Colecionadores de Ossos",
                "https://lattes.cnpq.br/5761534317977568",
                "Paleoecologia",
                "Youtube",
                "76,5 mil"
        );

        // O divulgador 11 é falso. Nele são testadas as funções de remoção.

        Divulgador divulgador11 = new Divulgador(
                "Charlatão",
                "Pseudociência",
                "Falso",
                "Sofismas",
                "Falso",
                "500 milhões"
        );

        // Adicionamos todos os divulgadores...
        vetor.adiciona(divulgador1);
        vetor.adiciona(divulgador2);
        vetor.adiciona(divulgador3);
        vetor.adiciona(divulgador4);
        vetor.adiciona(divulgador5);
        vetor.adiciona(divulgador6);
        vetor.adiciona(divulgador7);
        vetor.adiciona(divulgador8);
        vetor.adiciona(divulgador9);
        vetor.adiciona(divulgador10);
        // Incluindo o falso.
        vetor.adiciona(divulgador11);

        System.out.println(vetor);

        // Vamos encontrar o falso usando o método de busca.
        System.out.println(vetor.busca(10));


        // Removemos o falso a partir de sua posição.
        vetor.remove(10);

        System.out.println(vetor);

        // Adicionamos novamente para testar outro método...
        vetor.adiciona(divulgador11);

        // O de remoção por conteúdo.
        vetor.removeConteudo(divulgador11);

        // Agora só estão os verdadeiros.
        System.out.println(vetor);

    }
}
