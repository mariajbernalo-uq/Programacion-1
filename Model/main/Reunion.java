import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Reunion {
    private String descripcion;
    private Date fecha;
    private Time hora;
    private String categoria;

    private List<Contacto> listContactosReunion;

    public Reunion(String descripcion, Date fecha, Time hora, String categoria) {
        this.descripcion = descripcion;
        this.fecha = fecha;
        this.hora = hora;
        this.categoria = categoria;
        this.listContactosReunion = new ArrayList<>();
    }
    //Añadir la lista de contactos a una reunión
    public void anadirContactosReunion(Contacto c){
        listContactosReunion.add(c);
    }

    //Verificar que un contacto no esté duplicado
    public boolean verificarDuplicadoContactoReunion(Contacto c){
        boolean bandera= false;
        if (listContactosReunion.contains(c)) {
            bandera=true;
        }
        return bandera;
    }


    //Getters y Setters

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Time getHora() {
        return hora;
    }

    public void setHora(Time hora) {
        this.hora = hora;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Contacto> getListContactosReunion() {
        return listContactosReunion;
    }

    public void setListContactosReunion(List<Contacto> listContactosReunion) {
        this.listContactosReunion = listContactosReunion;
    }
}
