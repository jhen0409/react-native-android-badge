package me.jhen.react;

import android.content.Context;

import com.facebook.react.bridge.NativeModule;
import com.facebook.react.bridge.ReactApplicationContext;
import com.facebook.react.bridge.ReactContext;
import com.facebook.react.bridge.ReactContextBaseJavaModule;
import com.facebook.react.bridge.ReactMethod;

import me.leolin.shortcutbadger.ShortcutBadger;

public class BadgeModule extends ReactContextBaseJavaModule {

  private Context context;

  public BadgeModule(ReactApplicationContext reactContext) {
    super(reactContext);

    this.context = (Context) reactContext;
  }

  @Override
  public String getName() {
    return "BadgeAndroid";
  }

  @ReactMethod
  public void setBadge(int number) {
    ShortcutBadger.applyCount(getReactApplicationContext(), number);
  }
}