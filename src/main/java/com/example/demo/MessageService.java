package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import java.util.Locale;

import static java.util.Locale.forLanguageTag;

@Route("mainpl")
@Service
public class MessageService extends VerticalLayout {
    private MessageSource messageSource;

    @Autowired
    public MessageService (MessageSource messageSource) {
        this.messageSource = messageSource;
        String welcome = messageSource.getMessage("welcome", new Object[]{}, forLanguageTag("pl"));
        String header = messageSource.getMessage("header", new Object[]{}, forLanguageTag("pl"));
        System.out.println(welcome);
        H2 h2Header = new H2(header);

        Button buttonSwitchLanguage = new Button(welcome);
        buttonSwitchLanguage.addClickListener((event -> {
            Locale.forLanguageTag("pl");
        }));
        add(h2Header);
        add(buttonSwitchLanguage);

    }
}
