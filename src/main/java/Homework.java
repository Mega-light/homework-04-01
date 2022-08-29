import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.Properties;

public class Homework {
    public static void main(String[] args) {
        loadWebDriverProperties();

        runExercise1(new ChromeDriver());
        runExercise1(new FirefoxDriver());
        runExercise1(new EdgeDriver());

        runExercise2(new ChromeDriver());
        runExercise2(new FirefoxDriver());
        runExercise2(new EdgeDriver());

    }

    /**
     * Run the Selenium Locators
     * @param webDriver  Implementation of <code>WebDriver</code> to be run
     */
    private static void runExercise2(@NotNull WebDriver webDriver){
        String url = "https://automationpractice.com/index.php";
        webDriver.manage().window().maximize();
        webDriver.get(url);


        // Look for the element with the text "BEST SELLERS"

        // Find the correct XPATH for that element
        WebElement xpathElement = webDriver.findElement(By.xpath("//a[@class='blockbestsellers']"));
        // Find the CSS path
        WebElement cssElement = webDriver.findElement(By.cssSelector("a.blockbestsellers"));

        // Use either the XPATH or CSS path to do a click action on that element
        cssElement.click();

        // Look for another element that contains ID and locate the element By ID

        // Use this new element with an action like click or store the text it contains
        WebElement searchQueryTop = webDriver.findElement(By.id("search_query_top"));
        searchQueryTop.sendKeys("Printed Dress");
        webDriver.findElement(By.cssSelector("#searchbox>button")).click();

        // Go back to the main page
        webDriver.navigate().back();

        // Find multiple elements with the same class, for example
        // "price product-price" and get the price of the first and the last
        // element and show those prices in console
        List<WebElement> elements = webDriver.findElements(By.cssSelector("[class='price product-price']"));
        elements.removeIf(next -> next.getText().isEmpty());
        WebElement first = elements.get(0);
        System.out.println(first.getText());
        WebElement last = elements.get(elements.size() - 1);
        System.out.println(last.getText());

        // Close the browser window
        webDriver.close();
    }


    /**
     * Run the Selenium Introduction
     * @param webDriver  Implementation of <code>WebDriver</code> to be run
     */
    private static void runExercise1(@NotNull WebDriver webDriver){
        String url = "https://opencart.abstracta.us/index.php?route=common/home";
        webDriver.manage().window().maximize();
        webDriver.get(url);

        // 1. Verify that the title of the page is "My Store", otherwise show an error message in the terminal
        String actualTitle = webDriver.getTitle();
        String expectedTitle = "My Store";
        if (expectedTitle.equals(actualTitle)){
            System.out.println(expectedTitle + " is the page title");
        } else {
            System.out.println("ERROR: '" + actualTitle + "' is the page title" +
                    " instead of " + expectedTitle + " in " + url);
        }

        // 2. Refresh the page
        webDriver.navigate().refresh();

        // 3. Go to https://google.com.sv

        url = "https://google.com.sv";
        webDriver.get(url);

        // 4. Return to the home page
        webDriver.navigate().back();

        // 5. Get the current URL and compare it with
        // “https://opencart.abstracta.us/index.php?route=common/home”
        String expectedURL = "https://opencart.abstracta.us/index.php?route=common/home";
        String currentUrl = webDriver.getCurrentUrl();
        if (expectedURL.equals(currentUrl)){
            System.out.println("The home page returned successfully " + expectedURL);
        }

        // 6. Close the browser
        webDriver.close();
    }

    /**
     * Load the vendors' driver into System's properties.
     */
    private static void loadWebDriverProperties(){
        Properties configProp = System.getProperties();
        try (InputStream in = Homework.class.getClassLoader().getResourceAsStream("webdriver.properties")){
            configProp.load(in);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
