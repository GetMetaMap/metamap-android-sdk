---
title: "Android Changelog"
excerpt: "MetaMap's Android SDK Changelog"
slug: "android-changelog"
category: 61ae8e8dba577a0010791480
---
# Feedback

If you have an issue or ideas to improve MetaMap's Android SDK, please look at our [issues](https://github.com/GetMetaMap/metamap-android-sdk/issues) page to see if your issue has been reported or to add your own.


# Releases

| LTS version (Recommended for most users) | Current Version(Latest features) |
| :---:   | :---: |
| 3.23.0 | 3.27.0  |

# Version 3.27.0
###### 08 December 2022
#### Updated Features
* UI Redesign for Location Intelligence Feature
* Kotlin version upgraded to 1.6.21
* Device root detection

#### Bug Fixes
* Fixed: IP Restriction feature not working
* Fixed: Phone number submisison, country code getting duplicated
* Fixed: Unnecessary loading shown at bank account data step
* Fixed: Crashes related to Webview

# Version 3.26.1
###### 09 November 2022
#### Bug Fixes
* Fixed crash on Location Intelligence for Android API version 30 and above

# Version 3.26.0
###### 07 November 2022
#### Updated Features
* SDK start-up loading UI change
* SDK size is reduced by **~30%**(now it is **~3.5MB**)
* Third party libraries updated as following:
    - androidx.navigation:navigation-fragment-ktx:**2.5.2** -> **2.5.3**
    - androidx.navigation:navigation-ui-ktx:**2.5.2** -> **2.5.3**
    
#### Bug Fixes
* Fixed file pick functionality for bank account data
* Fixed crash on credit check for Brazil
* Fixed phone number search with country code in Phone verification
* Fixed crash on Location Intelligence for Android API version 30 and above
* Fixed issue when getting noFace error from BE twice not showed on the second time
* Fixed crash on eSign step
* Fixed issue when Liveness stack on upload state after the second failure
* Overall performance increase and minor improvements


# Version 3.25.0
###### 20 October 2022

#### Updated Features
* Third party libraries updated as follows:
    - `io.ktor:ktor-client-android:`**1.5.4** -> **2.0.3**
    - `io.ktor:ktor-client-content-negotiation:`**1.5.4** -> **2.0.3**
    - `io.ktor:ktor-serialization-kotlinx-json:`**1.5.4** -> **2.0.3**
    - `io.ktor:ktor-client-logging-jvm:`**1.5.4** -> **2.0.3**


# Version 3.24.0
###### 04 October 2022

#### Updated Features
* Liveness and voice liveness recording time limit is set to 20 seconds
* SDK initialization failure will show a meaning full error
* Third party libraries updated as follows:
    - io.insert-koin:koin-core:**3.1.4** -> **3.2.2**
    - io.insert-koin:koin-android:**3.1.4** -> **3.2.2**
    - org.jetbrains.kotlinx:kotlinx-coroutines-android:**1.5.0** -> **1.6.4**
    - io.coil-kt:coil:**1.4.0** -> **2.1.0**
    - androidx.constraintlayout:constraintlayout:**2.1.2** -> **2.1.4**
    - androidx.navigation:navigation-fragment-ktx:**2.3.3** -> **2.5.2**
    - androidx.navigation:navigation-ui-ktx:**2.3.3** -> **2.5.2**
    - org.jetbrains.kotlin:kotlin-stdlib-jdk7:**1.5.21** -> **1.5.32**

#### Bug Fixes
* Fixed: Frame size for document capture feature
* Fixed: Denied camera permission screen’s back button behaviour changed, it will open Exit verification screen
* Fixed: Dark background changed to white for android dark mode


# Version 3.23.0
###### 05 September 2022

#### Updated Features
* One sided documents support
* New icons for documents steps map screen

#### Bug Fixes
* Fixed: `IllegalStateException Fragment DocumentHintFragment not attached to a context`
* Fixed: `InternalError Thread starting during runtime shutdown`
* Fixed: `IOException Prepare failed.: status=0x64`
* Fixed: `FileNotFoundException 1661314210942.jpg: open failed: ENOENT`

