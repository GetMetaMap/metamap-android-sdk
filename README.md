# Mati Android SDK documentation
Our SDK requires Android v5.0 (API v21) or above.

![alt text](https://github.com/MatiFace/mati-global-id-sdk-integration-android/blob/master/Group%2011.png)

## Gradle configuration

1. Ensure that your top-level build.gradle contains a reference to the following repository:

        jcenter()
    
![alt text](https://github.com/MatiFace/mati-global-id-sdk-integration-android/blob/master/Screenshot%20from%202019-03-25%2014-22-45.png)

2. Open the build.gradle file inside your application module directory and include the following dependencies into build.gradle file of your app:
Check this for latest version: https://bintray.com/matibiometricskyc/maven/mati-global-id-sdk

        implementation 'com.matilock:mati-global-id-sdk:LATEST_VERSION'
        
        example:
        
        implementation 'com.matilock:mati-global-id-sdk:2.8.0'
        
![alt text](https://github.com/MatiFace/mati-global-id-sdk-integration-android/blob/master/Screenshot%20from%202019-03-25%2014-32-01.png)
    
Once you make these two changes, simply sync your project with gradle.

    
## Mati SDK initialization

In the onCreate() method of your application class, initialize Mati by calling the following line of code:

    public class MyApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Mati.init(this, "your client ID here");
      }
    }
   
Your application tag in manifest should include the application class that was created

    <application
        android:name=".MyApplication"
        ...

## Mati KYC Button Placement (UI)

You now need to place the Mati KYC button inside your App. Add it to your layout XML file:

    <com.matilock.mati_kyc_sdk.MatiLoginButton
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    app:flowId="your flow ID here"
                    app:text="Custom"/>
     
                    
Flow ID will be default if you don't put app:flowId attribute.

## Metadata

Choose what kind of metadata you want to receive as shown in example below.

    Metadata metadata = new Metadata.Builder()
                    .with("userId", "Your Client ID")
                    .with("type", 2)
                    .build();
    
    Mati.getInstance().setMetadata(metadata);

## Callback Registration

In order to handle login responses create a callback manager by calling following code:

    private MatiCallbackManager mCallbackManager = MatiCallbackManager.createNew();

Now register callback to handle callback responses

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

And in your onActivityResult method, call mCallbackManager.onActivityResult to pass the login results to the MatiLoginManger

    @Override
      protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        mCallbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
      }
      
      
## Mati Android SDK integration video    

[![Mati SDK integration demo video](https://img.youtube.com/vi/qDBjiBwyVF8/0.jpg)](https://www.youtube.com/watch?v=qDBjiBwyVF8)
