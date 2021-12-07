package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import org.springframework.http.ResponseEntity;

public class PrintJson extends TextTransformer {

    protected JsonNode json;

    public PrintJson(String transforms, String[] set) {
        super(transforms, set);
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.json = mapper.readTree(transforms);
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ResponseEntity<String> simplePrint() {
        String simpleJson = this.json.toString();
        ResponseEntity<String> responseEntity = ResponseEntity.ok().body(simpleJson);
        return responseEntity;
    }

}
