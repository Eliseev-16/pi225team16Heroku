package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;

public class StartCommand extends Commands{

    StartCommand(TelegramBot bot, Update item, long chatId, Keyboard replyKeyboardMarkup){
        super("start","Start the bot..");

        sendMes(bot,"Добро пожаловать!",chatId,replyKeyboardMarkup);

    }
}
