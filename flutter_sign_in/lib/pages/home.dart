import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/pages/selectDart.dart';

import '../common/utils/Album.dart';

class HomePage extends StatefulWidget {
  final a;
  const HomePage({Key key, this.a}) : super(key: key);

  @override
  State<HomePage> createState() => _HomePageState();
}

class _HomePageState extends State<HomePage> {
  @override
  Widget build(BuildContext context) {
    return Scaffold(
      appBar: AppBar(
        title: Text("Dashboard"),
      ),
      resizeToAvoidBottomInset: false,
      body: Container(
        color: Colors.white,
        alignment: Alignment.center,
        child: Column(
          children: [
            MaterialButton(
                onPressed: () {},
                color: Colors.blue,
                child: Text(
                  "Profile",
                  style: TextStyle(color: Colors.white),
                )),
            MaterialButton(
                onPressed: () {},
                color: Colors.blue,
                child: Text("Profile", style: TextStyle(color: Colors.white))),
            MaterialButton(
                onPressed: () {
                  Navigator.push(
                      context,
                    MaterialPageRoute(
                      builder: (context) => FutureDemoPage(),
                    ),
                    );
                },
                color: Colors.blue,
                child: Text("Booking", style: TextStyle(color: Colors.white))),
            MaterialButton(
                onPressed: () {},
                color: Colors.blue,
                child: Text("Manage Medicine",
                    style: TextStyle(color: Colors.white))),
          ],
        ),
      ),
    );
  }
}
