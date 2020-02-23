package com.mi.MICalculator.testcases;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.By;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.MobileElement;
import io.appium.java_client.android.AndroidDriver;

/**
 * Built to test an application installed in the following device:
 * <p>
 *  <b>Device:</b> Redmi Note 5 Pro<br>
 *  <b>Application Name:</b> MI Calculator
 * </p>
 * 
 * @author Deepjyoti Barman
 * @since February 23, 2020
 */
public class MICalculatorTest
{
    /**
     * Test to add two integer numbers and evaluate the result of addition
     * 
     * @throws MalformedURLException
     */
    @Test
    public void addTest() throws MalformedURLException
    {
        // Set the URL
        URL url = new URL("http://localhost:4723/wd/hub");
        
        // Set the DesiredCapabilities for the session that is going to be created
        DesiredCapabilities cap = new DesiredCapabilities();
        cap.setCapability("deviceName", "Redmi Note 5 Pro");
        cap.setCapability("automationName", "UiAutomator2");
        cap.setCapability("platformName", "Android");
        cap.setCapability("platformVersion", "9");
        cap.setCapability("udid", "563490e6");
        cap.setCapability("appPackage", "com.miui.calculator");
        cap.setCapability("appActivity", ".cal.AllInOneCalculatorActivity");
        
        AndroidDriver<MobileElement> driver = new AndroidDriver<MobileElement>(url, cap);
        
        // Click on the 'Agree' button of 'Terms and Conditions' pop-up
        driver.findElementById("android:id/button1").click();
        
        // Click on buttons: '1', '4' and '7'
        driver.findElement(By.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_4_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
        
        // Click on '+' button
        driver.findElementById("com.miui.calculator:id/btn_plus_s").click();
        
        // Click on buttons: '1', '2' and '7'
        driver.findElement(By.id("com.miui.calculator:id/btn_1_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_2_s")).click();
        driver.findElement(By.id("com.miui.calculator:id/btn_7_s")).click();
        
        // Click on '=' button
        driver.findElementById("com.miui.calculator:id/btn_equal_s").click();
        
        // Get the result
        String result    = driver.findElement(By.id("com.miui.calculator:id/result")).getText();
        int actualResult = Integer.parseInt(result.replaceAll("[^0-9]", ""));
        driver.closeApp();
        
        // Evaluate the result
        Assert.assertEquals(actualResult, 274, "TEST FAILED! result mismatch");
        System.out.println("TEST PASSED! Result " + result);
    }
}