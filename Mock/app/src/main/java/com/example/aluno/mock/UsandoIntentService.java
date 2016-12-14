package com.example.aluno.mock;

import android.app.IntentService;
import android.content.Intent;
import android.util.Log;

/**
 * Created by Aluno on 13/12/2016.
 */

public class UsandoIntentService extends IntentService{

    public UsandoIntentService() {
        super("Usando intent service");
    }

    @Override
    protected void onHandleIntent(Intent intent) {

        int ammountSeconds = 15;
        int countSeconds = 0;

        while (countSeconds < ammountSeconds){
            synchronized (this){
                try{
                    Log.e("gustavo", "" + countSeconds);
                    wait(1000);
                    countSeconds++;

                }catch (Exception e){

                }
            }
        }

    }
}
