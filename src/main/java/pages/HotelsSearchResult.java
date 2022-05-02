package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;

import static stepdefinitions.SharedSD.getDriver;

public class HotelsSearchResult extends Base{

    public void clickStarRating(String star)
    {
        WebElement element = getDriver().findElement(By.xpath("//input[@value='class=" + star + "']"));

        JavascriptExecutor js = (JavascriptExecutor) getDriver();
        js.executeScript("arguments[0].click()",element);

    }

    By totalStarRating = By.xpath("//div[@data-testid='rating-stars']");
    By totalStars = By.xpath("//div[@data-testid='rating-stars']/span");

    public int getStarRating()
    {
        getDriver().navigate().refresh();
        int totalStarInt = getDriver().findElements(totalStars).size();
        int totalStarRatingInt = getDriver().findElements(totalStarRating).size();

        return totalStarInt/totalStarRatingInt ;
    }
}
