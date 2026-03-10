# Parking Spot Finder

An Android app to find and mark available parking spots using Google Maps, built with Jetpack Compose and Clean Architecture.

## 📱 App Overview

Drop pins on a Google Maps Compose view to mark parking spots. Spots are saved locally with Room and persist across app restarts.

## 🔑 Google Maps API Setup

1. Go to [Google Cloud Console](https://console.cloud.google.com/)
2. Enable the **Maps SDK for Android**
3. Create an API key and restrict it to your app's package
4. Add to `local.properties`:
   ```
   MAPS_API_KEY=your_api_key_here
   ```

## 🛠 Tech Stack

| Technology | Purpose |
|-----------|---------|
| Kotlin | Primary language |
| Jetpack Compose | Declarative UI |
| Maps Compose | Google Maps in Compose |
| Room | Local persistence |
| Hilt | Dependency injection |
| MVVM Clean Architecture | App architecture |

## 🚀 How to Run

1. Clone the repo:
   ```bash
   git clone https://github.com/santhoshj001/ParkingSpotFinder.git
   ```
2. Get a Google Maps API key and add it to `local.properties` (see above)
3. Open in **Android Studio**
4. Run on an emulator or device with Google Play Services

## 📄 License

MIT — see [LICENSE](LICENSE)
