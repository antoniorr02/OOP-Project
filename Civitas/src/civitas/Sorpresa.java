package civitas;

/**
 *
 * @author antonio
 */
public class Sorpresa {
    private String texto;
    private int valor;
    private TipoSorpresa tipo;
    private MazoSorpresa mazo; // Misma duda de su uso que en casilla.

    public Sorpresa(TipoSorpresa t, String text, int v) {
        texto = text;
        valor = v;
        tipo = t;
    }
}
