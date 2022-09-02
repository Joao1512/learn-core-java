package injecao_dependencia_exercicio;

import java.time.LocalDate;

public class PaypalService implements PrestacaoService{
    TaxasService taxasService;

    public PaypalService(TaxasService taxasService) {
        this.taxasService = taxasService;
    };

    @Override
    public void calcularParcelas(Contract contract, int totalDeParcelas) {
        Long parcelaSemJuros = calcularParcelaSemJuros(contract, totalDeParcelas);
        for(int numeroDaParcela = 1; numeroDaParcela <= totalDeParcelas; numeroDaParcela++) {
            LocalDate dataProximaParcela = calcularDataProximaParcela(contract.getDate(), numeroDaParcela);
            Long totalDaParcela = acrescentarTaxaTransacao(acrescentarTaxaMensal(parcelaSemJuros, numeroDaParcela));
            salvarParcela(contract, dataProximaParcela, totalDaParcela);
        }
    }

    private Long calcularParcelaSemJuros(Contract contract, int parcelas) {
        return contract.getTotalValue() / parcelas;
    }

    private LocalDate calcularDataProximaParcela(LocalDate dataInicial, int numeroDaParcela) {
        return dataInicial.plusMonths(numeroDaParcela);
    }

    private Long acrescentarTaxaMensal(Long parcelaSemJuros, int numeroDaParcela) {
        double taxaMesAtual = taxasService.getTaxaSimplesMensal() * numeroDaParcela;
        double totalDeTaxaMensal = parcelaSemJuros * taxaMesAtual;
        String b = String.valueOf(parcelaSemJuros + totalDeTaxaMensal);
        Long a =  Long.getLong(String.valueOf(parcelaSemJuros + totalDeTaxaMensal));
        return new Double(parcelaSemJuros + totalDeTaxaMensal).longValue();
    }

    private Long acrescentarTaxaTransacao(Long parcelaComJurosMensal) {
        double totalDeTaxaTransacao = parcelaComJurosMensal * taxasService.getTaxaTsansacao();
        return new Double(parcelaComJurosMensal + totalDeTaxaTransacao).longValue();
    }

    private void imprimirParcela(LocalDate dataProximaParcela, Long totalDaParcela) {
        System.out.println(dataProximaParcela + " - " + "R$" + totalDaParcela);
    }
    private void salvarParcela(Contract contract, LocalDate dataProximaParcela, Long totalDaParcela) {
        contract.prestacoes.add(new Prestacao(dataProximaParcela, totalDaParcela));
    };
}
