package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static java.util.Locale.forLanguageTag;

@Route
@Service
public class MessageService extends VerticalLayout {
    private MessageSource messageSource;

    @Autowired
    public MessageService (MessageSource messageSource) {
        this.messageSource = messageSource;
        String welcome = messageSource.getMessage("welcome", new Object[]{}, forLanguageTag("pl"));
        String msg = messageSource.getMessage("msg", new Object[]{}, forLanguageTag("en"));
        System.out.println(welcome);
        System.out.println(msg);

      Button buttonSwitchLanguage = new Button(welcome = messageSource.getMessage("welcome", new Object[]{}, forLanguageTag("en")));
        buttonSwitchLanguage.addClickListener((event -> {
            Locale.forLanguageTag("en");
        }));
       add(buttonSwitchLanguage);
    }
}
