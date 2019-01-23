package projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase3CountryByMedal  extends TestBase{

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[4]")
    WebElement silverBtn;

    @FindBy(xpath =  "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 1 and position() < 12]/td[3]")
    List<WebElement> silverList;

    @FindBy(xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 1 and position() < 12]/td[2]/../th/a)")
    List<WebElement> allCountriesName;



    public List<String> silverMedalCount() {

        silverBtn.click();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        silverBtn.click();

        List<String> silverStrList = new ArrayList<>();
        for (int i = 0; i < silverList.size(); i++) {
            silverStrList.add(silverList.get(i).getText());
        }


        List<String> silverCountriesStr = new ArrayList<>();
        for (int i = 0; i < allCountriesName.size(); i++) {
            silverCountriesStr.add(allCountriesName.get(i).getText() + " : " + silverStrList.get(i) + " silver medals");
        }





        return silverCountriesStr;

    }



}
