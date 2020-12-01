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
   
import net.jmb19905.bibel.bot.Main;
import net.jmb19905.bibel.bot.util.SendTemplates;
import net.jmb19905.bibel.bot.util.Util;

import java.util.*;

public class LosungScheduler{
    
    private static final HashMap<Long, Timer> TIMERS = new HashMap<>();
    
    public static void init(){
        Main.jda.getGuilds().forEach((guild) -> TIMERS.put(guild.getIdLong(), new Timer()));
    }
    
    public static void start(long guildID){
        Time time = Util.getTime(guildID);
        Calendar cal = Calendar.getInstance();
        cal.set(Calendar.HOUR_OF_DAY, time.getHour());
        cal.set(Calendar.MINUTE, time.getMinute());
        cal.set(Calendar.SECOND, time.getSecond());
        Date date = cal.getTime();
        Date current = new Date();
        if(current.after(date)){
            Calendar c = Calendar.getInstance();
            c.setTime(date);
            c.add(Calendar.DATE, 1);
            date = c.getTime();
        }
        
        Timer timer = new Timer();
        timer.schedule(new TimerTask() {
            @Override
            @SuppressWarnings("null")
            public void run() {
                Objects.requireNonNull(Main.jda.getGuildById(guildID)).getTextChannelsByName(Util.getLosungenChannelName(guildID), false).forEach(SendTemplates::sendLosungHeute);
            }
        }, date, 24*60*60*1000);
    }
    
    public static void stop(long guildID){
        TIMERS.get(guildID).cancel();
    }
    
    public static void restart(long guildID){
        stop(guildID);
        TIMERS.put(guildID, new Timer());
        start(guildID);
    }

}