package projects;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestCase1SortTest extends TestBase {

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() >0 and position() < 11]/td[1]")
    List <WebElement> rankColumn;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/thead/tr/th[2]")
    WebElement NOCbutton;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr/th")
    List<WebElement> countryNamesSorted;

    @FindBy(xpath = "//table[@class='wikitable sortable plainrowheaders jquery-tablesorter']/tbody/tr[position() > 0 and position() < 12 and not(position()=8)]/td[1]")
    List<WebElement> rankAfterNOC;


    public void sortTestMethod(){

        //2.Verify that by default the Medal table is sorted by rank.To do that you need to
        // capture all the cells in the Rank column and check if they are in ascending order
        // (highlighted in the picture).

        List<Integer> rankInt = new ArrayList<>();
        for (int i=0; i< rankColumn.size(); i++) {
            rankInt.add(Integer.valueOf(rankColumn.get(i).getText()));
             Assert.assertTrue(Integer.valueOf(rankColumn.get(i).getText()).equals(rankInt.get(i)));
        }


        //3.Click link NOC
        NOCbutton.click();

        //4.Now verify that the table is now sorted by the country names. To do that you need to capture all the names in the NOC
        // column and check if they are in ascending / alphabetical order (highlighted in the picture).

        List<String> countryNamesStrList = new ArrayList<>();
        for (int i=0; i< countryNamesSorted.size(); i++) {
            countryNamesStrList.add(countryNamesSorted.get(i).getText());
        }


        Collections.sort(countryNamesStrList);
        for (int i=0; i< countryNamesSorted.size(); i++){
            Assert.assertTrue(countryNamesSorted.get(i).getText().equals(countryNamesStrList.get(i)));
        }


        //5.Verify that Rank column is not in ascending order any more.


        for (int i=0; i< rankAfterNOC.size(); i++) {

            System.out.println(rankAfterNOC.get(i).getText());
            Assert.assertFalse(Integer.valueOf(rankAfterNOC.get(i).getText()).equals(rankInt.get(i)));

        }







    }






}
