package com.reply.hackaton.executors;

import com.reply.hackaton.EntityEnum;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

import java.util.Random;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("TransactionTotal_Inquiry")
public class TransactionTotalInquiry implements IntentExecutor {
    @Override
    public String execute(Response apiAIResponse) {
        return getCarParameter(apiAIResponse);
    }

    private String getCarParameter(Response apiAIResponse){
        String cardEntity = apiAIResponse.getResult().getParameters().get(EntityEnum.CARD.getApiAiEntityName());
        String periodEntity = apiAIResponse.getResult().getParameters().get(EntityEnum.PERIOD.getApiAiEntityName());

        if (cardEntity == null){
            return ResponseForMissingParameters.CARD;
        } else if (periodEntity == null){
            return ResponseForMissingParameters.PERIOD;
        } else{
            return "Hai speso " + getRandomCardBalance();
        }
    }

    private int getRandomCardBalance(){
        Random r = new Random();
        int Low = 1000;
        int High = 40000;
        return r.nextInt(High-Low) + Low;
    }

    private static class ResponseForMissingParameters {
        private static String CARD = "Per quale carta?";
        private static String PERIOD = "Per quale periodo?";
        private static String SUCCESS = "Per quale carta?";
    }
}
