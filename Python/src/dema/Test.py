from selenium.webdriver.chrome.webdriver import WebDriver
#from selenium import Keys
from selenium.webdriver.common.keys import Keys
driver=WebDriver()
driver.get("http://www.google.com")
print (driver.title)
driver.refresh()
address=driver.maximize_window()
driver.save_screenshot("kk.png")
var=driver.find_element_by_name(name="q")
var.send_keys("what is my Ip ")
var.send_keys(Keys.RETURN)
var2=driver.find_element_by_class_name(class_name="MUxGbd u31kKd gsrt lyLwlc lEBKkf")
print var2
