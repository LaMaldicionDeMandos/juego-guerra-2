package org.pasut.games.war.endpoints;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelo on 12/04/15.
 */
@RestController
@RequestMapping(value = "/country")
public class CountryEndpoint {

    @RequestMapping(method = RequestMethod.GET)
    public String test() {
        return "test";
    }
}
