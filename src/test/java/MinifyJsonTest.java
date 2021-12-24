import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.Minify;

public class MinifyJsonTest {
    private ObjectMapper mapper;
    private Minify minify;
    
    @BeforeEach
    private void setUp() {
        mapper = new ObjectMapper();
    }
    
    @Test
    public void testReturnResultOK() {
        minify = new Minify("{\"id\":1,\"value\":\"test\"}", new String[] {});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1,\"value\":\"test\"}");
            resStr = resJson.toString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, minify.returnResult());
    } 
    
}
