package pl.put.poznan.transformer.logic;

public class Minify extends PrintJson {

    public Minify(String transforms, String[] set) {
        super(transforms, set);
    }

    public String returnResult() {
        String minified = json.toString();
        //ResponseEntity<String> responseEntity = ResponseEntity.ok().body(minified);
        return minified;
    }

}
