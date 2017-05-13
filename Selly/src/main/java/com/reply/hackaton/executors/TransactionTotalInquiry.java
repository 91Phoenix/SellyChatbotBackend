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
        if (apiAIResponse.getResult().isActionIncomplete()){
            return apiAIResponse.getResult().getSpeech();
        }

        return "Hai speso 782,10 euro.";
    }
}
