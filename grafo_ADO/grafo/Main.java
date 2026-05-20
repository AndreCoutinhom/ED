package aula._05_05_2026.grafo;

import java.util.*;

/**
 * Aplicação de navegação no Jardim Taquaral (Santo Amaro - SP).
 *
 * Cada nó representa um ponto de referência do bairro.
 * Cada aresta armazena a distância em metros até o próximo ponto.
 * Apresenta até 2 opções de rota (menor e segunda menor distância).
 *
 */
public class Main {

    // ---------------------------------------------------------------
    // Lista centralizada de todos os vértices do grafo
    // ---------------------------------------------------------------
    private static final List<String> VERTICES = Arrays.asList(
            "A", "B", "C", "D", "E", "F", "G",
            "H", "I", "J", "K", "L", "M",
            "N", "O", "P", "Q", "R", "S",
            "T", "U", "V", "X"
    );

    // ---------------------------------------------------------------
    // Ponto de entrada da aplicação
    // ---------------------------------------------------------------
    public static void main(String[] args) {

        Grafo<String> grafo = construirGrafo();

        Scanner scanner = new Scanner(System.in);

        System.out.println("╔══════════════════════════════════════════════════════╗");
        System.out.println("║   Navegação no Jardim Taquaral - Santo Amaro (SP)   ║");
        System.out.println("╚══════════════════════════════════════════════════════╝");
        System.out.println();
        System.out.println("Pontos disponíveis: " + VERTICES);
        System.out.println();

        String origem  = lerPonto(scanner, "Ponto de partida");
        String destino = lerPonto(scanner, "Ponto de chegada");

        scanner.close();

        if (origem.equals(destino)) {
            System.out.println("\nOrigem e destino são o mesmo ponto.");
            return;
        }

        System.out.println();
        System.out.println("Calculando rotas de " + origem + " até " + destino + "...");
        System.out.println();

        // Busca até 2 menores caminhos (Algoritmo de Yen — k = 2)
        List<List<String>> caminhos = encontrarKMenoresCaminhos(grafo, origem, destino, 2);

        if (caminhos.isEmpty()) {
            System.out.println("Não existe caminho entre " + origem + " e " + destino + ".");
            return;
        }

        if (caminhos.size() == 1) {
            System.out.println("Foi encontrada 1 rota:\n");
        } else {
            System.out.println("Foram encontradas " + caminhos.size() + " rotas (ordenadas por menor distância):\n");
        }

        for (int i = 0; i < caminhos.size(); i++) {
            imprimirCaminho(grafo, caminhos.get(i), i + 1);
        }
    }

