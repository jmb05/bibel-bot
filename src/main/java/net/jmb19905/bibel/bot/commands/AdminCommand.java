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

import java.awt.Color;
import java.sql.SQLException;
import java.util.Objects;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.Permission;
import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.jmb19905.bibel.bot.scheduler.Time;
import net.jmb19905.bibel.bot.util.SendTemplates;
import net.jmb19905.bibel.bot.util.Util;

/**
 *
 * @author Jared
 */
public class AdminCommand{
    
    @SuppressWarnings({"ConvertToStringSwitch", "null"})
    public static void adminMessageReceived(GuildMessageReceivedEvent evt, String[] args) throws SQLException{
        try{
            System.out.println("Checking rights...");
            if(Objects.requireNonNull(evt.getMember()).hasPermission(Permission.ADMINISTRATOR)){
                switch (args[1]) {
                    case "get-prefix":
                        SendTemplates.sendPrefix(evt.getChannel());
                        break;
                    case "set-prefix":
                        try {
                            if (Util.setPrefix(evt.getGuild().getIdLong(), args[2])) {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Pr" + '\u00E4' + "fix ist jetzt '" + args[2] + "'.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            } else {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Fehler beim " + '\u00E4' + "ndern des Pr" + '\u00E4' + "fix.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            EmbedBuilder message = new EmbedBuilder();
                            message.setTitle("Bibel Bot - Admin");
                            message.addField("", "Es muss noch der Pr" + '\u00E4' + "fix angegeben werden!", false);
                            message.setColor(Color.red);
                            evt.getChannel().sendTyping().queue();
                            evt.getChannel().sendMessage(message.build()).queue();
                        }
                        break;
                    case "get-time":
                        SendTemplates.sendTime(evt.getChannel());
                        break;
                    case "set-time":
                        try {
                            if (Util.setTime(evt.getGuild().getIdLong(), new Time(args[2]))) {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Zeit ist jetzt: '" + args[2] + "'.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            } else {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Fehler beim " + '\u00E4' + "ndern der Zeit.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            EmbedBuilder message = new EmbedBuilder();
                            message.setTitle("Bibel Bot - Admin");
                            message.addField("", "Es muss noch die Zeit angegeben werden!", false);
                            message.setColor(Color.red);
                            evt.getChannel().sendTyping().queue();
                            evt.getChannel().sendMessage(message.build()).queue();
                        }
                        break;
                    case "get-channel-name":
                        SendTemplates.sendLosungenChannelName(evt.getChannel());
                        break;
                    case "set-channel-name":
                        try {
                            if (Util.setLosungenChannelName(evt.getGuild().getIdLong(), args[2])) {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Der Losungskanal ist jetzt: '" + args[2] + "'.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            } else {
                                EmbedBuilder message = new EmbedBuilder();
                                message.setTitle("Bibel Bot - Admin");
                                message.addField("", "Fehler beim " + '\u00E4' + "ndern des Losungskanal.", false);
                                message.setColor(Color.red);
                                evt.getChannel().sendTyping().queue();
                                evt.getChannel().sendMessage(message.build()).queue();
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            EmbedBuilder message = new EmbedBuilder();
                            message.setTitle("Bibel Bot - Admin");
                            message.addField("", "Es muss noch der Name des Kanals angegeben werden!", false);
                            message.setColor(Color.red);
                            evt.getChannel().sendTyping().queue();
                            evt.getChannel().sendMessage(message.build()).queue();
                        }
                        break;
                    case "get-show-losung":
                        SendTemplates.sendIfShow(evt.getChannel());
                        break;
                    case "set-show-losung":
                        try {
                            if (args[2].equals("true")) {
                                System.out.println("Detected 'true'");
                                if (Util.setIfShow(evt.getGuild().getIdLong(), true)) {
                                    EmbedBuilder message = new EmbedBuilder();
                                    message.setTitle("Bibel Bot - Admin");
                                    message.addField("", "Die Losung wird ab jetzt automatisch angezeigt.", false);
                                    message.setColor(Color.red);
                                    evt.getChannel().sendTyping().queue();
                                    evt.getChannel().sendMessage(message.build()).queue();
                                } else {
                                    EmbedBuilder message = new EmbedBuilder();
                                    message.setTitle("Bibel Bot - Admin");
                                    message.addField("", "Fehler beim anschalten der automatischen Losung.", false);
                                    message.setColor(Color.red);
                                    evt.getChannel().sendTyping().queue();
                                    evt.getChannel().sendMessage(message.build()).queue();
                                }
                            } else if (args[2].equals("false")) {
                                System.out.println("Detected 'false'");
                                if (Util.setIfShow(evt.getGuild().getIdLong(), false)) {
                                    EmbedBuilder message = new EmbedBuilder();
                                    message.setTitle("Bibel Bot - Admin");
                                    message.addField("", "Die Losung wird ab jetzt nicht mehr automatisch angezeigt.", false);
                                    message.setColor(Color.red);
                                    evt.getChannel().sendTyping().queue();
                                    evt.getChannel().sendMessage(message.build()).queue();
                                } else {
                                    EmbedBuilder message = new EmbedBuilder();
                                    message.setTitle("Bibel Bot - Admin");
                                    message.addField("", "Fehler beim ausschalten der automatischen Losung.", false);
                                    message.setColor(Color.red);
                                    evt.getChannel().sendTyping().queue();
                                    evt.getChannel().sendMessage(message.build()).queue();
                                }
                            }
                        } catch (ArrayIndexOutOfBoundsException e) {
                            EmbedBuilder message = new EmbedBuilder();
                            message.setTitle("Bibel Bot - Admin");
                            message.addField("", "Es muss noch ein Wahrheitswert ('true', 'false') angegeben werden!", false);
                            message.setColor(Color.red);
                            evt.getChannel().sendTyping().queue();
                            evt.getChannel().sendMessage(message.build()).queue();
                        }
                        break;
                }
            }else{
                SendTemplates.sendNoAdmin(evt.getChannel());
                System.err.println("Member has not enough rights...");
            }
        }catch(ArrayIndexOutOfBoundsException ex){
            EmbedBuilder losung = new EmbedBuilder();
            losung.setTitle("Bibel Bot - Hilfe");
            losung.addField("", "Das Kommando '!admin' macht alleine nichts ... h" + '\u00E4' + "nge noch 'get-prefix', 'set-prefix [pr" + '\u00E4' + "fix]', 'get-time', 'set-time [hh:mm:ss]', 'get-channel-name' oder 'set-channel-name [channelname]' hinten ran um die gew" + '\u00FC' + "nschte Einstellung anzuzeigen! :wink:", false);
            losung.setColor(Color.green);

            evt.getChannel().sendTyping().queue();
            evt.getChannel().sendMessage(losung.build()).queue();
            losung.clear();
        }
            
    }
    
}