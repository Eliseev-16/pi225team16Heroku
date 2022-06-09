package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import dataBase.SQLAdder;
import dataBase.SQLReader;

import java.util.ArrayList;

public class RegisterCommand extends Commands {

    public RegisterCommand(TelegramBot bot, Update item, long chatId, Keyboard replyKeyboardMarkup,
                           ArrayList<Long> users, int mode) {
        super("register", "Register new user");

        Keyboard backMenu = new ReplyKeyboardMarkup("Назад")
                .oneTimeKeyboard(true)   // optional
                .resizeKeyboard(true)    // optional
                .selective(true);        // optional

        if (mode == 0){

            try {
                int access = SQLReader.readUser(chatId);

                if (access == 0) {
                    String mes = "Введите идентификатор";
                    sendMes(bot,mes,chatId,backMenu);
                    users.add(chatId);
                } else {
                    String mes = "Вы уже авторизованы и можете получить пароль от WiFi";
                    sendMes(bot,mes,chatId,replyKeyboardMarkup);
                }

            } catch (Exception e) {
                sendMes(bot,Bot.getErrorMessage(),chatId,replyKeyboardMarkup);
            }


        }
        else {

        //---------------------Сохранение пользователя в БД--------------------
            String mesKey = item.message().text();
            boolean access = isValidUser(mesKey);

            if (access){
                users.remove(chatId);

                try {
                    SQLAdder.addUser(chatId, item.message().chat().username(),
                            item.message().chat().firstName(),mesKey);

                    sendMes(bot,"Идентификатор верен. Теперь вы можете получить пароль от WiFi",
                            chatId,replyKeyboardMarkup);


                } catch (Exception e){
                    sendMes(bot,Bot.getErrorMessage(),chatId,replyKeyboardMarkup);
                }


            }else {
                String mes = "Введен неверный идентификатор. Попробуйте ввести другой";
                sendMes(bot,mes,chatId,backMenu);
            }



        //---------------------------------------------------------------------

        }




    }

    private boolean isValidUser(String mesKey){
        boolean access = false;

        if (mesKey.equals("123")){
            access = true;
        }else access = false;

        return access;
    };

}
