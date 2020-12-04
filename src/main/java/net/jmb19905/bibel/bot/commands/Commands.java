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
package net.jmb19905.bibel.bot.commands;

import java.nio.charset.StandardCharsets;
import java.sql.SQLException;
import java.util.Arrays;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.jmb19905.bibel.bot.util.Util;

/**
 *
 * @author Jared
 */
public class Commands extends ListenerAdapter{
    
    @Override
    public void onGuildMessageReceived(GuildMessageReceivedEvent evt){
        System.out.println("Message received: " + evt.getMessage().toString());
        String message = new String(evt.getMessage().getContentStripped().getBytes(StandardCharsets.UTF_8));
        String[] args = message.split("\\s+");
        String prefix = Util.getPrefix(evt.getGuild().getIdLong());
        try{
            if(args[0].equals(prefix + "admin")){
                System.out.println("Detected '!admin' command");
                AdminCommand.adminMessageReceived(evt, args);
            }else if(args[0].equals(prefix + "losung")){
                System.out.println("Detected '!losung' command");
                LosungCommand.losungMessageReceived(evt, args);
            }else if(args[0].equals(prefix + "hilfe")){
                System.out.println("Detected !'hilfe' command");
                HelpCommand.helpMessageReceived(evt, args);
            }else if(args[0].equals(prefix + "bibel")){
                System.out.println("Detected !'bibel' command");
                BibleCommand.verseMessageReceived(evt, args);
            }
        }catch(SQLException e){
            e.printStackTrace();
        }
    }
    
}
