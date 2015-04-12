package org.pasut.games.war.domain;

public class GameDate {
    private int day;
    private int hour;
    private int minute;

    public GameDate(){}

    public GameDate(int day, int hour, int minute){
        this.day = day;
        this.hour = hour;
        this.minute = minute;
    }

    public GameDate copy(){
        GameDate date = new GameDate(this.day, this.hour, this.minute);
        return date;
    }

    public boolean lessThan(GameDate date){
        if(this.day < date.day) return true;
        if(this.day > date.day) return false;
        if(this.hour < date.hour) return true;
        if(this.hour > date.hour) return false;
        return this.minute < date.minute;
    }

    public boolean lessThanOrEquals(GameDate date){
        return lessThan(date) || equals(date);
    }

    public boolean greaterThanOrEquals(GameDate date){
        return !lessThan(date);
    }

    public boolean greaterThan(GameDate date){
        return !lessThan(date) && !equals(date);
    }

    @Override
    public boolean equals(Object o){
        if(!(o instanceof GameDate)) return false;
        GameDate date = (GameDate)o;
        return this.day == date.day && this.hour == date.hour && this.minute == date.minute;
    }

    @Override
    public int hashCode(){
        return this.day + this.hour + this.minute;
    }

    @Override
    public String toString(){
        String minutes = minute < 10 ? "0" + minute : "" + minute;
        return day + " " + hour + ":" + minutes +"hs";
    }

    public int getDay() {
        return day;
    }

    public int getHour() {
        return hour;
    }

    public int getMinute(){
        return minute;
    }
}