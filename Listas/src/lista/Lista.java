package lista;

import java.util.List;

public class Lista {

    public static void main(String[] args) {
//        ListaEncadeada<String> lista = new ListaEncadeada<>();
//
//        System.out.println("Tamanho da lista = " + lista.getTamanho());
//
//        lista.adiciona("Claudio");
//
//        System.out.println("Tamanho da Lista = " + lista.getTamanho());
//        System.out.println("Início da Lista = " + lista.getInicio().getElemento());
//        System.out.println("Fim da Lista = " + lista.getFim().getElemento());
//
//        lista.adiciona("Camila");
//
//        System.out.println(lista);
//        System.out.println("Tamanho da Lista = " + lista.getTamanho());
//        System.out.println("Início da Lista = " + lista.getInicio().getElemento());
//        System.out.println("Fim da Lista = " + lista.getFim().getElemento());
//
//        System.out.println("Elemento na posição 2 = " + lista.get(2).getElemento());
//
//        lista.remover("Claudio");
//
//        System.out.println("Tamanho da Lista = " + lista.getTamanho());
//        System.out.println("Início da Lista = " + lista.getInicio().getElemento());
//        System.out.println("Fim da Lista = " + lista.getFim().getElemento());

        ListaDuplamenteEncadeada<String> lista2 = new ListaDuplamenteEncadeada<>();

        System.out.println("Tamanho da lista = " + lista2.getTamanho());

        lista2.adiciona("Andy");
        System.out.println("Tamanho da Lista = " + lista2.getTamanho());
        System.out.println("Início da Lista = " + lista2.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista2.getFim().getElemento());

        lista2.adiciona("Bonnie");
        System.out.println("Tamanho da Lista = " + lista2.getTamanho());
        System.out.println("Início da Lista = " + lista2.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista2.getFim().getElemento());

        lista2.adiciona("Wendy");
        System.out.println("Tamanho da Lista = " + lista2.getTamanho());
        System.out.println("Início da Lista = " + lista2.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista2.getFim().getElemento());

        lista2.remover("Wendy");
        System.out.println("Tamanho da Lista = " + lista2.getTamanho());
        System.out.println("Início da Lista = " + lista2.getInicio().getElemento());
        System.out.println("Fim da Lista = " + lista2.getFim().getElemento());

        System.out.println(lista2);

    }
}
