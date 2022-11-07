### Tech stack
*Retrofit
*Mvvm
*Coroutine
*Hilt


### Structure
*base
  *BaseActivity
  *BaseViewModel
*data
  *WeatherInfo
*di
  *ApuModule
*domain  
  *MainApiInterface
  *WeatherRepository
*presentation
  *adapter
    *ChicagoAdapter
    *LondinAdapter
    *SeoulAdapter
    *WeatherBindingAdapter
    *WeatherViewHolder
  *WeatherActivity
  *WeatherViewModel
*usecase
  *WeathgerUsecase
*weatherApp  
