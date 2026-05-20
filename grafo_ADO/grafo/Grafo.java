package aula._05_05_2026.grafo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;

public class Grafo<TIPO> {
    private ArrayList<Vertice<TIPO>> vertices;
    private ArrayList<Aresta<TIPO>> arestas;

    public Grafo() {
        this.vertices = new ArrayList<Vertice<TIPO>>();
        this.arestas = new ArrayList<Aresta<TIPO>>();
    }

    public void adicionarVertice(TIPO dado)
    {
        Vertice<TIPO> novoVertice = new Vertice<TIPO>(dado);
        this.vertices.add(novoVertice);
    }

    public void adicionarAresta(Double peso, TIPO dadoInicio, TIPO dadoFim)
    {
        Vertice<TIPO> inicio = this.getVertice(dadoInicio);
        Vertice<TIPO> fim = this.getVertice(dadoFim);
        Aresta<TIPO> aresta = new Aresta<TIPO>(peso, inicio, fim);
        inicio.adicionarArestaSaida(aresta);
        fim.adicionarArestaEntrada(aresta);
        this.arestas.add(aresta);
    }

    public Vertice<TIPO> getVertice(TIPO dado)
    {
        Vertice<TIPO> vertice = null;
        for (int i = 0; i < this.vertices.size(); i++) {
            if (this.vertices.get(i).getDado().equals(dado))
            {
                vertice = this.vertices.get(i);
                break;
            }
        }
        return vertice;
    }

    public void BuscaEmLargura()
    {
        ArrayList<Vertice<TIPO>> marcados = new ArrayList<Vertice<TIPO>>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<Vertice<TIPO>>();
        Vertice<TIPO> atual = this.vertices.get(0);
        marcados.add(atual);
        System.out.println(atual.getDado());
        fila.add(atual);
        while (fila.size() > 0)
        {
            Vertice<TIPO> visitado = fila.get(0);

            for (int i=0; i < visitado.getArestasSaida().size();i++)
            {
                Vertice<TIPO> proximo = visitado.getArestasSaida().get(i).getFim();
                if (!marcados.contains(proximo))
                {
                    marcados.add(proximo);
                    System.out.println(proximo.getDado());
                    fila.add(proximo);
                }
            }
            fila.remove(0);
        }
    }

    public void BuscaComDijkstra(TIPO origem, TIPO destino)
    {
        HashMap<Vertice<TIPO>, Double> distancias =
                new HashMap<>();

        HashMap<Vertice<TIPO>, Vertice<TIPO>> anteriores =
                new HashMap<>();

        HashSet<Vertice<TIPO>> visitados =
                new HashSet<>();

        // inicializa distâncias
        for (Vertice<TIPO> vertice : this.vertices)
        {
            distancias.put(vertice, Double.POSITIVE_INFINITY);
            anteriores.put(vertice, null);
        }

        Vertice<TIPO> inicial = getVertice(origem);
        Vertice<TIPO> fim = getVertice(destino);

        // valida vértices
        if (inicial == null || fim == null)
        {
            System.out.println("Vertice de origem ou destino invalido.");
            return;
        }

        distancias.put(inicial, 0.0);

        while (visitados.size() < this.vertices.size())
        {
            Vertice<TIPO> atual = null;
            Double menor = Double.POSITIVE_INFINITY;

            // pega menor vértice não visitado
            for (Vertice<TIPO> vertice : this.vertices)
            {
                Double distancia = distancias.get(vertice);

                if (!visitados.contains(vertice)
                        && distancia < menor)
                {
                    menor = distancia;
                    atual = vertice;
                }
            }

            // não existe mais caminho possível
            if (atual == null)
            {
                break;
            }

            // se chegou no destino pode parar
            if (atual.equals(fim))
            {
                break;
            }

            visitados.add(atual);

            // relaxamento
            for (Aresta<TIPO> aresta : atual.getArestasSaida())
            {
                Vertice<TIPO> vizinho = aresta.getFim();

                // ignora vizinhos já visitados
                if (visitados.contains(vizinho))
                {
                    continue;
                }

                Double novaDistancia =
                        distancias.get(atual) + aresta.getPeso();

                // encontrou caminho melhor
                if (novaDistancia < distancias.get(vizinho))
                {
                    distancias.put(vizinho, novaDistancia);
                    anteriores.put(vizinho, atual);
                }
            }
        }

        // verifica se existe caminho
        if (distancias.get(fim) == Double.POSITIVE_INFINITY)
        {
            System.out.println(
                    "Nao existe caminho entre "
                            + origem
                            + " e "
                            + destino
            );

            return;
        }

        // reconstrução do caminho
        ArrayList<Vertice<TIPO>> caminho =
                new ArrayList<>();

        Vertice<TIPO> atual = fim;

        while (atual != null)
        {
            caminho.add(0, atual);
            atual = anteriores.get(atual);
        }

        // saída
        System.out.println("Menor caminho:");

        for (int i = 0; i < caminho.size(); i++)
        {
            System.out.print(caminho.get(i).getDado());

            if (i < caminho.size() - 1)
            {
                System.out.print(" -> ");
            }
        }

        System.out.println(
                "\nCusto total: " + distancias.get(fim)
        );
    }
}