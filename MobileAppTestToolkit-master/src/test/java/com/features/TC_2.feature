Feature: POC

@iOS-norun
Scenario Outline: TC_2
Given Open app
Then Application should open with <lightBox> menu on top
Then validate the heading <newFeature> of the lightBox
Then validate <breakingNewsAlerts> text in the lightBox
Then validate button text for <notNow> in the lightBox
Then validate <getAlerts> button text in lightBox

Examples:
	| lightBox | newFeature | breakingNewsAlerts | notNow | getAlerts |
	| LIGHT BOX | NEW FEATURE | Breaking News Alerts | Not now | Get alerts |