# Version 3.22.6
###### 16 August 2022

#### Bug Fixes
* Fixed SDK behaviour when the app is being killed by the system
* Fixed crash when wrong types of the config data are provided through the metadata
* Fixed: `FileNotFoundException: No such file or directory`
* SDK error handling improvements


# Version 3.22.5
###### 03 August 2022

#### Updated Features
* Removed library `io.socket:socket.io-client`

#### Bug Fixes
* In case of unexpected crashes the SDK will close not affecting the client application
* Added support to languages Spanish, Portuguese, French and Russian for the countries list
* Icons loading on the start screen fixed
* Fixed `IOException Prepare failed.: status=0x64 onSurfaceTextureAvailable`
* Fixed `IllegalArgumentException android.graphics.Bitmap in createBitmap`
* Other minor improvements


# Version 3.22.4
###### 15 July 2022

#### Updated Features
* Brazilian driving licenses will require one page
* SDK icons updated

#### Bug Fixes
* Files upload screens will open the exit screen on back press
* Fixed duplicate bank account icon on the first screen
* Fixed behaviour when app was brought back to foreground from app icon click
* Fixed endless file uploading issue when the app was sent to background during it
* Fixed ApplicationNotResponding issue
* Fixed `FileNotFoundException`
* Fixed `IllegalStateException Host view isn't ready to create a ViewBinding instance`
* CameraX version updated to 1.1.0
* Other minor improvements


# Version 3.22.3
###### 29 June 2022

#### Bug Fixes
* UserAgent information update which will fix the bug related to the device information in the dashboard
* Captured media files are being removed right after they will no longer be re-used
* Fixed bug when the app language could remain the same after the language was changed several times
* Fixed: `JSONException: No value for inputId`
* Fixed: `IllegalStateException: KoinApplication has not been started`
* Fixed: `NullPointerException: Attempt to invoke virtual method 'int android.view.Display.getRotation()' on a null object reference`

#### Updated Features
Removed library `androidx.cardview:cardview`
Removed library `org.jetbrains.kotlin:kotlin-stdlib-jdk7`
Removed library `androidx.fragment:fragment-ktx`
Removed library `androidx.core:core-ktx`
Removed library `androidx.lifecycle:lifecycle-runtime-ktx`
Removed library `androidx.navigation:navigation-dynamic-features-fragment`


# Version 3.22.2
###### 15 June 2022

#### Bug Fixes
* Fixed: IllegalStateException: KoinApplication has not been started
* `metamap_` prefix added to all keys for string resources to avoid any conflicts with the client applications
* Resolved Github issue: https://github.com/GetMetaMap/metamap-android-sdk/issues/37



# Version 3.22.1
###### 03 June 2022

#### Bug Fixes
* Fixed `IllegalStateException` A recording is already in progress. Previous recordings must be stopped before a new recording can be started.
* Document icon fix in the hint screen
* Fixed ProgressBar overlap on email code submission screen
* Translations fixed on the first screen for Bank, Work, Payroll Data and CustomInput products



# Version 3.22.0
###### 27 May 2022

#### New Features
* Location Intelligence step support added

#### Updated Features
* Metadata builder updated. Method `with` was marked as deprecated

#### Bug Fixes
* Icons for Bank, Payroll, Work Account Data and Custom Input products became visible on the first page
* Fixed: the button on the first page didn’t work after language change
* Custom Document hint text and icon overlap bug fixed



# Version 3.21.6
###### 21 May 2022
  
#### Bug Fixes
* Face detector bugfix during selfie verification



# Version 3.21.5
###### 18 May 2022

#### Updated Features
* National Id documents are loaded dynamically

#### Bug Fixes
* Minor improvements



# Version 3.21.4
###### 14 May 2022
  
#### New Features
* Custom Input support added

#### Updated Features
* Terms and Conditions and our Privacy policy link updated
* CameraX version upgraded to 1.1.0-rc01

#### Bug Fixes
* Fixed resend countdown in email verification screen
* Other fixes and improvements



# Version 3.21.3
###### 11 May 2022

