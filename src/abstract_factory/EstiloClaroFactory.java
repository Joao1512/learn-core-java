package abstract_factory;

public class EstiloClaroFactory extends TemaFactory{
    @Override
    public Estilo CriarEstilo() {
        return new EstiloClaro();
    }
}
