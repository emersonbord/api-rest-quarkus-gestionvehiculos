package recursos;

import java.util.List;

import entity.VehiculoEntity;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;


 //Para insertar datos en una BD se debe amrcar el endpoint como Transactional, en este caso está a nivel de clase, aplica para todos los endpoints
 @Path("/vehiculos")
 @Transactional
 public class VehiculoResource {
    //IMPLEMENTAMOS ENDPOINTSA



    @GET //Lista vehiculos
    public List<VehiculoEntity> index(){
        return VehiculoEntity.listAll();
    }

    @POST
    public VehiculoEntity insertar(VehiculoEntity inserteVehiculo){
        
        inserteVehiculo.persist();
        return inserteVehiculo;
    }
}
