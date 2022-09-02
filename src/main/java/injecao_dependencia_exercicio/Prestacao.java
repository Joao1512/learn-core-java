package injecao_dependencia_exercicio;

import java.time.LocalDate;

public class Prestacao {
    private LocalDate vencimento;
    private Long amount;

    public Prestacao(LocalDate vencimento, Long amount) {
        this.vencimento = vencimento;
        this.amount = amount;
    }

    public LocalDate getVencimento() {
        return vencimento;
    }

    public void setVencimento(LocalDate vencimento) {
        this.vencimento = vencimento;
    }

    public Long getAmount() {
        return amount;
    }

    public void setAmount(Long amount) {
        this.amount = amount;
    }
}
