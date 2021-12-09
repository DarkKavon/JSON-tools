package pl.put.poznan.transformer.logic;
/** Concrete Decorator
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */

public class PrettyPrint extends PrintJson {
    /**
     * Class to pretty print JSON
     * @param transforms input JSON string
     * @param set input filters array
     */
    public PrettyPrint(String transforms, String[] set) {
        super(transforms, set);
    }

    /**
     * Method return pretty formatted JSON string from input string
     * @return pretty formatted JSON string
     */
    public String returnResult() {
        String prettyJson = this.json.toPrettyString();
        return prettyJson;
    }

}
