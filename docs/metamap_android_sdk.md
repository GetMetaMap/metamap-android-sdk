---
title: "Android"
excerpt: "Add the Metamap button to your Android app."
slug: "mobile-sdks"
category: 61141a8437375100442f3d20
hidden: true
---

## Android Demo App

You can go to GitHub to download the [Metamap Android Java demo app](https://github.com/GetMati/mati-mobile-examples/tree/main/javaDemoApp(native)).


## Requirements & size

Android: v5.0 (API v21) or higher.

Kotlin: 1.4 or higher.

SDK size: ~2.5MB

## Install the Metamap Android SDK

To install the Metamap Android SDK using [Gradle](https://gradle.org/), you will need to do the following:

- Ensure that your top-level `build.gradle` references to the following repository:

	```java
	maven { url 'https://repo1.maven.org/maven2' }
	```

- Enable Java 1.8 source compatibility.

	```java
	android {
	    compileOptions {
		sourceCompatibility = JavaVersion.VERSION_1_8
		targetCompatibility = JavaVersion.VERSION_1_8
	    }
	}
	```

- Add the following line to the list of gradle dependencies for your version of the Metamap Android SDK:

	```java
	implementation ('com.getmati:mati-sdk: <your Metamap SDK version number>'){
		exclude group: 'org.json', module: 'json'
	}
	```

	For example, if you are using the Metamap Android SDK version 3.12.3, you would include the following line:


	```java
	implementation ('com.getmati:mati-sdk:3.12.3'){
		exclude group: 'org.json', module: 'json'
	}
	```

Then sync your project with the gradle files.

_**Note**_ The following dependencies will be automatically installed with Metamap library. The version numbers listed are subject to change:

    `androidx.appcompat:appcompat:1.3.1`
    `androidx.recyclerview:recyclerview:1.2.1`
    `androidx.constraintlayout:constraintlayout:2.0.4`
    `com.google.android.material:material:1.4.0`
    `androidx.lifecycle:lifecycle-process:2.2.0`
    `androidx.lifecycle:lifecycle-common-java8:2.2.0`
    `com.google.code.gson:gson:2.8.5`
    `org.jetbrains.kotlin:kotlin-stdlib-jdk7:1.4.31`
    `androidx.fragment:fragment-ktx:1.3.0`
    `androidx.core:core-ktx:1.3.2`
    `io.socket:socket.io-client:1.0.0`
    `androidx.camera:camera-core:1.1.0-alpha10`
    `androidx.camera:camera-camera2:1.1.0-alpha10`
    `androidx.camera:camera-lifecycle:1.1.0-alpha10`
    `androidx.camera:camera-video:1.1.0-alpha10`
    `androidx.camera:camera-view:1.0.0-alpha30`
    `androidx.concurrent:concurrent-futures-ktx:1.1.0`
    `androidx.window:window:1.0.0-beta03`
    `org.jetbrains.kotlinx:kotlinx-coroutines-android:1.5.0`
    `androidx.lifecycle:lifecycle-runtime-ktx:2.3.1`
    `androidx.navigation:navigation-fragment-ktx:2.3.3`
    `androidx.navigation:navigation-ui-ktx:2.3.3`
    `androidx.navigation:navigation-dynamic-features-fragment:2.3.3`
    `io.coil-kt:coil:1.4.0`
    `org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1`



## Usage

1. Add the Metamap Button to your layout

	```xml
	<com.getmati.mati_sdk.MatiButton
		android:id="@+id/matiKYCButton"
		android:layout_width="match_parent"
		android:layout_height="wrap_content"
		android:layout_margin="16dp"
		app:color="@color/matiButtonColor"
		app:textColor="@color/matiButtonTextColor"
		app:text="YOUR CUSTOM TEXT" />
	```

1.  Call `setParams` with the following arguments to authorize the app and start verification:

	| 	Parameter     | Type                 | Required |
	|---------------|----------------------|----------|
	|  `activity`   | @NonNull Activity      | Required |
	|  `CLIENT_ID`   | @NonNull String      | Required |
	|  `FLOW_ID`     | @Nullable String     | Required |
	|  `BUTTON_TITLE` | @NonNull String      | Optional |
	|  `METADATA` <br /> _**Note**_ Go to the [Metadata section](#metadata-usage) <br />to learn more about using metadata   | @Nullable Metadata   | Optional |



	**Java**

	```Java
	@Override
	protected void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    setContentView(R.layout.activity_main);

	    ...

	    this.<MetamapButton>findViewById(R.id.matiKYCButton).setParams(
	        this,
	        "CLIENT_ID",
	        "FLOW_ID",
	        METADATA);
	}
	```

	**Kotlin**

	```kotlin
	override fun onCreate(savedInstanceState: Bundle?) {
	    super.onCreate(savedInstanceState)

	    setContentView(R.layout.activity_main);

	    ...

	    findViewById<MetamapButton>(R.id.matiKYCButton).setParams(
	    	this,
	        "CLIENT_ID",
	        "FLOW_ID",
	        METADATA)
	}
	```


1.  Listen for `KYCActivity` results

	**Java**
	```Java
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if(requestCode == MatiSdk.REQUEST_CODE) {
	        if(resultCode == RESULT_OK) {
                Toast.makeText( this,"SUCCESS | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
                        + " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
            } else {
                Toast.makeText( this,"CANCELLED | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
                        + " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
            }
	    } else {
	        super.onActivityResult(requestCode, resultCode, data);
	    }
	}
	```

	**Kotlin**
	```Kotlin
	override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
	    if (requestCode == MatiSdk.REQUEST_CODE) {
	        if (resultCode == Activity.RESULT_OK) {
			Toast.makeText(
				this, "SUCCESS | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
						+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG
			).show()
		} else {
			Toast.makeText(
				this, "CANCELLED | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
						+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG
			).show()
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

	        this.<MetamapButton>findViewById(R.id.matiKYCButton).setParams(
		    this,
	            "CLIENT_ID",
	            "FLOW_ID",
	            new Metadata.Builder()
	                .with("key_1", "value1")
	                .with("key2", 2)
	                .build());
	    }

	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if(requestCode == MatiSdk.REQUEST_CODE) {
	            if(resultCode == RESULT_OK) {
				Toast.makeText( this,"SUCCESS | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
						+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
			} else {
				Toast.makeText( this,"CANCELLED | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
						+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG).show();
			}
	        } else {
	            super.onActivityResult(requestCode, resultCode, data);
	        }
	    }
	}
	```

	**Kotlin**
	```kotlin
	class SecondActivity : AppCompatActivity() {
	    override fun onCreate(savedInstanceState: Bundle?) {
	        super.onCreate(savedInstanceState)
	        setContentView(R.layout.activity_second)

	        findViewById<MetamapButton>(R.id.matiKYCButton).setParams(
		    this,
	            "CLIENT_ID",
	            "FLOW_ID",
	            Metadata.Builder()
	                .with("key_1", "value1")
	                .with("key2", 2)
	                .build())
	    }

	    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
	        if (requestCode == MatiSdk.REQUEST_CODE) {
	            if (resultCode == Activity.RESULT_OK) {
				Toast.makeText(
					this, "SUCCESS | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
							+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG
				).show()
			} else {
				Toast.makeText(
					this, "CANCELLED | VerificationId: " + data.getStringExtra(MatiSdk.ARG_VERIFICATION_ID)
							+ " IdentityId: " + data.getStringExtra(MatiSdk.ARG_IDENTITY_ID), Toast.LENGTH_LONG
				).show()
			}
	        } else {
	            super.onActivityResult(requestCode, resultCode, data)
	        }
	    }
	}
	```

## Metadata Usage

You can use metadata to set specific parameters, including setting a selected language and hiding the language selection to make it permanent.

key: `fixedLanguage` <br/>
value: locale code of language

### Example: Set the Language Code for Spain

To set the language code for Spain to Spanish, we would set the `fixedLanguage` parameter to `es`

**Java**

```java
new Metadata.Builder()
                .with("fixedLanguage", "es")
                .build();
```

**Kotlin**
```kotlin
Metadata.Builder()
                .with("fixedLanguage", "es")
                .build()
```






If you don't use `MatiButton`, you can set the buttons' primary color and text color with metadata:

key: `buttonColor`
value: parsed color-int value

key: `buttonTextColor`
value: parsed color-int value


### Example: Set button color red(#FF0000) and text color white(#FFFFFF)

**Java**

```java
new Metadata.Builder()
                .with("buttonColor", Color.parseColor("#FF0000"))
	    	.with("buttonTextColor", Color.parseColor("#FFFFFF"))
                .build();
```


**Kotlin**
```kotlin
Metadata.Builder()
                .with("buttonColor", Color.parseColor("#FF0000"))
	    	.with("buttonTextColor", Color.parseColor("#FFFFFF"))
                .build()
```

If you use `MatiButton`, this values will be ignored and MatiButton's colors will be applied to all the screens.


## Proguard

The SDK uses the `kotlinx.serialization` library, so if you're using ProGuard you need to add rules to your `proguard-rules.pro` configuration to cover all classes that are serialized at runtime.

The following configuration keeps serializers for _all_ serializable classes that are retained after shrinking.

```java
# Keep `Companion` object fields of serializable classes.
# This avoids serializer lookup through `getDeclaredClasses` as done for named companion objects.
-if @kotlinx.serialization.Serializable class **
-keepclassmembers class <1> {
    static <1>$Companion Companion;
}

# Keep `serializer()` on companion objects (both default and named) of serializable classes.
-if @kotlinx.serialization.Serializable class ** {
    static **$* *;
}
-keepclassmembers class <1>$<3> {
    kotlinx.serialization.KSerializer serializer(...);
}

# Keep `INSTANCE.serializer()` of serializable objects.
-if @kotlinx.serialization.Serializable class ** {
    public static ** INSTANCE;
}
-keepclassmembers class <1> {
    public static <1> INSTANCE;
    kotlinx.serialization.KSerializer serializer(...);
}

# @Serializable and @Polymorphic are used at runtime for polymorphic serialization.
-keepattributes RuntimeVisibleAnnotations,AnnotationDefault

```
