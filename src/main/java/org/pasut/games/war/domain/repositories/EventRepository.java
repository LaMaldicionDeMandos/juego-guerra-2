package org.pasut.games.war.domain.repositories;

import org.pasut.games.war.domain.events.Event;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by marcelo on 17/04/15.
 */
@Repository
public interface EventRepository extends CrudRepository<Event, String> {
}
