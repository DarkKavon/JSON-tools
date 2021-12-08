package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FilterToDelete extends PrintJson {

    public FilterToDelete(String transforms, String[] set) {
        super(transforms, set);
    }

    public String returnResult() {
        ObjectNode obj = json.deepCopy();
        obj.remove(Arrays.asList(this.set));
        String prettyJson = obj.toPrettyString();
        //ResponseEntity<String> responseEntity = ResponseEntity.ok().body(prettyJson);
        return prettyJson;
    }
}
