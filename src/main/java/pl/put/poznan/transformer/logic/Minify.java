package pl.put.poznan.transformer.logic;

import org.springframework.http.ResponseEntity;

public class Minify extends PrintJson {

    public Minify(String transforms, String[] set) {
        super(transforms, set);
    }

    public ResponseEntity<String> minify() {
        String minified = json.toString();
        ResponseEntity<String> responseEntity = ResponseEntity.ok().body(minified);
        return responseEntity;
    }

}
