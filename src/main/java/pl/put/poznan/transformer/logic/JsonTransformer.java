package pl.put.poznan.transformer.logic;
/** Concrete Component
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */

public class JsonTransformer extends TextTransformer {
    /**
     * Concrete component
     * @param transforms input JSON string
     * @param set input filters array
     */

    public JsonTransformer(String transforms, String[] set) {
        super(transforms, set);
    }
}
