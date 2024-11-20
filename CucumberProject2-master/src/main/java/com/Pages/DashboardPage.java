package com.Pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.ArrayList;
import java.util.List;

public class DashboardPage {

    private WebDriver driver;

    private By dashboardLeftPanel=By.xpath("//*[@class='oxd-sidepanel-body']//li");

    public DashboardPage(WebDriver driver){
        this.driver=driver;
    }
    public int getLeftPanelCount(){
        return driver.findElements(dashboardLeftPanel).size();
    }

    public String getDashboardPagetitile(){
        return driver.getTitle();
    }

    public List<String> getleftPanelList(){
        List<String> leftpanltxt=new ArrayList();
      List<WebElement> Lftpanllist=  driver.findElements(dashboardLeftPanel);
      for(WebElement e:Lftpanllist){
         String txt= e.getText();
          System.out.println(txt);
          leftpanltxt.add(txt);

      }
        return leftpanltxt;
    }
}
