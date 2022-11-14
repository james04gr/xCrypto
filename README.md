# xCrypto

xCrypto is an Android Sample application for displaying CryptoCurrency details.

It uses 
  - Dagger - Hilt for Dependency Injection (di)
  - Retrofit for Network requests
  - Kotlin Flows for Data Observation
  - Jetpack Compose for constructing the UI along with the User Navigation

and shows how to use all of that together with the proper structure in order to achieve the MVVM design pattern by Clean Architecture.

The project has 3 Layers
  - Presentation layer 
    Contains all the UI elements (Activities, Composable views, ViewModels, View states classes and the Application Theme)
    
  - Domain layer
    Contains the Models, the Repository implementations and the several useCases that the system implements
    
  - Data layer
    Contains the Datasource (either RemoteAPI interface of the Local Database, in our case only the RemoteAPI) from where the application pulls/sends data  from to, along with the Data Transfer Objects of the API.
    
    
Free Remote API documentation can be found here (https://api.coinpaprika.com/)
