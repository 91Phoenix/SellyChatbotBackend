package com.reply.hackaton.executors;

import java.util.Random;

/**
 * Created by m.ditucci on 12/05/2017.
 */
public class Utils {

    public static int getRandomCardBalance(){
        Random r = new Random();
        int Low = 1000;
        int High = 40000;
        return r.nextInt(High-Low) + Low;
    }
}
