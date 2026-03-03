package Projeto_Revisao_ED;

import java.util.Arrays;

public class Vetor {
    public String[] elementos;

    public int tamanho;

    // TENTATIVA 1: Método construtor, para instanciar objetos declarando-lhes um valor padrão.
    /*
    // No método abaixo, a capacidade de armazenamento do vetor está associada ao vetor de elementos.
    public Vetor(int capacidade) {
        this.elementos = new String[capacidade];
    }

    // Com o laço de repetição, estamos criando uma estrutura baseada em uma fila de strings. Cada string é adicionada ao vetor.
    public void adiciona(String elemento) {
        for(int i = 0; i < this.elementos.length; i++) {
            if (this.elementos[i] == null) { // Usamos o null porque assim é como o Java reconhece um espaço de string vazio. Se tiver um espaço vazio, então um novo elemento é adicionado àquele espaço.
                this.elementos[i] = elemento;
                break;
            }
        }
    }
    // Esse método funciona, mas é ineficiente porque percorre todo o vetor todas as vezes.


 */
    // TENTATIVA 2: O método abaixo é um pouco mais eficiente porque trabalha, exclusivamente, por condições.
    // Ele não faz verificações de valor nulo. Ele parte de um tamanho definido e adiciona conforme a disponibilidade do espaço.
    // Quando não há mais espaços disponíveis, ele abre uma exceção para avisar ao usuário.

    public Vetor (int capacidade) {
        this.elementos = new String[capacidade];
        this.tamanho = 0;
    }

    public void adiciona (String elemento) {
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

    public String busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception("Calma aí Lux Elementalista! Só existem 4!");
        }
    }

    // O segundo método de busca faz o contrário. Inserimos uma string como parâmetro e o código retorna a posição em que está.
    public int busca1(String elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }

    public boolean adicionaInicio (int posicao, String elemento) throws Exception {
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
            String[] elementosNovos = new String[this.elementos.length * 2];
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

    public void removeConteudo (String elemento) throws Exception {
        int posicao = this.busca1(elemento);
        this.busca(posicao);
        this.remove(posicao);
    }

    public void alteraConteudo (String novoElemento, int posicao) {
        if (posicao >= 0 && posicao <= tamanho) {
            this.elementos[posicao] = novoElemento;
        }
    }

}

