package net.jmb19905.bibel.bot.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;

import java.awt.*;
import java.sql.SQLException;

public class SendTemplates {

    public static void sendLosungHeute(TextChannel channel){
        EmbedBuilder losung = new EmbedBuilder();
        losung.setTitle("Bibel Bot - Die Losung");
        losung.setDescription("Die heutigen Losung:");
        losung.addField(Util.getDate(), Util.getLosung(Util.getDayOfYear()), false);
        losung.setFooter("© Evangelische Brüder-Unität – Herrnhuter Brüdergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
        losung.setColor(Color.orange);

        channel.sendTyping().queue();
        channel.sendMessage(losung.build()).queue();
        losung.clear();
    }

    public static void sendLosungJahr(TextChannel channel){
        EmbedBuilder losung = new EmbedBuilder();
        losung.setTitle("Bibel Bot - Die Losung");
        losung.setDescription("Die Jahreslosung:");
        losung.addField(Util.getYear(), Util.getJahresLosung(), false);
        losung.setFooter("© Evangelische Brüder-Unität – Herrnhuter Brüdergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
        losung.setColor(Color.orange);

        channel.sendTyping().queue();
        channel.sendMessage(losung.build()).queue();
        losung.clear();
    }

    public static void sendHilfeKommandos(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Hilfe - Kommandos");
        help.setDescription("Alle Kommandos auf die ich höre!");
        help.addField("Kommandos:", "\'!hilfe [über/kommandos]\'\n"
                + "\'!losung [heute/jahr]\'\n"
                + "\'!admin [\n   get-prefix/\n   set-prefix [prefix]/\n   get-time/\n   set-time [time]/\n   get-channel-name/\n   set-channel-name [channelname]/\n   get-show-losung/\n   set-show-losung ['true'/'false']\n]\' \n(Für dieses Kommando werden Administratorrechte benötigt)", false);
        help.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendHilfeAbout(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Hilfe - Über");
        help.setDescription("Das sind meine specs!");
        help.addField("", "**Bibel Bot**\nVersion: 1.2.1\nEntwickler: @jmb05", false);
        help.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendNoAdmin(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot");
        help.addField("", "Sorry ... für dieses Kommando musst du Administrator sein...", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendPrefix(TextChannel channel) throws SQLException {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Der Prefix des Servers ist: \'" + Util.getPrefix(channel.getGuild().getIdLong())+"\'", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendTime(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Die Zeit für die automatische Losung des Servers ist auf: " + Util.getTime(channel.getGuild().getIdLong()).toString()+" gesetzt.", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendLosungenChannelName(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Der Name des Losungskanals für diesen Server ist: '" + Util.getLosungenChannelName(channel.getGuild().getIdLong())+"'.", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendIfShow(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        if(Util.getIfShow(channel.getGuild().getIdLong())){
            help.addField("", "Die Losung wird automatisch angezeigt.", false);
        }else{
            help.addField("", "Die Losung wird nicht automatisch angezeigt.", false);
        }
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

}
