package com.github.jzoom.flutterstatusbar;

import android.app.Activity;

import io.flutter.plugin.common.MethodChannel;
import io.flutter.plugin.common.MethodChannel.MethodCallHandler;
import io.flutter.plugin.common.MethodChannel.Result;
import io.flutter.plugin.common.MethodCall;
import io.flutter.plugin.common.PluginRegistry.Registrar;

/**
 * FlutterStatusbarPlugin
 */
public class FlutterStatusbarPlugin implements MethodCallHandler {
  private  final Activity activity;

  public FlutterStatusbarPlugin(Activity activity) {
    this.activity = activity;
  }

  /**
   * Plugin registration.
   */
  public static void registerWith(Registrar registrar) {
    final MethodChannel channel = new MethodChannel(registrar.messenger(), "flutter_statusbar");
    channel.setMethodCallHandler(new FlutterStatusbarPlugin(registrar.activity()));
  }
  public int getStatusBarHeight() {
    int result = 0;
    int resourceId = activity.getResources().getIdentifier("status_bar_height", "dimen", "android");
    if (resourceId > 0) {
      result = activity.getResources().getDimensionPixelSize(resourceId);
    }
    return result;
  }
  @Override
  public void onMethodCall(MethodCall call, Result result) {
    if (call.method.equals("height")) {
      result.success( (double)getStatusBarHeight() );
    } else {
      result.notImplemented();
    }
  }
}
