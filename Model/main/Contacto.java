import java.util.ArrayList;
import java.util.List;

public class Contacto {
    private String nombre;
    private String alias;
    private String direccion;
    private int telefono;
    private String email;

    private List<Reunion> listReunionesAAsistir;
    private List<Grupo> listGrupoContacto;

    //Constructor


    public Contacto(String nombre, String alias, String direccion, int telefono, String email) {
        this.nombre = nombre;
        this.alias = alias;
        this.direccion = direccion;
        this.telefono = telefono;
        this.email = email;
        this.listReunionesAAsistir = new ArrayList<>();
        this.listGrupoContacto =  new ArrayList<>();
    }

    public void agregarContacto(Grupo grupo){
        listGrupoContacto.add(grupo);
    }




    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getAlias() {
        return alias;
    }

    public void setAlias(String alias) {
        this.alias = alias;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public List<Reunion> getListReunionesAAsistir() {
        return listReunionesAAsistir;
    }

    public void setListReunionesAAsistir(List<Reunion> listReunionesAAsistir) {
        this.listReunionesAAsistir = listReunionesAAsistir;
    }

    public List<Grupo> getListGrupoContacto() {
        return listGrupoContacto;
    }

    public void setListGrupoContacto(List<Grupo> listGrupoContacto) {
        this.listGrupoContacto = listGrupoContacto;
    }
}
