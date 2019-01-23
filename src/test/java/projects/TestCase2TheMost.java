package projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCase2TheMost extends TestBase {

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[2]")
    List<WebElement> goldsList;

    @FindBy(xpath =  "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[3]")
    List<WebElement> silverList;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[4]")
    List<WebElement> bronzeList;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[5]")
    List<WebElement> allMedalsList;

    @FindBy(xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 11]/td[2]/../th/a)")
    List<WebElement> allCountriesName;


    public String countryTheGreatestNumberOfGOld() {

        return "The country with the greatest number of GOLD medals : " + findGreatMedals(goldsList);

    }


    public String countryTheGreatestNumberOfSilver() {

        return "The country with the greatest number of SILVER medals : " + findGreatMedals(silverList);

    }


    public String countryWithTheGreatestNumberOfBronzeMedals(){

        return "The country with the greatest number of BRONZE medals : " + findGreatMedals(bronzeList);
    }


    public String countryWithTheGreatestNumberOfAllMedals(){

        return "The country with the greatest number of ALL medals : " + findGreatMedals(allMedalsList);

    }


    
    public String findGreatMedals(List<WebElement> exmpl){

        int bestMedalsInt=0;
        int spotBestMedals = 0;

        for (int i=0; i< exmpl.size(); i++){
            if (Integer.valueOf(exmpl.get(i).getText()) > bestMedalsInt ){
                bestMedalsInt = Integer.valueOf(exmpl.get(i).getText());
            }
        }


        for (int j=0; j<exmpl.size(); j++){
            if ( Integer.valueOf(exmpl.get(j).getText()) == bestMedalsInt){
                spotBestMedals = j;
            }
        }


        String bestCountry = allCountriesName.get(spotBestMedals).getText();
        return  bestCountry;
        
        
    }





}
