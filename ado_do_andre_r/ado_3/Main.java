package ado.ado_3;

import java.util.Scanner;

public class Main{

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Grafo<String> mapaSenac = new Grafo<String>();
        IniciarMapa(mapaSenac);

        String opcao = "";

        System.out.println("- - - INICIALIZANDO LOCALIZADOR SENAC - - - \n");

        do {
            System.out.println("Informe o PONTO DE PARTIDA:");
            String pontoA = scanner.nextLine().trim();

            System.out.println("Agora informe o DESTINO:");
            String pontoB = scanner.nextLine().trim();

            System.out.println("Trajeto entre: " + pontoA + " e " + pontoB + "\n");

            mapaSenac.BuscarCaminho(pontoA, pontoB);

            // valida opção
            do {

                System.out.println(
                        "\n-------------------------\n" +
                                "Deseja calcular uma nova rota?\n" +
                                "S - Sim\n" +
                                "N - Não"
                );

                opcao = scanner.nextLine().trim().toUpperCase();

                if (!opcao.equals("S") && !opcao.equals("N")) {
                    System.out.println("Opção inválida. Digite apenas S ou N.");
                }

            } while (!opcao.equals("S") && !opcao.equals("N"));

        } while (opcao.equals("S"));
    }

    private static void IniciarMapa(Grafo<String> mapaSenac)
    {
        // Vértices

        // Ala 1
        mapaSenac.adicionarVertice("Portaria 1 (Principal)");
        mapaSenac.adicionarVertice("Biblioteca");
        mapaSenac.adicionarVertice("Reitoria");
        mapaSenac.adicionarVertice("Praça 1");
        mapaSenac.adicionarVertice("Prédio Gastronomia");
        mapaSenac.adicionarVertice("Central de Atendimento");
        mapaSenac.adicionarVertice("Coordenação");
        mapaSenac.adicionarVertice("Acadêmico 2");
        mapaSenac.adicionarVertice("Prédio Design");
        mapaSenac.adicionarVertice("Praça 3");
        mapaSenac.adicionarVertice("Área Aberta");

        // Ala 2

        mapaSenac.adicionarVertice("Estacionamento Descoberto");
        mapaSenac.adicionarVertice("Acadêmico 1");
        mapaSenac.adicionarVertice("Centro de Convenções");
        mapaSenac.adicionarVertice("Praça 2");
        mapaSenac.adicionarVertice("Centro Esportivo/Academia");
        mapaSenac.adicionarVertice("Estacionamento Academia");
        mapaSenac.adicionarVertice("Quadra de Basquete");
        mapaSenac.adicionarVertice("Quadra de Vôlei");
        mapaSenac.adicionarVertice("Campo de Futebol");
        mapaSenac.adicionarVertice("Quadra de Tênis");
        mapaSenac.adicionarVertice("Prédio de Manutenção");
        mapaSenac.adicionarVertice("Portaria de Serviços");
        mapaSenac.adicionarVertice("Portaria de Veículos");

        // Nós

        // não tem 9 e 33
        mapaSenac.adicionarVertice("P1");
        mapaSenac.adicionarVertice("P2");
        mapaSenac.adicionarVertice("P3");
        mapaSenac.adicionarVertice("P4");
        mapaSenac.adicionarVertice("P5");
        mapaSenac.adicionarVertice("P6");
        mapaSenac.adicionarVertice("P7");
        mapaSenac.adicionarVertice("P8");
        mapaSenac.adicionarVertice("P9");
        mapaSenac.adicionarVertice("P10");
        mapaSenac.adicionarVertice("P11");
        mapaSenac.adicionarVertice("P12");
        mapaSenac.adicionarVertice("P13");
        mapaSenac.adicionarVertice("P14");
        mapaSenac.adicionarVertice("P15");
        mapaSenac.adicionarVertice("P16");
        mapaSenac.adicionarVertice("P17");
        mapaSenac.adicionarVertice("P18");
        mapaSenac.adicionarVertice("P19");
        mapaSenac.adicionarVertice("P20");
        mapaSenac.adicionarVertice("P21");
        mapaSenac.adicionarVertice("P22");
        mapaSenac.adicionarVertice("P23");
        mapaSenac.adicionarVertice("P24");
        mapaSenac.adicionarVertice("P25");
        mapaSenac.adicionarVertice("P26");
        mapaSenac.adicionarVertice("P27");
        mapaSenac.adicionarVertice("P28");
        mapaSenac.adicionarVertice("P29");
        mapaSenac.adicionarVertice("P30");
        mapaSenac.adicionarVertice("P31");
        mapaSenac.adicionarVertice("P32");
        mapaSenac.adicionarVertice("P34");
        mapaSenac.adicionarVertice("P35");
        mapaSenac.adicionarVertice("P36");
        mapaSenac.adicionarVertice("P37");
        mapaSenac.adicionarVertice("P38");
        mapaSenac.adicionarVertice("P39");
        mapaSenac.adicionarVertice("P40");

        // Arestas

        mapaSenac.adicionarAresta(10.0, "Portaria 1 (Principal)", "Estacionamento Descoberto");
        mapaSenac.adicionarAresta(10.0, "Estacionamento Descoberto", "Portaria 1 (Principal)");

        mapaSenac.adicionarAresta(10.0, "Portaria 1 (Principal)", "P12");
        mapaSenac.adicionarAresta(10.0, "P12", "Portaria 1 (Principal)");

        mapaSenac.adicionarAresta(10.0, "Portaria 1 (Principal)", "P1");
        mapaSenac.adicionarAresta(10.0, "P1", "Portaria 1 (Principal)");

        mapaSenac.adicionarAresta(10.0, "P12", "P1");
        mapaSenac.adicionarAresta(10.0, "P1", "P12");

        mapaSenac.adicionarAresta(10.0, "P12", "P11");
        mapaSenac.adicionarAresta(10.0, "P11", "P12");

        mapaSenac.adicionarAresta(10.0, "P1", "Central de Atendimento");
        mapaSenac.adicionarAresta(10.0, "Central de Atendimento", "P1");

        mapaSenac.adicionarAresta(10.0, "P11", "Central de Atendimento");
        mapaSenac.adicionarAresta(10.0, "Central de Atendimento", "P11");

        mapaSenac.adicionarAresta(10.0, "P12", "P13");
        mapaSenac.adicionarAresta(10.0, "P13", "P12");

        mapaSenac.adicionarAresta(10.0, "P13", "Biblioteca");
        mapaSenac.adicionarAresta(10.0, "Biblioteca", "P13");

        mapaSenac.adicionarAresta(10.0, "P13", "P14");
        mapaSenac.adicionarAresta(10.0, "P14", "P13");

        mapaSenac.adicionarAresta(10.0, "P13", "Reitoria");
        mapaSenac.adicionarAresta(10.0, "Reitoria", "P13");

        mapaSenac.adicionarAresta(10.0, "P13", "Praça 1");
        mapaSenac.adicionarAresta(10.0, "Praça 1", "P13");

        mapaSenac.adicionarAresta(10.0, "Praça 1", "Prédio Gastronomia");
        mapaSenac.adicionarAresta(10.0, "Prédio Gastronomia", "Praça 1");

        mapaSenac.adicionarAresta(10.0, "Praça 1", "P11");
        mapaSenac.adicionarAresta(10.0, "P11", "Praça 1");

        mapaSenac.adicionarAresta(10.0, "P14", "P15");
        mapaSenac.adicionarAresta(10.0, "P15", "P14");

        mapaSenac.adicionarAresta(10.0, "P15", "P16");
        mapaSenac.adicionarAresta(10.0, "P16", "P15");

        mapaSenac.adicionarAresta(10.0, "P16", "P17");
        mapaSenac.adicionarAresta(10.0, "P17", "P16");

        mapaSenac.adicionarAresta(10.0, "P17", "P11");
        mapaSenac.adicionarAresta(10.0, "P11", "P17");

        mapaSenac.adicionarAresta(10.0, "P17", "P10");
        mapaSenac.adicionarAresta(10.0, "P10", "P17");

        mapaSenac.adicionarAresta(10.0, "P9", "P10");
        mapaSenac.adicionarAresta(10.0, "P10", "P9");

        mapaSenac.adicionarAresta(10.0, "P10", "P11");
        mapaSenac.adicionarAresta(10.0, "P11", "P10");

        mapaSenac.adicionarAresta(10.0, "P17", "P18");
        mapaSenac.adicionarAresta(10.0, "P18", "P17");

        mapaSenac.adicionarAresta(10.0, "P18", "P19");
        mapaSenac.adicionarAresta(10.0, "P19", "P18");

        mapaSenac.adicionarAresta(10.0, "P10", "Central de Atendimento");
        mapaSenac.adicionarAresta(10.0, "Central de Atendimento", "P10");

        mapaSenac.adicionarAresta(10.0, "P10", "Acadêmico 1");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P10");

        mapaSenac.adicionarAresta(10.0, "P10", "P38");
        mapaSenac.adicionarAresta(10.0, "P38", "P10");

        mapaSenac.adicionarAresta(10.0, "P10", "P30");
        mapaSenac.adicionarAresta(10.0, "P30", "P10");

        mapaSenac.adicionarAresta(10.0, "P30", "P29");
        mapaSenac.adicionarAresta(10.0, "P29", "P30");

        mapaSenac.adicionarAresta(10.0, "P30", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P30");

        mapaSenac.adicionarAresta(10.0, "P30", "Coordenação");
        mapaSenac.adicionarAresta(10.0, "Coordenação", "P30");

        mapaSenac.adicionarAresta(10.0, "P29", "P18");
        mapaSenac.adicionarAresta(10.0, "P18", "P29");

        mapaSenac.adicionarAresta(10.0, "P29", "P28");
        mapaSenac.adicionarAresta(10.0, "P28", "P29");

        mapaSenac.adicionarAresta(10.0, "P28", "Prédio Design");
        mapaSenac.adicionarAresta(10.0, "Prédio Design", "P28");

        mapaSenac.adicionarAresta(10.0, "Prédio Design", "P27");
        mapaSenac.adicionarAresta(10.0, "P27", "Prédio Design");

        mapaSenac.adicionarAresta(10.0, "Prédio Design", "Área Aberta");
        mapaSenac.adicionarAresta(10.0, "Área Aberta", "Prédio Design");

        mapaSenac.adicionarAresta(10.0, "Área Aberta", "P20");
        mapaSenac.adicionarAresta(10.0, "P20", "Área Aberta");

        mapaSenac.adicionarAresta(10.0, "Área Aberta", "P19");
        mapaSenac.adicionarAresta(10.0, "P19", "Área Aberta");

        mapaSenac.adicionarAresta(10.0, "Área Aberta", "Praça 3");
        mapaSenac.adicionarAresta(10.0, "Praça 3", "Área Aberta");

        mapaSenac.adicionarAresta(10.0, "Praça 3", "P27");
        mapaSenac.adicionarAresta(10.0, "P27", "Praça 3");

        mapaSenac.adicionarAresta(10.0, "Praça 3", "P26");
        mapaSenac.adicionarAresta(10.0, "P26", "Praça 3");

        mapaSenac.adicionarAresta(10.0, "Praça 3", "P23");
        mapaSenac.adicionarAresta(10.0, "P23", "Praça 3");

        mapaSenac.adicionarAresta(10.0, "Área Aberta", "P23");
        mapaSenac.adicionarAresta(10.0, "P23", "Área Aberta");

        mapaSenac.adicionarAresta(10.0, "P20", "P19");
        mapaSenac.adicionarAresta(10.0, "P19", "P20");

        mapaSenac.adicionarAresta(10.0, "P28", "P27");
        mapaSenac.adicionarAresta(10.0, "P27", "P28");

        mapaSenac.adicionarAresta(10.0, "P28", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P28");

        mapaSenac.adicionarAresta(10.0, "P27", "P26");
        mapaSenac.adicionarAresta(10.0, "P26", "P27");

        mapaSenac.adicionarAresta(10.0, "P27", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P27");

        mapaSenac.adicionarAresta(10.0, "P26", "P23");
        mapaSenac.adicionarAresta(10.0, "P23", "P26");

        mapaSenac.adicionarAresta(10.0, "P23", "P21");
        mapaSenac.adicionarAresta(10.0, "P21", "P23");

        mapaSenac.adicionarAresta(10.0, "P23", "P36");
        mapaSenac.adicionarAresta(10.0, "P36", "P23");

        mapaSenac.adicionarAresta(10.0, "P36", "Quadra de Tênis");
        mapaSenac.adicionarAresta(10.0, "Quadra de Tênis", "P36");

        mapaSenac.adicionarAresta(10.0, "P36", "P24");
        mapaSenac.adicionarAresta(10.0, "P24", "P36");

        mapaSenac.adicionarAresta(10.0, "P21", "P20");
        mapaSenac.adicionarAresta(10.0, "P20", "P21");

        mapaSenac.adicionarAresta(10.0, "P21", "P22");
        mapaSenac.adicionarAresta(10.0, "P22", "P21");

        mapaSenac.adicionarAresta(10.0, "P22", "Portaria de Serviços");
        mapaSenac.adicionarAresta(10.0, "Portaria de Serviços", "P22");

        mapaSenac.adicionarAresta(10.0, "Portaria de Serviços", "P24");
        mapaSenac.adicionarAresta(10.0, "P24", "Portaria de Serviços");

        mapaSenac.adicionarAresta(10.0, "P24", "P35");
        mapaSenac.adicionarAresta(10.0, "P35", "P24");

        mapaSenac.adicionarAresta(10.0, "P24", "P25");
        mapaSenac.adicionarAresta(10.0, "P25", "P24");

        mapaSenac.adicionarAresta(10.0, "P35", "Campo de Futebol");
        mapaSenac.adicionarAresta(10.0, "Campo de Futebol", "P35");

        mapaSenac.adicionarAresta(10.0, "P35", "P25");
        mapaSenac.adicionarAresta(10.0, "P25", "P35");

        mapaSenac.adicionarAresta(10.0, "P26", "P37");
        mapaSenac.adicionarAresta(10.0, "P37", "P26");

        mapaSenac.adicionarAresta(10.0, "P37", "P25");
        mapaSenac.adicionarAresta(10.0, "P25", "P37");

        mapaSenac.adicionarAresta(10.0, "P37", "Quadra de Basquete");
        mapaSenac.adicionarAresta(10.0, "Quadra de Basquete", "P37");

        mapaSenac.adicionarAresta(10.0, "P25", "P34");
        mapaSenac.adicionarAresta(10.0, "P34", "P25");

        mapaSenac.adicionarAresta(10.0, "P34", "P31");
        mapaSenac.adicionarAresta(10.0, "P31", "P34");

        mapaSenac.adicionarAresta(10.0, "P31", "P26");
        mapaSenac.adicionarAresta(10.0, "P26", "P31");

        mapaSenac.adicionarAresta(10.0, "P31", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P31");

        mapaSenac.adicionarAresta(10.0, "P31", "P32");
        mapaSenac.adicionarAresta(10.0, "P32", "P31");

        mapaSenac.adicionarAresta(10.0, "P32", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P32");

        mapaSenac.adicionarAresta(10.0, "P32", "Praça 2");
        mapaSenac.adicionarAresta(10.0, "Praça 2", "P32");

        mapaSenac.adicionarAresta(10.0, "Praça 2", "P8");
        mapaSenac.adicionarAresta(10.0, "P8", "Praça 2");

        mapaSenac.adicionarAresta(10.0, "P8", "Acadêmico 1");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P8");

        mapaSenac.adicionarAresta(10.0, "P8", "P38");
        mapaSenac.adicionarAresta(10.0, "P38", "P8");

        mapaSenac.adicionarAresta(10.0, "Praça 2", "P38");
        mapaSenac.adicionarAresta(10.0, "P38", "Praça 2");

        mapaSenac.adicionarAresta(10.0, "P38", "P40");
        mapaSenac.adicionarAresta(10.0, "P40", "P38");

        mapaSenac.adicionarAresta(10.0, "P39", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P39");

        mapaSenac.adicionarAresta(10.0, "P40", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P40");

        mapaSenac.adicionarAresta(10.0, "P38", "P10");
        mapaSenac.adicionarAresta(10.0, "P10", "P38");

        mapaSenac.adicionarAresta(10.0, "P38", "P39");
        mapaSenac.adicionarAresta(10.0, "P39", "P38");

        mapaSenac.adicionarAresta(10.0, "P32", "Centro Esportivo/Academia");
        mapaSenac.adicionarAresta(10.0, "Centro Esportivo/Academia", "P32");

        mapaSenac.adicionarAresta(10.0, "Praça 2", "Centro Esportivo/Academia");
        mapaSenac.adicionarAresta(10.0, "Centro Esportivo/Academia", "Praça 2");

        mapaSenac.adicionarAresta(10.0, "Centro Esportivo/Academia", "Estacionamento Academia");
        mapaSenac.adicionarAresta(10.0, "Estacionamento Academia", "Centro Esportivo/Academia");

        mapaSenac.adicionarAresta(10.0, "Estacionamento Academia", "P34");
        mapaSenac.adicionarAresta(10.0, "P34", "Estacionamento Academia");

        mapaSenac.adicionarAresta(10.0, "Estacionamento Academia", "P6");
        mapaSenac.adicionarAresta(10.0, "P6", "Estacionamento Academia");

        mapaSenac.adicionarAresta(10.0, "P6", "P5");
        mapaSenac.adicionarAresta(10.0, "P5", "P6");

        mapaSenac.adicionarAresta(10.0, "P5", "Centro de Convenções");
        mapaSenac.adicionarAresta(10.0, "Centro de Convenções", "P5");

        mapaSenac.adicionarAresta(10.0, "P5", "P4");
        mapaSenac.adicionarAresta(10.0, "P4", "P5");

        mapaSenac.adicionarAresta(10.0, "P5", "Estacionamento Descoberto");
        mapaSenac.adicionarAresta(10.0, "Estacionamento Descoberto", "P5");

        mapaSenac.adicionarAresta(10.0, "P5", "Portaria de Veículos");
        mapaSenac.adicionarAresta(10.0, "Portaria de Veículos", "P5");

        mapaSenac.adicionarAresta(10.0, "Estacionamento Descoberto", "Portaria de Veículos");
        mapaSenac.adicionarAresta(10.0, "Portaria de Veículos", "Estacionamento Descoberto");

        mapaSenac.adicionarAresta(10.0, "P5", "P3");
        mapaSenac.adicionarAresta(10.0, "P3", "P5");

        mapaSenac.adicionarAresta(10.0, "P5", "Praça 2");
        mapaSenac.adicionarAresta(10.0, "Praça 2", "P5");

        mapaSenac.adicionarAresta(10.0, "P3", "Estacionamento Descoberto");
        mapaSenac.adicionarAresta(10.0, "Estacionamento Descoberto", "P3");

        mapaSenac.adicionarAresta(10.0, "P3", "P2");
        mapaSenac.adicionarAresta(10.0, "P2", "P3");

        mapaSenac.adicionarAresta(10.0, "P3", "Acadêmico 1");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P3");

        mapaSenac.adicionarAresta(10.0, "P2", "P1");
        mapaSenac.adicionarAresta(10.0, "P1", "P2");

        mapaSenac.adicionarAresta(10.0, "P2", "Estacionamento Descoberto");
        mapaSenac.adicionarAresta(10.0, "Estacionamento Descoberto", "P2");

        mapaSenac.adicionarAresta(10.0, "P2", "Acadêmico 1");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P2");

        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "Central de Atendimento");
        mapaSenac.adicionarAresta(10.0, "Central de Atendimento", "Acadêmico 1");

        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P9");
        mapaSenac.adicionarAresta(10.0, "P9", "Acadêmico 1");

        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P1");
        mapaSenac.adicionarAresta(10.0, "P1", "Acadêmico 1");

        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P4");
        mapaSenac.adicionarAresta(10.0, "P4", "Acadêmico 1");

        mapaSenac.adicionarAresta(10.0, "Acadêmico 1", "P7");
        mapaSenac.adicionarAresta(10.0, "P7", "Acadêmico 1");

        mapaSenac.adicionarAresta(10.0, "P4", "P7");
        mapaSenac.adicionarAresta(10.0, "P7", "P4");

        mapaSenac.adicionarAresta(10.0, "Praça 2", "P7");
        mapaSenac.adicionarAresta(10.0, "P7", "Praça 2");

        mapaSenac.adicionarAresta(10.0, "P9", "P8");
        mapaSenac.adicionarAresta(10.0, "P8", "P9");

        mapaSenac.adicionarAresta(10.0, "P3", "P4");
        mapaSenac.adicionarAresta(10.0, "P4", "P3");

        mapaSenac.adicionarAresta(10.0, "P8", "P7");
        mapaSenac.adicionarAresta(10.0, "P7", "P8");

        mapaSenac.adicionarAresta(10.0, "P39", "P32");
        mapaSenac.adicionarAresta(10.0, "P32", "P39");

        mapaSenac.adicionarAresta(10.0, "P27", "P31");
        mapaSenac.adicionarAresta(10.0, "P31", "P27");

        mapaSenac.adicionarAresta(10.0, "P29", "Acadêmico 2");
        mapaSenac.adicionarAresta(10.0, "Acadêmico 2", "P29");

        mapaSenac.adicionarAresta(10.0, "P22", "Prédio de Manutenção");
        mapaSenac.adicionarAresta(10.0, "Prédio de Manutenção", "P22");
    }
}