---
title: "Android"
excerpt: "Add the Metamap button to your Android app."
slug: "android"
category: 61ae8e8dba577a0010791480
---

## Android Demo App

You can go to GitHub to download the [MetaMap Android Java demo app](https://github.com/GetMetaMap/mati-mobile-examples/tree/main/javaDemoApp(native)).


## Requirements
* &gt;2.5MB of disk space
* Android OS version: v5.0 (API v21) or higher.
* compileSdkVersion: 31
* targetSdkVersion: 31
* Kotlin: 1.5.21 or higher.

## Install the MetaMap Android SDK

To install the MetaMap Android SDK using [Gradle](https://gradle.org/), you will need to do the following:

- Ensure that your top-level `build.gradle` references to the following repository:

  ```
  mavenCentral()
  ```

- Enable Java 1.8 source compatibility.

  ```
  android {
    compileOptions {
	sourceCompatibility = JavaVersion.VERSION_1_8
	targetCompatibility = JavaVersion.VERSION_1_8
    }
  }
  ```

- Add the following to your app-level gradle dependencies using your version of the MetaMap Android SDK:

  ```
  implementation ('com.metamap:android-sdk: <your MetaMap SDK version number>')
  ```

  For example, if you are using the MetaMap Android SDK version 3.24.0, you would include the following:

  ```
  implementation ('com.metamap:android-sdk:3.24.0')
  ```

Then sync your project with the gradle files.

_**Note**_ The following dependencies will be automatically installed with MetaMap library. The version numbers listed are subject to change:

* `androidx.appcompat:appcompat:1.3.1`
* `androidx.recyclerview:recyclerview:1.2.1`
* `androidx.constraintlayout:constraintlayout:2.1.4`
* `androidx.lifecycle:lifecycle-process:2.2.0`
* `androidx.lifecycle:lifecycle-common-java8:2.2.0`
* `com.google.code.gson:gson:2.8.5`
* `androidx.camera:camera-core:1.1.0`
* `androidx.camera:camera-camera2:1.1.0`
* `androidx.camera:camera-lifecycle:1.1.0`
* `androidx.camera:camera-video:1.1.0`
* `androidx.camera:camera-view:1.1.0`
* `androidx.window:window:1.0.0`
* `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.6.4`
* `androidx.navigation:navigation-fragment-ktx:2.5.2`
* `androidx.navigation:navigation-ui-ktx:2.5.2`
* `io.coil-kt:coil:2.1.0`
* `io.coil-kt:coil-svg:2.1.0`
* `org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.2`
* `io.insert-koin:koin-core:3.2.2`
* `io.insert-koin:koin-android:3.2.2`
* `io.ktor:ktor-client-android:1.5.4`
* `io.ktor:ktor-client-serialization:1.5.4`
* `io.ktor:ktor-client-logging-jvm:1.5.4`
* `org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.5.32`

## Usage

1. Add the MetamapButton to your layout

    ```xml
    <com.metamap.metamap_sdk.MetamapButton
	android:id="@+id/metamapButton"
	android:layout_width="match_parent"
	android:layout_height="wrap_content"
	android:layout_margin="16dp"
	app:color="@color/metamapButtonColor"
	app:textColor="@color/metamapButtonTextColor"
	app:text="YOUR CUSTOM TEXT" />
    ```

1.  Call `setParams` with the following arguments to authorize the app and start verification:

    | 	Parameter     | Type                 | Required |
    |---------------|----------------------|----------|
    |  `activityResultLauncher`   | @NonNull ActivityResultLauncher<Intent>      | Optional |
    |  `activity`   | @NonNull Activity      | Required |
    |  `CLIENT_ID`   | @NonNull String      | Required |
    |  `FLOW_ID`     | @Nullable String     | Required |
    |  `BUTTON_TITLE` | @NonNull String      | Optional |
    |  `METADATA` <br /> _**Note**_ Go to the [Metadata section](#metadata-usage) <br />to learn more about using metadata   | @Nullable Metadata   | Optional |
    |  `requestCode`   | @NonNull Int      | Optional |

    **Java**

    ```java
    @Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.activity_main);

	    ...

	    this.<MetamapButton>findViewById(R.id.metamapButton).setParams(
	        activityResultLauncher,
	        this,
	        "CLIENT_ID",
	        "FLOW_ID",
	        METADATA);
    }
    ```

    or you can use onActivityResult

    ```java
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        ...

        this.<MetamapButton>findViewById(R.id.metamapButton).setParams(
            this,
            "YOUR_CLIENT_ID",
            "YOUR_FLOW_ID",
            new Metadata.Builder()
                    .additionalData("userId", "qwfguweo")
                    .additionalData("type", 2)
                    .build());
    }
    ```

    **Kotlin**

    ```kotlin
	override fun onCreate(savedInstanceState: Bundle?) {
	    super.onCreate(savedInstanceState)

	    setContentView(R.layout.activity_main);

	    ...

	    findViewById<MetamapButton>(R.id.metamapButton).setParams(
	    	activityResultLauncher,
	    	this,
	        "CLIENT_ID",
	        "FLOW_ID",
	        METADATA)
	}
    ```

    or you can use onActivityResult

    ```kotlin
	override fun onCreate(savedInstanceState: Bundle?) {
	    super.onCreate(savedInstanceState)

	    setContentView(R.layout.activity_main);

	    ...

	    findViewById<MetamapButton>(R.id.metamapButton).setParams(
	    	this,
	        "CLIENT_ID",
	        "FLOW_ID",
	        METADATA)
	}
    ```


1.  Listen for the result

    **Java**
    ```java
	ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                new ActivityResultContracts.StartActivityForResult(),
                result -> {
                    Intent data = result.getData();
                    if (data == null) {
                        Toast.makeText(MainActivity.this, "Verification cancelled", Toast.LENGTH_SHORT).show();
                        return;
                    }
                    if (result.getResultCode() == Activity.RESULT_OK) {
                        // There are no request codes
                        Toast.makeText(
                                MainActivity.this,
                                "Verification success! " +
                                        "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                        "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                                Toast.LENGTH_SHORT
                        ).show();
                    } else {
                        Toast.makeText(
                                MainActivity.this,
                                "Verification cancelled! " +
                                        "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                        "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                                Toast.LENGTH_SHORT
                        ).show();
                    }
                });
    ```

    or you can use onActivityResult

    ```java
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == MetamapSdk.DEFAULT_REQUEST_CODE) {
            if (resultCode == Activity.RESULT_OK && data != null) {
                // There are no request codes
                Toast.makeText(
                        this,
                        "onActivityResult Verification success! " +
                                "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                ).show();
            } else {
                if (data != null) {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled! " +
                                    "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                    "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                            Toast.LENGTH_SHORT
                    ).show();
                } else {
                    Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled!",
                            Toast.LENGTH_SHORT
                    ).show();
                }
            }
        } else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
    ```

    **Kotlin**
    ```kotlin
	private val activityResultLauncher =
            registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                val data = result.data
                if (data == null) {
                    Toast.makeText(requireContext(), "Verification cancelled", Toast.LENGTH_SHORT)
                        .show()
                    return@registerForActivityResult
                }
                if (result.resultCode == Activity.RESULT_OK) {
                    // There are no request codes
                    Toast.makeText(
                        requireContext(),
                        "Verification success! " +
                                "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    Toast.makeText(
                        requireContext(),
                        "Verification cancelled! " +
                                "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
    ```

    or you can use onActivityResult

    ```kotlin
     override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
            if (requestCode == MetamapSdk.DEFAULT_REQUEST_CODE) {
                if (resultCode == Activity.RESULT_OK && data != null) {
                    // There are no request codes
                    Toast.makeText(
                        this,
                        "onActivityResult Verification success! " +
                                "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                        Toast.LENGTH_SHORT
                    ).show()
                } else {
                    if (data != null) {
                        Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled! " +
                                    "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                    "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                            Toast.LENGTH_SHORT
                        ).show()
                    } else {
                        Toast.makeText(
                            this,
                            "onActivityResult Verification cancelled!",
                            Toast.LENGTH_SHORT
                        ).show()
                    }
                }
            } else {
                super.onActivityResult(requestCode, resultCode, data)
            }
        }
    ```

 1. Check for your activity

    **Java**
    ```java
	public class YourActivity extends AppCompatActivity implements MatiCallback {

	    @Override
	    protected void onCreate(Bundle savedInstanceState) {
	        super.onCreate(savedInstanceState);

	        setContentView(R.layout.activity_main);

	        this.<MatiButton>findViewById(R.id.metamapButton).setParams(
	        activityResultLauncher,
		    this,
	            "CLIENT_ID",
	            "FLOW_ID",
	            new Metadata.Builder()
	                .additionalData("key_1", "value1")
	                .additionalData("key2", 2)
	                .build());
	    }

	    ActivityResultLauncher<Intent> activityResultLauncher = registerForActivityResult(
                        new ActivityResultContracts.StartActivityForResult(),
                        result -> {
                            Intent data = result.getData();
                            if (data == null) {
                                Toast.makeText(MainActivity.this, "Verification cancelled", Toast.LENGTH_SHORT).show();
                                return;
                            }
                            if (result.getResultCode() == Activity.RESULT_OK) {
                                // There are no request codes
                                Toast.makeText(
                                        MainActivity.this,
                                        "Verification success! " +
                                                "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                                "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                                        Toast.LENGTH_SHORT
                                ).show();
                            } else {
                                Toast.makeText(
                                        MainActivity.this,
                                        "Verification cancelled! " +
                                                "VerificationId:" + data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID) +
                                                "IdentityId: " + data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID),
                                        Toast.LENGTH_SHORT
                                ).show();
                            }
                        });
    }
    ```

    **Kotlin**
    ```kotlin
	class SecondActivity : AppCompatActivity() {
	    override fun onCreate(savedInstanceState: Bundle?) {
	        super.onCreate(savedInstanceState)
	        setContentView(R.layout.activity_second)

	        findViewById<MetamapButton>(R.id.metamapButton).setParams(
	        activityResultLauncher,
		    this,
	            "CLIENT_ID",
	            "FLOW_ID",
	            Metadata.Builder()
	                .additionalData("key_1", "value1")
	                .additionalData("key2", 2)
	                .build())
	    }

	    private val activityResultLauncher =
                    registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
                        val data = result.data
                        if (data == null) {
                            Toast.makeText(requireContext(), "Verification cancelled", Toast.LENGTH_SHORT)
                                .show()
                            return@registerForActivityResult
                        }
                        if (result.resultCode == Activity.RESULT_OK) {
                            // There are no request codes
                            Toast.makeText(
                                requireContext(),
                                "Verification success! " +
                                        "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                        "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                                Toast.LENGTH_SHORT
                            ).show()
                        } else {
                            Toast.makeText(
                                requireContext(),
                                "Verification cancelled! " +
                                        "VerificationId: ${data.getStringExtra(MetamapSdk.ARG_VERIFICATION_ID)}, " +
                                        "IdentityId: ${data.getStringExtra(MetamapSdk.ARG_IDENTITY_ID)}",
                                Toast.LENGTH_SHORT
                            ).show()
                        }
                    }
    }
    ```

## Metadata Usage

You can use metadata to set specific parameters, including setting a selected language and hiding the language selection to make it permanent.

key: `fixedLanguage` <br/>
value: locale code of language

### Example: Set the Language Code for Spain

To set the language code for Spain to Spanish, we would set the `fixedLanguage` parameter to `es`.

**Java**

```java

UIConfig uiConfig = new UIConfig(MetamapLanguage.SPANISH);

new Metadata.Builder()
                .uiConfig(uiConfig)
                .build();
```

**Kotlin**
```kotlin

val uiConfig = UIConfig(fixedLanguage = MetamapLanguage.SPANISH)

Metadata.Builder()
                .uiConfig(uiConfig)
                .build()
```






If you don't use `MetamapButton`, you can set the buttons' primary color and text color with metadata:

key: `buttonColor`
value: parsed color-int value

key: `buttonTextColor`
value: parsed color-int value


### Example: Set button color red(#FF0000) and text color white(#FFFFFF)

**Java**

```java

UIConfig uiConfig = new UIConfig(
                        null,
                        Color.parseColor("#EF0404"),
                        Color.parseColor("#FFFFFF")
                    );

new Metadata.Builder()
                .uiConfig(uiConfig)
                .build();
```


**Kotlin**
```kotlin

val uiConfig = UIConfig(
                    buttonColor = Color.parseColor("#EF0404"),
                    buttonTextColor = Color.parseColor("#FFFFFF")
                )

Metadata.Builder()
                .uiConfig(uiConfig)
                .build()
```

If you use `MetamapButton`, these values will be ignored and `MetamapButton`'s colors will be applied to all screens.

### Example: Set `identityId` for re-verification

To set the identity id you can use the Metadata builder method `identityId` like in the example below:

**Java**

```java

new Metadata.Builder()
                .identityId("MY_IDENTITY_ID")
                .build();
```

**Kotlin**
```kotlin

Metadata.Builder()
                .identityId("MY_IDENTITY_ID")
                .build()
```


### Example: other data

For other data you can use additionalData builder method providing key value pairs like in the example below:

**Java**

```java

new Metadata.Builder()
                .additionalData("key1" "value")
                .additionalData("key2" 24)
                .build();
```

**Kotlin**
```kotlin

Metadata.Builder()
                .additionalData("key1" "value")
                .additionalData("key2" 32)
                .build()
```


## Some error codes you may get during integration

`402` - MetaMap services are not paid: please contact your customer success manager

`403` - MetaMap credentials issues: please check your client id and MetaMap id

