package recursos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;

@Path("/saludar") //anotación que indica a quarkus que esta clase está conectada a una página del servidor con al ruta parámetro "saludar"
public class EcoResource { //Conectamos esta clase con el parámetro saludar

    @GET
    public String principal(){
        return "Este es el método principal";
    }

    @GET //Con get invocamos al método saludar
    @Path("/probar") 
    public String probarEndpoint(){
        return "Probando endpoint";
    }

    @GET
    @Path("/dias") 
    public String saludar(){
        return "Buen día";
    }
}
