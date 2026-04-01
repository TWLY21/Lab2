# Lab2

`Lab2` is a simple Android true/false quiz app built in Android Studio. It presents a short question bank, tracks the user’s score, and shows a result screen when the quiz is completed.

## Overview

The app currently includes:

- a series of true/false quiz questions
- score tracking for correct answers
- toast feedback after each answer
- a result screen that shows the final score
- a restart option after finishing the quiz

The current quiz uses a small hardcoded question set and is structured as a beginner-friendly Android learning project.

## Tech Stack

- Java
- Android Studio
- Android SDK
- ConstraintLayout XML
- Gradle Kotlin DSL

## Main Features

- five built-in quiz questions
- `True` and `False` answer buttons
- score calculation throughout the quiz
- result page after the last question
- restart flow from the result screen

## Project Structure

```text
app/src/main/java/com/example/quizylecture/
  MainActivity.java
  Question.java
  ResultActivity.java
  User.java
```

## How To Run

### Requirements

- Android Studio
- Android SDK 35
- Minimum SDK 24
- Java 11

### Steps

1. Open the project in Android Studio.
2. Let Gradle sync complete.
3. Start an emulator or connect an Android device.
4. Run the app.

## Notes

- The quiz content is currently hardcoded in `MainActivity.java`.
- The app uses a local score flow only and does not store quiz history.
- This project is best viewed as a lab exercise or beginner Android practice app.

## Possible Improvements

- add more questions
- randomize the question order
- prevent score inflation when navigating backward
- add categories or difficulty levels
- store results locally

## Author

Created by Ives Tan Kian Hang.
