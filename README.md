# Kanboard Tests (API/UI) 
Final project for course QA Automation, 25/07/2023

### Instruction:

1. Download and save file **docker-compose.yml**

2. Run the command: **`docker compose up`** from the folder where the docker-compose.yml file is located.

   Docker desktop must be enabled.
3. Username - admin, Password - admin
4. After SignIn go to Settings -> API -> copy api token 
5. Open file **src/test/resources/env.local.properties** and change **token**


API documentation https://docs.kanboard.org/v1/api/

List tests for next **API** procedures:

- **User** API Procedures
    - createUser
    - getUser
    - removeUser
- **Project** API Procedures
    - createProject
    - getProjectById
    - removeProject
- **Task** API Procedures
    - createTask
    - getTask
    - removeTask
- **Project Permission** API Procedures
    - addProjectUser
    - removeProjectUser

Tests has next **UI** suits:
- auth/uiSignin
- project/uiCreateProjectTest
- project/uiRemoveProjectTest
- project/uiProjectTest
- task/uiCreateTaskTest
- task/uiAddCommentTaskTest
- task/uiCloseTaskTest
- task/uiTaskTest
- uiRegression
- apiRegression

Tests has next **API** suits:
- user/apiUsersTests
- project/apiProjectTests
- task/apiTaskTests
- apiRegression

Tests has next **API/UI** suit:
- regression

### Start suite with parameters

- #### local

By default, tests start in **local**. For start test suite in local you should write in terminal next command: mvn test -Dsuite=suiteName
(example: `mvn test -Dsuite=auth/uiSignin` OR
          `mvn test -Dsuite=auth/uiSignin -Denvironment=local`) 

- #### internet

For start tests in **internet** you should write in terminal next command: mvn test -Dsuite=suiteName -Denvironment=internet
(example: `mvn test -Dsuite=auth/uiSignin -Denvironment=internet`)

- #### browsers

You can start suite test in browsers: Chrome headless, Chrome, Firefox. For this you should use parameter -Dbrowser=browserName. If you do not specify this parameter, the test suite will run by default in the Chrome browser(example for Chrome headless: `-Dbrowser=headless`, for firefox: `-Dbrowser=firefox`, for chrome: `-Dbrowser=chrome`)

### Generate Allure report

For generate Allure report you should use next command `allure serve target/allure-results`