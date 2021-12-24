import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.FilterToDelete;

public class FilterToDeleteTest {

    private FilterToDelete filterToDelete;
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testReturnResultOK() {
        filterToDelete = new FilterToDelete("{\"id\":1,\"value\":\"test\"}", new String[] {"value"});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1}");
            resStr = resJson.toPrettyString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, filterToDelete.returnResult());
    }

    @Test
    public void testReturnResultErr1() {
        filterToDelete = new FilterToDelete("{\"id\":1,\"value\":\"test\"}", new String[] {"notInJSON"});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1,\"value\":\"test\"}");
            resStr = resJson.toPrettyString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, filterToDelete.returnResult());
    }

    @Test
    public void testReturnResultMock() {
        filterToDelete = mock(FilterToDelete.class);
        when(filterToDelete.returnResult()).thenReturn(new String());
    }
    
}
