package commons.factoryBrowser;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChromeDriverManager implements BrowserFactory{

    @Override
    public WebDriver getBrowserDriver() {
        ChromeOptions chromeOptions = new ChromeOptions();
        chromeOptions.addArguments("--user-data-dir=C:/Users/anlehoang/AppData/Local/Google/Chrome/User Data/");
        chromeOptions.addArguments("--profile-directory=Profile 6");
        chromeOptions.addArguments("--incognito");
        return new ChromeDriver(chromeOptions);
    }
}
