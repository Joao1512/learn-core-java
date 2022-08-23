package abstract_factory;

public class EstiloEscuroFactory extends TemaFactory {
    @Override
    public Estilo CriarEstilo() {
        return new EstiloEscuro();
    }
}
