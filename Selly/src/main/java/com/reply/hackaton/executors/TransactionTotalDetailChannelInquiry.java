package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import org.springframework.stereotype.Service;

/**
 * Created by m.ditucci on 12/05/2017.
 */
@Service("TransactionTotal_Detail_Channel_Inquiry")
public class TransactionTotalDetailChannelInquiry implements IntentExecutor{
    private static final String AMAZON = "amazon";
    private static final String AMAZON_WEB_SITE_URL = "CODICE COUPON: 4VBW-NV5GQ8-XPNZ ";

    @Override
    public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
        if (apiAIResponse.getResult().isActionIncomplete()){
            return apiAIResponse.getResult().getSpeech();
        }

        androidClientResponse.setResponseImageLink(AMAZON_WEB_SITE_URL);
        androidClientResponse.setResponseImageName(AMAZON);

        return "Hai fatto pagamenti in e-commerce per un totale di 110,63 €" + "\n\n" + showAmazonOffer();
    }

//    private String getTotalAmountForCardInPeriod() {
//        return "Hai fatto pagamenti in e-commerce per un totale di " + Utils.getRandomCardBalance() + " euro.";
//    }

    private String showAmazonOffer(){
        return "Ho visto che hai accumulato 22000 punti fedeltà IoSi. Cosa ne pensi di richiedere gratuitamente un buono Amazon da 50 €? ";
    }


}
