package listagem_com_set;

import java.util.Objects;

public class Pessoa {
    private Double altura;

    public Pessoa(Double altura) {
        this.altura = altura;
    }

    public Double getAltura() {
        return altura;
    }

    public void setAltura(Double altura) {
        this.altura = altura;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Pessoa pessoa = (Pessoa) o;
        return Objects.equals(altura, pessoa.altura);
    }

    @Override
    public int hashCode() {
        return Objects.hash(altura);
    }
}
