package org.pasut.games.war.domain.events;

import org.bson.types.ObjectId;
import org.pasut.games.war.domain.actuators.EventActuator;
import org.pasut.games.war.domain.GameDate;

/**
 * Created by marcelo on 17/04/15.
 */
public class Event implements Comparable<Event> {
    private final String id;
    private final GameDate date;
    private final String countryId;
    private final String itemId;
    private final String description;
    private final EventActuator actuator;

    public Event(final GameDate date, final String countryId, final String itemId, final String description,
                 EventActuator actuator) {
        this.id = ObjectId.get().toHexString();
        this.date = date;
        this.countryId = countryId;
        this.itemId = itemId;
        this.description = description;
        this.actuator = actuator;
    }

    public String getId() {
        return id;
    }

    public GameDate getDate() {
        return date;
    }

    public String getCountryId() {
        return countryId;
    }

    public String getItemId() {
        return itemId;
    }

    public String getDescription() {
        return description;
    }

    public EventActuator getActuator() {
        return actuator;
    }

    @Override
    public int compareTo(Event o) {
        return date.compareTo(o.getDate());
    }
}
