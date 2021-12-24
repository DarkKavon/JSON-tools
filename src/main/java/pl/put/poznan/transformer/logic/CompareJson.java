package pl.put.poznan.transformer.logic;

import java.io.IOException;
import com.flipkart.zjsonpatch.*;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

public class CompareJson extends PrintJson {
    
    private JsonNode jsonCmp;

    public CompareJson(String transforms, String[] set) {
        super(transforms, set);
    }

    public CompareJson(String transforms, String[] set, String compare) {
        super(transforms, set);
        ObjectMapper mapper = new ObjectMapper();
        try {
            this.jsonCmp = mapper.readTree(compare);
            logger.info("JSON parsed correctly.");
        } catch (JsonMappingException e) {
            e.printStackTrace();
            logger.error("Error in parsing. JSON structure must be incorrect.");
        } catch (IOException e) {
            e.printStackTrace();
            logger.error("Input/output error.");
        }
    }

    public String returnResult() {
        JsonNode patchNode = JsonDiff.asJson(this.json,this.jsonCmp);
        String diff = patchNode.toPrettyString();
        return "Operations needed to be made on 'transforms' to get 'compare':\n" + diff;
    }

}
