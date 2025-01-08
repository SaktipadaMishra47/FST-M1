    # Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver import ActionChains
from selenium.webdriver.common.by import By

    # Start the Driver
with webdriver.Firefox() as driver:
    # Declare the actions variable
    actions = ActionChains(driver)
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/keyboard-events")

    # Print the title of the page
    print("Page title is: ", driver.title)

    actions.send_keys("Hello this is Sakti here").pause(3).perform()
    result = driver.find_element(By.CSS_SELECTOR, "h1.mt-3").text
    print(" The result is : "+result)
