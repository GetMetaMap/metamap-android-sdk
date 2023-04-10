---
title: "Android Data Safety Guide"
excerpt: "Ensure that you comply with Google Play's data disclosure requirements."
slug: "android-data-safety-guide"
category: 61ae8e8dba577a0010791480
---

# Android Data Safety Guide

## Google Play’s data disclosure requirements
Google Play’ [Data safety section](https://android-developers.googleblog.com/2021/05/new-safety-section-in-google-play-will.html) is a developer-provided disclosure for an app's data-collection, sharing, and security practices.

Use this page to help you complete the requirements for this data disclosure with respect to your usage of MetaMap’s SDKs, including whether and how our SDK handles end-user data, and any applicable configurations or invocations you can control as the app developer.

We at MetaMap aim to be as transparent as possible, but as the app developer you are responsible for your response to Google Play's Data safety section form.

## Collected data
The following lists the end-user data collected by the latest version of the MetaMap SDK. The data collection falls into two classes:

- Automatic collection
Data collected automatically without invoking specific methods or classes in your app
- Dashboard-configured collection
Data collected based on your [Dashboard](https://dashboard.getmati.com/) configuration of the SDK. In many cases, the data collected by the SDK is defined by your app's dashboard configuration.

Use [Android's guide about data types](https://developer.android.com/guide/topics/data/collect-share) to help you determine which data type best describes the collected data to complete your data disclosure. In your data disclosure, make sure to also account for how your specific app shares and uses the collected data.

> 📘Data Encryption
> 
> All of the user data collected by the SDK is encrypted in transit using the Transport Layer Security (TLS) protocol.


### Data collected automatically

The MetaMap SDK collects the following data automatically.

| Data collected | Definition |
| --- | --- |
| User IDs | Identifiers that relate to an identifiable person. For example, an account ID, account number, or account name. |
| Device or other IDs | Identifiers that relate to an identifiable device |
| App interactions | Information about how a user interacts with the SDK. For example, the number of times they visit a page, or what they click on. |
| Crash logs | Information related to crashes, such as the number of times the SDK has crashed or stack traces. |
| Diagnostics | Information about the SDK’s performance, such as battery life, loading time, latency, framerate, or technical diagnostics. |
| Approximate location | Approximate location information derived from an IP address. |

### Data collected depending on your Dashboard configuration

Depending on how you configure the MetaMap [Dashboard](https://dashboard.getmati.com) your app may collect end-user data that needs to be included in your data disclosure. The following table lists end-user data that can be collected. Make sure to account for any data collected for your specific usage.

#### Location Intelligence

If the `High Accuracy check` is used:

| Data collected | Definition |
| --- | --- |
| Precise location | If High Accuracy check is used: user or device physical location within an area less than 3 square kilometers, such as location provided by Android's ACCESS_FINE_LOCATION
 permission. |


#### Biometric Verification

For `Selfie Photo`

| Data collected | Definition |
| --- | --- |
| Photos | A user's captured photo |

For `Selfie Video` or `Selfie Video + Voice`

| Data collected | Definition |
| --- | --- |
| Videos | A user’s recorded video |

#### Document Verification

| Data collected | Definition |
| --- | --- |
| Photos | A user's captured or provided photos. |
| Files and docs | A user provided files and docs |

#### Custom input

Any data covered by the data safety scope that is required by the custom template created in the dashboard. 

#### Phone check

| Data collected | Definition |
| --- | --- |
| Phone number | A user's phone number. |

#### Email check

| Data collected | Definition |
| --- | --- |
| Email address | User’s email address |

#### Custom document

| Data collected | Definition |
| --- | --- |
| Photos | A user's captured or provided photos. |
| Files and docs | A user provided files and docs |

#### E-signature

| Data collected | Definition |
| --- | --- |
| Name | How a user refers to themselves, such as their first or last name, or nickname. |

> 📘Additional data requirements
> 
>  Depending on the Dashboard configuration E-signature may also collect data required by Document Verification and Biometric verification in addition to the name.


#### Bank account data

| Data collected | Definition |
| --- | --- |
| Name | Account holder’s name |
| Email address | Account holder’s email address |
| User IDs | Client number, Taxpayer ID |
| Address | Account holder’s address |
| Phone number | Account holder’s phone number |
| User payment info | Information about a user's financial accounts: institution ID, currency, account type, account type name, account number, CLABE number |
| Purchase history | Information about purchases or transactions: transaction date, amount, balance, type, reference, formal description, transaction start and end dates, statement start and end dates |

#### Payroll account data

| Data collected | Definition |
| --- | --- |
| Name | Account holder’s name |
| Email address | Account holder’s email address |
| User IDs | Client number, Account number, Taxpayer ID |
| Address | Account holder’s address |
| Phone number | Account holder’s phone number |
| User payment info | Information about a user's financial accounts: name, number, CLABE number, balance, currency, type |
| Other financial info | transaction date, amount, reference, balance, type, formal description |

#### Work account data

| Data collected | Definition |
| --- | --- |
| Name | Account holder’s name |
| Email address | Account holder’s email address |
| User IDs | Client number, Taxpayer ID |
| Address | Account holder’s address |
| Phone number | Account holder’s phone number |
| User payment info | Information about a user's financial accounts: name, number, CLABE number, balance, currency, type |
| Other financial info | transaction date, amount, reference, balance, type, formal description |
