Feature: POC

@Android
Scenario Outline: TC_3

Given Open app
Then Application should open with <newsHeading> menu on top
When Tap on category <category> from category menu
Then A list of <numberOfNews> top stories should be displayed
When Note down headings for some of the news articles
Then Articles should be noted correctly
When Tap on weather icon, second from top right
Then Weather light box should be displayed with your current location, weather forecast for today and tomorrow
When Tap on the search icon on top right
Then Edit box should be enabled for changing the location
When Select the location from some other <weatherLocation> state
Then Proper location should be selected and weather light box should be displayed with new <weatherLocation> location and updated weather
When Tap back button
Then User should navigate back to local news section
When validate the news articles with the earlier noted ones
Then The articles should have some discrepancy

Examples:
	| newsHeading | category | numberOfNews | weatherLocation |
	| TOP STORIES | LOCAL | 17 | Richmond North |

