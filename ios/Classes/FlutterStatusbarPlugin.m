#import "FlutterStatusbarPlugin.h"

@implementation FlutterStatusbarPlugin
+ (void)registerWithRegistrar:(NSObject<FlutterPluginRegistrar>*)registrar {
  FlutterMethodChannel* channel = [FlutterMethodChannel
      methodChannelWithName:@"flutter_statusbar"
            binaryMessenger:[registrar messenger]];
  FlutterStatusbarPlugin* instance = [[FlutterStatusbarPlugin alloc] init];
  [registrar addMethodCallDelegate:instance channel:channel];
}

- (void)handleMethodCall:(FlutterMethodCall*)call result:(FlutterResult)result {
  if ([@"height" isEqualToString:call.method]) {
    result( @(  [[UIApplication sharedApplication] statusBarFrame].size.height  ) );
  } else {
    result(FlutterMethodNotImplemented);
  }
}

@end