#### Updated Features
* CameraX version upgraded to 1.1.0-beta03

#### Bug Fixes
* Bugfix: InvalidConfigException: Surface was requested when the Recorder had encountered error. Encoder cannot created: null



# Version 3.21.2
###### 20 April 2022

#### Updated Features
* Resources names changed

#### Bug Fixes
* Exit screen button UI bug fix


# Version 3.21.1
###### 14 April 2022

#### Bug Fixes
* Hotfix: Document upload errors are handled correctly now



# Version 3.21.0
###### 14 April 2022

#### Updated Features
* Reduced SDK size
* Added required documents screen
* Skip back side for Documents
* Changed subtypes for Panama and Nigeria

#### Removed Features
`com.github.mhiew:android-pdf-viewer` dependency removed



# Version 3.20.0
###### 01 April 2022
  
#### Updated Features
* Document subtypes support added for each document issuing country
* Face detection feature added to selfie
* No internet connection and internal server errors support added

#### Bug Fixes
* Fix: Now two applications using MetaMap can be installed on one device



# Version 3.19.1
###### 22 March 2022
  
#### Updated Features
* CameraX version upgraded to 1.1.0-beta02

#### Bug Fixes
* Camera crash fixed. Github [issue: #33](https://github.com/GetMetaMap/metamap-android-sdk/issues/33)
* Proguard obfuscation issue in debug mode fixed when using proguard-android-optimized.txt file



# Version 3.19.0
###### 16 March 2022
  
#### Bug Fixes
* Proguard obfuscation issue in debug mode fixed
* Koin conflict with the client app eliminated
* Issue with app restoration after being killed fixed



# Version 3.18.0
###### 14 March 2022
  
#### Bug Fixes
* HotFix: Metamaps containing e-signature will be seen in the verifications dashboard



# Version 3.17.0
###### 03 March 2022
  
#### Bug Fixes
* Hotfix: Esign step sent to the end of the flow



# Version 3.16.0
###### 25 February 2022
  
#### New Features
* Added support for OnActivityResult

#### Updated Features
* Translations updated



# Version 3.15.0
###### 24 February 2022
  
#### New Features
* Credit check consent added
* Activity Result API is used to get the SDK result instead of the deprecated onActivityResult method

#### Updated Features
* Rebranding conducted
* UI refactoring, added support for different screen sizes
* Resources renamed to avoid conflicts
* Added mechanism to remove temporary files to reduce SDK size
* `androidx.cardview:cardview` dependency added `1.0.0`
* `androidx.window: window` dependency added `1.0.0`
* `CameraX` version upgraded to `1.1.0-beta01`
* `androidx.constraintlayout:constraintlayout` version upgraded to `2.1.2`
* `org.jetbrains.kotlin:kotlin-stdlib-jdk7` version upgraded to `1.5.21`
* `androidx.core:core-ktx` version upgraded to `1.7.0`
* `org.jetbrains.kotlinx:kotlinx-serialization-json` version upgraded to `1.3.2`
* `com.github.mhiew:android-pdf-viewer` version upgraded to `3.2.0-beta.1`

#### Removed Features
* Material library removed

#### Bug Fixes
* Phone number validation issue fixed
* SecurityException fixed
* Metadata fixedLanguage issue eliminated
* Translation corrected: "cargar" became "cargando"



# Version 3.14.0
###### 09 February 2022

#### Updated Features
* Support for Brazilian NID CPF number manual entry



# Version 3.13.0
###### 28 January 2022
  
#### New Features
* Financial dynamic web containers added

#### Updated Features
* Face masks detection error support added
* Added support for localized SMS confirmation messages for phone verification step
* Added support for localized email confirmation messages for email verification step




<!-- Note to developers: copy/paste the template below for each version. Delete categories that don't apply the the release

# Version
###### Date
  
#### New Features
* <new feature>

#### Updated Features
* <changes in existing functionality>

#### Deprecated Features
* <soon-to-be removed features>

#### Removed Features
* <removed features>

#### Bug Fixes
* <bug fixes>

#### Security Vulnerabilities
* <known vulnerabilities>
-->
