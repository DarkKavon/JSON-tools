import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.PrintJson;

public class PrintJsonTest {

    private ObjectMapper mapper;
    private PrintJson printJson;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testReturnResultOK() {
        printJson = new PrintJson("{\"id\":1,\"value\":\"test\"}", new String[] {});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1,\"value\":\"test\"}");
            resStr = resJson.toString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, printJson.returnResult());
    }
    
    @Test
    public void testReturnResult() {
        printJson = mock(PrintJson.class);

        when(printJson.returnResult()).thenReturn(new String());

    }

}
