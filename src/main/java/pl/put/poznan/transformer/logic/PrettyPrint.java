package pl.put.poznan.transformer.logic;

public class PrettyPrint extends PrintJson {

    public PrettyPrint(String transforms, String[] set) {
        super(transforms, set);
    }

    public String returnResult() {
        String prettyJson = this.json.toPrettyString();
        return prettyJson;
    }

}
