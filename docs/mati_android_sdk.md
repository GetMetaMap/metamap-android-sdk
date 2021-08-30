---
title: "Mati for Android"
excerpt: "Add the Mati button to your Android app."
slug: "mobile-sdks"
category: 61141a8437375100442f3d20
---

# Mati for Android Usage Guide


## Requirements

Mati Android SDK versions &#8805;3.x.x requires Android v5.0 (API v21) or higher.

## Install the Mati Android SDK

To install the Mati Android SDK using [Gradle](https://gradle.org/), you will need to do the following:

- Ensure that your top-level `build.gradle` references to the following repository:
	```
	maven { url 'https://repo1.maven.org/maven2' }
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

- Add the following line to the list of gradle dependencies for your version of the Mati Android SDK:

	```
	implementation ('com.getmati:mati-sdk: <your Mati SDK version number>'){
		exclude group: 'org.json', module: 'json'
	}
	```

	For example, if you are using the Mati Android SDK version 3.8.0, you would include the following line:

	```
	implementation ('com.getmati:mati-sdk:3.8.0'){
		exclude group: 'org.json', module: 'json'
	}
	```

Then sync your project with the gradle files.

_**Note**_ The following dependency will be automatically installed with Mati library:

    `io.socket:socket.io-client:0.8.3`

## Usage

1. Add the MatiButton to your layout

	```xml
	<com.getmati.mati_sdk.MatiButton
	        android:id="@+id/matiKYCButton"
	        android:layout_width="match_parent"
	        android:layout_height="wrap_content"
	        android:layout_margin="16dp"
	        app:text="YOUR CUSTOM TEXT" />
	```
1.  Call `setParams` with the following arguments to authorize the app and start verification:

	| 	Parameter     | Type                 | Required |
	|---------------|----------------------|----------|
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

	    this.<MatiButton>findViewById(R.id.matiKYCButton).setParams(
	        "CLIENT_ID",
	        "FLOW_ID",
	        "BUTTON_TITLE",
	        METADATA);
	}
	```

	**Kotlin**

	```kotlin
	override fun onCreate(savedInstanceState: Bundle?) {
	    super.onCreate(savedInstanceState)

	    setContentView(R.layout.activity_main);

	    ...

	    findViewById<MatiButton>(R.id.matiKYCButton).setParams(
	        "CLIENT_ID",
	        "FLOW_ID",
	        "BUTTON_TITLE",
	        METADATA)
	}
	```

1.  Listen for `KYCActivity` result

	**Java**
	```Java
	@Override
	protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	    if(requestCode == MatiSdk.REQUEST_CODE) {
	        if(resultCode == RESULT_OK) {
	            Toast.makeText( this,"SUCCESS!!!", Toast.LENGTH_LONG).show();
	        } else {
	            Toast.makeText( this,"CANCELLED!!!", Toast.LENGTH_LONG).show();
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
	        if (resultCode == RESULT_OK) {
	            Toast.makeText(this, "SUCCESS!!!", Toast.LENGTH_LONG).show()
	        } else {
	            Toast.makeText(this, "CANCELLED!!!", Toast.LENGTH_LONG).show()
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

	        this.<MatiButton>findViewById(R.id.matiKYCButton).setParams(
	            "CLIENT_ID",
	            "FLOW_ID",
	            "BUTTON_TITLE"
	            new Metadata.Builder()
	                .with("key_1", "value1")
	                .with("key2", 2)
	                .build());
	    }

	    @Override
	    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
	        if(requestCode == MatiSdk.REQUEST_CODE) {
	            if(resultCode == RESULT_OK) {
	                Toast.makeText( this,"SUCCESS!!!", Toast.LENGTH_LONG).show();
	            } else {
	                Toast.makeText( this,"CANCELLED!!!", Toast.LENGTH_LONG).show();
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

	        findViewById<MatiButton>(R.id.matiKYCButton).setParams(
	            "CLIENT_ID",
	            "FLOW_ID",
	            "BUTTON_TITLE"
	            Metadata.Builder()
	                .with("key_1", "value1")
	                .with("key2", 2)
	                .build())
	    }

	    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
	        if (requestCode == MatiSdk.REQUEST_CODE) {
	            if (resultCode == RESULT_OK) {
	                Toast.makeText(this, "SUCCESS!!!", Toast.LENGTH_LONG).show()
	            } else {
	                Toast.makeText(this, "CANCELLED!!!", Toast.LENGTH_LONG).show()
	            }
	        } else {
	            super.onActivityResult(requestCode, resultCode, data)
	        }
	    }
	}
	```
## Metadata Usage

You can use metadata to set specific parameters, including setting a selected language and hiding the language selection to make it permanent.

key: `fixedLanguage`
value: locale code of language

### Example: Set the Language Code for Spain

To set the language code for Spain to Spanish, we would set the `fixedLanguage` parameter to `es" `

**Java**

```java
new Metadata.Builder()
                .with("fixedLanguage", "es")
                .build());
```

**Kotlin**
```kotlin
Metadata.Builder()
                .with("fixedLanguage", "es")
                .build())
```
