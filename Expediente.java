
package expedientedelictivo;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
/**
 *
 * @author betin
 */
public class Expediente {
    private List<Delito> delitos = new ArrayList<>();
    private Persona denunciante;
    private Persona denunciado;

    public void agregarDelito(Delito delito) {
        delitos.add(delito);
    }

    public void setDenunciante(Persona denunciante) {
        this.denunciante = denunciante;
    }

    public void setDenunciado(Persona denunciado) {
        this.denunciado = denunciado;
    }

}
