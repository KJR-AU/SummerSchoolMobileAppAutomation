Feature: POC
 @iOS-norun
Scenario Outline: TC_4

Given Open app
Then Application should open with <lightBox> menu on top
Then click on <Not_Now> button
Then top stories should be displayed
Then click on context menu
Then validate all the top stories are greyed out
Then tap on <business> category from context menu
Then <seventeen> business articles should be displayed
Then total <twentyone> articles should be present on the page
Then verify that last element is <business_in_90_seconds>
Then tap on business in 90 seconds link
Then light box should be displayed with details of video link
Then tap on Watch Now button
Then wait for <thirty> seconds and take screenshot and tap on done
Then light box should be displayed with details of video link

Examples:
	| lightBox | Not_Now | seventeen | twentyone | business_in_90_seconds | thirty |
	| LIGHT BOX | Not now | 17 | 21 | Business in 90 Seconds | 30 |