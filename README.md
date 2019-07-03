This project demonstrates a problem testing dialogs
===================================================

The app contains a button, which when clicked, shows a dialog.
Tapping on "ok" in the dialog dismisses the dialog.

An espresso test:
* Taps the button
* Verifies the dialog is visible (by looking for a view with the dialog title)
* Taps on the dialog button
* Verifies that the button is visible again

The espresso test works when run on an emulator or device.
The espresso tests fails when running on Robolectric: the dialog doesn't appear

Steps to reproduce the problem
------------------------------

* Launch an emulator and/or connect a device via adb
* Run `./gradlew cAT`
* The test passes: OK
* Run `./gradlew testDebugUnitTest`
* Expected behavior: the test passes
* Actual behavior: the test fails with error:
```
androidx.test.espresso.NoMatchingViewException: No views in hierarchy found matching: with string from resource id: <2131427370>[dialog_title] value: Some title
```
