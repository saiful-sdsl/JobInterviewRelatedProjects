# JobInterviewRelatedProjects


App name: Spin the Wheel Game



Special Facts about the Development:
- Full codebase developed using Kotlin
- Followed MVVM architecture design pattern
- Hilt Dependency Injection
- API call using Retrofit
- Implemented View Binding for all the Activities and Fragments
- Added Timber for easier Logging for Debug and Release level
- Clean Project/Package Structure




Overview
Create a simple wheel spinning Android app in kotlin. There will be a total of 2 screens - 
- main screen and 
- the game screen. 

Requirements
Main screen: This screen will have at least 1 button that will go to the game screen
Game screen: This screen will contain a back button that will go back to the previous screen, a main spin the wheel UI, and a button at the bottom that will trigger the wheel to spin.
Wheel: The spinning speed should be ease-out - speed should start quickly then slow down at the end.
Reward Items: The number of reward items will be determined by the API call (see specification)
Result: When the wheel stops, show the selected reward using Android’s Toast UI

Specifications
API endpoint
GET http://mockbin.org/bin/539dc092-8367-414a-8892-ed3b2d666dbe
See sample response at the end of this document
Each reward item will have a equal random chance of being selected
Wheel stopper image
https://drive.google.com/file/d/1Voa16Fi04mYW7GihMZMM8NwSky1dYYie/view?usp=sharing
Wheel ring image (if needed)
https://drive.google.com/file/d/1a30XLss_qCFrYQxD86VjstxVh7jUGWLo/view?usp=sharing
Colors for Game screen
Screen background: #040D14 
Wheel item darker background: #040D14
Wheel item lighter background: #141A1E 
Button pink color: #FDAEB6



API Response Sample
[
  {
    "id": "1",
    "displayText": "$50",
    "value": 50,
    "currency": "USD"
  },
  {
    "id": "2",
    "displayText": "$100",
    "value": 100,
    "currency": "USD"
  },
  {
    "id": "3",
    "displayText": "$50",
    "value": 50,
    "currency": "USD"
  },
  {
    "id": "4",
    "displayText": "$100",
    "value": 100,
    "currency": "USD"
  },
  {
    "id": "5",
    "displayText": "$50",
    "value": 50,
    "currency": "USD"
  },
  {
    "id": "6",
    "displayText": "$100",
    "value": 100,
    "currency": "USD"
  },
  {
    "id": "7",
    "displayText": "$50",
    "value": 50,
    "currency": "USD"
  },
  {
    "id": "8",
    "displayText": "$100",
    "value": 100,
    "currency": "USD"
  }
]


