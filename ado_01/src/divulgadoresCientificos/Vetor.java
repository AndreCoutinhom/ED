package divulgadoresCientificos;

// Classe de comportamento do vetor. Os métodos são os mesmos trabalhados em aula.

public class Vetor {
    public Object[] elementos;

    public int tamanho;

    public Vetor (int capacidade) {
        this.elementos = new Object[capacidade];
        this.tamanho = 0;
    }

    public void adiciona (Object elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override // Para mudar parâmetros de um método especificamente em uma classe. Ideal para mudar métodos de classes importadas.
    // Usamos o Override para somente mostrar os elementos que estão incluídos no tamanho do vetor, e não em sua capacidade. Dessa forma, o valor null não será printado.
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("");

        for (int i = 0; i < this.tamanho-1; i++) {
            s.append(this.elementos[i]);
            s.append("; ");
        }

        if(this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append(".");

        return s.toString();
    }

    // MÉTODOS DE BUSCA

    // O primeiro método busca o número da posição como parâmetro e retorna a string do elemento.

    public Object busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception("Calma aí Lux Elementalista! Só existem 4!");
        }
    }

    // O segundo método de busca faz o contrário. Inserimos uma string como parâmetro e o código retorna a posição em que está.
    public int busca1(Object elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaInicio (int posicao, Object elemento) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            for (int i = this.tamanho - 1; i >= posicao; i--) {
                this.elementos[i + 1] = this.elementos[i];
            }
            this.elementos[posicao] = elemento;
            this.tamanho++;
        } else {
            throw new Exception ("Posicao Invalida!");
        }
        return true;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public void remove (int posicao) throws Exception {
        if (posicao >= 0 && posicao <= tamanho) {
            for(int i = posicao; i < this.tamanho - 1; i++) {
                this.elementos[i] = this.elementos[i + 1];
            }
            this.elementos[this.tamanho - 1] = null;
            this.tamanho--;
        } else {
            throw new Exception("Posicao Invalida!");
        }
    }

    public void removeConteudo (Object elemento) throws Exception {
        int posicao = this.busca1(elemento);
        this.busca(posicao);
        this.remove(posicao);
    }

    public void alteraConteudo (Object novoElemento, int posicao) {
        if (posicao >= 0 && posicao <= tamanho) {
            this.elementos[posicao] = novoElemento;
        }
    }
}
