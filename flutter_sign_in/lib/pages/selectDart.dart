import 'package:flutter/cupertino.dart';
import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/common/utils/Album.dart';
import 'package:intl/intl.dart';

//
// class selectDart extends StatelessWidget {
//   const selectDart({Key key,  this.title}) : super(key: key);
//
//   final String title;
//
//   @override
//   Widget build(BuildContext context) {
//     // TODO: implement build
//     throw UnimplementedError();
//   }

  // @override
  // State<selectDart> createState() => FutureDemoPage();
// }



class FutureDemoPage extends StatelessWidget {
  // const FutureDemoPage({Key key,  this.title}) : super(key: key);
  // final String title;
  /// Function that will return a
  /// "string" after some time
  /// To demonstrate network call
  /// delay of [2 seconds] is used
  ///
  /// This function will behave as an
  /// asynchronous function

  Doc doc_selected;

  // const FutureDemoPage({Key key, this.doc_selected}) : super(key: key);
  @override
  Widget build(BuildContext context) {
    return SafeArea(
      child: Scaffold(
        appBar: AppBar(
          title: Text('Select Doctor'),
        ),
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
                final List<Doc> data = snapshot.data;
                return DropdownButton(
                        hint: Text("Select Doctor"),
                          isExpanded: true,
                          items: data.map<DropdownMenuItem<Doc>>((cityOne){
                          return DropdownMenuItem(
                          child: Text(cityOne.uname),
                          value: cityOne,
                          );
                          }).toList(),
                          onChanged: (child){
                          print("Selected Doctor is $child");
                          doc_selected = child;
                          }
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
        floatingActionButton: ElevatedButton(
          onPressed: () {

            var doc;
            print(doc_selected.uname);
            Navigator.pushNamed(
                context,
                "/booking",
              arguments: {
                  doc:doc_selected.uname
              }

            );
          },
          child: const Text('confirm'),
        ),
      ),

    );
  }
}