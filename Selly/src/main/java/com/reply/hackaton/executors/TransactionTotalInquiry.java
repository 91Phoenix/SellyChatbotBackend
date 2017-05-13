package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("TransactionTotal_Inquiry")
public class TransactionTotalInquiry implements IntentExecutor {
    @Override
    public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
        if (apiAIResponse.getResult().isActionIncomplete()){
            return apiAIResponse.getResult().getSpeech();
        }

        return "Hai speso 782,10 €";
    }
}
