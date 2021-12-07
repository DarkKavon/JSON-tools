package pl.put.poznan.transformer.logic;

import org.springframework.http.ResponseEntity;

public class PrettyPrint extends PrintJson {

    public PrettyPrint(String transforms, String[] set) {
        super(transforms, set);
    }

    public ResponseEntity<String> prettyPrint() {
        String prettyJson = this.json.toPrettyString();
        ResponseEntity<String> responseEntity = ResponseEntity.ok().body(prettyJson);
        return responseEntity;
    }

}
