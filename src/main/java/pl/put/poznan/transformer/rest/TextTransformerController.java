package pl.put.poznan.transformer.rest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;
import pl.put.poznan.transformer.logic.TextTransformer;
import org.springframework.http.HttpHeaders;
import org.springframework.http.ResponseEntity;
import org.springframework.http.HttpStatus;

import java.util.Arrays;


@RestController
@RequestMapping("/{opId}_{text}")
public class TextTransformerController {

    private static final Logger logger = LoggerFactory.getLogger(TextTransformerController.class);

    @RequestMapping(method = RequestMethod.GET, produces = "application/json")
    public ResponseEntity<String> get(@PathVariable String text, @PathVariable int opId,
                              @RequestParam(value="transforms", defaultValue="upper,escape") String[] transforms,
                              @RequestParam(value="opId", defaultValue="1") int operationId) {

        // log the parameters
        logger.debug(text);
        logger.debug(String.valueOf(opId));
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(text);
        if (opId == 1) {
            return transformer.prettyPrint();
        }
        else if (opId == 2) {
            return transformer.minimize();
        }
        else {
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
        
        
    }

    @RequestMapping(method = RequestMethod.POST, produces = "application/json")
    public ResponseEntity<String> post(@PathVariable String text, @PathVariable int opId,
                      @RequestBody String[] transforms,
                      @RequestBody int operationId) {

        // log the parameters
        logger.debug(text);
        logger.debug(Arrays.toString(transforms));

        TextTransformer transformer = new TextTransformer(text);
        if (opId == 1) {
            return transformer.prettyPrint();
        }
        else if (opId == 2) {
            return transformer.minimize();
        }
        else {
            ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.BAD_REQUEST);
            return responseEntity;
        }
    }



}


