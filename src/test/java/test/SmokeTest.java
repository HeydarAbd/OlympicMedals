package test;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import projects.*;

public class SmokeTest extends TestBase {


    @Test(priority = 1)
    public void sortTest(){
        TestCase1SortTest sortObj = PageFactory.initElements(driver, TestCase1SortTest.class);
        sortObj.sortTestMethod();

    }


    @Test(priority = 2)
    public void theMost(){
        TestCase2TheMost medals = PageFactory.initElements(driver, TestCase2TheMost.class);

        System.out.println(medals.countryTheGreatestNumberOfGOld());
        System.out.println(medals.countryTheGreatestNumberOfSilver());
        System.out.println(medals.countryWithTheGreatestNumberOfBronzeMedals());
        System.out.println(medals.countryWithTheGreatestNumberOfAllMedals());
    }


    @Test(priority = 3)
    public void countryByMedal(){
        TestCase3CountryByMedal silver = PageFactory.initElements(driver, TestCase3CountryByMedal.class);
        System.out.println(silver.silverMedalCount());
    }


    @Test(priority = 4)
    public  void findTheRowAndColumn(){
        TestCase4GetIndex find = PageFactory.initElements(driver, TestCase4GetIndex.class);
        System.out.println(find.takesCountryName("Germany"));
    }


    @Test(priority = 5)
    public void countriesTotal18(){
        TestCase5GetSum sum = PageFactory.initElements(driver, TestCase5GetSum.class);
        System.out.println(sum.totalBrozeIs18());
    }




}