    // ---------------------------------------------------------------
    // Monta o grafo com os dados do Jardim Taquaral (img_02)
    // As ruas são de mão dupla → cada trecho é adicionado
    // nas duas direções com o mesmo peso.
    // ---------------------------------------------------------------
    private static Grafo<String> construirGrafo() {

        Grafo<String> grafo = new Grafo<String>();

        // Adiciona todos os vértices
        for (String v : VERTICES) {
            grafo.adicionarVertice(v);
        }

        // ── Trecho superior (Av. Sargento Silvaldo Sant'Ana) ──────
        grafo.adicionarAresta(300.0, "A", "B");
        grafo.adicionarAresta(300.0, "B", "A");

        // ── Lado direito (R. Hungria / condomínios) ───────────────
        grafo.adicionarAresta(47.0,  "B", "C");
        grafo.adicionarAresta(47.0,  "C", "B");

        grafo.adicionarAresta(62.0,  "C", "D");
        grafo.adicionarAresta(62.0,  "D", "C");

        grafo.adicionarAresta(141.0, "C", "H");
        grafo.adicionarAresta(141.0, "H", "C");

        grafo.adicionarAresta(8.0,   "D", "E");
        grafo.adicionarAresta(8.0,   "E", "D");

        grafo.adicionarAresta(13.0,  "E", "F");
        grafo.adicionarAresta(13.0,  "F", "E");

        grafo.adicionarAresta(138.0, "H", "I");
        grafo.adicionarAresta(138.0, "I", "H");

        grafo.adicionarAresta(153.0, "I", "J");
        grafo.adicionarAresta(153.0, "J", "I");

        // ── Trecho inferior (R. Vito Bovino / R. Edmundo Luís) ───
        grafo.adicionarAresta(512.0, "J", "K");
        grafo.adicionarAresta(512.0, "K", "J");

        grafo.adicionarAresta(230.0, "J", "G");
        grafo.adicionarAresta(230.0, "G", "J");

        grafo.adicionarAresta(135.0, "K", "L");
        grafo.adicionarAresta(135.0, "L", "K");

        grafo.adicionarAresta(50.0,  "L", "M");  // distância fornecida pelo enunciado
        grafo.adicionarAresta(50.0,  "M", "L");

        grafo.adicionarAresta(187.0, "L", "N");
        grafo.adicionarAresta(187.0, "N", "L");

        // ── Lado esquerdo (R. das Palmeiras / R. Vito Bovino) ────
        grafo.adicionarAresta(108.0, "N", "O");
        grafo.adicionarAresta(108.0, "O", "N");

        grafo.adicionarAresta(82.0,  "O", "P");
        grafo.adicionarAresta(82.0,  "P", "O");

        grafo.adicionarAresta(243.0, "O", "R");
        grafo.adicionarAresta(243.0, "R", "O");

        grafo.adicionarAresta(215.0, "P", "Q");
        grafo.adicionarAresta(215.0, "Q", "P");

        // ── Trecho superior esquerdo (Av. Marajoara) ─────────────
        grafo.adicionarAresta(97.0,  "Q", "R");
        grafo.adicionarAresta(97.0,  "R", "Q");

        grafo.adicionarAresta(33.0,  "R", "S");
        grafo.adicionarAresta(33.0,  "S", "R");

        grafo.adicionarAresta(38.0,  "S", "V");
        grafo.adicionarAresta(38.0,  "V", "S");

        grafo.adicionarAresta(207.0, "S", "T");
        grafo.adicionarAresta(207.0, "T", "S");

        grafo.adicionarAresta(22.0,  "T", "U");
        grafo.adicionarAresta(22.0,  "U", "T");

        grafo.adicionarAresta(210.0, "V", "U");
        grafo.adicionarAresta(210.0, "U", "V");

        grafo.adicionarAresta(370.0, "V", "A");
        grafo.adicionarAresta(370.0, "A", "V");

        grafo.adicionarAresta(107.0, "U", "X");
        grafo.adicionarAresta(107.0, "X", "U");

        grafo.adicionarAresta(317.0, "X", "A");
        grafo.adicionarAresta(317.0, "A", "X");

        return grafo;
    }

    // ---------------------------------------------------------------
    // Lê e valida um ponto digitado pelo usuário
    // ---------------------------------------------------------------
    private static String lerPonto(Scanner scanner, String rotulo) {
        String ponto;
        while (true) {
            System.out.print(rotulo + " (ex.: A): ");
            ponto = scanner.nextLine().trim().toUpperCase();
            if (VERTICES.contains(ponto)) {
                break;
            }
            System.out.println("  ✗ Ponto \"" + ponto + "\" inválido. "
                    + "Escolha entre: " + VERTICES);
        }
        return ponto;
    }

