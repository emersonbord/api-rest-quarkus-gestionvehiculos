package recursos;

import java.util.List;
import java.util.NoSuchElementException;

import bean.TemperaturaBean;
import jakarta.inject.Inject;
import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.PathParam;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import jakarta.ws.rs.core.Response;
import service.TemperaturasService;

@Path("/temperatura") //Recurso que devuelve un Json
public class TemperaturaResource {
    
    //Instancia de TemperaturaService
    private TemperaturasService temperaturas;
    
    @Inject
    public TemperaturaResource(TemperaturasService temperaturas){
        this.temperaturas = temperaturas;
    }

    //private List<TemperaturaBean> valores = new ArrayList<>();
    @POST //Acepta información
    @Produces(MediaType.APPLICATION_JSON)
    public TemperaturaBean agregarTemperatura(TemperaturaBean temp){ //parametro del tipo temperatura, este método devuelve TemperaturaBean
        //Al visitar este endpoint "http://localhost:8080/temperatura", se castea y convierta el body que le proporcionamos (info desde postman) a un objeto del tipo temperatura
        temperaturas.addTemperatua(temp);
        return temp;
        
        //valores.add(temp);
        //return temp;
       
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) //Harcodeamos un JSON con la constante APPLICATION_JSON
    public List<TemperaturaBean> List(){
        return temperaturas.obtenerTemperaturas();
        //return Collections.unmodifiableList(valores); //Devuelve una copia de la lectura valores y no valores estáticos como el código comentado de abajo
        /*return Arrays.asList(
        new TemperaturaBean("Santiago", 9, 14),
        new TemperaturaBean("Cauquenes", 11, 13 )
        ); */
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON) //Harcodeamos un JSON con la constante APPLICATION_JSON
    @Path("/tiempo")
    public TemperaturaBean medicion(){
        return new TemperaturaBean("Santiago", 9, 14);
    }

    @GET
    @Path("/maxima")
    @Produces(MediaType.TEXT_PLAIN)
    public Response maxima(){ //Response, respuesta HTTP
       if(temperaturas.vacia()){
        return Response.status(404).entity("No existen temperaturas").build();
       }else{
        int temperaMaxima = temperaturas.maxima(); 
        return Response.ok(Integer.toString(temperaMaxima)).build();
       }

    }

    @GET
    @Path("{ciudad}")
    @Produces(MediaType.APPLICATION_JSON)
    public TemperaturaBean extraer(@PathParam("ciudad") String ciudad){
        return temperaturas.extraerTemperatura(ciudad)
        .orElseThrow(() ->
        new NoSuchElementException("No hay registro para la ciudad: " + ciudad));
    }
}
