package pl.put.poznan.transformer.logic;
/** Concrete Decorator
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */
public class Minify extends PrintJson {

    /**
     * Class used to minify JSON
     * @param transforms input JSON structure
     * @param set input filters array
     */

    public Minify(String transforms, String[] set) {
        super(transforms, set);
    }

    /**
     * Method returns minified input JSON
     * @return minified JSON
     */
    public String returnResult() {
        String minified = json.toString();
        return minified;
    }

}
