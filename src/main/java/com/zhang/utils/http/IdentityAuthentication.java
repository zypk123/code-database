package com.zhang.utils.http;

import com.zhang.utils.string.StringUtil;
import org.apache.http.HttpResponse;
import org.apache.http.util.EntityUtils;

import java.util.HashMap;
import java.util.Map;

/**
 * 实名认证接口
 *
 * @author zhangyu
 * @create 2018-05-24 11:23
 **/
public class IdentityAuthentication {

    /**
     * 阿里云 手机号（三网）实名认证查询接口 苏州云亿互通信息服务有限公司
     */
    private final static String IDENTITY_AUTHENTICATION_HOST = "https://phonecheck.market.alicloudapi.com";
    private final static String IDENTITY_AUTHENTICATION_PATH = "/phoneAuthentication";
    private final static String IDENTITY_AUTHENTICATION_METHOD = "POST";
    private final static String IDENTITY_AUTHENTICATION_APPCODE = "e04195b9e1e94cb4988b03013a446081";

    /**
     * 实名认证
     *
     * @param idNo    身份证号码
     * @param name    姓名
     * @param phoneNo 手机号
     */
    public static String identityAuthentication(String idNo, String name, String phoneNo) throws Exception {
        if (StringUtil.isNullOrEmpty(idNo) || StringUtil.isNullOrEmpty(name) || StringUtil.isNullOrEmpty(phoneNo)) {
            throw new RuntimeException("实名认证: 方法参数不能为空");
        }
        // 请求头
        Map<String, String> headers = new HashMap<>(16);
        // 最后在header中的格式(中间是英文空格)为Authorization:APPCODE 83359fd73fe94948385f570e3c139105
        headers.put("Authorization", "APPCODE " + IDENTITY_AUTHENTICATION_APPCODE);
        // 根据API的要求，定义相对应的Content-Type
        headers.put("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        // 查询体
        Map<String, String> querys = new HashMap<>(16);

        // 查询参数
        Map<String, String> bodys = new HashMap<>(16);
        bodys.put("idNo", idNo);
        bodys.put("name", name);
        bodys.put("phoneNo", phoneNo);

        // 调用HttpClient接口
        HttpResponse response = HttpUtil.doPost(IDENTITY_AUTHENTICATION_HOST, IDENTITY_AUTHENTICATION_PATH, IDENTITY_AUTHENTICATION_METHOD, headers, querys, bodys);
        if (response.getStatusLine().getStatusCode() != 200) {
            return null;
        }
        // 获取返回实体
        String httpEntity = EntityUtils.toString(response.getEntity());
        return httpEntity;
    }

    public static void main(String[] args) throws Exception {
        String httpEntity = identityAuthentication("34242719931027131X", "张宇", "18326893198");
        System.out.println(httpEntity);
    }

}
