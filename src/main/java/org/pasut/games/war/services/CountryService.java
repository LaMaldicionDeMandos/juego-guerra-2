package org.pasut.games.war.services;

import org.pasut.games.war.domain.Country;

/**
 * Created by marcelo on 17/04/15.
 */
public interface CountryService {
    Country newCountry(Country country);
    Country findByCode(String code);
}
