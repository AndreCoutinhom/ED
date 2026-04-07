package lista;

public class No<Tipo> {
    private Tipo elemento;
    private No<Tipo> proximo;
    private No<Tipo> anterior;

    public No<Tipo> getAnterior() {
        return anterior;
    }

    public void setAnterior(No<Tipo> anterior) {
        this.anterior = anterior;
    }

    public No(Tipo elemento) {
        this.elemento = elemento;
        this.proximo = null;
    }

    public No(Tipo elemento, No<Tipo> proximo) {
        this.elemento = elemento;
        this.proximo = proximo;
    }

    public Tipo getElemento() {
        return elemento;
    }

    public void setElemento(Tipo elemento) {
        this.elemento = elemento;
    }

    public No<Tipo> getProximo() {
        return proximo;
    }

    public void setProximo(No<Tipo> proximo) {
        this.proximo = proximo;
    }

    @Override
    public String toString() {
        String proximoStr = (proximo != null) ? String.valueOf(proximo.getElemento()) : "null";

        if (anterior != null) {
            String anteriorStr = String.valueOf(anterior.getElemento());
            return "No{" +
                    "anterior=" + anteriorStr +
                    ", elemento=" + elemento +
                    ", proximo=" + proximoStr +
                    '}';
        } else {
            return "No{" +
                    "elemento=" + elemento +
                    ", proximo=" + proximoStr +
                    '}';
        }
    }
}
