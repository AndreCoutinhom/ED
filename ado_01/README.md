# Divulgadores Científicos

<img width="1026" height="720" alt="image" src="https://github.com/user-attachments/assets/5507ea43-2fcb-47db-9615-6d2853e796eb" />


## Situação

Convivemos com um dos tempos mais propensos á disseminação de desinformação da história. O [relatório de riscos globais de 2026](https://reports.weforum.org/docs/WEF_Global_Risks_Report_2026.pdf) gerado pelo Fórum Econômico Mundial registrou que a Desinformação está em quinto lugar entre os maiores riscos do ano, e está frequentemente associada como em primeiro lugar na categoria de riscos relacionados à tecnologia.

Para combater a desinformação, uma estratégia possível é a disseminação de conhecimento científico, bem embasado e eficientemente comunicado, na Internet. Alguns dos principais agentes desse combate são os divulgadores científicos; pessoas dedicadas à construção de conteúdo baseado em evidências científicas, que quebram mitos, tabus e combatem pseudociências, fake news e sofismas.

Neste projeto, organizamos uma lista de divulgadores científicos, com acesso a alguns de seus dados acadêmicos mais importantes, utilizando classes de vetor em Java. Cada divulgador científico se comporta como um objeto, e seus atributos são seus fatores mais importantes para acessar seu conteúdo e validar seu posicionamento na comunidade científica.

## Projeto

O projeto consiste na criação de três classes no total. Uma que armazena métodos para manipulação de vetores, outra que parametriza o objeto de Divulgadores Científicos e uma última para teste.

### Vetor.java

Essa classe estabelece os principais métodos de vetor trabalhados nas aulas 02 e 03. Nessa classe se encontram alguns métodos fundamentais para o tratamento de dados em vetores:

#### Adicionar elementos

Um método que permite a adição de novos elementos no vetor enquanto aumenta sua capacidade quando estiver no limite:

``` java
    public void adiciona (Object elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
    }
```

#### Aumentar Capacidade

Chamado no método adicionar elementos, que dobra a capacidade de armazenamento do vetor, sempre que estiver no limite:

``` java
    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            Object[] elementosNovos = new Object[this.elementos.length * 2];
            for (int i = 0; i < elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }
```

#### Buscar elementos via posição

O índice do elemento é acionado como parâmetro, retornando o dado presente naquela posição:

``` java
    public Object busca(int posicao) throws Exception {
        if (posicao >= 0 && posicao < tamanho) {
            return this.elementos[posicao];
        } else {
            throw new Exception("Calma aí Lux Elementalista! Só existem 4!");
        }
    }

```

#### Buscar elementos via elemento

O elemento é acionado como parâmetro, retornando o índice em que se encontra:

``` java
    public int busca1(Object elemento) {
        for (int i = 0; i < tamanho; i++) {
            if (elementos[i].equals(elemento)) {
                return i;
            }
        }
        return -1;
    }
```

#### Remover elemento via posição

O índice do elemento é acionado como parâmetro, removendo o elemento que estiver naquela posição:

``` java
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
```

#### Remover elemento via elemento

O nome do elemento é acionado como parâmetro, removendo o elemento que estiver naquela variável:

``` java
    public void removeConteudo (Object elemento) throws Exception {
        int posicao = this.busca1(elemento);
        this.busca(posicao);
        this.remove(posicao);
    }
```

### Divulgador.java

Nessa classe foram declarados os atributos dos divulgadores. Os atributos são todos de tipo `String` e armazenam textos relevantes para as ações de divulgação científica:

``` java
package divulgadoresCientificos;

// Classe divulgador armazena atributos úteis para divulgadores científicos na Internet.

public class Divulgador {
    private String nome;
    private String nomeCanal;
    private String linkLattes;
    private String areaEstudo;
    private String plataformaPrincipal;
    private String seguidores;
```

A IDE utilizada (IntelliJ), é capaz de adicionar automaticamente os construtores, getters, setters e conversores de dados em string para a classe. Abordando estes métodos, cada atributo pode ser chamado para se referenciar ao próprio objeto:

``` java
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
```

### Teste.java

Finalmente, o teste coloca alguns exemplos de divulgadores científicos reais como objetos:

``` java
public class Teste {
    public static void main(String[] args) throws  Exception {
        // Novo vetor. A capacidade só deve ser maior que zero. Os métodos em vetor já aumentam a capacidade conforme o número de elementos adicionados.
        Vetor vetor = new Vetor(1);

        // Divulgadores científicos e seus dados declarados.
        Divulgador divulgador1 = new Divulgador(
                "Atila Iamarino",
                "Atila Iamarino",
                "https://lattes.cnpq.br/4978322672579487",
                "Ciências Biológicas",
                "Youtube",
                "1,71 milhões"
        );

        Divulgador divulgador2 = new Divulgador(
                "Ana Bonassa",
                "Nunca vi 1 cientista",
                "https://lattes.cnpq.br/4947742884022371",
                "Fisiologia",
                "Youtube",
                "540 mil"
        );

        Divulgador divulgador3 = new Divulgador(
                "Laura Marise",
                "Nunca vi 1 cientista",
                "https://lattes.cnpq.br/2603023551856235",
                "Biociências e Biotecnologia Aplicadas à Farmácia",
                "Youtube",
                "540 mil"
        );

        Divulgador divulgador4 = new Divulgador(
                "Carlos Seraphim",
                "Endócrino e talks com Dr. Carlos Seraphim",
                "https://lattes.cnpq.br/3272685919486334",
                "Medicina; Endocrinologia",
                "Youtube",
                "109 mil"
        );

        Divulgador divulgador5 = new Divulgador(
                "Igor Eckert",
                "igoreckert",
                "https://lattes.cnpq.br/6630037564221555",
                "Nutrição; Estudos clínicos",
                "Instagram",
                "300 mil"
        );

        Divulgador divulgador6 = new Divulgador(
                "Altay de Souza",
                "Naruhodo",
                "https://lattes.cnpq.br/8948217221748469",
                "Psicologia Experimental",
                "Spotify",
                "19 mil"
        );

        Divulgador divulgador7 = new Divulgador(
                "Camila Laranjeira",
                "Peixe Babel",
                "https://lattes.cnpq.br/1641872523529515",
                "Ciências da Computação",
                "Youtube",
                "88,1 mil"
        );

        Divulgador divulgador8 = new Divulgador(
                "Virginia Mota",
                "Peixe Babel",
                "https://lattes.cnpq.br/3250170839435251",
                "Ciências da Computação",
                "Youtube",
                "88,1 mil"
        );

        Divulgador divulgador9 = new Divulgador(
                "Tito Aureliano",
                "Colecionadores de Ossos",
                "https://lattes.cnpq.br/3666297020355529",
                "Geopaleontologia",
                "Youtube",
                "76,5 mil"
        );

        Divulgador divulgador10 = new Divulgador(
                "Aline Ghilardi",
                "Colecionadores de Ossos",
                "https://lattes.cnpq.br/5761534317977568",
                "Paleoecologia",
                "Youtube",
                "76,5 mil"
        );
```

Todos os divulgadores foram adicionados ao vetor usando o método `adiciona()` criado na classe `Vetor.java`:

``` java
        vetor.adiciona(divulgador1);
        vetor.adiciona(divulgador2);
        vetor.adiciona(divulgador3);
        vetor.adiciona(divulgador4);
        vetor.adiciona(divulgador5);
        vetor.adiciona(divulgador6);
        vetor.adiciona(divulgador7);
        vetor.adiciona(divulgador8);
        vetor.adiciona(divulgador9);
```

Há, também, um divulgador falso. Esse objeto foi sujeito de testes de remoção e busca:

``` java

        Divulgador divulgador11 = new Divulgador(
                "Charlatão",
                "Pseudociência",
                "Falso",
                "Sofismas",
                "Falso",
                "500 milhões"
        );

        vetor.adiciona(divulgador11);

        System.out.println(vetor.busca(10));
        vetor.remove(10);

        // Adicionamos novamente para testar outro método...
        vetor.adiciona(divulgador11);

        // O de busca e remoção por conteúdo.

        System.out.println(vetor.busca1(divulgador11));

        vetor.removeConteudo(divulgador11);

        // Agora só estão os verdadeiros.
        System.out.println(vetor);

```

Agora, só sobraram os divulgadores verdadeiros. A lista pode ser ampliada sempre que desejarmos. Precisamos de mais divulgadores para combater a desinformação!
