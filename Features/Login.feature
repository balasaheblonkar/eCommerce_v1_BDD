Feature: Login

Scenario: Successful Login with valid Credentials
         Given User Launch Chrome browser
         When User opens URL "https://demo.guru99.com/v4/"
         And User enters username as "mngr441730" and password as"EsErEsE"
         And Click on Login
         Then Page Title should be"Guru99 Bank Manager HomePage"
         When User click on Log out Link
         Then Page Title should be"Welcome To The Online Banking Page of Guru99 Bank"
         And close browser