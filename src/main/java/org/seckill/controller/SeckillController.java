package org.seckill.controller;

import org.seckill.dto.Exposer;
import org.seckill.dto.SeckillExecution;
import org.seckill.dto.SeckillResult;
import org.seckill.entity.Seckill;
import org.seckill.enums.SeckillStateEnum;
import org.seckill.exception.RepeatKillException;
import org.seckill.exception.SeckillCloseException;
import org.seckill.service.SeckillService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

//url:/模块/资源/{id}/细分
@Controller
@RequestMapping(value="/seckill")
public class SeckillController {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private SeckillService service;

    @RequestMapping(value="/list" ,method = RequestMethod.GET)
    public String list(Model model){
        //获取列表页
        List<Seckill> list = service.getSeckillList();
        model.addAttribute("list",list);
        return "list";
    }

    @RequestMapping(value = "/{seckId}/detail",method = RequestMethod.GET)
    public String detail(@PathVariable("seckId") Long seckId, Model model){
        if(seckId==null){
            return "redirect:/seckill/list";
        }
        Seckill seckill = service.getById(seckId);
        if(seckill==null){
            return "forward:/seckill/list";
        }
        model.addAttribute("seckill",seckill);
        return "detail";
    }

    //ajax/json
    @RequestMapping(value = "/{seckId}/exposer",
            method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<Exposer> exposer(@PathVariable("seckId")Long seckId){
        SeckillResult<Exposer> result;
        try {
            Exposer exposer = service.exportSeckillUrl(seckId);
            result = new SeckillResult<Exposer>(true,exposer);
        }catch (Exception e){
            logger.error(e.getMessage(),e);
            result = new SeckillResult<Exposer>(false,e.getMessage());
        }
        return result;
    }

    @RequestMapping(value = "/{seckId}/{md5}/execution",
                    method = RequestMethod.POST,
            produces = {"application/json;charset=UTF-8"})
    @ResponseBody
    public SeckillResult<SeckillExecution> execute(@PathVariable("seckId")Long seckId,
                                                   @PathVariable("md5")String md5,
                                                    @CookieValue(value="phone",required = false)Long phone){
        if(phone==null){
            return new SeckillResult<SeckillExecution>(false,"未注册");
        }
        SeckillResult<SeckillExecution> result;
        try{
            SeckillExecution execution = service.executeSeckill(seckId,phone,md5);
            return new SeckillResult<SeckillExecution>(true,execution);
        }catch(RepeatKillException e){
            SeckillExecution execution = new SeckillExecution(seckId,SeckillStateEnum.REPEAT_KILL);
            return new SeckillResult<SeckillExecution>(false,execution);
        }catch (SeckillCloseException e){
            SeckillExecution execution = new SeckillExecution(seckId,SeckillStateEnum.END);
            return new SeckillResult<SeckillExecution>(false,execution);
        }catch (Exception e){
            SeckillExecution execution = new SeckillExecution(seckId,SeckillStateEnum.INNER_ERROR);
            return new SeckillResult<SeckillExecution>(false,execution);
        }

    }

    @RequestMapping(value = "/time/now",method = RequestMethod.GET)
    public SeckillResult<Long> time(){
        Date now = new Date();
        return new SeckillResult<Long>(true,now.getTime());
    }
}
