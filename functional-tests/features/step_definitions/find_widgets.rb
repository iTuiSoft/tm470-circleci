require 'selenium-webdriver'

Given("I am on the Java home page") do
  driver = Selenium::WebDriver.for :chrome

  driver.manage.window.maximize

  driver.get "http://localhost:8080/"
end

When("I search for Widget id {int}") do |int|
  pending # Write code here that turns the phrase above into concrete actions
end

Then("widget id {int} is displayed") do |int|
  pending # Write code here that turns the phrase above into concrete actions
end
