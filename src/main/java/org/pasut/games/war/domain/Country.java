package org.pasut.games.war.domain;

import com.google.common.collect.Iterables;
import com.google.common.collect.Lists;
import org.bson.types.ObjectId;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.collect.Iterables.getLast;

public class Country {

    private final String id;

    private final String code;
    private final double lat;
    private final double lon;
    private final String name;
    private double pbi;
    private double reserve;
    private double estamitionPercent = .01f;
    private double estimation;
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
        this.pbi = pbi*.9;
        this.reserve = pbi*.1;
        this.estamitionPercent = .01;
        this.estimation = this.pbi*this.estamitionPercent;
        this.historyStats = Lists.newArrayList();
        this.date = new GameDate();
        this.fixedCost = 0;
        this.dynamicCost = 0;
        this.historyStats.add(new CountryStat(this.estimation,this.fixedCost, this.dynamicCost));
    }

    public void addDynamicCost(double cost){
        this.dynamicCost+= cost;
        getLast(historyStats, new CountryStat(estimation, fixedCost, dynamicCost)).addDynamicCost(cost);
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


    public String getName() {
        return name;
    }

    public double getPbi() {
        return pbi;
    }

    public double getReserve() {
        return reserve;
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
}