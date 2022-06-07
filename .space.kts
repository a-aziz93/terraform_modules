
/**
* JetBrains Space Automation
* This Kotlin-script file lets you automate build activities
* For more info, see https://www.jetbrains.com/help/space/automation.html
*/

job("Code analysis, up and and test") {
    container(displayName = "Sonarqube continuous inspection of code quality and security", image = "openjdk:11")
    {
        env["SONAR_TOKEN"] = Secrets("terraform_modules_sonar_token")
        kotlinScript { api->
            api.gradlew("sonarqube")
        }
    }
}

