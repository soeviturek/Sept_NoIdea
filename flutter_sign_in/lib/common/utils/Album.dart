import 'dart:convert';


import 'package:http/http.dart';

class Album {
  final String access_token;
  final String refresh_token;

  const Album({
    this.access_token,
    this.refresh_token
  });

  factory Album.fromJson(Map<String, dynamic> json) {
    return Album(
      access_token: json['access_token'],
      refresh_token: json['refresh_token']
    );
  }
}

class Doc {
  final String uname;
  final int uid;
  final String email;
  final String mobile;
  const Doc({
    this.uname,
    this.uid,
    this.email,
    this.mobile
  });

  factory Doc.fromJson(Map<String ,dynamic> json){
    return Doc(
        uname: json['username'],
        uid: json['userid'],
        email: json['email'],
        mobile: json['mobile']
    );
  }
}

Future<Album> fetchPassword(String email, String password) async {

  Map data = new Map<String, dynamic>();
  data['username'] = email;
  data['password'] = password;
  Response res = await post(Uri.parse('https://noidea.ngrok.io/login'), body: data);

  if (res.statusCode == 200) {
    // If the server did return a 200 OK response,
    // then parse the JSON.
    // print(res.statusCode);
    print(res.body);
    // print("200 ka code hai");
    // Album tokens = new Album();
    // tokens.
    return Album.fromJson(jsonDecode(res.body));
  } else {
    // If the server did not return a 200 OK response,
    // then throw an exception.

    print(res.statusCode);
    return null;
  }
}

Future<Response> createUser(String uname, String email, String password, String mobile) async{
  return post(
    Uri.parse('https://noidea.ngrok.io/api/users/create'),
    headers: <String, String>{
      'Content-Type': 'application/json; charset=UTF-8',
    },
    body: jsonEncode(<String, String>{
      'mobile': mobile,
      "email": email,
      "password":password,
      'DF':'0',
      'username':uname,
      'userType': '0'
    }),
  );
}

Future<String> makeAppointment(String date, String doctor){

  return null;
}


Future<List<Doc>> fetchDocList() async {

  Response res = await get(Uri.parse('https://noidea.ngrok.io/api/book/get_doc'));

  if (res.statusCode == 200) {
    // If the server did return a 200 OK response,
    // then parse the JSON.
    print(res.statusCode);
    print(res.body);
    List<String> docrawlis = res.body.replaceAllMapped("[", (match) => "").replaceAllMapped("]", (match) => "").split("},");
    print(docrawlis);
    Doc dc = new Doc();
    List<Doc> doclis = List<Doc>.filled(docrawlis.length,dc);
    int last;
    for(int x= 0;x<docrawlis.length-1;x++){
      doclis[x] = Doc.fromJson(jsonDecode(docrawlis[x]+'}'));
      print(doclis[x]);
      last =x;
    }
    doclis[last+1] = Doc.fromJson(jsonDecode(docrawlis[last+1]));
    print(doclis[0].uname);
    return doclis;
  } else {
    // If the server did not return a 200 OK response,
    // then throw an exception.
    print(res.statusCode);
    throw Exception('Failed to fetch doc list');
  }
}


