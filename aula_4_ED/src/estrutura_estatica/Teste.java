package estrutura_estatica;

// Exemplo de modelagem com pilha usando API.
import java.util.Stack;

public class Teste {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<Integer>();

        System.out.println(stack.isEmpty());


        for (int i = 0; i <= 3; i++) {
            stack.push(i);
        }

        System.out.println(stack.size());

        System.out.println(stack);

    }
}
