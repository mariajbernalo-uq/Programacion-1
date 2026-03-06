import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Membresia {
        private String tipo;
        private Date fechaInicio;
        private Date fechaFin;
        private double precio;

        private List<Socio> listSocios;

        public Membresia(String tipo, Date fechaInicio, Date fechaFin, double precio) {
                this.tipo = tipo;
                this.fechaInicio = fechaInicio;
                this.fechaFin = fechaFin;
                this.precio = precio;
        }



        // Membresia Activa
        public boolean isMembresiaActiva(){
                boolean centinela= false;
                Date fechaActual= new Date();
                if(fechaFin.after(fechaActual)){
                        centinela=true;
                }
                return centinela;
        }






        public String getTipo() {
                return tipo;
        }

        public void setTipo(String tipo) {
                this.tipo = tipo;
        }

        public Date getFechaInicio() {
                return fechaInicio;
        }

        public void setFechaInicio(Date fechaInicio) {
                this.fechaInicio = fechaInicio;
        }

        public Date getFechaFin() {
                return fechaFin;
        }

        public void setFechaFin(Date fechaFin) {
                this.fechaFin = fechaFin;
        }

        public double getPrecio() {
                return precio;
        }

        public void setPrecio(double precio) {
                this.precio = precio;
        }

        public List<Socio> getListSocios() {
                return listSocios;
        }

        public void setListSocios(List<Socio> listSocios) {
                this.listSocios = listSocios;
        }
}
