package org.pasut.games.war.services;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.domain.actuators.AsignBudgetEventActuator;
import org.pasut.games.war.domain.events.Event;
import org.pasut.games.war.domain.repositories.CountryRepository;
import org.pasut.games.war.domain.repositories.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Created by marcelo on 17/04/15.
 */

@Service
public class CountryServiceImpl implements CountryService {
    private final CountryRepository repo;
    private final EventRepository eventRepo;

    @Autowired
    public CountryServiceImpl(final CountryRepository repo, final EventRepository eventRepo) {
        this.repo = repo;
        this.eventRepo = eventRepo;
    }
    @Override
    public Country newCountry(final Country country) {
        Event asignEvent = new Event(country.getDate(), country.getId(), country.getId(), "Asignar Presupuesto", new AsignBudgetEventActuator());
        eventRepo.save(asignEvent);
        return repo.save(country);
    }
}
