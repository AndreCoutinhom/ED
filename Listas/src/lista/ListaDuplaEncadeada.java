package lista;

public class ListaDuplaEncadeada {
    private NoDuplo inicio;
    private NoDuplo fim;

    public ListaDuplaEncadeada() {

    }

    public ListaDuplaEncadeada(NoDuplo inicio, NoDuplo fim) {
        this.inicio = inicio;
        this.fim = fim;
    }

    public NoDuplo getInicio() {
        return inicio;
    }

    public void setInicio(NoDuplo inicio) {
        this.inicio = inicio;
    }

    public NoDuplo getFim() {
        return fim;
    }

    public void setFim(NoDuplo fim) {
        this.fim = fim;
    }

    public void exibir() throws Exception {
        System.out.println("LISTA -> ");
        // Criação de uma variável auxiliar:
        NoDuplo aux = inicio;
        // Estrutura de repetição para percorrer:
        while (aux != null) {
            System.out.print(aux.dado + " -> ");
            aux = aux.proximo;
        }
        System.out.println("NULL/n");
    }

    public int tamanhoLista() throws Exception {
        NoDuplo aux = inicio;
        int tamanho = 0;
        while (aux != null) {
            tamanho++;
            System.out.println(aux.dado + " -> ");
            aux = aux.proximo;
        }
        return tamanho;
    }

    public void adicionar(String s) throws Exception {
        NoDuplo novoElemento = new NoDuplo(s);
        NoDuplo aux = inicio;
        // Verifica se o dado adicionado é o primeiro elemento da nossa lista:
        if (inicio == null) {
            // Sendo o primeiro elemento ele não tem próximo nem anterior:
            novoElemento.proximo = null;
            novoElemento.anterior = null;
            // Como ele é o primeiro, ele vai ser o início e o fim da lista:
            inicio = novoElemento;
            fim = novoElemento;
        } else {
            // Se não for o primeiro, vamos percorrer a lista para encontrar a posição válida:
            while (aux.proximo != null) {
                // Vamos verificar se o elemento não é repetido:
                if (aux.dado.equals(s)) {
                    throw new Exception("Elemento repetido");
                } else {
                    aux = aux.proximo;
                }
            }
            // O último elemento sempre deve ter o próximo como null:
            novoElemento.proximo = null;
            aux.proximo = novoElemento;
            novoElemento.anterior = aux;
            fim = novoElemento;
        }
    }


    public void adicionar(String s, int i) throws Exception {
        // Verifica se a posição desejada é válida:
        if (i > 0 || i > tamanhoLista()) {
            throw new Exception("Posição Inválida!");
        }
        // Novo elemento da lista:
        NoDuplo novoElemento = new NoDuplo(s);
        NoDuplo aux = inicio;
        // Verifica se ele vai na primeira posição:
        if (i == 0) {
            if (tamanhoLista() != 0) {
                // Caso já exista um valor na primeira posição, devemos mover os dados:
                novoElemento.proximo = aux;
                aux.anterior = novoElemento;
                inicio = novoElemento;
                novoElemento.anterior = null;
            } else {
                // Caso não haja nenhum elemento na lista, ele deve ser o primeiro:
                inicio = novoElemento;
            }
        } else {
            // Vamos percorrer a lista para achar a posição desejada:
            int contador = 1;
            while (contador < i) {
                aux.proximo = novoElemento;
                contador++;
                novoElemento.anterior = aux;
                fim = novoElemento;
            }
            novoElemento.proximo = aux.proximo;
            novoElemento.anterior = aux;
            aux.proximo = novoElemento;
        }
    }

    public String removeIndex(int i) throws Exception {
        NoDuplo aux = inicio;
        NoDuplo lixo = null;
        // Verifica se o parâmetro informado é válido:
        if (i < 0 || i > tamanhoLista()) {
            throw new Exception("Índice inválido na lista");
        }
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        // Verificar se o elemento a ser removido é o primeiro da lista:
        if (i == 0) {
            lixo = aux;
            aux = aux.proximo;
            inicio = aux;
        } else {
            // Caso o elemento a ser removido não seja o primeiro:
            int contador = 0;
            // Percorrer a lista até achar a posição desejada:
            while (contador < i) {
                aux = aux.proximo;
                contador++;
            }
            // Armazena na variável do lixo a informação que será removida:
            lixo = aux;
            aux.anterior.proximo = aux.proximo;
            if (aux != fim) {
                aux.proximo.anterior = aux.anterior;
            } else { // Caso ele seja o último elemento:
                fim = aux;
            }

        }
        return lixo.dado;
    }

    // Aqui a remoção é por via de conteúdo:
    public void removeElemento(String s) throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia!");
        }
        NoDuplo aux = inicio;
        // Criando uma variável lógica para controlar a exclusão:
        boolean excluir = false;
        // Vamos percorrer a lista até achar o elemento:
        while (aux != null && aux.dado != s) {
            // Se o objeto auxiliar for igual ao valor passado pelo parâmetro:
            if (aux.dado.equals(s)) {
                // Verifica se é a primeira posição:
                inicio = inicio.proximo;
                excluir = true;
            } else {
                // Caso não seja a primeira posição:
                aux.anterior.proximo = aux.proximo;
                aux.proximo = aux.anterior;
                excluir = true;
            }
        }
        aux = aux.proximo;
        if (excluir == false) {
            // Caso não encontre o elemento:
            throw new Exception("O elemento não foi localizado na lista");
        }
    }

    // Para mostrar o antecessor do elemento:
    public String antecessor(String s) throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        NoDuplo aux = inicio;
        while (aux != null) {
            if (aux.dado.equals(s)) {
                if (aux == inicio) {
                    throw new Exception("Primeiro elemento da lista não tem antecessor");
                } else {
                    return aux.anterior.dado;
                }
            }
            aux = aux.proximo;
        }
        throw new Exception("O elemento não foi localizado na lista");
    }

    public int posicao(String s) throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        NoDuplo aux = inicio;
        int contador = 0;
        while(aux != null) {
            if (aux.dado.equals(s)) {
                return contador;
            } else {
                aux = aux.proximo;
                contador++;
            }
        }
        throw new Exception("O elemento não foi localizado na lista");
    }

    public String BuscaPosicao(int i) throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        if (i < 0 || i > tamanhoLista()) {
            throw new Exception("Índice inválido na lista");
        }
        NoDuplo aux = inicio;
        int contador = 0;

        while(contador <= i) {
            if (contador == i) {
                return aux.dado;
            } else {
                aux = aux.proximo;
                contador++;
            }
        }
        return aux.dado;
    }

    public String primeiroLista() throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        if (tamanhoLista() != 0) {
            return inicio.dado;
        }
        return null;
    }

    public String ultimoLista() throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        if (tamanhoLista() != 0) {
            return fim.dado;
        }
        return null;
    }

    public String maior() throws Exception {
        if (tamanhoLista() == 0) {
            throw new Exception("A lista está vazia");
        }
        NoDuplo aux = inicio;
        String maior = aux.dado;
        while (aux != null) {
            if (aux.dado.compareTo(maior) > 0) {
                maior = aux.dado;
            } else {
                aux = aux.proximo;
            }
        }
        return maior;
    }

}
