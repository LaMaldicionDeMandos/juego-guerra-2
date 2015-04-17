package org.pasut.games.war.domain.actuators;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.services.GeneralService;

/**
 * Created by marcelo on 17/04/15.
 */
public class AsignBudgetEventActuator implements EventActuator<Country> {
    @Override
    public Country find(final String id, GeneralService service) {
        return service.findCountry(id);
    }

    @Override
    public boolean changeDynamicCost(Country item) {
        return false;
    }

    @Override
    public void actOver(Country item, GeneralService service) {}
}
