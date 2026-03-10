package estrutura_estatica;

// HERANÇA:
// Com o comando extends, tudo o que foi criado na classe de EstruturaEstatica, está sendo aproveitado na classe Pilha. Ela herda absolutamente tudo.


public class Pilha<T> extends EstruturaEstatica<T> {
    public Pilha() {
        super();
    }

    public Pilha(int capacidade) {
        super(capacidade);
    }

    public void empilha(T elemento) {
        super.adiciona(elemento);
    }

    public T topo() {
        if(this.estaVazia()) {
            return null;
        } else {
            return this.elementos[tamanho - 1];
        }
    }

    // Em pilha, se remove o último item adicionado. Isso é representado no método abaixo:
    public T desempilha() {
        if(this.estaVazia()) {
            return null;
        }
        T elemento = this.elementos[tamanho-1];
        elemento = null;
        tamanho--;
        return elemento;
    }

    // OUTRO JEITO DE FAZER:
    /*public T desempilha() {
        if (this.estaVazia()) {
            return null;
        }
        T elemento = this.elementos[tamanho - 1];
        super.remove(tamanho - 1);
        return elemento;
    }*/



}
