package net.jmb19905.bibel.bot.commands;

import net.dv8tion.jda.api.events.message.guild.GuildMessageReceivedEvent;
import net.jmb19905.bibel.bot.Main;
import net.jmb19905.bibel.bot.util.SendTemplates;

public class BibleCommand {

    /**
     *
     * Syntax 'Book chapter,verse'
     *
     * @param evt the event that is fired when an message is received on a guild
     * @param args the content of the message
     */
    public static void verseMessageReceived(GuildMessageReceivedEvent evt, String[] args){
        String bookAbbreviation = args[1];
        String[] parts = args[2].split(",");
        int book = Main.bible.getIndex(Main.bible.getBookFromAbbreviation(bookAbbreviation)) + 1;
        int chapter = Integer.parseInt(parts[0]);
        int verse = Integer.parseInt(parts[1]);
        SendTemplates.sendVerse(evt.getChannel(), book, chapter, verse);
    }

}
