package injecao_dependencia_exercicio;

public class TaxasServiceImpl implements TaxasService {
    private static final Double TAXA_SIMPLES_MENSAL = 0.01;
    private static final Double TAXA_TRANSACAO = 0.02;

    @Override
    public Double getTaxaSimplesMensal() {
        return TAXA_SIMPLES_MENSAL;
    }

    @Override
    public Double getTaxaTsansacao() {
        return TAXA_TRANSACAO;
    }
}
