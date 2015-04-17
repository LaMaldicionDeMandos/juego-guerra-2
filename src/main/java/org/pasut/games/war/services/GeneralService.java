package org.pasut.games.war.services;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.domain.repositories.CountryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcelo on 17/04/15.
 */
@Service
public class GeneralService {
    private final CountryRepository countryRepo;

    @Autowired
    public GeneralService(final CountryRepository countryRepo) {
        this.countryRepo = countryRepo;
    }

    public Country findCountry(final String id) {
        return countryRepo.findOne(id);
    }
}
