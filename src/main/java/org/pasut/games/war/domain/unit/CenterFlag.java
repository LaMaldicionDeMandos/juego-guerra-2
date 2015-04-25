package org.pasut.games.war.domain.unit;

import org.pasut.games.war.domain.Country;
import org.pasut.games.war.domain.visibility.AllwaysVisibleVisibility;
import org.pasut.games.war.domain.visibility.Visibility;

/**
 * Created by marcelo on 25/04/15.
 */
public class CenterFlag extends Unit {

    private final Visibility visivility;

    public CenterFlag(final Country country, final String name, final double lat, final double lon) {
        super(country.getId(), name, "CenterFlag");
        this.visivility = new AllwaysVisibleVisibility(lat, lon);

    }

    @Override
    protected Visibility getVisibility() {
        return null;
    }

    @Override
    public int getSpeed() {
        return 0;
    }

    @Override
    double getCost() {
        return 0;
    }

    @Override
    double getMaintenance() {
        return 0;
    }

    @Override
    int getContructionTime() {
        return 0;
    }
}
