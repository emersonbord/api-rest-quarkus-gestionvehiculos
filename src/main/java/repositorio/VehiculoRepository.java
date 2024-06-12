package repositorio;

import entity.VehiculoEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class VehiculoRepository implements PanacheRepository<VehiculoEntity>{
    
}
