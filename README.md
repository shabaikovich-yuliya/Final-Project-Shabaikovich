# Automation Testing for Tabletka.by

This project is dedicated to automating the testing of key functionalities on the **tabletka.by** platform using **Java**. It focuses on ensuring that critical features such as login, signup, search, and the kit management work.

---

## Table of Contents

1. [Project Overview](#project-overview)
2. [Technologies Used](#technologies-used)
3. [Setup and Installation](#setup-and-installation)
4. [Test Cases Covered](#test-cases-covered)

---

## Project Overview

The automation suite ensures the reliability and functionality of the following features on **Tabletka.by**:

- **Login**: Validate user authentication flows.
- **Signup**: Verify user registration processes.
- **Search**: Test product search functionality.
- **Kit Management**: Test adding products to user's kit and removing ones from the kit.

---

## Technologies Used

- **Programming Language**: Java
- **Automation Framework**: Selenium WebDriver
- **Test Runner**: JUnit
- **Reporting**: Allure Reports
- **Build Tool**: Maven

---

## Test Cases Covered

### Login
- Valid login with correct credentials.
- Invalid login attempts (e.g., incorrect password, non-existent user).

### Signup
- Successful registration with valid data.
- Error validation for missing or invalid fields.

### Search
- Search results for valid queries.
- No results for invalid queries.

### Kit Management
- Add items to the kit.
- Remove item from the kit.
- Remove all items from the kit.

---
