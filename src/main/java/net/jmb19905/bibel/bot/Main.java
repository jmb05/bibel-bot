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
package net.jmb19905.bibel.bot;

import java.io.IOException;
import java.sql.SQLException;
import javax.security.auth.login.LoginException;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.jmb19905.bibel.bot.commands.Commands;
import net.jmb19905.bibel.bot.scheduler.LosungScheduler;
import net.jmb19905.bibel.bot.util.Util;
import net.jmb19905.bible.parser.Bible;
import net.jmb19905.bible.parser.loader.BibleLoader;

/**
 *
 * @author Jared
 */
public class Main {
    
    public static JDA jda;
    public static String losungenFile = "";
    public static String jahreslosungenFile = "";
    public static Bible bible = null;

    static {
        try {
            bible = BibleLoader.loadBible("lut1912.txt");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //Main method
    public static void main(String[] args) throws InterruptedException, LoginException {
        java.util.logging.Logger.getLogger(Main.class.getName()).info("Initializing Variables ...");
        
        losungenFile = "losungen.xlsx";
        jahreslosungenFile = "jahreslosungen.xlsx";
        
        java.util.logging.Logger.getLogger(Main.class.getName()).info("Initializing and Starting JDA...");
        jda = JDABuilder.createDefault(Util.loadToken()).build();
        jda.getPresence().setStatus(OnlineStatus.ONLINE);
        jda.awaitReady();
        
        LosungScheduler.init();
        
        Main.jda.getGuilds().forEach((guild) -> {
            LosungScheduler.start(guild.getIdLong());
        });
        
        jda.addEventListener(new Commands());
    }
    
    public static void close(){
        java.util.logging.Logger.getLogger(Main.class.getName()).info("Closing everything down ... bye!");
        jda.shutdown();
        System.exit(0);
    }
    
}
