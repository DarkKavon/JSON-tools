package pl.put.poznan.transformer.logic;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.JsonMappingException;
import java.io.IOException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/** Decorator
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */
public class PrintJson extends TextTransformer {

    protected JsonNode json;
    protected static final Logger logger = LoggerFactory.getLogger(PrintJson.class);

    /**
     * Class print JSON.
     * @param transforms input JSON string
     * @param set input filters array
     */

    public PrintJson(String transforms, String[] set) {
        /**
         * Constructor map input JSON string to JsonNode object
         */
        super(transforms, set);
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.json = mapper.readTree(transforms);
            logger.info("JSON parsed correctly.");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            logger.error("Error in parsing. JSON structure must be incorrect.");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Input/output error.");
        }
    }

    /**
     * Method returns minified JSON string
     * @return Minified JSON string
     */
    public String returnResult() {
        String simpleJson = this.json.toString();
        return simpleJson;
    }

}
