package net.jmb19905.bibel.bot.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.jmb19905.bibel.bot.Main;

import java.awt.*;
import java.nio.charset.StandardCharsets;

public class SendTemplates {

    public static void sendVerse(TextChannel channel, int book, int chapter, int verse){
        try {
            String title = Util.replaceSpecialChars(Main.bible.get(book - 1).getName()) + " " + chapter + "," + verse;
            String message = Main.bible.getSingleVerse(book, chapter, verse);
            EmbedBuilder verseEmbed = new EmbedBuilder();

            verseEmbed.setTitle("Bibel Bot - Bibelstelle");
            verseEmbed.addField(title, message, false);
            verseEmbed.setFooter("Bibel" + '\u00FC' + "bersetzung: " + Main.bible.getData().getName());
            verseEmbed.setColor(Color.orange);

            channel.sendTyping().queue();
            channel.sendMessage(verseEmbed.build()).queue();
            verseEmbed.clear();
        }catch (ArrayIndexOutOfBoundsException ignored){
            System.out.println("Array Index out of bounds exception");
        }
    }

    public static void sendLosungHeute(TextChannel channel){
        EmbedBuilder losung = new EmbedBuilder();
        losung.setTitle("Bibel Bot - Die Losung");
        losung.setDescription("Die heutigen Losung:");
        losung.addField(Util.getDate(), Util.getLosung(Util.getDayOfYear()), false);
        losung.setFooter('\u00A9' + " Evangelische Br" + '\u00FC' + "der-Unit" + '\u00E4' + "t - Herrnhuter Br" + '\u00FC' + "dergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
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
        losung.setFooter('\u00A9' + " Evangelische Br" + '\u00FC' + "der-Unit" + '\u00E4' + "t - Herrnhuter Br" + '\u00FC' + "dergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
        losung.setColor(Color.orange);

        channel.sendTyping().queue();
        channel.sendMessage(losung.build()).queue();
        losung.clear();
    }

    public static void sendHilfeKommandos(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Hilfe - Kommandos");
        help.setDescription("Alle Kommandos auf die ich h" + '\u00F6' + "re!");
        help.addField("Kommandos:", "'!hilfe [" + '\u00FC' + "ber/kommandos]'\n"
                + "'!losung [heute/jahr]'\n"
                + "'!admin [\n   get-prefix/\n   set-prefix [prefix]/\n   get-time/\n   set-time [time]/\n   get-channel-name/\n   set-channel-name [channelname]/\n   get-show-losung/\n   set-show-losung ['true'/'false']\n]' (F" + '\u00FC' + "r dieses Kommando werden Administratorrechte ben" + '\u00F6' + "tigt) \n"
                + "'!bibel [Abk" + '\u00FC' + "rzung Buch] [Kapitel],[Vers]'", false);
        help.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendHilfeAbout(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Hilfe - " + '\u00FC' + "ber");
        help.setDescription("Das sind meine specs!");
        help.addField("", "**Bibel Bot**\nVersion: 2.0.0\nEntwickler: @jmb05", false);
        help.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendNoAdmin(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot");
        help.addField("", "Sorry ... f" + '\u00FC' + "r dieses Kommando musst du Administrator sein...", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendPrefix(TextChannel channel) {
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Der Prefix des Servers ist: '" + Util.getPrefix(channel.getGuild().getIdLong())+ "'", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendTime(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Die Zeit f" + '\u00FC' + "r die automatische Losung des Servers ist auf: " + Util.getTime(channel.getGuild().getIdLong()).toString()+" gesetzt.", false);
        help.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(help.build()).queue();
        help.clear();
    }

    public static void sendLosungenChannelName(TextChannel channel){
        EmbedBuilder help = new EmbedBuilder();
        help.setTitle("Bibel Bot - Admin");
        help.addField("", "Der Name des Losungskanals f" + '\u00FC' + "r diesen Server ist: '" + Util.getLosungenChannelName(channel.getGuild().getIdLong())+"'.", false);
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
