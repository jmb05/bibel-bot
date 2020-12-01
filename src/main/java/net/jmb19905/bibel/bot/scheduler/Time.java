/*
 * Copyright (C) 2020 Jared
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package net.jmb19905.bibel.bot.scheduler;

/**
 *
 * @author Jared
 */
public class Time {
    
    private int hour;
    private int minute;
    private int second;

    public Time(int hour, int minute, int second) {
        this.hour = hour;
        this.minute = minute;
        this.second = second;
    }
    
    public Time(String time) {
        String[] parts = time.split(":");
        this.hour = Integer.parseInt(parts[0]);
        this.minute = Integer.parseInt(parts[1]);
        this.second = Integer.parseInt(parts[2]);
    }

    public int getHour() {
        return hour;
    }

    public void setHour(int hour) {
        this.hour = hour;
    }

    public int getMinute() {
        return minute;
    }

    public void setMinute(int minute) {
        this.minute = minute;
    }

    public int getSecond() {
        return second;
    }

    public void setSecond(int second) {
        this.second = second;
    }
    
    @Override
    public String toString(){
        String out = "";
        if(getHour()>9){
            out = out.concat(getHour()+":");
        }else{
            out = out.concat("0"+getHour()+":");
        }
        if(getMinute()>9){
            out = out.concat(getMinute()+":");
        }else{
            out = out.concat("0"+getMinute()+":");
        }
        if(getSecond()>9){
            out = out.concat(getSecond()+"");
        }else{
            out = out.concat("0"+getSecond()+" Uhr");
        }
        return out;
    }
}
