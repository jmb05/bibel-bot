package net.jmb19905.bibel.bot.util;

import net.dv8tion.jda.api.EmbedBuilder;
import net.dv8tion.jda.api.entities.TextChannel;
import net.jmb19905.bibel.bot.Main;

import java.awt.*;

public class SendTemplates {

    private static final EmbedBuilder embedBuilder = new EmbedBuilder();

    public static void sendVerse(TextChannel channel, int book, int chapter, int verse){
        try {
            String title = Util.replaceSpecialChars(Main.bible.get(book - 1).getName()) + " " + chapter + "," + verse;
            String message = Main.bible.getSingleVerse(book, chapter, verse);

            embedBuilder.setTitle("Bibel Bot - Bibelstelle");
            embedBuilder.addField(title, message, false);
            embedBuilder.setFooter("Bibel" + '\u00FC' + "bersetzung: " + Main.bible.getData().getName());
            embedBuilder.setColor(Color.orange);

            channel.sendTyping().queue();
            channel.sendMessage(embedBuilder.build()).queue();
            embedBuilder.clear();
        }catch (ArrayIndexOutOfBoundsException ignored){
            System.out.println("Array Index out of bounds exception");
        }
    }

    public static void sendLosungHeute(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Die Losung");
        embedBuilder.setDescription("Die heutigen Losung:");
        embedBuilder.addField(Util.getDate(), Util.getLosung(Util.getDayOfYear()), false);
        embedBuilder.setFooter('\u00A9' + " Evangelische Br" + '\u00FC' + "der-Unit" + '\u00E4' + "t - Herrnhuter Br" + '\u00FC' + "dergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
        embedBuilder.setColor(Color.orange);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendLosungJahr(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Die Losung");
        embedBuilder.setDescription("Die Jahreslosung:");
        embedBuilder.addField(Util.getYear(), Util.getJahresLosung(), false);
        embedBuilder.setFooter('\u00A9' + " Evangelische Br" + '\u00FC' + "der-Unit" + '\u00E4' + "t - Herrnhuter Br" + '\u00FC' + "dergemeine (www.herrnhuter.de)\nWeitere Informationen finden sie hier: www.losungen.de");
        embedBuilder.setColor(Color.orange);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendHilfeKommandos(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Hilfe - Kommandos");
        embedBuilder.setDescription("Alle Kommandos auf die ich h" + '\u00F6' + "re!");
        embedBuilder.addField("Kommandos:", "'!hilfe [" + '\u00FC' + "ber/kommandos]'\n"
                + "'!losung [heute/jahr]'\n"
                + "'!admin [\n   get-prefix/\n   set-prefix [prefix]/\n   get-time/\n   set-time [time]/\n   get-channel-name/\n   set-channel-name [channelname]/\n   get-show-losung/\n   set-show-losung ['true'/'false']\n]' (F" + '\u00FC' + "r dieses Kommando werden Administratorrechte ben" + '\u00F6' + "tigt) \n"
                + "'!bibel [Abk" + '\u00FC' + "rzung Buch] [Kapitel],[Vers]'", false);
        embedBuilder.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendHilfeAbout(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Hilfe - " + '\u00FC' + "ber");
        embedBuilder.setDescription("Das sind meine specs!");
        embedBuilder.addField("", "**Bibel Bot**\nVersion: 2.0.0\nEntwickler: @jmb05", false);
        embedBuilder.setColor(Color.green);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendHilfeAbbr(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Hilfe - Abk\u00FCrzungen");
        embedBuilder.setDescription("Die Abk\u00FCrzungen f\u00FCr die B\u00FCcher der Bibel");
        embedBuilder.addField("Altes Testament", "gen - 1. Mose (Genesis)\n" +
                "ex - 2. Mose (Exodus)\n" +
                "lev - 3. Mose (Levitikus)\n" +
                "num - 4. Mose (Numeri)\n" +
                "dtn - 5. Mose (Deuteronomium)\n" +
                "jos - Josua\n" +
                "ri - Richter\n" +
                "rut - Ruth\n" +
                "1sam - 1. Samuel\n" +
                "2sam - 2. Samuel\n" +
                "1k\u00F6n - 1. K\u00F6nige\n" +
                "2k\u00F6n - 2. K\u00F6nige\n" +
                "1chr - 1. Chronik\n" +
                "2chr - 2. Chronik\n" +
                "esra - Esra\n" +
                "neh - Nehemia\n" +
                "est - Esther\n" +
                "hi - Hiob\n" +
                "ps - Psalmen\n" +
                "spr - Spr\u00FCche\n" +
                "koh - Prediger Salomo\n" +
                "hld - Das Hohelied\n" +
                "jes - Jesaja\n" +
                "jer - Jeremia\n" +
                "klgl - Klagelieder\n" +
                "hes - Hesekiel\n" +
                "dan - Daniel\n" +
                "hos - Hosea\n" +
                "joel - Joel\n" +
                "am - Amos\n" +
                "obd - Obadja\n" +
                "jona - Jona\n" +
                "mi - Micha\n" +
                "nah - Nahum\n" +
                "hab - Habakuk\n" +
                "zef - Zefania\n" +
                "hag - Haggai\n" +
                "sach - Sacharja\n" +
                "mal - Maleachi\n", false);
        embedBuilder.addField("Neues Testament",
                "mt - Matth\u00E4us\n" +
                "mk - Markus\n" +
                "lk - Lukas\n" +
                "joh - Johannes\n" +
                "apg - Apostelgeschichte\n" +
                "r\u00F6m - R\u00F6mer\n" +
                "1kor - 1. Korinther\n" +
                "2kor - 2. Korinther\n" +
                "gal - Galater\n" +
                "eph - Epheser\n" +
                "phil - Philipper\n" +
                "kol - Kolosser\n" +
                "1thess - 1. Thessalonicher\n" +
                "2thess - 2. Thessalonicher\n" +
                "1tim - 1. Timotheus\n" +
                "2tim - 2. Timotheus\n" +
                "tit - Titus\n" +
                "phlm - Philemon\n" +
                "hebr - Hebr\u00E4er\n" +
                "jak - Jakobus\n" +
                "1petr - 1. Petrus\n" +
                "2petr - 2. Petrus\n" +
                "1joh - 1. Johannes\n" +
                "2joh - 2. Johannes\n" +
                "3joh - 3. Johannes\n" +
                "jud - Judas\n" +
                "offb - Offenbarung", false);
        embedBuilder.setColor(Color.green);
        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendNoAdmin(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot");
        embedBuilder.addField("", "Sorry ... f" + '\u00FC' + "r dieses Kommando musst du Administrator sein...", false);
        embedBuilder.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendPrefix(TextChannel channel) {
        embedBuilder.setTitle("Bibel Bot - Admin");
        embedBuilder.addField("", "Der Prefix des Servers ist: '" + Util.getPrefix(channel.getGuild().getIdLong())+ "'", false);
        embedBuilder.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendTime(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Admin");
        embedBuilder.addField("", "Die Zeit f" + '\u00FC' + "r die automatische Losung des Servers ist auf: " + Util.getTime(channel.getGuild().getIdLong()).toString()+" gesetzt.", false);
        embedBuilder.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendLosungenChannelName(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Admin");
        embedBuilder.addField("", "Der Name des Losungskanals f" + '\u00FC' + "r diesen Server ist: '" + Util.getLosungenChannelName(channel.getGuild().getIdLong())+"'.", false);
        embedBuilder.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

    public static void sendIfShow(TextChannel channel){
        embedBuilder.setTitle("Bibel Bot - Admin");
        if(Util.getIfShow(channel.getGuild().getIdLong())){
            embedBuilder.addField("", "Die Losung wird automatisch angezeigt.", false);
        }else{
            embedBuilder.addField("", "Die Losung wird nicht automatisch angezeigt.", false);
        }
        embedBuilder.setColor(Color.red);

        channel.sendTyping().queue();
        channel.sendMessage(embedBuilder.build()).queue();
        embedBuilder.clear();
    }

}
