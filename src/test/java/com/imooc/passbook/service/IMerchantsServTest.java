package com.imooc.passbook.service;

import com.alibaba.fastjson.JSON;
import com.imooc.passbook.vo.CreateMerchantsRequest;
import com.imooc.passbook.vo.PassTemplate;
import com.imooc.passbook.vo.Response;
import org.apache.commons.lang.time.DateUtils;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Date;

/**
 * @Auther: wwh
 * @Date: 2019-12-04 22:55
 * @Description:
 */
@RunWith(SpringRunner.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.NONE)
public class IMerchantsServTest {
    @Autowired
    private IMerchantsServ merchantsServ;

    @Test
    public void testCreateMerchants(){
        CreateMerchantsRequest request = new CreateMerchantsRequest();
        request.setName("1231233212");
        request.setLogoUrl("1");
        request.setAddress("1");
        request.setPhone("1212");
        request.setBusinessLicenseUrl("1111");
        System.out.println(JSON.toJSONString(merchantsServ.createMerchants(request)));
    }

    @Test
    public void testBuildMerchants(){
        Integer id = 17;
        Response merchants = merchantsServ.buildMerchantsById(id);
        System.out.println(JSON.toJSONString(merchants));
    }
    @Test
    public void testDropPassTemplate(){
        PassTemplate passTemplate = new PassTemplate();
        passTemplate.setId(3);
        passTemplate.setTitle("晚餐券");
        passTemplate.setSummary("简介: SEU剧院cat");
        passTemplate.setDesc("详情：请点击查看");
        passTemplate.setLimit(10000L);
        passTemplate.setHasToken(false);
        passTemplate.setBackground(2);
        passTemplate.setStart(DateUtils.addDays(new Date(),-10));
        passTemplate.setEnd(DateUtils.addDays(new Date(),10));

        Response response = merchantsServ.dropPassTemplate(passTemplate);
        System.out.println(JSON.toJSONString(response));
    }


}