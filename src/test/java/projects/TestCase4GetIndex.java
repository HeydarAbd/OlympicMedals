package projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

import java.util.List;

public class TestCase4GetIndex extends TestBase{

    @FindBy(xpath = "(//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 12]/td[2]/../th/a)")
    List<WebElement> allCountriesList;


    public String takesCountryName(String countryStr){

        int row = 0;

        for (int i=0; i< allCountriesList.size(); i++){
            if (allCountriesList.get(i).getText().equals(countryStr)){
                row = i+1;
                return countryStr + " is in the row: " + row;
            }
        }

        if(row ==0){
            return "ERROR! Country not on the list";
        }

        return null;



    }







}
