//�����Ҫ�����߼�Js����
//javascriptģ�黯
var seckill={
    //��װ��ɱ���ajax�ĵ�ַ
    URL:{},
    //��֤�ֻ���
    validatePhone: function (phone) {
        if (phone && phone.length==11 && !isNaN(phone)){
            return true;
        }else{
            return false;
        }
    },
    //����ҳ��ɱ�߼�
    detail:{
        //����ҳ��ʼ��
        init:function (params) {
            //�ֻ���֤�͵�¼����ʱ����
            //��cookie�в����ֻ���
            var killPhone = $.cookie('killPhone');
            var startTime = params['startTime'];
            var endTime = params['endTime'];
            var seckId = params['seckId'];
            //��֤�ֻ���
            if(!seckill.validatePhone(killPhone)){
                //��phone

            }
        }
    }
}