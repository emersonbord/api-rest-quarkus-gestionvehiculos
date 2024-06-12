package excepciones;

import java.util.NoSuchElementException;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;

@Provider 
public class NoSuchElementExceptionMapper implements ExceptionMapper<NoSuchElementException>{

    public static record NoSuchElementMessage(String message, String detail){

    }

    @Override //Función mapper, recibe una expcepción y genera una respuesta, es un mapper, transforma la excepción en una respuesta
    public Response toResponse(NoSuchElementException e) {
        var error = new NoSuchElementMessage(e.getMessage(), null);
        return Response.status(404).entity(error).build();
    }
    
}
