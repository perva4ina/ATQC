Feature: Login Action
        As a user,
        I want to login to mailbox with valid credentials
        So that I can safely use my mail.

    Scenario: Successful Login with Valid Credentials
        Given user is on ukr.net Mail Login Page
        When he enter username "umachiha@gmail.com"
        And he enter password "test1234!"
        And click Login button
        Then MailBoxPage displayed with "umachiha@gmail.com" username

    Scenario: Successful LogOut
        When user open User Menu
        And click Logout button
        Then LoginPage displayed