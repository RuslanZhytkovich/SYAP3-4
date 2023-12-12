from selenium import webdriver
from selenium.webdriver.common.by import By
from selenium.webdriver.support.ui import WebDriverWait
from selenium.webdriver.support import expected_conditions as EC

driver = webdriver.Chrome()
driver.get('http://localhost:8080/login')


username_field = driver.find_element(by=By.ID, value='username')
password_field = driver.find_element(by=By.ID, value='password')

username_field.send_keys('user')
password_field.send_keys('user')

submit_button = driver.find_element(by=By.CSS_SELECTOR, value='button.btn-primary')
submit_button.click()


wait = WebDriverWait(driver, 10)
wait.until(EC.presence_of_element_located((By.CSS_SELECTOR, 'a.nav-link[href="task1"]')))


driver.get('http://localhost:8080/task1')


numbers_input = driver.find_element(By.ID, 'numbersInput')
number_input = driver.find_element(By.ID, 'numberInput')

numbers_input.send_keys("1, 2, 3, 4, 5")
number_input.send_keys("3")


submit_button = driver.find_element(By.ID, "searchButton")
submit_button.click()


wait.until(EC.visibility_of_element_located((By.ID, 'result')))


result = driver.find_element(By.ID, "result")

res = result.text[11:32]

assert driver.title != 'Задание 2'
assert driver.title == 'Задание 1'
assert res == 'найдено на позиции: 2'
assert res != 'найдено на позиции: 4'

print('Тесты успешно прошли')
driver.quit()
