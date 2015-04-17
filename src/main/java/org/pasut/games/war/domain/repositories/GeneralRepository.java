package org.pasut.games.war.domain.repositories;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by marcelo on 17/04/15.
 */
@Component
public class GeneralRepository {
    private final CountryRepository countryRepo;

    @Autowired
    public GeneralRepository(CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }
}
