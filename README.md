
<p align="left">
  <a href="#"><img alt="Android OS" src="https://img.shields.io/badge/OS-Android-3DDC84?style=flat-square&logo=android"></a>
  <a href="#"><img alt="Languages-Kotlin" src="https://flat.badgen.net/badge/Language/Kotlin?icon=https://raw.githubusercontent.com/binaryshrey/Awesome-Android-Open-Source-Projects/master/assets/Kotlin_Logo_icon_white.svg&color=f18e33"/></a>
</p>

# GameOfThrones
An Android App that List all Game of Thrones Characters History. The app is still being build and not ready for production.

## Approach ##
### Architecture 
This app has a Model View Intent(MVI) architecture in place to allow the App to **Scale**, improve Quality and Robustness and Allow the App to Scale.
Better separation of concern that leads to easier maintainability.

This App uses Clean Architecture to ensure:

- State management using immutability to have a single source of truth.
- Unidirectional data flow
- reproducible state -> simple code reuse
- Make Code easier to read
- better separation of concern -> maintainability


## Libraries used

- **Retrofit** - Android Network Client, Used to consume API from Game of thrones Api at [Thrones Api](https://thronesapi.com/)
- **AirBnB Epoxy** - Epoxy is an Android library for building complex screens in a RecyclerView. Models are automatically generated from custom views or databinding layouts via annotation processing. These models are then used in an EpoxyController to declare what items to show in the RecyclerView.
- **Coroutines** - Used to execute code asynchronously
- **Material Design + XML** - Used to write the UI of the App
- **Material Design** - Give the App a theme and generally improve UI of the App
- **Coil Image** - Image Loading library
- **Lifecycle library** - Majorly to define the ViewModels of the app
- **Navigation** - To navigate to different screens of the App


## Screenshots
<img src="https://user-images.githubusercontent.com/47518452/202251160-552e7129-399b-4da8-816d-cb29a1eddbce.png" width="240" height="510">.
<img src="https://user-images.githubusercontent.com/47518452/202251178-4c4a0822-9f76-47cf-b581-b2f35faf32e1.png" width="240" height="510">
