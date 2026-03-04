package divulgadoresCientificos;

// Classe divulgador armazena atributos úteis para divulgadores científicos na Internet.

public class Divulgador {
    private String nome;
    private String nomeCanal;
    private String linkLattes;
    private String areaEstudo;
    private String plataformaPrincipal;
    private String seguidores;

    // Construtores, get, setters, toString; todos criados automaticamente.

    public Divulgador(String nome, String nomeCanal, String linkLattes, String areaEstudo, String plataformaPrincipal, String seguidores) {
        this.nome = nome;
        this.nomeCanal = nomeCanal;
        this.linkLattes = linkLattes;
        this.areaEstudo = areaEstudo;
        this.plataformaPrincipal = plataformaPrincipal;
        this.seguidores = seguidores;
    }

    public Divulgador() {

    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeCanal() {
        return nomeCanal;
    }

    public void setNomeCanal(String nomeCanal) {
        this.nomeCanal = nomeCanal;
    }

    public String getLinkLattes() {
        return linkLattes;
    }

    public void setLinkLattes(String linkLattes) {
        this.linkLattes = linkLattes;
    }

    public String getAreaEstudo() {
        return areaEstudo;
    }

    public void setAreaEstudo(String areaEstudo) {
        this.areaEstudo = areaEstudo;
    }

    public String getPlataformaPrincipal() {
        return plataformaPrincipal;
    }

    public void setPlataformaPrincipal(String plataformaPrincipal) {
        this.plataformaPrincipal = plataformaPrincipal;
    }

    public String getSeguidores() {
        return seguidores;
    }

    public void setSeguidores(String seguidores) {
        this.seguidores = seguidores;
    }

    @Override
    public String toString() {
        return "\n Divulgador { \n" +
                "Nome = " + nome + "\n" +
                "Nome do Canal = " + nomeCanal + "\n" +
                "Link do Currículo = " + linkLattes + "\n" +
                "Área de Estudo = " + areaEstudo + "\n" +
                "Plataforma mais usada = " + plataformaPrincipal + "\n" +
                "Número de seguidores na plataforma = " + seguidores + "\n" +
                '}';
    }
}