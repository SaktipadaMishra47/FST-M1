
from concurrent.futures import thread
from selenium import webdriver

from selenium.webdriver.common.by import By

# Start the Driver
with webdriver.Firefox() as driver:
# Navigate to the URL
 driver.get("https://training-support.net/webelements/dynamic-controls")

# Print the title of the page
 print("Page title is: ", driver.title)
 checkbox = driver.find_element(By.ID, "checkbox")
 if not checkbox.is_displayed():
  thread.sleep(3000)
 else:
  checkbox.click()
  print("Check box is selected ",checkbox.is_selected())
  
 checkbox.click()
 print("Check box is selected ",checkbox.is_selected())
  
driver.close()


  
 