package co.com.ceiba.parqueadero.paola.infraestructura.integracion;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.put;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import co.com.ceiba.parqueadero.paola.aplicacion.comando.ParqueaderoComando;
import co.com.ceiba.parqueadero.paola.infraestructura.controlador.ParqueaderoControlador;
import co.com.ceiba.parqueadero.paola.infraestructura.excepcion.ManejadorExcepcion;
import co.com.ceiba.parqueadero.paola.testdatabuilder.ParqueaderoComandoTestDataBuilder;

@SpringBootTest
@RunWith(SpringRunner.class)
public class ParqueaderoControladorTest {

	@Autowired
    private ManejadorExcepcion manejadorExcepcion;
	
    @Autowired
    private ParqueaderoControlador parqueaderoControlador;
    
    private MockMvc mockMvc;

    @Before
    public void setupMock() {
        mockMvc = MockMvcBuilders.standaloneSetup(parqueaderoControlador, manejadorExcepcion).build();
    }

    @Test
    public  void getListaTest() throws Exception{
        // Arrange , Act y Assert
      mockMvc.perform(get("/parqueadero").contentType(MediaType.APPLICATION_JSON)).andExpect(status().isOk());
    }

    @Test
    public void postIngresarVehiculoTest() throws Exception {
        // Arrange
        ParqueaderoComandoTestDataBuilder parqueaderoComandoTestDataBuilder = new ParqueaderoComandoTestDataBuilder();
        ParqueaderoComando parqueaderoComando = parqueaderoComandoTestDataBuilder.build();

        // Act y Assert
        mockMvc.perform(post("/parqueadero").contentType(MediaType.APPLICATION_JSON)
                .content(jsonToString(parqueaderoComando))).andExpect(status().isOk());

    }

    @Test
    public void putSalidaVehiculoTest() throws Exception{
        // Arrange
        String  licensePlate = "DXR423";
        // Act y Assert
        mockMvc.perform(put("/parqueadero/" + licensePlate).contentType(MediaType.APPLICATION_JSON))
                .andExpect(status().isOk());
    }


    private String jsonToString(ParqueaderoComando json) throws JsonProcessingException {
        return new ObjectMapper().writeValueAsString(json);
    }

}
