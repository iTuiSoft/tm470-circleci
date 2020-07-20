require 'selenium-webdriver'
options = Selenium::WebDriver::Chrome::Options.new
options.add_argument('--headless')
options.add_argument('--no-sandbox')
driver = Selenium::WebDriver.for :chrome, options: options

Given("I am on the Java home page") do
  driver.get Settings.base_url.java
end

When("I search for Widget id {int}") do |id|
  id_input = driver.find_element(:id, "widgetId")
  id_input.send_keys(id)
  search_link = driver.find_element(:name, "search_link")
  search_link.click
end

Then("widget id {int} is displayed") do |id|
  widget_id = driver.find_element(:name, "id")

  if widget_id.text === id.to_s
    puts "Test Passed"
  else
    raise "Test Failed"
  end
end
