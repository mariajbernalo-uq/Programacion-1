import java.util.List;

public class Entrenador {
    private String nombre;
    private String clase;
    private int cedula;

    private List<ClasesGrupales> listClaseGrupal;

    // Getters y Setters
    public Entrenador(String nombre, String clase, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.clase = clase;
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

    public List<ClasesGrupales> getListClaseGrupal() {
        return listClaseGrupal;
    }

    public void setListClaseGrupal(List<ClasesGrupales> listClaseGrupal) {
        this.listClaseGrupal = listClaseGrupal;
    }

    public ClaseGrupal consultarClasesEntenador{


    }
}