package listagem_com_set;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class ExercicioSet {


    public static void main(String[] args) {
        listagemHashSet();
//       listagemLinkedHashSet();
    }

    public static void listagemLinkedHashSet() {
      /*
        - a ordenação existe, e é por ordem de inserção. Insere sempre no final.
        - complexidade de 0(1) para operação básica.
      */
        LinkedHashSet<Pessoa> pessoas = new LinkedHashSet<Pessoa>();

        Pessoa p1 = new Pessoa(1.10);
        Pessoa p2 = new Pessoa(1.20);
        Pessoa p3 = new Pessoa(1.30);
        Pessoa p4 = new Pessoa(1.40);

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        pessoas.add(p4);


        for(Pessoa p: pessoas) {
            System.out.println(p.getAltura());
        }
        /*
        Console output:
        1.1
        1.2
        1.3
        1.4
        */
    }

    public static void listagemHashSet() {
        /*
        - no hashSet a listagem não tem ordem.
        - complexidade de O(1) pra inserção e remoção.
        - utilizar para priorizar a velocide em uma lista grande e quando a ordem não importar.
        */

        HashSet<Pessoa> pessoas = new HashSet<Pessoa>();

        Pessoa p1 = new Pessoa(1.79);
        Pessoa p2 = new Pessoa(1.65);
        Pessoa p3 = new Pessoa(1.90);
        Pessoa p4 = new Pessoa(1.50);

        pessoas.add(p1);
        pessoas.add(p2);
        pessoas.add(p3);
        pessoas.add(p4);

        Pessoa p5 = new Pessoa(1.50);

        if (pessoas.contains(p5)) {
           /*
            -para que o set consiga verificar se já contém este objeto na lista através de comparação,
            precisa implementar hashCode e equals na classe Pessoa.

            - caso não tenha hashCode e equals, compara pelo ponteiro do objeto, permitindo que eu insira um novo
            objeto com propriedades iguais a de um já presente na lista.

            */
            System.out.println("impossível inserir, já existe na lista um objeto com esse valor. ");
        }
        else {
            pessoas.add(p5);
        }

        for(Pessoa p: pessoas) {
            System.out.println(p.getAltura());
        }
       /*
        Console output:
        1.65
        1.5
        1.79
        1.9
       */
    }
}
