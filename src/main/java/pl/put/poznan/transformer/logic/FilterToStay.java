package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import com.fasterxml.jackson.databind.node.ObjectNode;

public class FilterToStay extends PrintJson {

    public FilterToStay(String transforms, String[] set) {
        super(transforms, set);
    }

    public String returnResult() {
        ObjectNode obj = json.deepCopy();
        obj.retain(Arrays.asList(this.set));
        String prettyJson = obj.toPrettyString();
        return prettyJson;
    }
}
