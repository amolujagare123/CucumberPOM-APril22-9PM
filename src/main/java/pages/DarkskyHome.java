package pages;

import org.openqa.selenium.By;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class DarkskyHome extends Base {

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");
    By lowTempText = By.xpath("//span[@class='low-temp-text']");
    By highTempText = By.xpath("//span[@class='high-temp-text']");

    By barLowTempText = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By barHighTempText = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");


    public ArrayList<String> getCurrentTempList()
    {
        String lowTemp = getTextFromElement(lowTempText).split("˚")[0];//82˚
        String highTemp = getTextFromElement(highTempText).split("˚")[0];//82˚

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(lowTemp);
        tempList.add(highTemp);

        return tempList;
    }

    public ArrayList<String> getBarTempList()
    {
        String lowTemp = getTextFromElement(barLowTempText).split("˚")[0];//82˚
        String highTemp = getTextFromElement(barHighTempText).split("˚")[0];

        ArrayList<String> tempList = new ArrayList<>();
        tempList.add(lowTemp);
        tempList.add(highTemp);

        return tempList;
    }

    public int getCurrentTemp()
    {
        String tempTextRaw = getTextFromElement(currentTempText);
        //98˚ Clear. --> {"98"," Clear."}
        String tempStr = tempTextRaw.split("˚")[0];

        return Integer.parseInt(tempStr);
    }

    public int getTimelineTemp()
    {
        String tempTextRaw = getTextFromElement(timelineTempText);
        //100° --> {"100"}
        String tempStr = tempTextRaw.split("°")[0];

        return Integer.parseInt(tempStr);
    }
}
