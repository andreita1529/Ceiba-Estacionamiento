package co.com.ceiba.parqueadero.paola.infraestructura.excepcion;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import co.com.ceiba.parqueadero.paola.dominio.excepcion.*;

import java.util.concurrent.ConcurrentHashMap;

@ControllerAdvice
public class ManejadorExcepcion {

    private static final Logger LOGGER = LoggerFactory.getLogger(ManejadorExcepcion.class);
    private static final String OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR = "Ocurrio un error, favor contactar al administrador.";
    private static final ConcurrentHashMap<String, Integer> CODIGOS_ESTADO = new ConcurrentHashMap<>();

    public ManejadorExcepcion(){
        CODIGOS_ESTADO.put(ExcepcionObligatorio.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionRegistroDuplicado.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionLetraPlaca.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionTipoVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionNoCupo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionNoExisteVehiculo.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
        CODIGOS_ESTADO.put(ExcepcionNoSeActualiza.class.getSimpleName(), HttpStatus.BAD_REQUEST.value());
    }

    @ExceptionHandler(Exception.class)
    public final ResponseEntity<ExcepcionInfraestructura> handleAllExceptions(ExcepcionInfraestructura excepcion) {
        ResponseEntity<ExcepcionInfraestructura> response;

        String nombre = excepcion.getClass().getSimpleName();
        String mensaje = excepcion.getMensaje();
        Integer code = CODIGOS_ESTADO.get(nombre);

        if (code != null) {
        	ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, mensaje);
            response = new ResponseEntity<>(error, HttpStatus.valueOf(code));
        } else {
            LOGGER .error(nombre, excepcion);
            ExcepcionInfraestructura error = new ExcepcionInfraestructura(nombre, OCURRIO_UN_ERROR_FAVOR_CONTACTAR_AL_ADMINISTRADOR);
            response = new ResponseEntity<>(error, HttpStatus.INTERNAL_SERVER_ERROR);
        }

        return response;
    }
}
