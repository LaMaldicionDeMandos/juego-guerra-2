package org.pasut.games.war.domain.repositories;

import org.pasut.games.war.domain.Country;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by marcelo on 17/04/15.
 */
@Repository
public interface CountryRepository extends CrudRepository<Country, String> {
}
