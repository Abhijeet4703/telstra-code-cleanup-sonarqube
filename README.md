# telstra-code-cleanup-sonarqube
# Task 4 – Code Cleanup Using SonarQube

## Overview
This task focuses on improving code quality by using **SonarQube**, a static code analysis tool. The objective is to analyze an existing codebase, identify code quality issues such as code smells and maintainability problems, and ensure the project meets standard quality gates without adding new features or functionality.

This task is a continuation of the previous tasks and uses the **same Spring Boot project**.

---

## Objective
- Analyze the existing codebase using SonarQube
- Identify code smells, bugs, and maintainability issues
- Improve code quality by following SonarQube recommendations
- Ensure the project passes the Quality Gate
- Push the analyzed and cleaned code to GitHub

---

## Tools & Technologies Used
- Java 17
- Spring Boot
- Maven
- SonarQube Community Edition (Local)
- SonarScanner CLI
- Git & GitHub

---

## Approach

### 1. SonarQube Setup
A local SonarQube server was installed and started on `localhost:9000`. A local project was created in the SonarQube dashboard to analyze the existing codebase.

### 2. Token Generation
An authentication token was generated from the SonarQube dashboard and configured in the `sonar-project.properties` file to allow secure communication between SonarScanner and SonarQube.

### 3. Code Analysis
The project was compiled using Maven, and SonarScanner was executed from the project root directory. The scanner successfully uploaded the analysis report to the SonarQube server.

### 4. Review of Results
SonarQube analyzed the code and provided insights related to:
- Code smells
- Maintainability issues
- Code structure and readability

The analysis helped validate that the code meets standard quality guidelines.

### 5. Final Verification
The analysis completed successfully, and the project appeared on the SonarQube dashboard with the Quality Gate passed. The codebase was then committed and pushed to GitHub.

---

## Outcome
- Static code analysis successfully completed
- Code quality verified using SonarQube
- No new features added; focus was on code quality
- Project passed SonarQube Quality Gate
- Task completed as per requirements

---

## Conclusion
This task demonstrates the use of SonarQube for maintaining high code quality in a real-world project. By integrating static analysis into the development workflow, potential issues can be identified early, improving maintainability, readability, and overall software quality.
