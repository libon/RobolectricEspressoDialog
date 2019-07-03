This project demonstrates a problem testing dialogs
===================================================

The app contains a button, which when clicked, shows a dialog.
Tapping on "ok" in the dialog dismisses the dialog.

An espresso test:
* Taps the button
* Verifies the dialog is visible (by looking for a view with the dialog title)
* Taps on the dialog button
* Verifies that the button is visible again

Results:
* The espresso test works when run on an emulator or device.
* The espresso test fails when running on Robolectric: the dialog doesn't appear

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

View Hierarchy:
+>DecorView{id=-1, visibility=VISIBLE, width=320, height=470, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params={(0,0)(fillxfill) ty=BASE_APPLICATION wanim=0x10302f8
  fl=LAYOUT_IN_SCREEN LAYOUT_INSET_DECOR SPLIT_TOUCH HARDWARE_ACCELERATED DRAWS_SYSTEM_BAR_BACKGROUNDS
  pfl=FORCE_DRAW_STATUS_BAR_BACKGROUND}, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
|
+->LinearLayout{id=-1, visibility=VISIBLE, width=320, height=470, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@78a37cf6, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
|
+-->ViewStub{id=16908682, res-name=action_mode_bar_stub, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@66b5ada5, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0} 
|
+-->FrameLayout{id=-1, visibility=VISIBLE, width=320, height=470, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.LinearLayout$LayoutParams@49987012, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
|
+--->ActionBarOverlayLayout{id=2131165232, res-name=decor_content_parent, visibility=VISIBLE, width=320, height=470, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@2593714d, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
|
+---->ContentFrameLayout{id=16908290, res-name=content, visibility=VISIBLE, width=320, height=414, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@7a6386df, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=56.0, child-count=1} 
|
+----->ConstraintLayout{id=-1, visibility=VISIBLE, width=320, height=414, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@40a7b822, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=1} 
|
+------>AppCompatButton{id=2131165265, res-name=my_button, visibility=VISIBLE, width=88, height=61, has-focus=true, has-focusable=true, has-window-focus=true, is-clickable=true, is-enabled=true, is-focused=true, is-focusable=true, is-layout-requested=false, is-selected=false, layout-params=androidx.constraintlayout.widget.ConstraintLayout$LayoutParams@5de9b12, tag=null, root-is-layout-requested=false, has-input-connection=false, x=116.0, y=177.0, text=Click here, input-type=0, ime-target=false, has-links=false} 
|
+---->ActionBarContainer{id=2131165192, res-name=action_bar_container, visibility=VISIBLE, width=320, height=56, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.ActionBarOverlayLayout$LayoutParams@d86a7b3, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
|
+----->Toolbar{id=2131165190, res-name=action_bar, visibility=VISIBLE, width=320, height=56, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@5f4324af, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=2} 
|
+------>AppCompatTextView{id=-1, visibility=VISIBLE, width=25, height=41, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@45dc814d, tag=null, root-is-layout-requested=false, has-input-connection=false, x=16.0, y=7.0, text=RobolectricEspressoDialog, input-type=0, ime-target=false, has-links=false} 
|
+------>ActionMenuView{id=-1, visibility=VISIBLE, width=0, height=56, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=false, is-selected=false, layout-params=androidx.appcompat.widget.Toolbar$LayoutParams@272064de, tag=null, root-is-layout-requested=false, has-input-connection=false, x=320.0, y=0.0, child-count=0} 
|
+----->ActionBarContextView{id=2131165198, res-name=action_context_bar, visibility=GONE, width=0, height=0, has-focus=false, has-focusable=false, has-window-focus=true, is-clickable=false, is-enabled=true, is-focused=false, is-focusable=false, is-layout-requested=true, is-selected=false, layout-params=android.widget.FrameLayout$LayoutParams@72c7b78d, tag=null, root-is-layout-requested=false, has-input-connection=false, x=0.0, y=0.0, child-count=0} 
|

	at java.lang.Thread.getStackTrace(Thread.java:1556)
	at androidx.test.espresso.base.DefaultFailureHandler.getUserFriendlyError(DefaultFailureHandler.java:96)
	at androidx.test.espresso.base.DefaultFailureHandler.handle(DefaultFailureHandler.java:59)
	at androidx.test.espresso.ViewInteraction.waitForAndHandleInteractionResults(ViewInteraction.java:322)
	at androidx.test.espresso.ViewInteraction.check(ViewInteraction.java:306)
	at com.example.robolectricespressodialog.DialogTest.testDialog(DialogTest.kt:19)
	at sun.reflect.NativeMethodAccessorImpl.invoke0(Native Method)
	at sun.reflect.NativeMethodAccessorImpl.invoke(NativeMethodAccessorImpl.java:62)
	at sun.reflect.DelegatingMethodAccessorImpl.invoke(DelegatingMethodAccessorImpl.java:43)
	at java.lang.reflect.Method.invoke(Method.java:498)
	at org.junit.runners.model.FrameworkMethod$1.runReflectiveCall(FrameworkMethod.java:50)
	at org.junit.internal.runners.model.ReflectiveCallable.run(ReflectiveCallable.java:12)
	at org.junit.runners.model.FrameworkMethod.invokeExplosively(FrameworkMethod.java:47)
	at org.junit.internal.runners.statements.InvokeMethod.evaluate(InvokeMethod.java:17)
	at org.robolectric.RobolectricTestRunner$HelperTestRunner$1.evaluate(RobolectricTestRunner.java:546)
	at org.robolectric.internal.SandboxTestRunner$2.lambda$evaluate$0(SandboxTestRunner.java:252)
	at org.robolectric.internal.bytecode.Sandbox.lambda$runOnMainThread$0(Sandbox.java:89)
	at java.util.concurrent.FutureTask.run(FutureTask.java:266)
	at java.util.concurrent.ThreadPoolExecutor.runWorker(ThreadPoolExecutor.java:1142)
	at java.util.concurrent.ThreadPoolExecutor$Worker.run(ThreadPoolExecutor.java:617)
	at java.lang.Thread.run(Thread.java:745)
```
