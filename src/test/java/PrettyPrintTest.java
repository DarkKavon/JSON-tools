import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.PrettyPrint;

public class PrettyPrintTest {
    
    private PrettyPrint prettyPrint;
    private ObjectMapper mapper;

    @BeforeEach
    private void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testReturnResultOK() {
        prettyPrint= new PrettyPrint("{\"id\":1,\"value\":\"test\"}", new String[] {});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1,\"value\":\"test\"}");
            resStr = resJson.toPrettyString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, prettyPrint.returnResult());
    } 

    @Test
    public void testReturnResultMock() {
        prettyPrint = mock(PrettyPrint.class);
        when(prettyPrint.returnResult()).thenReturn(new String());
    }

}
