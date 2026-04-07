package lista;

public class ListaDuplamenteEncadeada<Tipo> {
    private No<Tipo> inicio;
    private No<Tipo> fim;
    private int tamanho;

    public ListaDuplamenteEncadeada() {
        this.tamanho = 0;
    }

    public No<Tipo> getInicio() {
        return inicio;
    }

    public void setInicio(No<Tipo> inicio) {
        this.inicio = inicio;
    }

    public No<Tipo> getFim() {
        return fim;
    }

    public void setFim(No<Tipo> fim) {
        this.fim = fim;
    }

    public int getTamanho() {
        return tamanho;
    }

    public void setTamanho(int tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "ListaDuplamenteEncadeada{" +
                "inicio=" + inicio +
                '}';
    }

    // FEITO COM CLAUDE:

    // ─── ADICIONA ────────────────────────────────────────────────────────────────
    public void adiciona(Tipo elemento) {
        No<Tipo> celula = new No<>(elemento);

        if (this.inicio == null && this.fim == null) {
            // Lista vazia: o único nó é início e fim; sem anterior nem próximo
            this.inicio = celula;
            this.fim    = celula;
        } else {
            // Liga o novo nó ao antigo fim
            this.fim.setProximo(celula);   // fim  →  celula  (encadeamento "para frente")
            celula.setAnterior(this.fim);  // celula  →  fim  (encadeamento "para trás")
            this.fim = celula;             // atualiza ponteiro de fim
        }
        this.tamanho++;
    }

    // ─── GET ─────────────────────────────────────────────────────────────────────
    public No<Tipo> get(int posicao) {
        No<Tipo> atual = this.inicio;
        for (int i = 1; i < posicao; i++) {   // começa em 1: posição 1 já é "inicio"
            if (atual.getProximo() != null) {
                atual = atual.getProximo();
            }
        }
        return atual;
    }

    // ─── REMOVER ─────────────────────────────────────────────────────────────────
    public void remover(Tipo elemento) {
        No<Tipo> atual = this.inicio;

        for (int i = 0; i < this.tamanho; i++) {

            if (atual.getElemento().equals(elemento)) {

                if (this.tamanho == 1) {
                    // Único elemento: lista fica vazia
                    this.inicio = null;
                    this.fim    = null;

                } else if (atual == this.inicio) {
                    // Remove o início: o novo início não tem anterior
                    this.inicio = atual.getProximo();
                    this.inicio.setAnterior(null);

                } else if (atual == this.fim) {
                    // Remove o fim: o novo fim não tem próximo
                    this.fim = atual.getAnterior();
                    this.fim.setProximo(null);

                } else {
                    // Remove nó do meio: costura os vizinhos entre si
                    No<Tipo> anterior  = atual.getAnterior();
                    No<Tipo> proximo   = atual.getProximo();
                    anterior.setProximo(proximo);  // anterior  →  próximo
                    proximo.setAnterior(anterior); // próximo   →  anterior
                }

                this.tamanho--;
                break;
            }

            atual = atual.getProximo();
        }
    }
}