    // ---------------------------------------------------------------
    // Algoritmo de Yen — encontra os k menores caminhos simples
    // entre origem e destino.
    //
    // Referência: Yen, J.Y. (1971). "Finding the k Shortest Loopless
    // Paths in a Network." Management Science 17(11): 712–716.
    // ---------------------------------------------------------------
    private static List<List<String>> encontrarKMenoresCaminhos(
            Grafo<String> grafo, String origem, String destino, int k) {

        // A  = caminhos confirmados (k menores já encontrados)
        List<CaminhoComCusto> A = new ArrayList<>();

        // B  = candidatos ainda não confirmados (fila de prioridade)
        PriorityQueue<CaminhoComCusto> B =
                new PriorityQueue<>(Comparator.comparingDouble(c -> c.custo));

        // 1. Menor caminho simples (Dijkstra padrão)
        List<String> primeiroCaminho =
                dijkstra(grafo, origem, destino, Collections.emptySet(), Collections.emptySet());

        if (primeiroCaminho == null) {
            return Collections.emptyList();
        }

        A.add(new CaminhoComCusto(primeiroCaminho, custoTotal(grafo, primeiroCaminho)));

        // 2. Para cada caminho já confirmado, gera candidatos pela técnica do "spur"
        for (int ki = 1; ki < k; ki++) {

            List<String> caminhoAnterior = A.get(ki - 1).caminho;

            for (int i = 0; i < caminhoAnterior.size() - 1; i++) {

                String spurNode  = caminhoAnterior.get(i);
                List<String> rootPath = caminhoAnterior.subList(0, i + 1);

                // Arestas a ignorar: aquelas usadas por caminhos em A
                // que compartilham o mesmo "rootPath"
                Set<String> arestasRemovidas = new HashSet<>();
                for (CaminhoComCusto cc : A) {
                    List<String> p = cc.caminho;
                    if (p.size() > i
                            && p.subList(0, i + 1).equals(rootPath)) {
                        // Remove aresta spurNode → próximo nó desse caminho
                        arestasRemovidas.add(p.get(i) + ">" + p.get(i + 1));
                    }
                }

                // Nós a ignorar: todos os nós do rootPath, exceto o próprio spurNode
                Set<String> nosRemovidos = new HashSet<>(rootPath.subList(0, rootPath.size() - 1));

                // Dijkstra restrito a partir do spurNode
                List<String> spurPath =
                        dijkstra(grafo, spurNode, destino, arestasRemovidas, nosRemovidos);

                if (spurPath != null) {
                    // Caminho total = rootPath (sem o spurNode repetido) + spurPath
                    List<String> caminhoTotal = new ArrayList<>(rootPath.subList(0, rootPath.size() - 1));
                    caminhoTotal.addAll(spurPath);

                    // Evita duplicatas
                    double custo = custoTotal(grafo, caminhoTotal);
                    CaminhoComCusto candidato = new CaminhoComCusto(caminhoTotal, custo);

                    boolean duplicado = A.stream().anyMatch(c -> c.caminho.equals(caminhoTotal))
                            || B.stream().anyMatch(c -> c.caminho.equals(caminhoTotal));

                    if (!duplicado) {
                        B.add(candidato);
                    }
                }
            }

            if (B.isEmpty()) break;

            A.add(B.poll());
        }

        // Retorna apenas as listas de vértices (já ordenadas por custo crescente)
        List<List<String>> resultado = new ArrayList<>();
        for (CaminhoComCusto cc : A) {
            resultado.add(cc.caminho);
        }
        return resultado;
    }

