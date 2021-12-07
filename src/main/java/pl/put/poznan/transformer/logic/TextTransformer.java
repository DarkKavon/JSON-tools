package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.node.ObjectNode;
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
    private final String[] set;

    public TextTransformer(String transforms, String[] set) {
        this.transforms = transforms;
        this.set = set;
    }

    public ResponseEntity<String> prettyPrint() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            String prettyJson = json.toPrettyString();
            ResponseEntity<String> responseEntity = ResponseEntity.ok().body(prettyJson);
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

    public ResponseEntity<String> minify() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            String minified = json.toString();
            ResponseEntity<String> responseEntity = ResponseEntity.ok().body(minified);
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


    public ResponseEntity<String> filterToDelete() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            ObjectNode obj = json.deepCopy();
            obj.remove(Arrays.asList(this.set));
            String prettyJson = obj.toPrettyString();
            ResponseEntity<String> responseEntity = ResponseEntity.ok().body(prettyJson);
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


    public ResponseEntity<String> filterToStay() {
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            ObjectNode obj = json.deepCopy();
            obj.retain(Arrays.asList(this.set));
            String prettyJson = obj.toPrettyString();
            ResponseEntity<String> responseEntity = ResponseEntity.ok().body(prettyJson);
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
