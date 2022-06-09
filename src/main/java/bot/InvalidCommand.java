package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;

public class InvalidCommand extends Commands{

    InvalidCommand(TelegramBot bot, Update item, long chatId, Keyboard replyKeyboardMarkup){
        super("invalidcommand","Not a command");

        sendMes(bot,"Неверная команда!",chatId,replyKeyboardMarkup);
    }
}
