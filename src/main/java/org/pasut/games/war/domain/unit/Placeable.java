package org.pasut.games.war.domain.unit;

import org.pasut.games.war.domain.LatLong;

/**
 * Created by marcelo on 17/04/15.
 */
public interface Placeable {
    double getLat();
    double getLon();
    LatLong getPosition();
    void setPosition(LatLong position);
}
