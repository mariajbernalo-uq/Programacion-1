import java.util.ArrayList;
import java.util.List;

public class Grupo {
    private String nombre;
    private String categoria;
    private List<Contacto> listContactosGrupo;


    public Grupo (String nombre, String categoria){
        this.nombre= nombre;
        this.categoria= categoria;
        this.listContactosGrupo= new ArrayList<>();
    }
//Añadir un contacto a un grupo
    public void anadirContactoGrupo(Contacto c){
        listContactosGrupo.add(c);
    }
    // Verificar si un contacto ya está en un grupo
    public boolean estaContactoEnGrupo(Contacto c){
        boolean bandera= false;
        if (listContactosGrupo.contains(c)){
            bandera= true;
        }
        return bandera;
    }



    //Getters y Setters

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public List<Contacto> getListContactosGrupo() {
        return listContactosGrupo;
    }

    public void setListContactosGrupo(List<Contacto> listContactosGrupo) {
        this.listContactosGrupo = listContactosGrupo;
    }
}
