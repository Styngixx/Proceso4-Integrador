package HotelConsumo.MicroConsumo;

import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@JsonPropertyOrder({ "id", "empleado", "carrito", "servicios", "importeTotal", "fechaHora" })
public class FichaConsumo {
    @Id private Long id;
    @Embedded private Empleado empleado;
    @Embedded private Carrito carrito;
    
    @OneToMany(cascade = CascadeType.ALL)
    @JoinColumn(name = "ficha_id")
    private List<ServicioAdquirido> servicios;

    private double importeTotal;
    private LocalDateTime fechaHora;

    public FichaConsumo() {}
    // Getters y Setters...
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Empleado getEmpleado() { return empleado; }
    public void setEmpleado(Empleado empleado) { this.empleado = empleado; }
    public List<ServicioAdquirido> getServicios() { return servicios; }
    public void setServicios(List<ServicioAdquirido> servicios) { this.servicios = servicios; }
    public Carrito getCarrito() { return carrito; }
    public void setCarrito(Carrito carrito) { this.carrito = carrito; }
    public double getImporteTotal() { return importeTotal; }
    public void setImporteTotal(double importeTotal) { this.importeTotal = importeTotal; }
    public LocalDateTime getFechaHora() { return fechaHora; }
    public void setFechaHora(LocalDateTime fechaHora) { this.fechaHora = fechaHora; }
}