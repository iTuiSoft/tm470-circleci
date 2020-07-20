require 'selenium-webdriver'
require 'webdrivers/chromedriver'

options = Selenium::WebDriver::Chrome::Options.new
options.add_argument('--headless')
options.add_argument('--no-sandbox')
driver = Selenium::WebDriver.for :chrome, options: options

current_widget = 0

Given("I am on the Ruby new widget page") do
  driver.get Settings.base_url.ruby + "widgets/new"
end

When(/^I create for Widget name: (.*), purpose: (.*) and size: (.*)$/) do |name, purpose, size|
  name_input = driver.find_element(:name, "widget[name]")
  purpose_input = driver.find_element(:name, "widget[purpose]")
  size_input = driver.find_element(:name, "widget[size]" )

  name_input.send_keys(name)
  purpose_input.send_keys(purpose)
  size_input.send_keys(size)

  save_button = driver.find_element(:name, "commit")
  save_button.click
  current_widget = driver.find_element(:name, "id")
end


Then(/^new widget (.*) is displayed$/) do |name|
  widget_name = driver.find_element(:name, "name")

  if widget_name.text === name
    puts "Test Passed"
  else
    raise "Test Failed"
  end
end

And(/^navigate to the widget page on the java site$/) do
  driver.get Settings.base_url.java + "widget/" + current_widget.text
end

Then(/^widget with name: (.*) and purpose: (.*) is displayed$/) do |name, purpose|
  widget_name = driver.find_element(:name, "name")
  widget_purpose = driver.find_element(:name, "purpose")

  if (widget_name.text === name) && (widget_purpose.text === purpose)
    puts "Test Passed"
  else
    raise "Test Failed"
  end
end