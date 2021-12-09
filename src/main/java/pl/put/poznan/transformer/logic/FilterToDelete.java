package pl.put.poznan.transformer.logic;

import java.util.Arrays;
import com.fasterxml.jackson.databind.node.ObjectNode;

/** Concrete Decorator
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */

public class FilterToDelete extends PrintJson {
    /**
     * Class filters JSON input using keys from set
     * @param transforms
     * @param set
     */

    public FilterToDelete(String transforms, String[] set) {
        super(transforms, set);
    }

    /**
     * Method returns JSON structure with keys from set deleted.
     * @return pretty printed JSON without values under keys from set
     */
    public String returnResult() {
        ObjectNode obj = json.deepCopy();
        obj.remove(Arrays.asList(this.set));
        String prettyJson = obj.toPrettyString();
        return prettyJson;
    }
}
