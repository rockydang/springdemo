!function(a){var b={},c="lb_login";MOGU.user_handsome_login_init=function(d){function e(a,d){var e={title:d,lightBoxId:c,contentHtml:a,scroll:!0};b=new MGLightBox(e),b.init()}function f(a){var b={};b.sinaurl="http://www.mogujie.com/oauth/login/sina/"+(1==MOGUPROFILE.is_subsite?"mogujia":"mogujie"),b.taobaourl="http://www.mogujie.com/oauth/login/taobao/"+(1==MOGUPROFILE.is_subsite?"mogujia":"mogujie"),b.qqurl="http://www.mogujie.com/oauth/login/qq/"+(1==MOGUPROFILE.is_subsite?"mogujia":"mogujie");var c=doT.template(a)(b);return c}var g=['<div class="login_box clearfix">','<p class="login_fail imgcheckclear">请输入密码！</p>','<div class="login_form">',"<dl>","<dd>用户名：</dd>",'<dt><input type="text" name="user_email" class="text"></dt>',"<dd>密　码：</dd>",'<dt class="u_passwd">','<input type="password" name="user_pass" class="text">','<a href="http://www.mogujie.com/usersecurity/findpwd">忘记密码？</a>',"</dt>","<dd>&nbsp;</dd>",'<dt class="rem"><input type="checkbox" name="remember" class="checkbox" checked="">两周内免登录</dt>',"<dd>&nbsp;</dd>","<dt>",'<input type="button" value="" class="login_btn">','<a href="http://www.mogujie.com/register/" class="register_btn"></a>',"</dt>","</dl>","</div>",'<div class="reg_or_weibo">','<div class="register_box">',"其他登陆方式",'<a href="{{=it.qqurl}}" class="login_a" ></a>',"</div>",'<div class="l_o">','<a href="{{=it.sinaurl}}">用微博帐号登录</a>',"</div>","</div>","</div>"].join("");!function(){var b=MOGUPROFILE.showqq;if("undefined"!=typeof b&&"is_qzone"==b)return!1;a(".light_box").remove();var c=1==MOGUPROFILE.is_subsite?"登录蘑菇家":"登录蘑菇街";d=d||c;var h=f(g);e(h,d),a("#lb_login input[name=user_email]").focus()}()},MOGU.user_handsome_login=function(d,e){function f(b,d){a("#"+c+" .login_fail").text(b).css("visibility","visible"),d&&d.focus()}function g(b){a("#"+c+" .login_fail").css("visibility","hidden"),b.removeClass("error")}function h(a,b){var c=a.val();g(a),""==MGTOOL.trim(c)&&(f(b,a),a.addClass("error"))}function i(b,d,e){var f=!1;return h(b,"请输入用户名！"),h(d,"请输入密码！"),e&&(f=j()),a("#"+c+" .error").length>0||f?!1:!0}function j(){if(a(".imgcheck_code_main").length>0){if(!MOGU.imgCodeCheck())return f("请旋转验证码图片到正确方向!"),!0}else{var b=a(".check_code"),c=b.val();if(""===c)return f("请输入验证码!",b),!0}return!1}function k(){if(a(".imgcheck_code_main").length>0){var b=[],c=0;return a("#lb_login input[name='check[]']").each(function(){b[c]=a(this).val(),c++}),b}var d=a(".check_code");return d.val()}function l(a,b,c,d){var e={user_email:a.val(),user_pass:b.val(),remember:c};return d&&(e.check=k()),e}function m(c,d,g){var h=0==a(".imgcheck_code_main").length?!1:!0,j=i(c,d,h);if(0==j)return!1;var k=l(c,d,g,h);jQuery.post("/user/zlogin",k,function(c){if(null==c)alert(MGLANG.msgTimeout);else{var d=c.status.code,g=c.status.msg;if(1001==d)MOGUPROFILE.userid=c.result.data.userId,b.success_close("登录成功！",200),e.callback&&e.callback(c.result.data);else if(1126==d||1120==d){if(a(".imgcheck_code_main").length>0)MOGU.imgCaptchaRecaptcha();else{var h=a("#lb_login input[name='user_email']"),i=['<dd id="check_dd" class="check_title shouldremove">&nbsp;</dd>','<dt id="check_dt" class="clearfix shouldremove">',"</dt>"].join(""),j="#check_dt",k=a(".u_passwd");n.CHECK.GetImgCheck(i,j,h,k)}f(g)}else MOGU.imgCaptchaRecaptcha(),f(g)}},"json")}var n=this;n.CHECK={FixIe6Bug:function(){a.browser.msie&&"6.0"==a.browser.version&&document.execCommand("BackgroundImageCache",!1,!0)},HasCheckImg:function(a,b){if(h(a,"请输入用户名！"),a.val()==a.attr("data-lastname")&&a.addClass("error"),!a.hasClass("error")){var c=a.val();jQuery.post("/user/isloginneedvalid?group=zlogin",{username:c},function(a){b(a)},"json")}},GetImgCheck:function(b,c,d,e){a(c).length>0||jQuery.post("/pcaptcha/getview/zlogin",function(d){{var f=d.status.code;d.status.msg}if(1001==f){var g=d.result.captcha;a(c).length>0&&n.CHECK.RemoveImgCheck(),e.after(b),setTimeout(function(){a(c).html(g).css("opacity",0).animate({opacity:1},1e3),n.CHECK.BindCheckNum()},0)}},"json")},RemoveImgCheck:function(){a(".shouldremove").remove(),a(".imgcheckclear").css("visibility","hidden")},BindCheckNum:function(){a(".imgcheck_code_main").length>0?MOGU.imgCaptchaInit():MOGU.Globe_Checkcode_Change()}},function(){MOGU.Globe_Bind_Keybord_Submit("",a("#"+c+" .login_btn"),"not_need_focus"),n.CHECK.FixIe6Bug();var b=a("#lb_login input[name='user_email']"),d=a("#lb_login input[name='user_pass']"),e=a("#"+c+" :checkbox").prop("checked"),f=['<dd id="check_dd" class="check_title shouldremove">&nbsp;</dd>','<dt id="check_dt" class="clearfix shouldremove">',"</dt>"].join(""),g="#check_dt",h=a(".u_passwd");b.die().live("blur",function(){{var b=a(this);b.val()}n.CHECK.HasCheckImg(b,function(a){1001==a.status.code?n.CHECK.GetImgCheck(f,g,b,h):1002==a.status.code&&n.CHECK.RemoveImgCheck(),b.attr("data-lastname",b.val())})}),a("#"+c+" .login_btn").die().live("click",function(){m(b,d,e)})}()},MOGU.User_Other_login=function(){var b=a("#show_more_login");b.size()>0&&a(".more_login").hover(function(){a(this).addClass("more_login_active");var c=a(this).offset().top+25,d=a(this).offset().left-90;b.css({top:c,left:d}).show()},function(){var c=a(this),d=setTimeout(function(){b.hide()},1e3);b.hover(function(){clearTimeout(d)},function(){c.removeClass("more_login_active"),b.hide()})})},MOGU.User_Find_Password=function(){0!=a(".text").size()&&(a(".text").focus(function(){a(this).css("border-color","#aaaaaa")}),a(".text").blur(function(){a(this).css("border-color","#cfcfcf")}))},MOGU.Globe_Checkcode_Change=function(){0!=a("#checkcode_change").size()&&a("#checkcode_change").click(function(){a.ajax({url:"/users/recaptcha",type:"POST",timeout:6e4,data:"{}",dataType:"json",success:function(b){if(null==b)alert(MGLANG.msgTimeout);else{var c=b.status.code,d=b.status.msg;if(1001==c){var e=b.result.data.captchaId,f=b.result.data.captchaSrc;a("#img_checkcode").attr("src",f),a("#captcha-id").val(e)}else alert(d)}},error:function(a,b){"timeout"==b&&alert(MGLANG.msgTimeout)}})})},MOGU.User_Find_Password(),jQuery(document).ready(function(){MOGU.User_Other_login()})}(jQuery);