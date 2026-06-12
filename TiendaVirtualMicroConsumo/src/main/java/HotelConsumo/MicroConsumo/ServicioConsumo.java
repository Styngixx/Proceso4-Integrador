package HotelConsumo.MicroConsumo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;

@Service
public class ServicioConsumo {
    
    @Autowired 
    private Repositorio r;

    public FichaConsumo registrarConsumo(FichaConsumo ficha) {
        // 1. Asignar fecha actual
        ficha.setFechaHora(LocalDateTime.now());
        
        // 2. Asignar ID (si la tabla está vacía, evita el null con COALESCE en el repositorio)
        Long maxId = r.findMaxId();
        ficha.setId(maxId + 1);

        // 3. Calcular importe total recorriendo la lista de servicios
        double total = 0;
        if (ficha.getServicios() != null) {
            for (ServicioAdquirido s : ficha.getServicios()) {
                total += s.getPrecio();
            }
        }
        ficha.setImporteTotal(total);

        // 4. Guardar
        return r.save(ficha);
    }
    
    public List<FichaConsumo> listar() { 
        return r.findAll(); 
    }
}