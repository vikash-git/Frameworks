from selenium import webdriver
from selenium import SendKeys
user = "vikashkumarsahoo"
pwd = "ft$bt533"
driver = webdriver.Chrome()
driver.get("http://www.facebook.com")
driver.save_screenshot("vikash.png")
driver.find_element_by_id("email").send_keys(user)
elem=driver.find_element_by_id("pass").send_keys(pwd)
#elem.send_keys(Keys.RETURN)

