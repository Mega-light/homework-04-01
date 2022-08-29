# Homework 04-01

## Instructions

Set in [webdriver.properties](src/main/resources/webdriver.properties) file the properties with executable path of:

* [chromedriver](https://chromedriver.chromium.org/)
* [msedgedriver](https://developer.microsoft.com/en-us/microsoft-edge/tools/webdriver/)
* [geckodriver](https://github.com/mozilla/geckodriver/releases)

## Exercise 1(Selenium Introduction)

Go to page: http://opencart.abstracta.us/index.php?route=common/home

    1. Verify that the title of the page is "My Store", otherwise show an error message in the terminal 
    2. Refresh the page
    3. Then go to https://google.com.sv
    4. Now you must return to the home page
    5. To finish get the current URL and compare it with "http://opencart.abstracta.us/index.php?route=common/home"
    6. At the end of the script the browser window should close

## Exercise 2(Selenium Locators)

Go to page: http://automationpractice.com/index.php

    7. Look for the element with the text "BEST SELLERS".
    8. Find the correct XPATH for that element.
    9. Find the CSS path.
    10. Use either the XPATH or CSS path to do a click action on that element.
    11. Look for another element that contains ID and locate the element By.ID in Selenium.
    12. Use this new element with an action like click or store the text it contains.
    13. Go back to the main page.
    14. Find multiple elements with the same class, for example "price product-price" and get the price of the first and the last element and show those prices in console.
    15. At the end of the script the browser window should close
