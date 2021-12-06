package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

/**
 * This is just an example to show that the logic should be outside the REST
 * service.
 */
public class TextTransformer {

    private final String transforms;

    public TextTransformer(String transforms) {
        this.transforms = transforms;
    }

    public ResponseEntity<String> prettyPrint() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            String prettyJson = json.toPrettyString();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK).ok(prettyJson);
            return responseEntity;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

    public ResponseEntity<String> minimize() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            String minified = json.toString();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK).ok(minified);
            return responseEntity;
        } catch (JsonMappingException e) {
            e.printStackTrace();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        } catch (IOException e) {
            e.printStackTrace();
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

}
