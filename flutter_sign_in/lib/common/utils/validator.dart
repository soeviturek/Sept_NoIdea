import 'dart:convert';

import 'package:http/http.dart';

import 'Album.dart';

/// 检查邮箱格式
bool duIsEmail(String input) {
  if (input == null || input.isEmpty) return false;
  // 邮箱正则
  String regexEmail = "^\\w+([-+.]\\w+)*@\\w+([-.]\\w+)*\\.\\w+([-.]\\w+)*\$";
  return RegExp(regexEmail).hasMatch(input);
}

/// 检查字符长度
bool duCheckStringLength(String input, int length) {
  if (input == null || input.isEmpty) return false;
  return input.length >= length;
}


/// Check if the password Matches or not
Future<List<dynamic>> checkPassword(String email, String passwordInput) async {

  Album pass = await fetchPassword(email, passwordInput);
  print("paSSSS");
  print(pass);

  var list = List<dynamic>.filled(2,0);
  print(pass == null);
  if( pass == null){
    pass = null;
    list[1] = null;
  }
  else{
    list[1] =pass;
  }
  print(pass);
  list[0] = false;

  return list;
}

Future<bool> checkUsernameExist(String uname) async {
  final String url =
      "https://noidea.ngrok.io/api/users/check_uname/" + uname;
  Response res = await get(Uri.parse(url));
  return true;
}