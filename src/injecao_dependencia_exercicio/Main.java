package injecao_dependencia_exercicio;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Contract contract = new Contract(01L, LocalDate.now(), 600L);
        int totalParcelas = 3;
        PaypalService paypalService = new PaypalService(new TaxasServiceImpl());
        paypalService.calcularParcelas(contract, totalParcelas);
        System.out.println(contract.toString());
    }
}
