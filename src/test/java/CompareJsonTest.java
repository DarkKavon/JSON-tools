import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import java.io.IOException;
import com.flipkart.zjsonpatch.*;

import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonMappingException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import pl.put.poznan.transformer.logic.CompareJson;

public class CompareJsonTest {

    private ObjectMapper mapper;
    private CompareJson compareJson;

    @BeforeEach
    public void setUp() {
        mapper = new ObjectMapper();
    }

    @Test
    public void testReturnResultOK() {
        compareJson = new CompareJson("{\"id:1\",\"value\":\"test\"}",new String[] {}, "{\"id:1\",\"value\":\"test1\"}");
        JsonNode patchNode = any(JsonNode.class);

        try {
            JsonNode json = mapper.readTree("\"id:1\",\"value\":\"test\"");
            JsonNode json1 = mapper.readTree("\"id:1\",\"value\":\"test1\"");
            patchNode = JsonDiff.asJson(json,json1);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String res = "Operations needed to be made on 'transforms' to get 'compare':\n" + patchNode.toPrettyString();

        assertEquals(res, compareJson.returnResult());
    }

    @Test
    public void testReturnResultOK2() {
        compareJson = new CompareJson("{\"id:1\",\"value\":\"test\",\"test1\":\"testtest\",\"value1\":123}",new String[] {}, "{\"id:1\",\"value\":\"test1\"}");
        JsonNode patchNode = any(JsonNode.class);

        try {
            JsonNode json = mapper.readTree("\"id:1\",\"value\":\"test\",\"test1\":\"testtest\",\"value1\":123");
            JsonNode json1 = mapper.readTree("\"id:1\",\"value\":\"test1\"");
            patchNode = JsonDiff.asJson(json,json1);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        String res = "Operations needed to be made on 'transforms' to get 'compare':\n" + patchNode.toPrettyString();

        assertEquals(res, compareJson.returnResult());
    }

    @Test
    public void testReturnResultMock() {
        compareJson = mock(CompareJson.class);
        when(compareJson.returnResult()).thenReturn(new String());
    }


}
