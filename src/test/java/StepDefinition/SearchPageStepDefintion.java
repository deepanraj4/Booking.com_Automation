package StepDefinition;

import Hooks.Hooks;
import io.cucumber.java.PendingException;
import io.cucumber.java.en.And;
import io.cucumber.java.en.When;
import pageobjects.SearchPage;
import io.cucumber.java.en.Given;

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
    searchPage.selectCheckinDate(checkindate);
}
@And ("selects {string} as the check-out date")
    public void user_selects_checkout_date(String checkoutdate){
searchPage.selectCheckoutDate(checkoutdate);
}
@And("selects {string} as the number of guests")
    public void user_selects_number_of_guests( String numberofguests){
    int guestCount = Integer.parseInt(numberofguests);
    searchPage.select_numberof_guests(guestCount);
}
@And("selects {string} as the number of rooms")
public void user_selects_number_of_rooms(String numberofrooms){
    int roomCount = Integer.parseInt(numberofrooms);
    searchPage.select_numberof_rooms(roomCount);
}

    @And("clicks on the search button")
    public void clicksOnTheSearchButton() {
    searchPage.clickSearchButton();
    }
}