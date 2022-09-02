package operador_bitwise;

public class BitWise {

    public static void main(String[] args) {
        // converte meu numeroTestar em binario e compara bit a bit com o binario usado na máscara.
        // se o bit 1 estiver no mesmo índice, tanto na mascara quanto no numero a testar, retorna true.
        int mascara = 0b1000;
        int numeroTestar = 8;
        if ((numeroTestar & mascara) != 0) {
            System.out.println("4th bit is true");
        }
        else {
            System.out.println("4th bit is false");
        }
    }
}
