# React Native Android Badge

[![NPM version](http://img.shields.io/npm/v/react-native-android-badge.svg?style=flat)](https://www.npmjs.com/package/react-native-android-badge)

A react native wrapper for [leolin310148/ShortcutBadger](https://github.com/leolin310148/ShortcutBadger).

## Why?

A react-native `PushNotificationIOS` provide setting badge of functions, it belongs to the native iOS support, but Android requires third-party library to do.

## Install & Setup

* install module

```bash
npm i --save react-native-android-badge
```

* `android/setting.gradle`

```gradle
...
include ':react-native-android-badge'
project(':react-native-android-badge').projectDir = new File(settingsDir, '../node_modules/react-native-android-badge')
```

* `android/app/build.gradle`

```gradle
...
dependencies {
    ...
    compile project(':react-native-android-badge')
}
```

* register module (in MainActivity.java)

```java
import me.jhen.react.BadgeModule;  // <--- import

public class MainActivity extends Activity implements DefaultHardwareBackBtnHandler {
  ...

  // create class
  private class ExampleReactPackage extends MainReactPackage {

    @Override
    public List<NativeModule> createNativeModules(
                                ReactApplicationContext reactContext) {
      List<NativeModule> modules = super.createNativeModules(reactContext);

      modules.add(new BadgeModule(reactContext));
      return modules;
    }
  }

  ......

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    mReactRootView = new ReactRootView(this);

    mReactInstanceManager = ReactInstanceManager.builder()
      .setApplication(getApplication())
      .setBundleAssetName("index.android.bundle")
      .setJSMainModuleName("index.android")
      .addPackage(new ExampleReactPackage())         // <------- here
      .setUseDeveloperSupport(BuildConfig.DEBUG)
      .setInitialLifecycleState(LifecycleState.RESUMED)
      .build();

    mReactRootView.startReactApplication(mReactInstanceManager, "ExampleRN", null);

    setContentView(mReactRootView);
  }

  ......

}
```

## Usage

```js
var BadgeAndroid = require('react-native-android-badge');

BadgeAndroid.setBadge(10);
```