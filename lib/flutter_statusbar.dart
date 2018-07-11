import 'dart:async';

import 'package:flutter/services.dart';

class FlutterStatusbar {
  static const MethodChannel _channel =
      const MethodChannel('flutter_statusbar');

  static Future<double> get height async {
    return await _channel.invokeMethod('height');
  }
}
