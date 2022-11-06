import 'package:flutter/material.dart';

class BookingConfirmPage extends StatefulWidget {
  const BookingConfirmPage({Key key}) : super(key: key);
  @override
  State<BookingConfirmPage> createState() => _BookingConfirmPageState();
}

class _BookingConfirmPageState extends State<BookingConfirmPage> {
  Map arguments; 
  @override
  Widget build(BuildContext context) {
     arguments = ModalRoute.of(context).settings.arguments;
    return Scaffold(
      appBar: AppBar(title: Text("Scheduled results"),),
      body: Container(
        alignment: Alignment.centerLeft,
        child: Column(children: [
          Text('     Date and time：${arguments['date1'] ?? ''}',style: TextStyle(fontSize: 20),),
          // Text('The second option：${arguments['date2'] ?? ''}',style: TextStyle(fontSize: 20,),),
          Text('Doctor：${arguments['date3']?? ''}',style: TextStyle(fontSize: 20,),),
        ]),
      ),
    );
  }
}