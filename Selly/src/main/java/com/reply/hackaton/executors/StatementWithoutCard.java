package com.reply.hackaton.executors;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("ask_card_number")
public class StatementWithoutCard implements IntentExecutor {
    @Override
    public String execute(Response ApiAIResponse) {
        return ApiAIResponse.getResult().getSpeech();
    }
}
