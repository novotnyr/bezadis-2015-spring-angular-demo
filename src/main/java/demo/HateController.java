package demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

/**
 * Created by rn on 15.4.2015.
 */


@RestController
public class HateController {
    @Autowired
    private HateRepository hateRepository;

    @RequestMapping("/hates")
    public Iterable<Hate> list() {
        return hateRepository.findAll();
    }

    @RequestMapping(value = "/hates", method = RequestMethod.POST)
    @ResponseStatus(HttpStatus.CREATED)
    public void addHate(@RequestBody Hate hate) {
        hateRepository.save(hate);
    }
}
