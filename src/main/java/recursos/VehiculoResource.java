package recursos;

import java.util.List;
import java.util.NoSuchElementException;

import entity.VehiculoEntity;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.DELETE;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import repositorio.VehiculoRepository;


 //Para insertar datos en una BD se debe amrcar el endpoint como Transactional, en este caso está a nivel de clase, aplica para todos los endpoints
 @Path("/vehiculos")
 @Transactional
 public class VehiculoResource {
    //IMPLEMENTAMOS ENDPOINTSA

    @Inject
    private VehiculoRepository vehiculosRepository;

    @GET //Lista vehiculos
    public List<VehiculoEntity> index(){
        return VehiculoEntity.listAll();
    }

    @POST
    public VehiculoEntity insertar(VehiculoEntity inserteVehiculo){
        
        inserteVehiculo.persist();
        return inserteVehiculo;
    }

    @GET
    @Path("{id}")
    public VehiculoEntity obtenerVehiculo(@PathParam("id") Long id){
        var vehi = vehiculosRepository.findById(id);
        if (vehi != null) {
            return vehi;
        }
        throw new NoSuchElementException("No existen vehículos con el ID "+id);
    }

    @DELETE
    @Path("{id}")
    public void eliminar(@PathParam("id") Long id){
        vehiculosRepository.deleteById(id);
        
    }

    
}
