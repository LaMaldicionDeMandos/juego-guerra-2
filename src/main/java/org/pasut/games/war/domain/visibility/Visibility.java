package org.pasut.games.war.domain.visibility;

import org.pasut.games.war.domain.unit.Placeable;

/**
 * Created by marcelo on 17/04/15.
 */
public interface Visibility extends Placeable {
    boolean isVisible(Visibility visibility);
    double getRatio();
    int getLevel();
}
