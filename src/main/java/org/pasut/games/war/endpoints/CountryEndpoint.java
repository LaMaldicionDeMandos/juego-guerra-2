package org.pasut.games.war.endpoints;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.services.CountryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Created by marcelo on 12/04/15.
 */
@RestController
@RequestMapping(value = "/country", produces = MediaType.APPLICATION_JSON_VALUE)
public class CountryEndpoint {
    private final CountryService service;

    @Autowired
    public CountryEndpoint(final CountryService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, params = {"code", "name", "pbi", "lat", "lon"})
    public Country add(@RequestParam final String code, @RequestParam final String name, @RequestParam final double pbi,
                       @RequestParam final double lat, @RequestParam final double lon) {
        final Country country = new Country(code, name, pbi, lat, lon);
        return service.newCountry(country);
    }

    @RequestMapping(value = "/code/{code}", method = RequestMethod.GET)
    public Country findByCode(@PathVariable final String code) {
        return service.findByCode(code);
    }
}
