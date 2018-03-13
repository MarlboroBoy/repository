(function () {
  /*占屏广告*/
  var uid = getUIDByJWT();
  var $advertisementModal = $("#advertisementModal");
  //checkCookie("advertisement");
  function setCookie(c_name, value, expiredays) {
    var curDate = new Date();
    var curTamp = curDate.getTime();
    var curWeeHours = new Date(curDate.toLocaleDateString()).getTime() - 1;
    var passedTamp = curTamp - curWeeHours;
    var leftTamp = 24 * 60 * 60 * 1000 - passedTamp;
    var leftTime = new Date();
    leftTime.setTime(leftTamp + curTamp);
    document.cookie = c_name + "=" + escape(value) +
      ((expiredays == null) ? "" : ";expires=" + leftTime.toUTCString());
  }

  function getCookie(c_name) {
    if (document.cookie.length > 0) {
      var c_start = document.cookie.indexOf(c_name + "=");
      if (c_start != -1) {
        c_start = c_start + c_name.length + 1;
        var c_end = document.cookie.indexOf(";", c_start);
        if (c_end == -1) c_end = document.cookie.length;
        return unescape(document.cookie.substring(c_start, c_end))
      }
    }
    return ""
  }


  
  function slide() {
    var autoLb = true;          //autoLb=true为开启自动轮播
    var autoLbtime = 2;         //autoLbtime为轮播间隔时间（单位秒）
    var touch = true;           //touch=true为开启触摸滑动
    var slideBt = true;         //slideBt=true为开启滚动按钮
    var slideNub;               //轮播图片数量
    //窗口大小改变时改变轮播图宽高
    $(window).resize(function () {
      $(".slide").height($(".slide").width() * 0.56);
    });
    $(function () {
      $(".slide").height($(".slide").width() * 0.56);
      slideNub = $(".slide .img").size();             //获取轮播图片数量
      for (i = 0; i < slideNub; i++) {
        $(".slide .img:eq(" + i + ")").attr("data-slide-imgId", i);
      }

      //根据轮播图片数量设定图片位置对应的class
      if (slideNub == 1) {
        for (i = 0; i < slideNub; i++) {
          $(".slide .img:eq(" + i + ")").addClass("img3");
        }
      }
      if (slideNub == 2) {
        for (i = 0; i < slideNub; i++) {
          $(".slide .img:eq(" + i + ")").addClass("img" + (i + 3));
        }
      }
      if (slideNub == 3) {
        for (i = 0; i < slideNub; i++) {
          $(".slide .img:eq(" + i + ")").addClass("img" + (i + 2));
        }
      }
      if (slideNub > 3 && slideNub < 6) {
        for (i = 0; i < slideNub; i++) {
          $(".slide .img:eq(" + i + ")").addClass("img" + (i + 1));
        }
      }
      if (slideNub >= 6) {
        for (i = 0; i < slideNub; i++) {
          if (i < 5) {
            $(".slide .img:eq(" + i + ")").addClass("img" + (i + 1));
          } else {
            $(".slide .img:eq(" + i + ")").addClass("img5");
          }
        }
      }


      //根据轮播图片数量设定轮播图按钮数量
      if (slideBt) {
        for (i = 1; i <= slideNub; i++) {
          $(".slide-bt").append("<span data-slide-bt='" + i + "' onclick='tz(" + i + ")'></span>");
        }
        $(".slide-bt").width(slideNub * 34);
        $(".slide-bt").css("margin-left", "-" + slideNub * 17 + "px");
      }


      //自动轮播
      if (autoLb) {
        setInterval(function () {
          right();
        }, autoLbtime * 1000);
      }


      if (touch) {
        k_touch();
      }
      slideLi();
      imgClickFy();
    })


    //右滑动
    function right() {
      var fy = new Array();
      for (i = 0; i < slideNub; i++) {
        fy[i] = $(".slide .img[data-slide-imgId=" + i + "]").attr("class");
      }
      for (i = 0; i < slideNub; i++) {
        if (i == 0) {
          $(".slide .img[data-slide-imgId=" + i + "]").attr("class", fy[slideNub - 1]);
        } else {
          $(".slide .img[data-slide-imgId=" + i + "]").attr("class", fy[i - 1]);
        }
      }
      imgClickFy();
      slideLi();
    }


    //左滑动
    function left() {
      var fy = new Array();
      for (i = 0; i < slideNub; i++) {
        fy[i] = $(".slide .img[data-slide-imgId=" + i + "]").attr("class");
      }
      for (i = 0; i < slideNub; i++) {
        if (i == (slideNub - 1)) {
          $(".slide .img[data-slide-imgId=" + i + "]").attr("class", fy[0]);
        } else {
          $(".slide .img[data-slide-imgId=" + i + "]").attr("class", fy[i + 1]);
        }
      }
      imgClickFy();
      slideLi();
    }


    //轮播图片左右图片点击翻页
    function imgClickFy() {
      $(".slide .img").removeAttr("onclick");
      $(".slide .img2").attr("onclick", "left()");
      $(".slide .img4").attr("onclick", "right()");
    }


    //修改当前最中间图片对应按钮选中状态
    function slideLi() {
      var slideList = parseInt($(".slide .img3").attr("data-slide-imgId")) + 1;
      $(".slide-bt span").removeClass("on");
      $(".slide-bt span[data-slide-bt=" + slideList + "]").addClass("on");
    }


    //轮播按钮点击翻页
    function tz(id) {
      var tzcs = id - (parseInt($(".slide .img3").attr("data-slide-imgId")) + 1);
      if (tzcs > 0) {
        for (i = 0; i < tzcs; i++) {
          setTimeout(function () {
            right();
          }, 1);
        }
      }
      if (tzcs < 0) {
        tzcs = (-tzcs);
        for (i = 0; i < tzcs; i++) {
          setTimeout(function () {
            left();
          }, 1);
        }
      }
      slideLi();
    }


    //触摸滑动模块
    function k_touch() {
      var _start = 0, _end = 0, _content = document.getElementById("slide");
      _content.addEventListener("touchstart", touchStart, false);
      _content.addEventListener("touchmove", touchMove, false);
      _content.addEventListener("touchend", touchEnd, false);
      function touchStart(event) {
        var touch = event.targetTouches[0];
        _start = touch.pageX;
      }

      function touchMove(event) {
        var touch = event.targetTouches[0];
        _end = (_start - touch.pageX);
      }

      function touchEnd(event) {
        if (_end < -100) {
          left();
          _end = 0;
        } else if (_end > 100) {
          right();
          _end = 0;
        }
      }
    }


  /*0810*/
  //判断当前用户是否登录 未登录显示新手攻略  已登录在判断是否投资过
  }
  var uid = getUIDByJWT().unique_name;
  })();
function isLogin() {
  var value = "";
  var str = window.navigator.userAgent;
  //如果是移动设备
  if (str.indexOf("jojojr") != -1) {
    /*是安卓*/
    var search = window.location.search;
    // alert("search"+search)
    if (search.indexOf("?") != -1) {
      var msg = search.slice(1);
      if (msg.indexOf("&") != -1) {
        var msgArr = msg.split("&");
        for (var i = 0; i < msgArr.length; i++) {
          var item1 = msgArr[i].split("=");
          if (item1[0] == "token") {
            value = item1[1];
          }
        }
      }
      else {
        var item2 = msg.split("=");
        if (item2[0] == "token") {
          value = item2[1];
        }
      }
    }
    if (value == null
      || value == ""
      || value == undefined) {
      return false;
    }
    else {
      var aftervalue = value.split(".");
      return $.parseJSON($.base64.atob(aftervalue[1], true));
    }
  }
  else {
    value = localStorage.getItem("token");
    if (value == null) {
      return false;
    }
    else {
      var aftervalue = value.split(".");
      return $.parseJSON($.base64.atob(aftervalue[1], true));
    }
  }
}