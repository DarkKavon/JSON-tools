package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

import pl.put.poznan.transformer.logic.FilterToDelete;
import pl.put.poznan.transformer.logic.FilterToStay;
import pl.put.poznan.transformer.logic.Minify;
import pl.put.poznan.transformer.logic.PrettyPrint;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;
import java.util.Arrays;

@RestController
@RequestMapping("/json-tools")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> get(
            @RequestParam(value = "transforms", defaultValue = "{}") String transforms,
            @RequestParam(value = "opId", defaultValue = "1") int operationId,
            @RequestParam(value = "set", defaultValue = "") String[] set) {

        // log the parameters
        logger.debug(transforms);
        logger.debug(String.valueOf(operationId));
        logger.debug(Arrays.toString(set));
        
        if (operationId == 1) {
            PrettyPrint pp = new PrettyPrint(transforms, set);
            return pp.prettyPrint();
        } else if (operationId == 2) {
            Minify min = new Minify(transforms, set);
            return min.minify();
        } else if (operationId == 3) {
            FilterToDelete ftd = new FilterToDelete(transforms, set);
            return ftd.filterToDelete();
        } else if (operationId == 4) {
            FilterToStay fts = new FilterToStay(transforms, set);
            return fts.filterToStay();
        } else {
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }

    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> post(
            @RequestBody String transforms,
            @RequestBody int operationId,
            @RequestBody String[] set) {

        // log the parameters
        logger.debug(transforms);
        logger.debug(String.valueOf(operationId));
        logger.debug(Arrays.toString(set));

        if (operationId == 1) {
            PrettyPrint pp = new PrettyPrint(transforms, set);
            return pp.prettyPrint();
        } else if (operationId == 2) {
            Minify min = new Minify(transforms, set);
            return min.minify();
        } else if (operationId == 3) {
            FilterToDelete ftd = new FilterToDelete(transforms, set);
            return ftd.filterToDelete();
        } else if (operationId == 4) {
            FilterToStay fts = new FilterToStay(transforms, set);
            return fts.filterToStay();
        } else {
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }

}
