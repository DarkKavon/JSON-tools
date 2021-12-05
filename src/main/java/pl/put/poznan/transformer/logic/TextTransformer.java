package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import org.springframework.http.converter.json.Jackson2ObjectMapperBuilder;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;

/**
 * This is just an example to show that the logic should be outside the REST
 * service.
 */
public class TextTransformer {

    private final String transforms;

    public TextTransformer(String transforms) {
        this.transforms = transforms;
    }

    public String transform() {
        // of course, normally it would do something based on the transforms
        ObjectMapper mapper = new ObjectMapper();
        try {
            JsonNode json = mapper.readTree(this.transforms);
            System.out.println(json);
            String prettyJson = json.toPrettyString();
            return prettyJson;
        } catch (JsonMappingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        System.out.println(this.transforms);
        System.out.println(this.transforms);
        return this.transforms.toUpperCase();
    }

}
