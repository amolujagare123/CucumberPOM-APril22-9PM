package pages;

import org.openqa.selenium.By;

import java.util.ArrayList;

public class DarkskyHome extends Base {

    By currentTempText = By.xpath("//span[@class='summary swap']");
    By timelineTempText = By.xpath("//span[@class='first']//span");
    By lowTempText = By.xpath("//span[@class='low-temp-text']");
    By highTempText = By.xpath("//span[@class='high-temp-text']");

    By barLowTempText = By.xpath("//a[@data-day='0']//span[@class='minTemp']");
    By barHighTempText = By.xpath("//a[@data-day='0']//span[@class='maxTemp']");

    By timeListRaw = By.xpath("//span[@class='hour']/span");

    public ArrayList<Integer> getTimeList()
    {
        ArrayList<String> timelist = getElementTextList(timeListRaw);
        System.out.println(timelist);

        ArrayList<Integer> timelistInt = new ArrayList<>();

        for (int i=0;i<timelist.size();i++)
        {
            String rawTime = timelist.get(i); // 11am , 1pm

            int l = rawTime.length();
            String timeStr = rawTime.substring(0, l - 2);
            int time = Integer.parseInt(timeStr);
            timelistInt.add(time);
        }
        System.out.println(timelistInt);

        return timelistInt;
    }


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
