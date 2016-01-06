Feature: POC

@Android
Scenario Outline: TC_6

Given Open app
Then Application should open with <newsHeading> menu on top
When Tap on category <category> from category menu
When Tap on article for details
Then The article details should be displayed with heading
When Swipe from left to right till Weblink
Then Next article should be displayed
When Tap on Weblink
Then User should be navigated to the browser on that
When Navigate back to app
Then User should be able to navigate back to app and the same article should be displayed on top
When Swipe from left to right till Videolink
Then Next article should be Present
When Tap on video link
Then User should be able to play the video properly from the video lightbox
When Navigate back to app
When Navigate back to app
Then User should be able to navigate back to app and the same article should be Present
When Swipe from left to right till Audiolink
Then Next article should displayed
When Tap on audio link
Then User should be able to play the audio properly from the audio lightbox
When Navigate back to app
Then User should be able to navigate back to app and the same article should displayed on top

Examples:
	| newsHeading | category | numberOfNews |
	| TOP STORIES | TOP STORIES | 17 |