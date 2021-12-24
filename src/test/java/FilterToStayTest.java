import static org.junit.jupiter.api.Assertions.assertEquals;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.FilterToStay;

public class FilterToStayTest {
    private FilterToStay filterToStay;
    private ObjectMapper mapper;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testReturnResultOK() {
        filterToStay = new FilterToStay("{\"id\":1,\"value\":\"test\"}", new String[] {"id"});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{\"id\":1}");
            resStr = resJson.toPrettyString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, filterToStay.returnResult());
    }

    @Test
    public void testReturnResultErr1() {
        filterToStay = new FilterToStay("{\"id\":1,\"value\":\"test\"}", new String[] {"notInJSON"});
        String resStr = "";
        try {
            JsonNode resJson = mapper.readTree("{}");
            resStr = resJson.toPrettyString();
        } catch(JsonMappingException e) {
            e.printStackTrace();
        } catch(JsonProcessingException e) {
            e.printStackTrace();
        }
        assertEquals(resStr, filterToStay.returnResult());
    }
}
