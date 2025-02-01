package com.example.demo.steps;

import com.example.demo.base.TestBase;
import com.example.demo.page.HomePage;
import io.cucumber.java.en.And;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class NewSteps extends TestBase {
    private HomePage hp;
    private static final Logger logger = LoggerFactory.getLogger(NewSteps.class);

    @And("the user searches for {string}")
    public void the_user_searches_for(String Product) throws InterruptedException {
        logger.info(Product);
        hp = new HomePage(getDriver());
        hp.performAction();
    }

}
