package org.pasut.games.war.domain.unit;

import org.pasut.games.war.domain.GameDate;
import org.pasut.games.war.domain.LatLong;
import org.pasut.games.war.domain.visibility.Visibility;

/**
 * Created by marcelo on 17/04/15.
 */
public abstract class Unit implements Visibility {
    private String id;
    private final String countryId;
    private final String name;
    private final String type;
    protected UnitState state = UnitState.UNAVAILABLE;
    protected GameDate date;

    public Unit(){
        this("", "", "");
    }

    public Unit(final String countryId, final String name, final String type){
        this.countryId = countryId;
        this.name = name;
        this.type = type;
    }

    public String getId() {
        return id;
    }

    abstract protected Visibility getVisibility();

    public final double getLat(){
        return getVisibility().getLat();
    }

    public final double getLon(){
        return getVisibility().getLon();
    }

    public final LatLong getPosition(){
        return getVisibility().getPosition();
    }

    public final void setPosition(LatLong position){
        getVisibility().setPosition(position);
    }

    public boolean isVisible(Visibility visibility) {
        return getVisibility().isVisible(visibility);
    }

    public double getRatio() {
        return getVisibility().getRatio();
    }

    public int getLevel() {
        return getVisibility().getLevel();
    }

    public final String getCountryId(){
        return this.countryId;
    }

    public final String getName(){
        return name;
    }

    public final String getType(){
        return type;
    }

    public final UnitState getState(){
        return state;
    }

    public final GameDate getDate(){
        return date;
    }

    public abstract int getSpeed();

    abstract double getCost();

    abstract double getMaintenance();

    abstract int getContructionTime();
}
