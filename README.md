# SkillForge

A modern Android application built in Kotlin using Jetpack Compose. The app fetches course data from a REST API and provides a clean learning experience with three screens:

- Home
- Course Detail
- Lesson

## Tech Stack

- Kotlin
- Jetpack Compose
- MVVM Architecture
- Retrofit
- Kotlin Coroutines
- StateFlow
- Coil
- Navigation Compose
- Material 3

## Project Structure

```
data/
    api/
    model/
    repository/

navigation/

ui/
    components/
    detail/
    home/
    lesson/
    theme/

utils/

viewmodel/
```

## AI Usage

### AI Tools Used

- ChatGPT
- GitHub Copilot
- Gemini

### Example Prompts

**Prompt 1**

> Design a clean MVVM architecture for a Jetpack Compose Android application that consumes a single Retrofit endpoint and displays three screens: Home, Course Detail, and Lesson.

**Prompt 2**

> Generate Kotlin data classes for a nested JSON response containing categories, courses, instructors, and lessons using Gson-compatible models.

**Prompt 3**

> Improve a Jetpack Compose Course Card UI to better match a Material 3 design while keeping the code modular and reusable.

### What AI Got Right

AI helped quickly generate the initial project structure, Retrofit setup, model classes, and reusable Compose components, which significantly reduced development time.

### What AI Got Wrong

One generated navigation implementation recreated the ViewModel for each screen, which could have caused unnecessary API requests and inconsistent UI state. I refactored the navigation and state handling so data is managed correctly and reused across screens.

I also reviewed and tested all AI-generated code, made manual improvements, and ensured the final implementation met the assignment requirements.

## Features

- Fetches data from REST API
- Category listing
- Course listing
- Course Detail screen
- Lesson screen
- Image loading using Coil
- Loading and Error states
- Material 3 UI
- Unit Test

## Build Instructions

1. Clone the repository
2. Open in Android Studio
3. Sync Gradle
4. Run the project on an emulator or device

## API

```
https://raw.githubusercontent.com/android-assesment/notes/refs/heads/main/data.json
```
