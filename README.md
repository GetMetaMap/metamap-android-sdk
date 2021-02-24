# Mati Android SDK documentation 



### Install Mati SDK via Gradle

Ensure that your top-level build.gradle contains a reference to the following repository:

	 jcenter()

Add this line into gradle dependencies
  
    implementation 'com.matilock:mati-global-id-sdk:3.0.2'
    
Sync project with gradle files
    
##### ! Dependencies (will be automatically installed with Mati library)
io.socket:socket.io-client:0.8.3

## Example

You now need to place the MatiButton inside your App.

#### 1) Place button into YOUR_ACTIVITY.XML

##### YOUR_ACTIVITY.XML
    
    <com.matilock.mati_kyc_sdk.MatiButton
        android:id="@+id/matiKYCButton"
        android:layout_width="match_parent"
        android:layout_height="wrap_content"
	mati:text="BUTTON TITLE" // YOU CAN SET IT IN setParams PROGRAMATICALLY
        android:layout_margin="16dp"
        android:layout_gravity="center"/>
    
#### 2) Set params button CLIENT_ID (Required), FLOW_ID (Optional) and Metadata (Optional) into YOUR_ACTIVITY.java

##### YOUR_ACTIVITY.java
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.<MatiButton>findViewById(R.id.matiKYCButton).setParams("YOUR_CLIENT_ID", "BUTTON_TITLE" , "YOUR_FLOW_ID", METADATA);
    }
    
#### 3) Implement callback handling into YOUR_ACTIVITY.java

##### YOUR_ACTIVITY.java
    
    
    public class YourActivity extends AppCompatActivity implements MatiCallback {

    @Override
    public void onSuccess(@Nullable LoginResult pLoginResult) {
		// YOU GET SUCCESS RESULTS HERE FOR YOUR APP
    }

    @Override
    public void onCancel() {
		// YOU GET CANCEL RESULTS HERE FOR YOUR APP
    }

    @Override
    public void onError(@Nullable LoginError pLoginError) {
		// YOU GET ERROR RESULTS HERE FOR YOUR APP
    }
	}
    
#### 4) Check complete file YOUR_ACTIVITY.java again

##### YOUR_ACTIVITY.java

```java
public class YourActivity extends AppCompatActivity implements MatiCallback {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        this.<MatiButton>findViewById(R.id.matiKYCButton).setParams(
                getString("YOUR_CLIENT_ID",
                "YOUR_FLOW_ID",
		"BUTTON_TITLE",
                new Metadata.Builder()
                        .with("key_1", "value1")
                        .with("key2", 2)
                        .build());
    }


    @Override
    public void onSuccess(@Nullable LoginResult pLoginResult) {
		// YOU GET SUCCESS RESULTS HERE FOR YOUR APP
    }

    @Override
    public void onCancel() {
		// YOU GET CANCEL RESULTS HERE FOR YOUR APP
    }

    @Override
    public void onError(@Nullable LoginError pLoginError) {
		// YOU GET ERROR RESULTS HERE FOR YOUR APP
    }
}
```

    
### Requirements 
   
Our SDK requires Android v5.0 (API v21) or above.

   For Mati SDK below 3.x.x please use this documentation https://github.com/GetMati/mati-android-sdk/blob/master/README_old__2_x_x_.md


