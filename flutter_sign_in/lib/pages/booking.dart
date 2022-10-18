import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/common/utils/Album.dart';
import 'package:intl/intl.dart';

const double _kItemExtent = 32.0;
const double _kPickerHeight = 216.0;
const bool _kUseMagnifier = true;
const double _kMagnification = 2.35 / 2.1;
const double _kSqueeze = 1.25;
List<Doc> doclist;


const TextStyle _kDefaultPickerTextStyle = TextStyle(
  inherit: false,
  fontFamily: '.SF Pro Display',
  fontSize: 21,
  fontWeight: FontWeight.normal,
  color: CupertinoColors.label,
);
  
class BookingPage extends StatefulWidget {
  const BookingPage({Key key,  this.title}) : super(key: key);

  final String title;


  @override
  State<BookingPage> createState() => _BookingPageState();
}

class _BookingPageState extends State<BookingPage> {
  String date1 ;
  var date3;
  DateTime dt1,dt2;
  bool error;

  final DateFormat formatter = DateFormat(' d,MMMM, y hh:mm aaa');
  int cindex  =5;
  @override
  void initState()  {

    super.initState();
    dt1 = DateTime.now();
    date1 = formatter.format(dt1);
    // dt2 = DateTime.now();
    // date2 = dt2.toString();
    date3 = "index$cindex";
    // doclist = Future.  (DocContainer());

  }
  Map arguments;
  @override
  Widget build(BuildContext context) {
    arguments = ModalRoute.of(context).settings.arguments;
    // Doc d  = arguments["doc"];
    print(arguments["doc"]);
    return Scaffold(
      appBar: AppBar(
        title: Text("Scheduled"),
      ),
      body: Center(
        child: Builder(builder: (context) {
          return SingleChildScrollView(
            child: Column(
              mainAxisAlignment: MainAxisAlignment.start,
              crossAxisAlignment: CrossAxisAlignment.stretch,

              children: <Widget>[
                //Select Date and Time
                Container(
                  //SizedBox Widget
                  child: SizedBox(
                    width: 100.0,
                    height: 50.0,
                    child: Card(
                      color: Colors.green,
                      child: Center(
                        child: Text(
                          'Select date and time',
                          style: TextStyle(color: Colors.white),
                        ), //Text
                      ), //Center
                    ), //Card
                  ), //SizedBox
                ),
              SizedBox(
                // width: double.maxFinite,
                height: _kPickerHeight,
                child: CupertinoDatePicker(
                  initialDateTime: dt1,
                  backgroundColor: Colors.white,
                  use24hFormat: false,
                  onDateTimeChanged: (DateTime value) {
                    date1 =  formatter.format(value);
                  },
                ),
              ),
            //Select Doctor
            Container(
              //SizedBox Widget
              child: SizedBox(
                width: 100.0,
                height: 50.0,
                child: Card(
                  color: Colors.green,
                  child: Center(
                    child: Text(
                      'Select Doctor',
                      style: TextStyle(color: Colors.white),
                    ), //Text
                  ), //Center
                ), //Card
              ), //SizedBox
            ),
            // Container(
            //   width: double.maxFinite,
            //   height: _kPickerHeight,
            //
            //   child: Row(
            //     children: [
            //
            //       Container(
            //         margin: EdgeInsets.only(top:30),
            //         child:
            //           date3 == null?
            //         Text("Choose Doctor"):
            //         cityList(),
            //       ),
            //     ],
            //   ),
            // ),
            Container(
              height: 54,
              width: 100,
              alignment: Alignment.bottomCenter,
              child: ElevatedButton(
                onPressed: () {
                  makeAppointment(date1, date3);
                  Navigator.pushNamed(
                  context,
                  "/booking-confirm",
                  arguments: {
                    "date1":date1,
                    "date3":"doc2",

                  }

                );
                },
                child: const Text('confirm'),
              ),
            ),
          ],
            ),
          );
        }),
      ),
    );
  }

  Future<List<Doc>> DocContainer() async {
    List<Doc> doclist= await fetchDocList();
    return doclist;
  }


  @override
  Widget cityList() {
    return SafeArea(
      child: Scaffold(

        body: FutureBuilder(
          builder: (ctx, snapshot) {
            // Checking if future is resolved or not
            if (snapshot.connectionState == ConnectionState.done) {
              // If we got an error
              if (snapshot.hasError) {
                return Center(
                  child: Text(
                    '${snapshot.error} occurred',
                    style: TextStyle(fontSize: 18),
                  ),
                );

                // if we got our data
              } else if (snapshot.hasData) {
                // Extracting data from snapshot object
                final data = snapshot.data as String;
                return Center(
                  child: Text(
                    '$data',
                    style: TextStyle(fontSize: 18),
                  ),
                );
              }
            }

            // Displaying LoadingSpinner to indicate waiting state
            return Center(
              child: CircularProgressIndicator(),
            );
          },

          // Future that needs to be resolved
          // inorder to display something on the Canvas
          future: fetchDocList(),
        ),
      ),
    );
  }


}


