import java.util.ArrayList;
import java.util.List;

public class Entrenador {
    private String nombre;
    private String clase;
    private int cedula;

    private List<ClaseGrupal> listClaseGrupal;

    // Getters y Setters
    public Entrenador(String nombre, String clase, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clase = clase;
        this.listClaseGrupal = new ArrayList<>();
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public List<ClaseGrupal> getListClaseGrupal() {
        return listClaseGrupal;
    }

    public void setListClaseGrupal(List<ClaseGrupal> listClaseGrupal) {
        this.listClaseGrupal = listClaseGrupal;
    }

}