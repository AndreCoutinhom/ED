package estrutura_estatica;


// HERANÇA:
// Com o comando extends, tudo o que foi criado na classe de EstruturaEstatica, está sendo aproveitado na classe Lista. Ela herda absolutamente tudo.

public class Lista<T> extends EstruturaEstatica<T> {
    public Lista(int capacidade) {
        super(capacidade);
    }

    public Lista() {
        super();
    }

    public boolean adiciona(T elemento) {
        return super.adiciona(elemento);
    }

    public boolean adiciona(int posicao, T elemento) {
        return super.adiciona(posicao, elemento);
    }
}
