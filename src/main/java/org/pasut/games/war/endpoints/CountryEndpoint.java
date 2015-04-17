package org.pasut.games.war.endpoints;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by marcelo on 12/04/15.
 */
@RestController
@RequestMapping(value = "/country")
public class CountryEndpoint {
    private final CountryService service;

    @Autowired
    public CountryEndpoint(final CountryService service) {
        this.service = service;
    }
    @RequestMapping(method = RequestMethod.POST)
    public Country add(@RequestBody final Country country) {
        return service.newCountry(country);
    }
}
