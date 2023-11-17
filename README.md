## Project with API-tests for [REQRES](https://reqres.in/api)

<p>
  <img src="images/logo/reqres.png" alt="Logo of Reqres">
</p>

## Content

- [🛠️ Stack of technologies](#-stack-of-technologies)
- [📋 List of API tests](#-list-of-api-tests)
- [🔌 Running tests from the terminal](#-running-tests-from-the-terminal)
- [🔧 Property files](#-property-files)
- [⚙️ Running tests in Jenkins](#-running-tests-in-jenkins)
- [📊 Test results report in Allure Report](#-test-results-report-in-allure-report)
- [🚀 Integration with Allure TestOps](#-integration-with-allure-testops)
- [📣 Integration with Telegram](#-telegram-notifications-using-a-bot)

## 🛠️ Stack of technologies

<div style="text-align: center;">
<img width="7%" title="IntelliJ IDEA" src="images/logo/idea.png" alt="IntelliJ IDEA Logo">
<img width="7%" title="Rest Assured" src="images/logo/restAssured.png" alt="Rest Assured Logo">
<img width="7%" title="GitHub" src="images/logo/github.png" alt="GitHub Logo">
<img width="7%" title="Java" src="images/logo/java.png" alt="Java Logo">
<img width="7%" title="Junit5" src="images/logo/junit5.png" alt="JUnit5 Logo">
<img width="7%" title="Gradle" src="images/logo/gradle.png" alt="Gradle Logo">
<img width="7%" title="Selenide" src="images/logo/selenide.png" alt="Selenide Logo">
<img width="7%" title="Jenkins" src="images/logo/jenkins.png" alt="Jenkins Logo">
<img width="7%" title="Allure Report" src="images/logo/allure.png" alt="Allure Report Logo">
<img width="7%" title="Allure TestOps" src="images/logo/allureTestops.png" alt="Allure TestOps Logo">
<img width="7%" title="Jira" src="images/logo/jira.png" alt="Jira Logo">
<img width="7%" title="Telegram" src="images/logo/telegram.png" alt="Telegram Logo">
</div>

## 📋 List of API Tests

- [x] Successful user registration
- [x] Successful user deletion
- [x] Successful user creation
- [x] Failed attempt to register user without password
- [x] Successful retrieving of user list

## 🔌 Running tests from the terminal

### Running tests locally:

```bash
gradle clean test
```

## <img width="7%" title="Jenkins" src="images/logo/jenkins.png"> Running tests in [Jenkins](https://jenkins.autotests.cloud/job/Project%2021-ValeriaReshetina-diploma-project-API/)

#### To execute the tests in Jenkins, you need to click `Build Now`:

#### Main page of the build:

<div style="text-align: center;">
  <img src="images/screenshots/JenkinsMainPage.png" alt="Jenkins" width="800">
</div>

## <img width="8%" title="Allure Report" src="images/logo/allure.png"> Test results report in [Allure Report](https://jenkins.autotests.cloud/job/21-ValeriaReshetina-diploma-project-UI/allure/)

####  It is possible to switch from <code><strong>Jenkins</strong></code> to reports generated by <code><strong>Allure</strong></code>.

<div style="text-align: center;">
  <img src="images/screenshots/AllureReport.png" alt="allure5" width="800">
</div>

###  Allure dashboard with statistics

<div style="text-align: center;">
  <img src="images/screenshots/dashboard.png" alt="allure5" width="800">
</div>

### Grouping of tests by checked functionality

<div style="text-align: center;">
  <img src="images/screenshots/groupOfTests.png" alt="allure5" width="800">
</div>

## <img width="8%" title="Allure TestOPS" src="images/logo/allureTestops.png"> Integration with [Allure TestOps](https://allure.autotests.cloud/launch/32151)
#### Integration of <code><strong>Allure TestOps</strong></code> with <code><strong>Jenkins</strong></code>  allows you to run several custom tests and monitor their execution online.

<div style="text-align: center;">
  <img src="images/screenshots/AllureTestOps.png" alt="allure5" width="800">
</div>

## <img width="8%" title="Telegram" src="images/logo/telegram.png"> Telegram notifications using a bot

####  After passing all the tests, an automatic report is sent to the <code>Telegram Notification Bot</code>.

<div style="text-align: center;">
    <img title="Telegram Notifications" src="images/screenshots/telegramNotification.png" width="500" alt="Screenshot of Telegram Notifications">
</div>

[Back to content](#content)
