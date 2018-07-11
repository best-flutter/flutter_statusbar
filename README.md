# flutter_statusbar

A flutter plugin to fetch statusbar info like height.

## Getting Started
Add 

```bash

flutter_statusbar : ^0.0.1

```
to your pubspec.yaml ,and run 

```bash
flutter packages get 
```

## How to use
```
import 'package:flutter_statusbar/flutter_statusbar.dart';

double _height = await FlutterStatusbar.height;

```