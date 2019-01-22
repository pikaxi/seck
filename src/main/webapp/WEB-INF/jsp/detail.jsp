<%--
  Created by IntelliJ IDEA.
  User: zcj
  Date: 2019/1/22
  Time: 16:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>秒杀详情页面</title>
    <%@include file="common/head.jsp" %>

</head>
<body>

    <div class="container">
        <div class="panel panel-default text-center">
            <div class="panel-heading"><h1>${seckill.name}</h1></div>
        </div>
        <div class="panel-body">
            <h2 class="pannel-body">
                <span class="text-danger">
                        <%--显示time图标--%>
                    <span class="glyphicon glyphicon-time"></span>
                    <%--展示倒計時--%>
                    <span class="glyphicon" id="seckill-box"></span>
                </span>
            </h2>
        </div>
    </div>
    <%--登录弹出层，输入电话--%>
    <div id="killPhoneModal" class="modal fade">
        <div class="modal-dialog">
            <div class="modal-content">
                <div class="modal-header">
                    <h3 class="modal-title text-center">
                        <span class="glyphicon glyphicon-phone">

                        </span>
                    </h3>
                </div>
                <div class="modal-body">
                    <div class="row">
                        <div class="col-xs-8 col-xs-offset-2">
                            <input type="text" name="killPhone" id="killPhoneKey"
                            placeholder="输入手机号^o^" class="form-control">
                        </div>
                    </div>
                </div>

                <div class="modal-footer">
                    <span id="killPhoneMessage" class="glyphicon"></span>
                    <button type="button" id="killPhoneBtn" class="btn btn-success">
                        <span class="glyphicon glyphicon-phone"></span>
                        SUBMIT
                    </button>
                </div>
            </div>
        </div>
    </div>
<!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
<script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
<!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
<script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>

<%--cdn获取jquery cookie插件和Countdown插件--%>
<script src="https://cdn.bootcss.com/jquery-cookie/1.4.1/jquery.cookie.min.js"/>
<script src="https://cdn.bootcss.com/jquery-countdown/2.1.0/jquery.countdown.min.js"/>
<%--开始编写交互逻辑--%>
<script src="/resources/script/seckill.js" type="text/javascript">
</script>
<script type="text/javascript">
    $(function () {
        //使用EL表达式传入参数
       seckill.detail.init({
           seckId:${seckill.seckId},
           startTime:${seckill.startTime.time},//毫秒时间
           endTime:${seckill.endTime.time}
       }) ;
    });
</script>
</body>
</html>
