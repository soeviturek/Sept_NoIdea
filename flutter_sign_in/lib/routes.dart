import 'package:flutter_ducafecat_news/pages/booking.dart';
import 'package:flutter_ducafecat_news/pages/booking_confirm.dart';
import 'package:flutter_ducafecat_news/pages/home.dart';
import 'package:flutter_ducafecat_news/pages/sign_in/sign_in.dart';
import 'package:flutter_ducafecat_news/pages/sign_up/sign_up.dart';

/// 静态路由
var staticRoutes = {
  "/sign-in": (context) => SignInPage(), // 登录
  "/sign-up": (context) => SignUpPage(), // 注册
  // "/home": (context) => HomePage(a: albumn), // 首页
  "/booking": (context) => BookingPage(), // 预定
  "/booking-confirm": (context) => BookingConfirmPage(), // 预定结果
};
