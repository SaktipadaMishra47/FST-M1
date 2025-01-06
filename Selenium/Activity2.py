# Import webdriver from selenium
from selenium import webdriver
from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
    # Navigate to the URL
    driver.get("https://training-support.net/webelements/login-form/")

    # Print the title of the page
    print("Page title is: ", driver.title)
    driver.find_element(By.XPATH,"//input[@type= 'text'][@name='username']").send_keys("admin")
    driver.find_element(By.XPATH,"//input[@type= 'password'][@name='password']").send_keys("password")
    driver.find_element(By.XPATH,"//button[@class= 'svelte-1pdjkmx']").click()
    print("Message",driver.find_element(By.CSS_SELECTOR, "h1.text-center").text)
    driver.quit()
