package org.pasut.games.war.domain;

/**
 * Created by marcelo on 17/04/15.
 */
public interface Event extends Comparable<Event> {
    GameDate getTime();
    String getCountryId();
    String getItemId();
    String getDescription();
    EventActuator getEventActuator();
}
