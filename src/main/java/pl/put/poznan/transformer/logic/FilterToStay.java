package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import com.fasterxml.jackson.databind.node.ObjectNode;

/** Concrete Decorator
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */
public class FilterToStay extends PrintJson {
    /**Concrete Decorator */

    public FilterToStay(String transforms, String[] set) {
        super(transforms, set);
    }

    /**
     * Method returns pretty formatted string only with keys from set
     * @return pretty formatted JSON only with keys from set
     */
    public String returnResult() {
        ObjectNode obj = json.deepCopy();
        obj.retain(Arrays.asList(this.set));
        String prettyJson = obj.toPrettyString();
        return prettyJson;
    }
}
