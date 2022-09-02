package injecao_dependencia_exercicio;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Contract {
    private Long number;
    private LocalDate date;
    private Long totalValue;

    List<Prestacao> prestacoes = new ArrayList<Prestacao>();

    public Contract(Long number, LocalDate date, Long totalValue) {
        this.number = number;
        this.date = date;
        this.totalValue = totalValue;
    }

    public Long getNumber() {
        return number;
    }

    public void setNumber(Long number) {
        this.number = number;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Long getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(Long totalValue) {
        this.totalValue = totalValue;
    }

    public List<Prestacao> getPrestacoes(){
        return this.prestacoes;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        String contract = "Contract{" +
                "number=" + number +
                ", date=" + date +
                ", totalValue=" + totalValue +
                '}';
        sb.append(contract);
        sb.append("\n");
        prestacoes.forEach(prestacao -> {
            sb.append(prestacao.getVencimento() + " - " + prestacao.getAmount() + "\n");
        });
        return sb.toString();
    }
}
