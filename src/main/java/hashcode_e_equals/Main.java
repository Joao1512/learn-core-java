package hashcode_e_equals;

public class Main {

    public static void main(String[] args) {
        Cliente c1 = new Cliente("joao", "2384975");
        Cliente c2 = new Cliente("joao", "2384975");

        if (c1.hashCode() == c2.hashCode()) {
            System.out.println(c1.equals(c2)); //equals é necessário, pois mesmo que os hashCodes sejam os mesmos, os objetos ainda podem ser diferenetes
        }
    }
}
