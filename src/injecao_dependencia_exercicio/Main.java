package injecao_dependencia_exercicio;

import java.time.LocalDate;

public class Main {

    public static void main(String[] args) {
        Contract contract = new Contract(01L, LocalDate.now(), 600L);
        int totalParcelas = 3;
//        A linha abaixo é uma injeção da dependência TaxasServiceImpl dentro do serviço PaypalService.
//        A vantagem é diminuir o o acoplamento entre os serviços, caso tenha que mudar TaxasServiceImpl para outra classe, basta alterar este ponto do código
//        Uma interface foi utilizada, permitindo injetar em  PaypalService qualquer classe que implemente TaxasService
        PaypalService paypalService = new PaypalService(new TaxasServiceImpl());
        paypalService.calcularParcelas(contract, totalParcelas);
        System.out.println(contract.toString());
    }
}
