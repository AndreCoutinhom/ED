# Gestão de Fila para Coleta de Sangue 🩸

O projeto requisita um sistema de gestão de filas para doação de sangue com algumas condições. O usuário deve ser capaz de realizar todas as ações do programa. Neste projeto, a interface utilizada é o próprio terminal.

No sistema de gestão deve ser possível gerar uma nova senha, remover uma senha, consultar as senhas já geradas e verificar qual a próxima senha que será chamada. Se tratando de uma fila, o projeto deve seguir o mecanismo FIFO (First In, First Out).

Um requisito específico do sistema condiciona a ordem em que as senhas são chamadas. Considerando que devem haver dois tipos de senha (preferencial e comum), a chamada das senhas deve priorizar três senhas preferenciais na frente de cada senha comum.

O projeto foi construído utilizando classes em Java. A lógica requerida pelo professor foi estruturada pelo estudante, com apoio técnico da LLM "Claude". Apesar da assistência da LLM, o raciocínio pelo estudante não foi perdido. Todo o código está comentado conforme a interpretação do código pelo estudante.

## Classes

O projeto é dividido em 3 classes: `EstruturaEstatica.java` (criada em aula), `Fila.java` (criada em aula) e `Teste.java` (criada pelo estudante durante a atividade). 

As classes criadas em aula foram replicadas conforme os códigos escritos abaixo:

### EstruturaEstatica.java

``` java
package coleta_sangue;

public class EstruturaEstatica<T> {
    public T[] elementos;
    public int tamanho;

    public EstruturaEstatica(int capacidade) {
        this.elementos = (T[]) new Object[capacidade];
        this.tamanho = 0;
    }

    public EstruturaEstatica() {
        this(10);
    }

    public boolean adiciona(T elemento) {
        this.aumentaCapacidade();
        this.elementos[this.tamanho] = elemento;
        this.tamanho++;
        return true;
    }

    public boolean adiciona(int posicao, T elemento) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        this.aumentaCapacidade();
        for (int i = this.tamanho - 1; i >= posicao; i--) {
            this.elementos[i + 1] = this.elementos[i];
        }
        this.elementos[posicao] = elemento;
        this.tamanho++;
        return true;
    }

    public void aumentaCapacidade() {
        if (this.tamanho == this.elementos.length) {
            T[] elementosNovos = (T[]) new Object[this.elementos.length * 2];
            for (int i = 0; i < this.elementos.length; i++) {
                elementosNovos[i] = this.elementos[i];
            }
            this.elementos = elementosNovos;
        }
    }

    public int tamanho() {
        return this.tamanho;
    }

    @Override
    public String toString() {
        StringBuilder s = new StringBuilder();
        s.append("[");

        for (int i = 0; i < this.tamanho - 1; i++) {
            s.append(this.elementos[i]);
            s.append(", ");
        }

        if (this.tamanho > 0) {
            s.append(this.elementos[this.tamanho - 1]);
        }

        s.append("]");

        return s.toString();
    }

    public boolean estaVazia() {
        return this.tamanho == 0;
    }

    public void remove(int posicao) {
        if (!(posicao >= 0 && posicao < tamanho)) {
            throw new IllegalArgumentException("Posição Inválida");
        }
        for (int i = posicao; i < tamanho - 1; i++) {
            elementos[i] = elementos[i + 1];
        }
        tamanho--;
    }
}

```

### Fila.java

``` java
package coleta_sangue;

public class Fila<T> extends EstruturaEstatica<T> {
    public Fila() {
        super();
    }

    public Fila(int capacidade) {
        super(capacidade);
    }

    public void enfileira(T elemento) {
        this.adiciona(elemento);
    }

    public T espiar() {
        if (this.estaVazia()) {
            return null;
        }
        return this.elementos[0];
    }

    public T desenfileira() {
        if (this.estaVazia()) {
            return null;
        }

        final int POS = 0;

        T elementoASerRemovida = this.elementos[POS];
        this.remove(POS);
        return elementoASerRemovida;
    }
}

```

### Teste.java

As partes comentadas do código são mensagens diretas para o professor que fez o requisito da atividade. Todos os detalhes da participação do Claude e raciocínio humano do estudante, incluindo os prompts criados, estão comentados pelo código funcional.

Versões anteriores do código, incluindo a estrutura montada pelo estudante em primeiras instâncias, também estão em longas sessões de comentário:

