require 'selenium-webdriver'

driver = Selenium::WebDriver.for :chrome

Given("I am on the Java home page") do

  driver.manage.window.maximize

  driver.get "http://localhost:8080/"
end

When("I search for Widget id {int}") do |id|
  widget_id_input = driver.find_element(:id, "widgetId")
  widget_id_input.send_keys(id)
  search_link = driver.find_element(:name, "search_link")
  search_link.click
end

Then("widget id {int} is displayed") do |id|
  widget_id = driver.find_element(:name, "id")

  puts widget_id.text
  if widget_id.text === id.to_s
    puts "Test Passed"
  else
    raise "Test Failed"
  end
end
