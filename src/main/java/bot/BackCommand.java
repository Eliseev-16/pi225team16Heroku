package bot;

import bot.Commands;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;

import java.util.ArrayList;

public class BackCommand extends Commands {

    BackCommand(TelegramBot bot, Update item, long chatId, Keyboard replyKeyboardMarkup,
                ArrayList<Long> users){
        super("back","Back to the menu");

        users.remove(chatId);
        sendMes(bot,"Выберите действие",chatId,replyKeyboardMarkup);
    }

}
