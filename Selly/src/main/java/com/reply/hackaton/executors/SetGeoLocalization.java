package com.reply.hackaton.executors;

import com.reply.hackaton.model.AndroidClientResponse;
import com.reply.hackaton.model.IntentExecutor;
import com.reply.hackaton.model.Response;
import com.reply.hackaton.model.User;
import com.reply.hackaton.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * Created by m.ditucci on 13/05/2017.
 */
@Service("Set_geolocalization")
public class SetGeoLocalization implements IntentExecutor {
    private static final String WORLD = "World";
    @Autowired
    private UserRepository userRepository;

    @Override
    @Transactional
    public String execute(Response apiAIResponse, AndroidClientResponse androidClientResponse) {
        User user = userRepository.findOne("525500******9045");
        user.setGeoFencing(WORLD);
        return apiAIResponse.getResult().getSpeech();
    }
}
