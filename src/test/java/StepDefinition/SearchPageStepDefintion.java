package StepDefinition;

import Hooks.Hooks;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import io.cucumber.java.eo.Se;
import pageobjects.SearchPage;
import io.cucumber.java.en.Given;

import java.security.PrivateKey;

public class SearchPageStepDefintion {

    SearchPage searchPage = new SearchPage(Hooks.driver);


@Given("the user is on the homepage")
public void user_is_on_theHomepage() {
    searchPage.NavigateToHomePage();
    System.out.println("Navigated to home page successfully");
}
@When("the user enters {string} in the search bar")
    public void the_user_enters_location(String location ){
    searchPage.enterLocation(location);
}
@And("selects {string} as the check-in date")
   public void User_selects_checking_date(String checkindate){

    searchPage.selectCheckinDate();
}
}