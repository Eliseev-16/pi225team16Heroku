package bot;

import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import dataBase.SQLReader;
import fileManager.ReadFile;

import java.util.ArrayList;

public class WiFiCommand extends Commands{

    WiFiCommand(TelegramBot bot, Update item, long chatId, Keyboard replyKeyboardMarkup){
        super("WiFi","Get WiFi password");

        try {
            int access = SQLReader.readUser(chatId);

            if (access == 1){//Если пользователь зарегестрирован
                String mes = getWifiPassword();
                sendMes(bot,mes,chatId,replyKeyboardMarkup);
            } else {//Если пользователь не зарегестрирован
                String mes = "В доступе отказано. Необходимо зарегестрироваться.";
                sendMes(bot,mes,chatId,replyKeyboardMarkup);
            }


        } catch (Exception e) {
            sendMes(bot,Bot.getErrorMessage(),chatId,replyKeyboardMarkup);
        }

    }

    private String getWifiPassword(){

//        String pathToWiFiPassword = "/home...";
//        String wifiPass;
//        ArrayList <String> password = new ReadFile().getText();
//
//        wifiPass = password.get(0);
//        return wifiPass;

        return "12345";
    }

}
