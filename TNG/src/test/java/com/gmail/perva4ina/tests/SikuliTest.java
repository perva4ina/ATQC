package com.gmail.perva4ina.tests;

import org.sikuli.basics.Settings;
import org.sikuli.script.Screen;
import org.sikuli.script.SikuliException;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SikuliTest extends BaseWebTest{

    @BeforeClass
    public void setup() {
        setupDriver("http://google.com");
    }

    @Test
    public void openBrowserSettings() {
        Screen s = new Screen();
        Settings settings = new Settings();
//        settings.
        try{
            s.click("C:\\GIT\\TNG\\src\\test\\java\\com\\gmail\\perva4ina\\pages\\img\\menuButton.png");
            s.wait("C:\\GIT\\TNG\\src\\test\\java\\com\\gmail\\perva4ina\\pages\\img\\settingsButton.png");
            s.click("C:\\GIT\\TNG\\src\\test\\java\\com\\gmail\\perva4ina\\pages\\img\\settingsButton.png");
            s.find("C:\\GIT\\TNG\\src\\test\\java\\com\\gmail\\perva4ina\\pages\\img\\settingsButton.png");
        }
        catch (SikuliException e){
            e.printStackTrace();
        }
    }
}
