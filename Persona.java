
package expedientedelictivo;
    import java.util.ArrayList;
    import java.util.HashMap;
    import java.util.List;
    import java.util.Map;
/**
 *
 * @author betin
 */
public class Persona {
    private String nombre;
    private String direccion;
    private String edad;
    private String sexo;

    public Persona(String nombre, String direccion, String edad, String sexo) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.edad = edad;
        this.sexo = sexo;
                
    }

    public String getNombre() {
        return nombre;
    }

    public String getDireccion() {
        return direccion;
    }
    
    public String getEdad() {
        return edad;
    }
    
    public String getSexo() {
        return sexo;
    }
}
