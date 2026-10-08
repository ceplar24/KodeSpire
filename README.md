# KodeSpire

KodeSpire is an Android learning app for beginners exploring Kotlin
and Jetpack Compose.It combines short explanations with interactive practice.

The app is a personal learning project under active development.
The interface and learning content are currently in Norwegian.

## Current features

- Home screen with a custom background and an expandable introduction.
- Bottom navigation between three screens.
- Expandable concept cards explaining Column, Row and Box.
- A practice question with three answer options.
- Visual highlighting of the selected answer and immediate feedback.
- Scrollable screen content.

## Technologies

- Kotlin
- Jetpack Compose
- Material 3
- Android Studio
- Gradle

## Implementation

The app currently uses composable functions for each screen.

- Screen switching is controlled by state in MainContent.
- rememberSaveable manages the selected screen, expanded cards and
selected quiz answers.
- CourseCard is a reusable component for learning content.
- animateContentSize animates the expansions and collapse of cards.

The current version uses local, hardcoded content and does not require
an account or a backend.

## Run the app
1. Clone this repository
2. Open the project folder in Android Studio.
3. Let Gradle syns and install any SDK components requested.
4. Start an Android emulator or connect an Android device.
5. Run the app module.

## Current limitations

- The practice screen contains one question.
- There is no score tracking or persistent learning progress.
- Navigation currently switches screen content using state,
  without NavController or a navigation back stack.

## Planned improvements

- Add more concepts and practical code examples.
- Expand the quiz with multiple questions and a results screen.
- Introduce navigation to detail screens with NavController.
- Apply a consistent visual theme across all screens.
- Add meaningful tests as the quiz logic develops.

## Development approach

The project is built incrementally to practise Compose layouts,
state, reusable components and user interaction.

Git commits document individual changes as development continues.