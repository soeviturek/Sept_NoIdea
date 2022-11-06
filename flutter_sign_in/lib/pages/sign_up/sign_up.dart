import 'package:flutter/material.dart';
import 'package:flutter_ducafecat_news/common/utils/utils.dart';
import 'package:flutter_ducafecat_news/common/values/values.dart';
import 'package:flutter_ducafecat_news/common/widgets/widgets.dart';

import '../../common/utils/Album.dart';

class SignUpPage extends StatefulWidget {
  SignUpPage({Key key}) : super(key: key);

  @override
  _SignUpPageState createState() => _SignUpPageState();
}

class _SignUpPageState extends State<SignUpPage> {
  // fullName email password controller
  final TextEditingController _fullnameController = TextEditingController();
  final TextEditingController _emailController = TextEditingController();
  final TextEditingController _passController = TextEditingController();
  final TextEditingController _mobileController  = TextEditingController();

  // logo
  Widget _buildLogo() {
    return Container(
      margin: EdgeInsets.only(top: duSetHeight(50)),
      child: Text(
        "Sign up",
        textAlign: TextAlign.center,
        style: TextStyle(
          color: AppColors.primaryText,
          fontFamily: "Montserrat",
          fontWeight: FontWeight.w600,
          fontSize: duSetFontSize(24),
          height: 1,
        ),
      ),
    );
  }

  // Registration form
  Widget _buildInputForm() {
    return Container(
      width: duSetWidth(295),
      // height: 204,
      margin: EdgeInsets.only(top: duSetHeight(49)),
      child: Column(
        children: [
          // fullName input
          inputTextEdit(
            controller: _fullnameController,
            keyboardType: TextInputType.text,
            hintText: "User-name",
            marginTop: 0,
          ),
          // email input
          inputTextEdit(
            controller: _emailController,
            keyboardType: TextInputType.emailAddress,
            hintText: "Email",
          ),
          //mobile
          inputTextEdit(
            controller: _mobileController,
            keyboardType: TextInputType.visiblePassword,
            hintText: "mobile",
            isPassword: true,
          ),
          // password input
          inputTextEdit(
            controller: _passController,
            keyboardType: TextInputType.visiblePassword,
            hintText: "Password",
            isPassword: true,
          ),


          // 创建
          Container(
            height: duSetHeight(44),
            margin: EdgeInsets.only(top: duSetHeight(15)),
            child: btnFlatButtonWidget(
              onPressed: () async {
                if (!duCheckStringLength(_fullnameController.value.text, 5)) {
                  toastInfo(msg: 'The UserName Cannot Be Less Than 5 Digits');
                  return;
                }
                if (!duIsEmail(_emailController.value.text)) {
                  toastInfo(msg: 'Please Enter The Email Correctly');
                  return;
                }
                if (!duCheckStringLength(_passController.value.text, 6)) {
                  toastInfo(msg: 'The Password Cannot Be Less Than 6 Digits');
                  return;
                }

                else{
                  await createUser(_fullnameController.value.text, _emailController.value.text, _passController.value.text, _mobileController.value.text);
                }
                Navigator.pop(context);
              },
              width: 295,
              fontWeight: FontWeight.w600,
              title: "Create an account",
            ),
          ),
          // Spacer(),

          // 忘记密码
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



  // 有账号
  Widget _buildHaveAccountButton() {
    return Container(
      margin: EdgeInsets.only(bottom: duSetHeight(20)),
      child: btnFlatButtonWidget(
        onPressed: () {
          Navigator.pop(context);
        },
        width: 294,
        gbColor: AppColors.secondaryElement,
        fontColor: AppColors.primaryText,
        title: "I have an account",
        fontWeight: FontWeight.w500,
        fontSize: 16,
      ),
    );
  }

  @override
  Widget build(BuildContext context) {
    return Scaffold(
      resizeToAvoidBottomInset: false,
      appBar: transparentAppBar(
        context: context,
        actions: <Widget>[
          IconButton(
            icon: Icon(
              Icons.info_outline,
              color: AppColors.primaryText,
            ),
            onPressed: () {
              toastInfo(msg: 'This is the registration interface');
            },
          )
        ],
      ),
      body: Center(
        child: Column(
          children: <Widget>[
            Divider(height: 1),
            _buildLogo(),
            _buildInputForm(),
            Spacer(),
            // _buildThirdPartyLogin(),
            _buildHaveAccountButton(),
          ],
        ),
      ),
    );
  }
}
