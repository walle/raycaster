# Raycaster

This is a quick port of "A first-person engine in 265 lines" from JavaScript to Java using the libGDX framework. 

* http://www.playfuljs.com/a-first-person-engine-in-265-lines/
* http://libgdx.badlogicgames.com/

## Porting details

Besides the obvious changes in rendering and input code there is four new types introduced that in the original code are represented either as an `Array` or `Object`.

* Point
* Projection
* Ray
* Step

## Building

To test it out download the repository and build it using gradle.

**Requirements**

* JDK - http://www.oracle.com/technetwork/java/javase/downloads/jdk7-downloads-1880260.html
* Gradle - http://www.gradle.org/

The following instructions assumes you are in the root folder of the project, eg.

    $ git clone https://github.com/walle/raycaster.git
    $ cd raycaster

The first time you build the project is going to take a while since all dependencies are downloaded, will be faster after that.

### Building the desktop version

The easiest way to test the project is on desktop, just run

    $ ./gradlew desktop:run

### Building the Android version

Make sure you have the Android SDK and have created an AVD. http://developer.android.com/sdk/index.html#download
Start the emulator with your AVD and have it running before building the project. Eg.

    $ cd /path/to/android/sdk
    $ tools/emulator -avd my_avd_name -gpu on
    
When you see the emulated home screen, run the gradle task

    $ ./gradlew android:installDebug android:run

### Building the web version

    $ ./gradlew html:superDev
    
Then open your browser to http://localhost:8080/html/

### Building the IOS version

To build the IOS version it's required to use OS X. Also to have Xcode installed, install it from the AppStore.
When you have Xcode installed, make sure you have the iOS Simulator installed, otherwise install it. `Xcode -> Preferences -> Downloads`
Then run the gradle task to start the simulator.

    $ ./gradlew ios:assemble launchIPhoneSimulator
