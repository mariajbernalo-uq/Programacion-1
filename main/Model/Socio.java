import java.util.ArrayList;
import java.util.List;

public class Socio {
    private String nombre;
    private int cedula;
    private Membresia themembresia;
    private List<HistorialPagos> listHistorialPagos;

    public Socio(String nombre, int cedula) {
        this.nombre = nombre;
        this.cedula = cedula;
        this.listHistorialPagos= new ArrayList<>();
    }

    public void registrarPago(HistorialPagos pago){
        listHistorialPagos.add(pago);
    }

    public List<HistorialPagos> getListHistorialPagos(){
        return listHistorialPagos;
    }

    public int getCedula() {
        return cedula;
    }

    public void setCedula(int cedula) {
        this.cedula = cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Membresia getThemembresia() {
        return themembresia;
    }

    public void setThemembresia(Membresia themembresia) {
        this.themembresia = themembresia;
    }

    public void setListHistorialPagos(List<HistorialPagos> listHistorialPagos) {
        this.listHistorialPagos = listHistorialPagos;
    }

}
