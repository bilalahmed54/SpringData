package com.vd.spring.hibernate.jpa.integration.email;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Component
public class SendInBlueEmailService {
    private static final Logger LOGGER = LoggerFactory.getLogger(SendInBlueEmailService.class);
    private static final String SENDINBLUE_API_URL = "https://api.sendinblue.com/v2.0";
    private static final String SENDINBLUE_ACCES_KEY = "yOCJLhDdAMtrznvX";
    private static final String FROM = "noreply.indiewood@gmail.com";

    public void sendEmail(String subject, String body, List<String> recipientEmail) {
        Mailin http = new Mailin(SENDINBLUE_API_URL, SENDINBLUE_ACCES_KEY);
        Map< String, String > to = new HashMap< String, String >();
        for (String email : recipientEmail) {
            to.put(email, "to");
        }

        Map < String, Object > data = new HashMap < String, Object > ();
        data.put("to", to);
        data.put("from", new String [] {FROM,"Indiewood Team"});
        data.put("subject", subject);
        data.put("text", body);

        String str = http.send_email(data);
        LOGGER.info(str);
    }
}
