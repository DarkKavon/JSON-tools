package pl.put.poznan.transformer.logic;
/** Component
 * @author Kacper Wandel
 * @author Bartosz Pietrowiak
 * @author Michał Olszewski
 * @version 1.0
 */
public class TextTransformer {

    protected final String transforms;
    protected final String[] set;
    /**
     * Create TextTransformer
     * @param transforms input JSON string
     * @param set input filters array
     */

    public TextTransformer(String transforms, String[] set) {
        /** Set parameters from input */
        this.transforms = transforms;
        this.set = set;
    }

}
