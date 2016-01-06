Feature: POC
 @iOS-norun
Scenario Outline: TC_5

Given Open app
Then Application should open with <lightBox> menu on top
Then click on <Not_Now> button
Then top stories should be displayed
Then click on context menu
Then validate all the top stories are greyed out
Then click on RADIO ON DEMAND category from context menu
Then Radio On Demand Tab Should be opened
Then Validate the number and names of the Radio streams under Radio on Demand
Then search the radio stream <the_music_show> and open it
Then lightbox should be opened with details about radio stream
Then click on play button and radio stream should be played
Then close the radio stream

Then search the radio stream <All_in_the_mind> and open it
Then lightbox should be opened with details about radio stream
Then click on play button and radio stream should be played
Then close the radio stream

Then search the radio stream <baby_talk> and open it
Then lightbox should be opened with details about radio stream
Then click on play button and radio stream should be played
Then close the radio stream

Examples:
	| lightBox | Not_Now | the_music_show | All_in_the_mind | baby_talk |
	| LIGHT BOX | Not now | The Music Show | All In The Mind | Baby Talk | 