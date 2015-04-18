package org.pasut.games.war.domain.repositories;

import org.pasut.games.war.domain.Country;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by marcelo on 17/04/15.
 */
public interface CountryRepository extends CrudRepository<Country, String> {
    Country findByCode(final String code);
}
