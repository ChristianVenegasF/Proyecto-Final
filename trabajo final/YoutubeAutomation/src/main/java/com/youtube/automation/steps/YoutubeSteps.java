package com.youtube.automation.steps;

import com.youtube.automation.driver.DriverFactory;
import io.cucumber.java.en.*;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class YoutubeSteps {

    WebDriver driver = DriverFactory.getDriver();

    @Given("abro YouTube")
    public void abroYouTube() throws InterruptedException {
        driver.get("https://www.youtube.com");
        Thread.sleep(1500);
    }

    @When("busco el video {string}")
    public void buscoVideo(String texto) throws InterruptedException {
        WebElement search = driver.findElement(By.name("search_query"));
        search.sendKeys(texto);
        search.sendKeys(Keys.ENTER);
        Thread.sleep(2500);
    }

    @Then("reproduzco el primer resultado")
    public void reproduzcoVideo() throws InterruptedException {
        WebElement video = driver.findElement(By.cssSelector("ytd-video-renderer"));
        video.click();
        Thread.sleep(8000);
        DriverFactory.closeDriver();
    }
}