``` java
/*
Oi professor, quero deixar esse comentário aqui para esclarecer o que foi feito. Como eu não me senti
inteiramente apto a realizar a sua atividade por completo, eu pedi para o Claude me ajudar. Além disso,
eu optei por escrever o código usando duas filas diferentes. A lógica de usar uma única fila não estava
conseguindo entrar na minha cabeça. Com duas filas eu tinha pelo menos uma noção de como poderia ser feito.
Eu quero que fique registrado o ponto da lógica em que eu consegui desenvolver eu mesmo. O código abaixo,
e as classes Fila e EstruturaEstatica feitos em aula, fui eu mesmo que escrevi, e depois fiz requisições
ao Claude especificando quais métodos ele deveria usar.

O prompt que eu fiz ao Claude compartilhou os arquivos das classes e o meu código. Assim foi escrito o prompt:

PROMPT PARA O CLAUDE
-------------------------------

Preciso usar os métodos da classe Fila para que ambas filaComum e filaPreferencial sejam preenchidas com dados conforme o usuário os seleciona.

 As diferentes filas devem ser acionadas conforme a primeira opção do usuário para fila comum ou preferencial. À partir da linha 21 do arquivo 'Teste.java' estão organizadas as condições de digitação do usuário depois de selecionar o tipo de senha.

"1 - Solicitar nova senha" deve chamar o método 'enfileira()' e gerar uma senha aleatória.

"2 - Excluir uma senha" deve chamar o método 'remove()' e remover a senha escolhida.

"3 - Listar todas as senhas" deve chamar o método toString() para retornar uma array com todas as senhas da fila referida.

"4 - Ver quem é o próximo da fila" deve chamar o método 'espiar()' para retornar a próxima senha que será chamada.

-------------------------------

Depois eu pedi a ele para conseguir interagir com o código continuamente.

E eis o código que eu já havia escrito:
 */
/*
CÓDIGO FONTE ORIGINAL
-------------------------------

package coleta_sangue;

import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Fila<String> filaComum = new Fila<>();
        Fila<String> filaPreferencial = new Fila<>();

        // Estrutura básica para interação com usuário:

        Scanner scan = new Scanner(System.in);

        System.out.println("Boas vindas ao controle de senhas para coleta de sangue no Hospital Benossi! Que tipo de senha é a sua?:");
        System.out.println("1 - Comum");
        System.out.println("2 - Preferencial");

        String opcaoSelecionada = scan.nextLine();

        switch (opcaoSelecionada) {
            case "1":
                System.out.println("O que deseja fazer?:");
                System.out.println("1 - Solicitar nova senha");
                System.out.println("2 - Excluir uma senha");
                System.out.println("3 - Listar todas as senhas");
                System.out.println("4 - Ver quem é o próximo da fila");

                switch (opcaoSelecionada) {
                    case "1":
                        System.out.println("Solicitando nova senha");
                        break;
                    case "2":
                        System.out.println("Excluindo senha");
                        break;
                    case "3":
                        System.out.println("Retornando senhas");
                        filaComum.toString();
                        break;
                    case "4":
                        System.out.println("Retornando o próximo da fila");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                break;
            case "2":
                System.out.println("O que deseja fazer?:");
                System.out.println("1 - Solicitar nova senha");
                System.out.println("2 - Excluir uma senha");
                System.out.println("3 - Listar todas as senhas");
                System.out.println("4 - Ver quem é o próximo da fila");

                switch (opcaoSelecionada) {
                    case "1":
                        System.out.println("Solicitando nova senha");
                        break;
                    case "2":
                        System.out.println("Excluindo senha");
                        break;
                    case "3":
                        System.out.println("Retornando senhas");
                        filaPreferencial.toString();
                        break;
                    case "4":
                        System.out.println("Retornando o próximo da fila");
                        break;
                    default:
                        System.out.println("Opção inválida");
                }
                break;
        }
    }

}
-------------------------------

Enfim o Claude entrega o que está abaixo como primeira versão do código final.

*/
/* CÓDIGO FONTE FINAL V1
-------------------------------
package coleta_sangue;

import java.util.Random;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        Fila<String> filaComum = new Fila<>();
        Fila<String> filaPreferencial = new Fila<>();

        Scanner scan = new Scanner(System.in);
        Random random = new Random();

        System.out.println("Boas vindas ao controle de senhas para coleta de sangue no Hospital Benossi!");

        while (true) {

            // --- Escolha do tipo de fila ---
            System.out.println("\nQue tipo de senha é a sua?:");
            System.out.println("1 - Comum");
            System.out.println("2 - Preferencial");
            System.out.println("0 - Sair");

            String tipoFila = scan.nextLine();

            if (tipoFila.equals("0")) {
                System.out.println("Encerrando o sistema. Até logo!");
                break;
            }

            Fila<String> filaSelecionada;
            String prefixoSenha;

            switch (tipoFila) {
                case "1":
                    filaSelecionada = filaComum;
                    prefixoSenha = "C";
                    break;
                case "2":
                    filaSelecionada = filaPreferencial;
                    prefixoSenha = "P";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue; // volta ao início do while
            }

            // --- Escolha da ação ---
            System.out.println("\nO que deseja fazer?:");
            System.out.println("1 - Solicitar nova senha");
            System.out.println("2 - Excluir uma senha");
            System.out.println("3 - Listar todas as senhas");
            System.out.println("4 - Ver quem é o próximo da fila");

            String acao = scan.nextLine();

            switch (acao) {
                case "1":
                    String novaSenha = prefixoSenha + String.format("%03d", random.nextInt(900) + 100);
                    filaSelecionada.enfileira(novaSenha);
                    System.out.println("Nova senha gerada e adicionada à fila: " + novaSenha);
                    break;

                case "2":
                    if (filaSelecionada.estaVazia()) {
                        System.out.println("A fila está vazia. Nenhuma senha para excluir.");
                    } else {
                        System.out.println("Senhas na fila: " + filaSelecionada.toString());
                        System.out.print("Digite a posição da senha a ser removida (começando em 0): ");
                        try {
                            int posicao = Integer.parseInt(scan.nextLine());
                            filaSelecionada.remove(posicao);
                            System.out.println("Senha removida com sucesso.");
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida: digite um número inteiro.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Posição inválida: " + e.getMessage());
                        }
                    }
                    break;

                case "3":
                    if (filaSelecionada.estaVazia()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("Senhas na fila: " + filaSelecionada.toString());
                    }
                    break;

                case "4":
                    String proxima = filaSelecionada.espiar();
                    if (proxima == null) {
                        System.out.println("A fila está vazia. Não há próxima senha.");
                    } else {
                        System.out.println("Próxima senha da fila: " + proxima);
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } // fim do while

        scan.close();
    }
}

-------------------------------

O código gerado pelo Claude já foi testado e está funcionando. Agora só falta a regra de atendimento.
Um novo prompt para o Claude foi gerado aproveitando a lógica proposta e a devida ordem de atendimento:

PROMPT
-------------------------------
Agora eu quero uma nova opção no início. Mudando a primeira pergunta para "Qual sua ação?" e as duas primeiras opções para "Opções de senha Comum" e "Opções de senha preferencial". Deve haver uma opção "Gerar fila de senhas" que retorna uma array com todas as senhas de ambas as filas. As senhas deverão ser chamadas seguindo a seguinte ordem (Preferencial = P; Comum = C):



P -> P -> P -> C -> P -> P -> P -> C.............



Se não houver preferencial em seguida, chamar a comum mesmo.
-------------------------------

Finalmente, o Claude entrega a versão final do código fonte para o teste:
*/

package coleta_sangue;

import java.util.Random;
import java.util.Scanner;

public class Teste {
    public static void main(String[] args) {

        // As duas filas são criadas:
        Fila<String> filaComum = new Fila<>();
        Fila<String> filaPreferencial = new Fila<>();

        // Precisamos interepretar o que o usuário digita. Por isso...
        Scanner scan = new Scanner(System.in);

        // Também precisamos ser capazes de gerar códigos aleatórios para senhas. Por isso...
        Random random = new Random();

        // Hospitalidade básica :)
        System.out.println("Boas vindas ao controle de senhas para coleta de sangue no Hospital Benossi!");

        // Usamos o while para que o sistema só se encerre quando quisermos. Assim podemos trabalhar com as listas sem que o programe feche e reinicie.
        while (true) {

            // --- Menu principal ---
            System.out.println("\nQual sua ação?:");
            System.out.println("1 - Opções de senha Comum");
            System.out.println("2 - Opções de senha Preferencial");
            System.out.println("3 - Gerar fila de senhas");
            System.out.println("0 - Sair");

            // A variável acao recolhe tudo o que o usuário digitar.
            String acao = scan.nextLine();

            // --- Sair ---
            // A única condição que leva ao break do while:
            if (acao.equals("0")) {
                System.out.println("Encerrando o sistema. Até logo!");

                break;
            }

            // --- Gerar fila de senhas intercalada ---
            // Digitar "3" se refere a listar as senhas existentes.
            if (acao.equals("3")) {
                // Verifica se as filas estão vazias. Se estiverem, não há ação de listagem.
                if (filaComum.estaVazia() && filaPreferencial.estaVazia()) {
                    System.out.println("Ambas as filas estão vazias.");
                    continue;
                }

                // Monta a fila intercalada: P, P, P, C, P, P, P, C...
                // A cada 4 posições, a 4ª é sempre Comum. As 3 anteriores são Preferenciais.
                // Se não houver Preferencial disponível, chama Comum mesmo.

                // O Claude optou por criar uma nova fila:
                Fila<String> filaGerada = new Fila<>();

                // A variável de contador serve para contar quantas senhas preferenciais foram geradas...
                int contadorP = 0;

                while (!filaComum.estaVazia() || !filaPreferencial.estaVazia()) {

                    // ... e a condição ativa métodos da fila utilizando dados das outras filas criadas:
                    if (contadorP < 3) {
                        // Slot preferencial: tenta P, senão usa C
                        // Deve haver alguma conta preferencial...
                        if (!filaPreferencial.estaVazia()) {
                            // ... para que a nova filaGerada armazene o próximo valor da filaPreferencial.
                            filaGerada.enfileira(filaPreferencial.desenfileira());
                        } else {
                            // Se a filaPreferencial estiver vazia, a posição é preenchida com uma senha comum...
                            filaGerada.enfileira(filaComum.desenfileira());
                        }
                        //... e o contador é ativado. Tudo isso é condicionado ao contador ser menor que 3.
                        contadorP++;
                    } else {
                        // Slot comum (a cada 3 preferenciais, 1 comum)
                        if (!filaComum.estaVazia()) {
                            filaGerada.enfileira(filaComum.desenfileira());
                        } else {
                            filaGerada.enfileira(filaPreferencial.desenfileira());
                        }
                        contadorP = 0; // reinicia ciclo
                    }
                }

                System.out.println("Fila de atendimento gerada: " + filaGerada.toString());
                continue;
            }

            // O resto do código segue o fluxo da versão anterior, com vários cases para cada opção escolhida pelo usuário.

            // --- Opções de senha Comum ou Preferencial ---
            Fila<String> filaSelecionada;
            String prefixoSenha;

            switch (acao) {
                case "1":
                    filaSelecionada = filaComum;
                    prefixoSenha = "C";
                    break;
                case "2":
                    filaSelecionada = filaPreferencial;
                    prefixoSenha = "P";
                    break;
                default:
                    System.out.println("Opção inválida. Tente novamente.");
                    continue;
            }

            System.out.println("\nO que deseja fazer?:");
            System.out.println("1 - Solicitar nova senha");
            System.out.println("2 - Excluir uma senha");
            System.out.println("3 - Listar todas as senhas");
            System.out.println("4 - Ver quem é o próximo da fila");

            String subAcao = scan.nextLine();

            switch (subAcao) {
                case "1":
                    String novaSenha = prefixoSenha + String.format("%03d", random.nextInt(900) + 100);
                    filaSelecionada.enfileira(novaSenha);
                    System.out.println("Nova senha gerada e adicionada à fila: " + novaSenha);
                    break;

                case "2":
                    if (filaSelecionada.estaVazia()) {
                        System.out.println("A fila está vazia. Nenhuma senha para excluir.");
                    } else {
                        System.out.println("Senhas na fila: " + filaSelecionada.toString());
                        System.out.print("Digite a posição da senha a ser removida (começando em 0): ");
                        try {
                            int posicao = Integer.parseInt(scan.nextLine());
                            filaSelecionada.remove(posicao);
                            System.out.println("Senha removida com sucesso.");
                        } catch (NumberFormatException e) {
                            System.out.println("Posição inválida: digite um número inteiro.");
                        } catch (IllegalArgumentException e) {
                            System.out.println("Posição inválida: " + e.getMessage());
                        }
                    }
                    break;

                case "3":
                    if (filaSelecionada.estaVazia()) {
                        System.out.println("A fila está vazia.");
                    } else {
                        System.out.println("Senhas na fila: " + filaSelecionada.toString());
                    }
                    break;

                case "4":
                    String proxima = filaSelecionada.espiar();
                    if (proxima == null) {
                        System.out.println("A fila está vazia. Não há próxima senha.");
                    } else {
                        System.out.println("Próxima senha da fila: " + proxima);
                    }
                    break;

                default:
                    System.out.println("Opção inválida.");
            }

        } // fim do while

        scan.close();
    }
}


/*
Todo o código foi testado com todas as suas funções e está funcionando devidamente.

Minha maior dificuldade permanece em elaborar minha própria lógica.
Consigo fazer isso se me esforçar muito, mas com o tempo
disponível para entregar a atividade, eu optei pela praticidade.
Continuo sempre aprendendo e melhorando.

Aceito a nota que achar mais justo me oferecer. Obrigado!

*/
```
