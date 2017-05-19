# Android Architecture Kotlin + Dagger2 + Room + LiveData + Retrofit

Project contributors: [Nazar Ivanchuk](https://goo.gl/1185SB)

### Summary
This sample stands on the principles of [Android Architecture](https://goo.gl/p917KL).

It's based on the MVC sample, splitting the application in four layers:

<img src="https://developer.android.com/topic/libraries/architecture/images/final-architecture.png" alt="Diagram"/>

###Testability

With this approach, all domain code is tested with unit tests. This can be extended with integration tests, that cover from Use Cases to the boundaries of the view and repository.

### Maintainability

ViewModel concept makes application more flexible for support 
