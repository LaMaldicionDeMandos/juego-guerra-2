package org.pasut.games.war.domain;

import com.google.common.collect.Lists;
import org.bson.types.ObjectId;
import org.pasut.games.war.domain.unit.Placeable;
import org.springframework.data.annotation.Id;

import java.util.List;

import static com.google.common.collect.Iterables.getLast;

public class Country implements Placeable {

    @Id
    private final String id;

    private final String code;
    private final double lat;
    private final double lon;
    private final String name;
    private double pbi;
    private double pbiPercent;
    private double reserve;
    private double currentAmount;
    private List<CountryStat> historyStats;
    private GameDate date;
    private double fixedCost;
    private double dynamicCost;


    public Country() {
        this("", "", 0, 0, 0);
    }

    public Country(final String code, final String name, final double pbi, final double lat,
                   final double lon) {
        this.id = ObjectId.get().toHexString();
        this.code = code;
        this.name = name;
        this.lat = lat;
        this.lon = lon;
        this.pbi = pbi;
        this.pbiPercent = .1;
        this.reserve = pbi*pbiPercent;
        this.currentAmount = reserve;
        this.historyStats = Lists.newArrayList();
        this.date = new GameDate();
        this.fixedCost = 0;
        this.dynamicCost = 0;
        this.historyStats.add(new CountryStat(this.reserve,this.fixedCost, this.dynamicCost));
    }

    public void addDynamicCost(double cost){
        this.dynamicCost+= cost;
        getLast(historyStats, new CountryStat(reserve, fixedCost, dynamicCost)).addDynamicCost(cost);
    }

    public GameDate getDate() {
        return date;
    }

    public String getId() {
        return id;
    }

    public String getCode() {
        return code;
    }

    public double getLat() {
        return lat;
    }

    public double getLon() {
        return lon;
    }

    @Override
    public LatLong getPosition() {
        return new LatLong(lat, lon);
    }

    @Override
    public void setPosition(LatLong position) {}


    public String getName() {
        return name;
    }

    public double getPbi() {
        return pbi;
    }

    public double getReserve() {
        return reserve;
    }

    public double getCurrentAmount() {
        return currentAmount;
    }

    public void setDate(GameDate date) {
        this.date = date;
    }

    public double getFixedCost() {
        return fixedCost;
    }

    public double getDynamicCost() {
        return dynamicCost;
    }

    public List<CountryStat> getHistoryStats() {
        return historyStats;
    }
}