    // ---------------------------------------------------------------
    // Dijkstra com suporte a arestas e nós removidos (para Yen)
    //
    //  arestasRemovidas : chaves no formato "FROM>TO"
    //  nosRemovidos     : vértices a ignorar (exceto origem e destino)
    // ---------------------------------------------------------------
    private static List<String> dijkstra(
            Grafo<String> grafo,
            String origem,
            String destino,
            Set<String> arestasRemovidas,
            Set<String> nosRemovidos) {

        Map<String, Double>  dist = new HashMap<>();
        Map<String, String>  prev = new HashMap<>();
        Set<String>          visitados = new HashSet<>();

        for (String v : VERTICES) {
            dist.put(v, Double.POSITIVE_INFINITY);
            prev.put(v, null);
        }
        dist.put(origem, 0.0);

        while (true) {
            // Seleciona o vértice não visitado com menor distância acumulada
            String atual    = null;
            double menorDist = Double.POSITIVE_INFINITY;

            for (String v : VERTICES) {
                if (visitados.contains(v)) continue;
                // Nós removidos não são considerados, exceto origem e destino
                if (nosRemovidos.contains(v)
                        && !v.equals(origem)
                        && !v.equals(destino)) continue;
                double d = dist.get(v);
                if (d < menorDist) {
                    menorDist = d;
                    atual = v;
                }
            }

            if (atual == null || atual.equals(destino)) break;

            visitados.add(atual);

            Vertice<String> verticeAtual = grafo.getVertice(atual);
            if (verticeAtual == null) continue;

            for (Aresta<String> aresta : verticeAtual.getArestasSaida()) {
                String vizinho = aresta.getFim().getDado();
                String chaveAresta = atual + ">" + vizinho;

                // Ignora aresta removida
                if (arestasRemovidas.contains(chaveAresta)) continue;
                // Ignora nó removido (exceto destino)
                if (nosRemovidos.contains(vizinho) && !vizinho.equals(destino)) continue;
                // Ignora já visitados
                if (visitados.contains(vizinho)) continue;

                double novaDist = dist.get(atual) + aresta.getPeso();
                if (novaDist < dist.get(vizinho)) {
                    dist.put(vizinho, novaDist);
                    prev.put(vizinho, atual);
                }
            }
        }

        // Sem caminho
        if (dist.get(destino).isInfinite()) return null;

        // Reconstrói o caminho de trás para frente
        List<String> caminho = new ArrayList<>();
        String cur = destino;
        while (cur != null) {
            caminho.add(0, cur);
            cur = prev.get(cur);
        }

        return caminho;
    }

    // ---------------------------------------------------------------
    // Calcula o custo total (soma dos pesos) de um caminho
    // ---------------------------------------------------------------
    private static double custoTotal(Grafo<String> grafo, List<String> caminho) {
        double total = 0.0;
        for (int i = 0; i < caminho.size() - 1; i++) {
            Vertice<String> v = grafo.getVertice(caminho.get(i));
            String proximo    = caminho.get(i + 1);
            for (Aresta<String> a : v.getArestasSaida()) {
                if (a.getFim().getDado().equals(proximo)) {
                    total += a.getPeso();
                    break;
                }
            }
        }
        return total;
    }

    // ---------------------------------------------------------------
    // Exibe uma rota com distâncias trecho a trecho e total
    // ---------------------------------------------------------------
    private static void imprimirCaminho(
            Grafo<String> grafo, List<String> caminho, int numero) {

        double total = custoTotal(grafo, caminho);

        System.out.println("┌─ Opção " + numero
                + " ─────────────────────────────────────────────────");
        System.out.print  ("│  Trajeto : ");

        for (int i = 0; i < caminho.size(); i++) {
            System.out.print(caminho.get(i));
            if (i < caminho.size() - 1) {
                double segmento = 0;
                Vertice<String> v = grafo.getVertice(caminho.get(i));
                String prox = caminho.get(i + 1);
                for (Aresta<String> a : v.getArestasSaida()) {
                    if (a.getFim().getDado().equals(prox)) {
                        segmento = a.getPeso();
                        break;
                    }
                }
                System.out.printf(" --(%.0fm)--> ", segmento);
            }
        }

        System.out.println();
        System.out.printf ("│  Distância total: %.0f metros%n", total);
        System.out.println("└────────────────────────────────────────────────────────");
        System.out.println();
    }

    // ---------------------------------------------------------------
    // Classe auxiliar: caminho + custo (para a fila de prioridade)
    // ---------------------------------------------------------------
    private static class CaminhoComCusto {
        final List<String> caminho;
        final double       custo;

        CaminhoComCusto(List<String> caminho, double custo) {
            this.caminho = caminho;
            this.custo   = custo;
        }
    }
}