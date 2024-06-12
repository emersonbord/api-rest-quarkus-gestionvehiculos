package recursos;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.QueryParam;

//ESTA CLASE (RECURSO )RECIBE INFO DESDE EXTERIORde URL, ENVIAR DATOS Y LA API LO PROCESA
@Path("/informacion")
public class EcoExteriorResource {
    
    @GET //http://localhost:8080/informacion?mensaje=Probando mensaje
    public String saludar(@QueryParam("mensaje") String mensaje){
        if (mensaje ==null){
            return "Escriba un mensaje en la URL, como por ejemplo: http://localhost:8080/informacion?mensaje=Escriba su mensaje aquí";
        }else{
            return "->" + mensaje;
        }
    }

    @GET
    @Path("/{nombre}") //Ruta en donde si se le pasa entre las {} cualquier cosa, reacciona a este endpoint, a este método
    public String nombreParam(@PathParam("nombre") String nombre){
        return "Hola, " + nombre;
    }

    @GET
    @Path("/{nombre}/mayusculas") //Ruta en donde si se le pasa entre las {} cualquier cosa, reacciona a este endpoint, a este método
    public String nombreMayuscula(@PathParam("nombre") String nombre){
        return "HOLA, " + nombre.toUpperCase();
    }
}
