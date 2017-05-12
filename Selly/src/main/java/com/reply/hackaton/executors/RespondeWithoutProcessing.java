package com.reply.hackaton.executors;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("forward")
public class RespondeWithoutProcessing implements IntentExecutor {
    @Override
    public String execute(Response apiAIResponse) {
        return apiAIResponse.getResult().getSpeech();
    }
}