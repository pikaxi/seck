//存放主要交互逻辑Js代码
//javascript模块化
var seckill={
    //封装秒杀相关ajax的地址
    URL:{},
    //验证手机号
    validatePhone: function (phone) {
        if (phone && phone.length==11 && !isNaN(phone)){
            return true;
        }else{
            return false;
        }
    },
    //详情页秒杀逻辑
    detail:{
        //详情页初始化
        init:function (params) {
            //手机验证和登录，计时交互
            //在cookie中查找手机号
            var killPhone = $.cookie('killPhone');
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckId = params['seckId'];
            //验证手机号
            if(!seckill.validatePhone(killPhone)){
                //绑定phone

            }
        }
    }
}