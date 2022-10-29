package StepDefinitions;

import Utils.SetupClass;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import java.net.MalformedURLException;



public class S01_AddProduct extends SetupClass{

    @Given("user go to categories screen")
    public void userGoToCategoriesScreen() throws MalformedURLException {
        SetupClass.setUp();
        homePage.clickCategories();
    }

    @When("user choose category list")
    public void userChooseCategoryList() {
       categoriesPage.clickCategoryItem();
    }

    @And("user select sub category")
    public void userSelectSubCategory() throws InterruptedException {
       categoriesPage.scrollToCategoryItem("Absolute");
    }

    @And("user select product")
    public void userSelectProduct() {
        productsPage.selectProduct();
    }

    @And("user select color")
    public void userSelectColor() {
        productsPage.selectColor();
    }

    @And("user add item to the cart")
    public void userAddItemToTheCart() {
        productsPage.clickAddToCartBtn();
    }


    @Then("item should be added successfully to the cart")
    public void itemShouldBeAddedSuccessfullyToTheCart() {
        productsPage.assertSuccessfullyAddingToTheCart();
    }
}
