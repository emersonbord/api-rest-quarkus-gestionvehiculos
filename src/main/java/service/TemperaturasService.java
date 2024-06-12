package service;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;

import bean.TemperaturaBean;
import jakarta.enterprise.context.ApplicationScoped;

//Contectamos este servicio con el recurso de TemperaturaResource con inyección de dependecias
@ApplicationScoped //Anotasción que señala a quarkus que esta clase la instancie
public class TemperaturasService {
    
    private List<TemperaturaBean> valores = new ArrayList<>();

    public void addTemperatua(TemperaturaBean t){
        valores.add(t);
    }

    public List<TemperaturaBean> obtenerTemperaturas(){
        return Collections.unmodifiableList(valores);
    }

    public boolean vacia(){
        return valores.isEmpty();
    }

    public int maxima(){
        return valores.stream().mapToInt(TemperaturaBean::getMaxima).max().getAsInt();
    }

    public Optional<TemperaturaBean> extraerTemperatura(String ciudad){
        return valores.stream()
        .filter(t -> t.getCiudad().equals(ciudad))
        .findAny();
    }

    
}
