from selenium import webdriver

driver = webdriver.Chrome()

driver.get('http://127.0.0.1:8080/login')

input_google = driver.find_element("name", "username")

assert "Please sign in" in driver.title
assert "Информация которой нету на странице" not in driver.title
print('Тесты успешно прошли')
driver.close()