package ado.ado_3;

import java.util.ArrayList;
import java.util.HashMap;

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

    public void BuscarCaminho(TIPO inicio, TIPO fim)
    {
        Vertice<TIPO> origem = null;
        Vertice<TIPO> destino = null;

        // Validação da Busca (Pega a referência do vertice com o mesmo valor procurado)
        for (Vertice<TIPO> v : vertices)
        {
            if (v.getDado().equals(inicio))
                origem = v;

            if (v.getDado().equals(fim))
                destino = v;
        }

        if (origem == null || destino == null)
        {
            System.out.println("Origem ou destino não encontrado");
            return;
        }

        //---------------------------------------------------------

        ArrayList<Vertice<TIPO>> marcados = new ArrayList<>();
        ArrayList<Vertice<TIPO>> fila = new ArrayList<>();

        HashMap<Vertice<TIPO>, Vertice<TIPO>> pai = new HashMap<>();

        fila.add(origem);
        marcados.add(origem);

        while (fila.size() > 0)
        {
            Vertice<TIPO> atual = fila.get(0);
            fila.remove(0);

            if (atual.equals(destino))
                break;

            for (Aresta<TIPO> aresta : atual.getArestasSaida())
            {
                Vertice<TIPO> proximo = aresta.getFim();

                if (!marcados.contains(proximo))
                {
                    marcados.add(proximo);
                    fila.add(proximo);
                    pai.put(proximo, atual);
                }
            }
        }

        // Recontroi o caminho
        ArrayList<Vertice<TIPO>> caminho = new ArrayList<>();

        Vertice<TIPO> atual = destino;

        while (atual != null)
        {
            caminho.add(0, atual);
            atual = pai.get(atual);
        }

        // Exibição
        System.out.println("Caminho com " + (caminho.size() - 1) + " ponto(s)\n");

        for (Vertice<TIPO> v : caminho)
        {
            System.out.print(" -> " + v.getDado());
        }
    }


    /*
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
    }*/
}