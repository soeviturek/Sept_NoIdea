import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/pages/sign_in/sign_in.dart';
import 'package:flutter_ducafecat_news/pages/welcome/welcome.dart';
import 'package:flutter_ducafecat_news/routes.dart';

void main() => runApp(MyApp());

class MyApp extends StatelessWidget {
  @override
  Widget build(BuildContext context) {
    return MaterialApp(
      title: 'nd_telemedicine',
      home: WelcomePage(),
      routes: staticRoutes,
      debugShowCheckedModeBanner: false,
    );
  }
}
