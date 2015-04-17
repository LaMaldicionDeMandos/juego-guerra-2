package org.pasut.games.war.domain.actuators;

import org.pasut.games.war.services.GeneralService;
import org.pasut.games.war.domain.unit.Placeable;

/**
 * Created by marcelo on 17/04/15.
 */
public interface EventActuator<T extends Placeable>{
    T find(String id, GeneralService repo);
    boolean changeDynamicCost(T item);
    void actOver(T item, GeneralService service);
}
