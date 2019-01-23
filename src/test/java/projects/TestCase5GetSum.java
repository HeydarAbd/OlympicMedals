package projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase5GetSum extends TestBase {

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[4]")
    List<WebElement> bronzeList;

    @FindBy(xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 12]/td[2]/../th/a)")
    List<WebElement> allCountriesName;



    List<Integer> allBronzeInt = new ArrayList<>();
    static int firstCountrySpot = 0;
    static int secondCountrySpot=0;
    static String firstCountryOf18="";
    static String secondCountryOf18="";

    public String totalBrozeIs18(){

        //get the all the bronze medals to Integer List
        for (int i=0; i< bronzeList.size(); i++){
            allBronzeInt.add(Integer.parseInt(bronzeList.get(i).getText()));
        }


        //find out the total 18 bronzes spot on the Integer List
        for (int i=0; i<allBronzeInt.size()-1; i++){
            for (int x=i+1; x<allBronzeInt.size(); x++){
                if (allBronzeInt.get(i) + allBronzeInt.get(x) == 18){
                    firstCountrySpot = i;
                    secondCountrySpot = x;
                    break;
                }
            }
        }


        String result = allCountriesName.get(firstCountrySpot).getText() + " and " +
                allCountriesName.get(secondCountrySpot).getText() + " have totatl 18 bronze";

        return result;
    }




}
