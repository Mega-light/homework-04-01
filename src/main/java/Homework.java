import org.jetbrains.annotations.NotNull;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Homework {
    public static void main(String[] args) {
        loadWebDriverProperties();

        runExercise1(new ChromeDriver());
        runExercise1(new FirefoxDriver());
        runExercise1(new EdgeDriver());

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
