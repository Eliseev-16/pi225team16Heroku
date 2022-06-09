package bot;

import com.pengrad.telegrambot.Callback;
import com.pengrad.telegrambot.TelegramBot;
import com.pengrad.telegrambot.UpdatesListener;
import com.pengrad.telegrambot.model.BotCommand;
import com.pengrad.telegrambot.model.Update;
import com.pengrad.telegrambot.model.request.Keyboard;
import com.pengrad.telegrambot.model.request.ReplyKeyboardMarkup;
import com.pengrad.telegrambot.request.GetMyCommands;
import com.pengrad.telegrambot.request.GetUpdates;
import com.pengrad.telegrambot.request.SendMessage;
import com.pengrad.telegrambot.response.GetMyCommandsResponse;
import com.pengrad.telegrambot.response.GetUpdatesResponse;
import com.pengrad.telegrambot.response.SendResponse;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Bot {

    private TelegramBot bot;
    private ArrayList <Long> usersWaitingForResponse = new ArrayList();
    private static String errorMessage = "Произошла ошибка. Пожалуйста, попробуйте зарегестрироваться позже";
    private int offset = 0;

    private  static  Keyboard baseMenu = new ReplyKeyboardMarkup(
            new String[]{"Получить пароль Wi-Fi", "Зарегестрироваться"})
            //new String[]{"second row button1", "second row button2"})
            .oneTimeKeyboard(true)   // optional
            .resizeKeyboard(true)    // optional
            .selective(true);        // optional


    public Bot(){
       this.bot = new TelegramBot("5578236469:AAGt1n4IU1scmfwtXUV_nQ8vDhUI7-xhXDI");
       //5066734522:AAFg1jbtkkkuvYbt19O3uD73XwcxGXCoAHg
        //5578236469:AAGt1n4IU1scmfwtXUV_nQ8vDhUI7-xhXDI

        System.out.println("Work..");

       updateMes();


    }

    private void updateMes(){

        // Register for updates
        bot.setUpdatesListener(updates -> {
            // ... process updates
            // return id of last processed update or confirm them all
            recognize(updates);

//            GetUpdates getUpdates = new GetUpdates().limit(1).offset(0).timeout(0);
//
//            // async
//            bot.execute(getUpdates, new Callback<GetUpdates, GetUpdatesResponse>() {
//                @Override
//                public void onResponse(GetUpdates request, GetUpdatesResponse response) {
//                    List<Update> updates = response.updates();
//                    recognize(updates);
//                }
//
//                @Override
//                public void onFailure(GetUpdates getUpdates, IOException e) {
//                    System.out.println("Что-то пошло не так..");
//                }
//
//            });

            return UpdatesListener.CONFIRMED_UPDATES_ALL;
        });



    }



    private void sendMes(Update update, String mes){
                long chatId = update.message().chat().id();
                SendResponse response = bot.execute(new SendMessage(chatId, mes));
    }



    private void recognize(List <Update> updates){

        if (updates.size() != 0) {

            GetMyCommandsResponse commandsList = getCommand(); //Просто так..
            List <BotCommand> BotCom = Arrays.asList(commandsList.commands());//Просто так..

            for (int i = 0; i < updates.size(); i++) {
                Update update = updates.get(i);
                offset = update.updateId() + 1;
                String mes = update.message().text();
                long chatId = update.message().chat().id();

                if (mes.equals("Назад")) new BackCommand(bot,update,chatId,baseMenu,usersWaitingForResponse);

                else if (usersWaitingForResponse.contains(chatId)) new RegisterCommand(bot,update,chatId,
                        baseMenu,usersWaitingForResponse,1);

                else if (mes.equals("Получить пароль Wi-Fi")) new WiFiCommand(bot,update,chatId,baseMenu);
                else if (mes.equals("Зарегестрироваться")) new RegisterCommand(bot,update,chatId,baseMenu,
                        usersWaitingForResponse,0);
                else if (mes.equals("/start")) new StartCommand(bot,update,chatId,baseMenu);
                else new InvalidCommand(bot,update,chatId,baseMenu);
            }


        }


    }


    public GetMyCommandsResponse getCommand() {
        GetMyCommands commands = new GetMyCommands();
        GetMyCommandsResponse commands_response = bot.execute(commands);
        return commands_response;
    }

    public static Keyboard getBaseMenu() {
        return baseMenu;
    }

    public static String getErrorMessage(){
        return errorMessage;
    }
}