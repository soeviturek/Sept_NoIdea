import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/common/utils/utils.dart';
import 'package:flutter_ducafecat_news/common/values/values.dart';
import 'package:flutter_ducafecat_news/common/widgets/widgets.dart';
import 'package:flutter_screenutil/screenutil.dart';

import '../home.dart';

class SignInPage extends StatefulWidget {
  SignInPage({Key key}) : super(key: key);

  @override
  _SignInPageState createState() => _SignInPageState();
}

class _SignInPageState extends State<SignInPage> {
  //email controller
  final TextEditingController _emailController = TextEditingController();
  //password Controller
  final TextEditingController _passController = TextEditingController();

  // logo
  Widget _buildLogo() {
    return Container(
      width: duSetWidth(110),
      margin: EdgeInsets.only(top: duSetHeight(40 + 44.0)), // 顶部系统栏 44px
      child: Column(
        crossAxisAlignment: CrossAxisAlignment.stretch,
        children: [
          Container(
            height: duSetWidth(76),
            width: duSetWidth(76),
            margin: EdgeInsets.symmetric(horizontal: duSetWidth(15)),
            child: Stack(
              alignment: Alignment.center,
              children: [
                Positioned(
                  left: 0,
                  top: 0,
                  right: 0,
                  child: Container(
                    height: duSetWidth(76),
                    decoration: BoxDecoration(
                      color: AppColors.primaryBackground,
                      boxShadow: [
                        Shadows.primaryShadow,
                      ],
                      borderRadius: BorderRadius.all(
                          Radius.circular(duSetWidth(76 * 0.5))), // 50% of parent container
                    ),
                    child: Container(),
                  ),
                ),
                Positioned(
                  top: duSetWidth(13),
                  child: Image.asset(
                    "assets/images/ic_launcher.png",
                    fit: BoxFit.none,
                  ),
                ),
              ],
            ),
          ),
          Container(
            margin: EdgeInsets.only(top: duSetHeight(15)),
            child: Text(
              "hospital",
              textAlign: TextAlign.center,
              style: TextStyle(
                color: AppColors.primaryText,
                fontFamily: "Montserrat",
                fontWeight: FontWeight.w600,
                fontSize: duSetFontSize(24),
                height: 1,
              ),
            ),
          ),
        ],
      ),
    );
  }

  // Login form
  Widget _buildInputForm() {
    return Container(
      width: duSetWidth(295),
      // height: 204,
      margin: EdgeInsets.only(top: duSetHeight(49)),
      child: Column(
        children: [
          // email input
          inputTextEdit(
            controller: _emailController,
            keyboardType: TextInputType.emailAddress,
            hintText: "username",
            marginTop: 0,
          ),
          // password input
          inputTextEdit(
            controller: _passController,
            keyboardType: TextInputType.visiblePassword,
            hintText: "Password",
            isPassword: true,
          ),

          // Register, login Landscape layout
          Container(
            height: duSetHeight(44),
            margin: EdgeInsets.only(top: duSetHeight(15)),
            child: Row(
              children: [
                // enroll
                btnFlatButtonWidget(
                  onPressed: () {
                    Navigator.pushNamed(
                      context,
                      "/sign-up",
                    );
                  },
                  gbColor: AppColors.thirdElement,
                  title: "Sign up",
                ),
                Spacer(),
                // 登录
                btnFlatButtonWidget(
                  onPressed: () async {
                    // if (!duIsEmail(_emailController.value.text)) {
                    //   toastInfo(msg: 'Please Enter The Email Correctly');
                    //   return;
                    // }
                    if (!duCheckStringLength(_passController.value.text, 6)) {
                      toastInfo(msg: 'The Password Cannot Be Less Than 6 Digits');
                      return;
                    }
                    var list = List<dynamic>.filled(2,0);
                    list = await checkPassword(_emailController.value.text,
                        _passController.value.text);
                    print( list[1].toString());
                    if ( list[1]== null) {
                      // if (list[0]) {
                        toastInfo(msg: "email or Password is incorrect!!");
                        return;
                      // }
                    }
                    Navigator.push(
                      context,
                      MaterialPageRoute(
                        builder: (context) => HomePage(a: list[1]),
                      )
                      // "/home",
                    );
                  },
                  gbColor: AppColors.primaryElement,
                  title: "Sign in",
                ),
              ],
            ),
          ),
          // Spacer(),

          // Fogot password
          Container(
            height: duSetHeight(22),
            margin: EdgeInsets.only(top: duSetHeight(20)),
            child: ElevatedButton(
              onPressed: () => {},
              child: Text(
                "Fogot password?",
                textAlign: TextAlign.center,
                style: TextStyle(
                  color: AppColors.secondaryElementText,
                  fontFamily: "Avenir",
                  fontWeight: FontWeight.w400,
                  fontSize: duSetFontSize(16),
                  height: 1, // 设置下行高，否则字体下沉
                ),
              ),
            ),
          ),
        ],
      ),
    );
  }
 
  // Register button
  Widget _buildSignupButton() {
    return Container(
      margin: EdgeInsets.only(bottom: duSetHeight(20)),
      child: btnFlatButtonWidget(
        onPressed: () {},
        width: 294,
        gbColor: AppColors.secondaryElement,
        fontColor: AppColors.primaryText,
        title: "Sign up",
        fontWeight: FontWeight.w500,
        fontSize: 16,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
     // Height minus top, bottom navigation
    ScreenUtil.init(context,
        width: 375, height: 812 - 44 - 34, allowFontScaling: true);

    return Scaffold(
      resizeToAvoidBottomInset: false,
      body: Center(
        child: Column(
          children: <Widget>[
            _buildLogo(),
            _buildInputForm(),
          ], 
        ),
      ),
    );
  }
}
