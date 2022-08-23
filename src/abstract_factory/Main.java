package abstract_factory;

public class Main {

    public static void main(String[] args) {
        TemaFactory estilo = montar("escuro");
        Tema tema = new Tema();
        tema.setEstilo(estilo.CriarEstilo());
        System.out.println(tema.getEstilo().cor);
    }

    public static TemaFactory montar(String tipo) {
        TemaFactory temaFactory = null;
        switch (tipo) {
            case "claro":
                temaFactory = new EstiloClaroFactory();
                break;
            case "escuro":
                temaFactory = new EstiloEscuroFactory();
                break;
        }
        return temaFactory;
    }
}
