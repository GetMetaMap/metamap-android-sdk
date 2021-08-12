# Mati Android SDK Usage Guide &lt; 3.x.x


## Requirements

Mati Android SDK versions &lt; 3.x.x requires Android v5.0 (API v21) or above.

_**Note**_ For Mati SDK &gt; 3.x.x please follow the instructions in the [Mati Android SDK &gt; 3.x.x User Guide](https://github.com/GetMati/mati-android-sdk/blob/master/mati_android_sdk_3_x_x_.md).

## Install the Mati Android SDK

To install the Mati Android SDK, you will need to do the following:

1. [Configure Gradle](#configure-gradle)
1. [Initialize the Mati Andoid SDK](#initialize-the-mati-sdk)

### Configure Gradle

  1. Check that your top-level `build.gradle` contains a reference to the `jcenter()` repository:
  ![Top-level Android source folder with red arrow pointing at the build.grade file+in the application's source folder](Screenshot%20from%202019-03-25%2014-22-45.png)

  1. Open the `build.gradle` file inside your application module (`app`) directory and include the following dependencies into build.gradle file of your app:

      ```
      implementation 'com.matilock:mati-global-id-sdk:<version number>'
      ```

      For example, if your Mati version is 2.10.0, you would add the following dependency:

      ```
      implementation 'com.matilock:mati-global-id-sdk:2.10.0'
      ```

      ![Android source folder with red arrow pointing at the build.gradle file in the application's source app folder](Screenshot%20from%202019-03-25%2014-32-01.png)

  1. Use Gradle to sync your project.


### Initialize the Mati SDK

In the `onCreate()` method of your application class, initialize Mati by calling the following line of code:

```
public class MyApplication extends Application {

@Override
public void onCreate() {
    super.onCreate();
    Mati.init(this, "your client ID here");
  }
}
```

Your application tag in manifest should include the application class that was created

```
<application
    android:name=".MyApplication"
    ...
```
## Integrate the Mati SDK with Your Application

### Add the Mati KYC Button

Add the Mati KYC button to your application UI. In your layout XML file, add the following:

```xml
<com.matilock.mati_kyc_sdk.MatiLoginButton
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                app:flowId="<your flow ID here>"
                app:text="Custom"/>
```

_**Note**_ The `flowID` will be `default` if you don't put include the `app:flowId` attribute.

### Metadata

Choose what kind of metadata you want to receive based on the following example:

```
Metadata metadata = new Metadata.Builder()
                .with("userId", "Your Client ID")
                .with("type", 2)
                .build();

Mati.getInstance().setMetadata(metadata);
```

### Callback Registration

In order to handle login responses create a callback manager by calling following code:

```
private MatiCallbackManager mCallbackManager = MatiCallbackManager.createNew();
```

Register the callback to handle callback responses:

```
MatiLoginManager.getInstance().registerCallback(mCallbackManager, new MatiCallback() {
            @Override
            public void onSuccess(LoginResult pLoginResult) {
                Log.d(TAG, "User finished verification process successfully!");
            }

            @Override
            public void onCancel() {
                Log.d(TAG, "User cancelled verification flow");
            }

            @Override
            public void onError(LoginError pLoginError) {
                Log.d(TAG, pLoginError.getMessage());
            }
        });
```
In your `onActivityResult()` method, call `mCallbackManager.onActivityResult` to pass the login results to the MatiLoginManger

```
@Override
  protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    mCallbackManager.onActivityResult(requestCode, resultCode, data);
    super.onActivityResult(requestCode, resultCode, data);
  }
```

## Mati Android SDK Integration Video

The following video demonstrates how to integrate the Mati SDK with your application:  

[![Mati SDK integration demo video](https://img.youtube.com/vi/qDBjiBwyVF8/0.jpg)](https://www.youtube.com/watch?v=qDBjiBwyVF8)
