package com.example.demo;

import com.vaadin.flow.component.button.Button;
import com.vaadin.flow.component.html.Label;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.Route;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Component;

import java.util.Locale;



@Route
@Component
public class MainView extends VerticalLayout {

    private MessageSource messageSource;

    @Autowired
    public MainView(MessageSource messageSource) {
        this.messageSource = messageSource;

            Button buttonSwitchLanguageToEnglish = new Button("ENGLISH");
            buttonSwitchLanguageToEnglish.addClickListener((eventEn -> {
                Locale.forLanguageTag("en");
            }));
                Button buttonSwitchLanguageToPolish = new Button("POLSKI");
                buttonSwitchLanguageToPolish.addClickListener((eventPl -> {
                    Locale.forLanguageTag("pl");

                }));
                add(buttonSwitchLanguageToEnglish, buttonSwitchLanguageToPolish);


            }
    }
