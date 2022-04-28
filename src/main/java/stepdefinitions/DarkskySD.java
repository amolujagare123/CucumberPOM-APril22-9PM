package stepdefinitions;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import pages.DarkskyHome;

import java.util.ArrayList;

import static stepdefinitions.SharedSD.getDriver;

public class DarkskySD {

    DarkskyHome darkskyHome = new DarkskyHome();

    @Given("I am on Darksky Home Page")
    public void i_am_on_darksky_home_page() {

        Assert.assertEquals("This is not a Darksky home page",
                "Dark Sky - Sansad Marg, New Delhi, Delhi",
                getDriver().getTitle());

    }

    @Then("I verify current temp is equal to Temperature from Daily Timeline")
    public void i_verify_current_temp_is_equal_to_temperature_from_daily_timeline() {

        int expected = darkskyHome.getCurrentTemp();
        int actual = darkskyHome.getTimelineTemp();
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals("the temperatures are different",expected,actual);
    }

    @Then("I verify today's lowest and highest temp is displayed correctly")
    public void iVerifyTodaySLowestAndHighestTempIsDisplayedCorrectly() {

        ArrayList<String> expected = darkskyHome.getCurrentTempList();
        ArrayList<String> actual = darkskyHome.getBarTempList();
        System.out.println("expected="+expected);
        System.out.println("actual="+actual);
        Assert.assertEquals("the temperatures are different",expected,actual);

    }
}
