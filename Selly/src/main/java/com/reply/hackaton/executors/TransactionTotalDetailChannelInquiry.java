package com.reply.hackaton.executors;

import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("TransactionTotal_Detail_Channel_Inquiry")
public class TransactionTotalDetailChannelInquiry implements IntentExecutor{
    @Override
    public String execute(Response apiAIResponse) {
        if (apiAIResponse.getResult().isActionIncomplete()){
            return apiAIResponse.getResult().getSpeech();
        }

        return "Hai fatto pagamenti in e-commerce per un totale di 448,63 €" + "\n\n" + showAmazonOffer();
    }

//    private String getTotalAmountForCardInPeriod() {
//        return "Hai fatto pagamenti in e-commerce per un totale di " + Utils.getRandomCardBalance() + " euro.";
//    }

    private String showAmazonOffer(){
        return "Ho visto che hai accumulato 22000 punti fedeltà MySi. Cosa ne pensi di richiedere gratuitamente un buono Amazon da 50 €? ";
    }


}
