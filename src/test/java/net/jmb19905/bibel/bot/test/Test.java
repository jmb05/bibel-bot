package net.jmb19905.bibel.bot.test;

import net.dv8tion.jda.api.AccountType;
import net.dv8tion.jda.api.JDA;
import net.dv8tion.jda.api.JDABuilder;
import net.dv8tion.jda.api.OnlineStatus;
import net.dv8tion.jda.api.entities.Message;
import net.dv8tion.jda.api.events.message.MessageReceivedEvent;
import net.dv8tion.jda.api.hooks.ListenerAdapter;
import net.jmb19905.bibel.bot.util.Util;

import javax.security.auth.login.LoginException;
import java.nio.charset.StandardCharsets;

public class Test extends ListenerAdapter {

    public static void main(String[] args) throws LoginException {
        System.out.println("Testing");
        JDA jdaBot = JDABuilder.createDefault(Util.loadToken()).build();
        jdaBot.getPresence().setStatus(OnlineStatus.IDLE);
        jdaBot.addEventListener(new Test());
    }

    @Override
    public void onMessageReceived(MessageReceivedEvent e) {
        Message MsgObj = e.getMessage();
        String message = new String(MsgObj.getContentStripped().getBytes(StandardCharsets.UTF_8));

        System.out.println("Received a message: '" + message + "'");
    }

}
