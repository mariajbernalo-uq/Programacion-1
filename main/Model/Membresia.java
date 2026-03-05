import java.util.List;

public class Membresia {
        private String tipo;
        private String fechaInicio;
        private String fechaFin;
        private double precio;

        private List<HistorialPagos> pagos = new ArrayList<>();

        public void registrarPago(HistorialPagos pago) {
            pagos.add(pago);
        }

        public List<HistorialPagos> getPagos() {
            return pagos;
        }


}
