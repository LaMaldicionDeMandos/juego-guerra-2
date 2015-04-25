package org.pasut.games.war.domain.visibility;

/**
 * Created by marcelo on 25/04/15.
 */
public class AllwaysVisibleVisibility extends AbstractVisibility {

    public AllwaysVisibleVisibility(double lat, double lon){
        super(lat, lon, 0, 0);
    }

    public boolean isVisible(Visibility visibility) {
        return true;
    }
}
