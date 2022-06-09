package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ParseMode;
import com.pengrad.telegrambot.request.SendMessage;

public abstract class Commands extends BotCommand {
    private static final long serialVersionUID = 1L;
    private static SendMessage message;
    public Commands(String commandIdent, String description) {
        super(commandIdent, description);
    }

    public void sendMes(TelegramBot bot ,Update item, String Message, long chatId,Keyboard replyKeyboardMarkup) {

        if(replyKeyboardMarkup != null) {
            message= new SendMessage(chatId, Message)
                    .parseMode(ParseMode.Markdown)
                    .replyMarkup(replyKeyboardMarkup);
            bot.execute(message);}
        else {
            message= new SendMessage(chatId, Message)
                    .parseMode(ParseMode.Markdown);
            bot.execute(message);
        }

    }

    public static void sendMes(TelegramBot bot, String Message, long chatId,Keyboard replyKeyboardMarkup) {

        if(replyKeyboardMarkup != null) {
            message= new SendMessage(chatId, Message)
                    .parseMode(ParseMode.Markdown)
                    .replyMarkup(replyKeyboardMarkup);
            bot.execute(message);}
        else {
            message= new SendMessage(chatId, Message)
                    .parseMode(ParseMode.Markdown);
            bot.execute(message);
        }

    }



}