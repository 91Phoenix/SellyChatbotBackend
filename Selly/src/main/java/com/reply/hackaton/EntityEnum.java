package com.reply.hackaton;

/**
 * Created by m.ditucci on 12/05/2017.
 */
public enum EntityEnum {
    CARD("Card"),
    PERIOD("date-period");

    private String apiAiEntityName;

    EntityEnum(String apiAiEntityName){
        this.apiAiEntityName = apiAiEntityName;
    }

    public String getApiAiEntityName() {
        return apiAiEntityName;
    }
}
