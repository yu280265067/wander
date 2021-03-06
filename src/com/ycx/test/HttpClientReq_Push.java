package com.ycx.test;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import antlr.collections.List;

public class HttpClientReq_Push {
	public static void main2(String[] args) {
		
	}
	public static void main(String[] args) {
		 // 创建默认的httpClient实例.    
        CloseableHttpClient httpclient = HttpClients.createDefault();  
        // 创建httppost    
       HttpPost httppost = new HttpPost("http://localhost:8080/pay/member/withdrawAuthIden/realnameAuthAndBank");  
       // HttpPost httppost = new HttpPost("http://10.1.22.94:8080/pay/member/withdrawAuthIden/bindBank");  
       // HttpPost httppost = new HttpPost("http://localhost:8080/member/withdrawAuthImg/multipleAuth");  
       // HttpPost httppost = new HttpPost("http://10.1.22.94:8080/withdrawAuthImg/upload");  
        // 创建参数队列    
        ArrayList formparams = new ArrayList<BasicNameValuePair>();  
        ArrayList formparams2 = new ArrayList<BasicNameValuePair>(); 
        formparams.add(new BasicNameValuePair("request_no", "v" + System.currentTimeMillis()));  
        //formparams.add(new BasicNameValuePair("identity_no", "100000016814"));  // 李福泽
        //formparams.add(new BasicNameValuePair("identity_no", "100038486104"));  
        formparams.add(new BasicNameValuePair("memberId", "100224470195"));  
        //formparams.add(new BasicNameValuePair("telephone", "15142300652"));  
        //formparams.add(new BasicNameValuePair("identity_type", "MEMBER_ID"));  //必须是MEMBER_ID   MemberConvert.java
        formparams.add(new BasicNameValuePair("realName", "于呈翔"));  //name必传 实名认证时会验证是否存在提现记录
       // formparams.add(new BasicNameValuePair("auth_type", "CERT"));  //必须为CERT  DefaultCertificationFacade 79
        formparams.add(new BasicNameValuePair("certType", "IC"));      // 身份证 军官证 
        formparams.add(new BasicNameValuePair("certNum", "210202199210173211"));
      //  formparams.add(new BasicNameValuePair("is_async", "true"));
      //  formparams.add(new BasicNameValuePair("partner_id", "100000016031"));
      //  formparams.add(new BasicNameValuePair("service", "AuthIden"));
        formparams.add(new BasicNameValuePair("bankCode", "ICBC"));  
        formparams.add(new BasicNameValuePair("bankName", "中国工商银行"));  
        formparams.add(new BasicNameValuePair("cardNum", "6222023400021366967"));  
     
        // 单独绑卡
        
       /* formparams.add(new BasicNameValuePair("request_no", "v" + System.currentTimeMillis()));  
        formparams.add(new BasicNameValuePair("memberId", "100038486104"));  
        formparams.add(new BasicNameValuePair("identity_type", "MEMBER_ID"));  //必须是MEMBER_ID   MemberConvert.java
        formparams.add(new BasicNameValuePair("bankCode", "CITIC"));  
        formparams.add(new BasicNameValuePair("bankName", "中信银行"));  
        formparams.add(new BasicNameValuePair("bankNum", "6217730701372185"));  
        formparams.add(new BasicNameValuePair("realName", "满志远"));  
       // formparams.add(new BasicNameValuePair("auth_type", "CERT"));  //必须为CERT
        formparams.add(new BasicNameValuePair("is_async", "true"));
        formparams.add(new BasicNameValuePair("certType", "IC"));
        formparams.add(new BasicNameValuePair("partner_id", "100000016031"));
        formparams.add(new BasicNameValuePair("service", "AuthIden"));*/
        UrlEncodedFormEntity uefEntity;  
        formparams2 = getMuliCert(formparams2);
      //  System.out.println(formparams2.toString());
        try {  
            uefEntity = new UrlEncodedFormEntity(formparams, "UTF-8");  
            httppost.setEntity(uefEntity);  
            System.out.println("executing request " + httppost.getURI());  
            CloseableHttpResponse response = httpclient.execute(httppost);  
            try {  
                HttpEntity entity = response.getEntity();  
                if (entity != null) {  
                    System.out.println("--------------------------------------");  
                    System.out.println("Response content: " + EntityUtils.toString(entity, "UTF-8"));  
                    System.out.println("--------------------------------------");  
                }  
            } finally {  
                response.close();  
            }  
        } catch (ClientProtocolException e) {  
            e.printStackTrace();  
        } catch (UnsupportedEncodingException e1) {  
            e1.printStackTrace();  
        } catch (IOException e) {  
            e.printStackTrace();  
        } finally {  
            // 关闭连接,释放资源    
            try {  
                httpclient.close();  
            } catch (IOException e) {  
                e.printStackTrace();  
            }  
        }  
       
    }  
	public static ArrayList<BasicNameValuePair> getMuliCert(ArrayList<BasicNameValuePair> formparams){
		 
	        //formparams.add(new BasicNameValuePair("identity_no", "100000016814"));  // 李福泽
	        //formparams.add(new BasicNameValuePair("identity_no", "100038486104"));  
	        formparams.add(new BasicNameValuePair("memberId", "100059106088"));  
	        //formparams.add(new BasicNameValuePair("identity_type", "MEMBER_ID"));  //必须是MEMBER_ID   MemberConvert.java
//	        formparams.add(new BasicNameValuePair("realName", "满志远"));  //name必传 实名认证时会验证是否存在提现记录
//	        formparams.add(new BasicNameValuePair("auth_type", "CERT"));  //必须为CERT  DefaultCertificationFacade 79
//	        formparams.add(new BasicNameValuePair("certType", "IC"));      // 身份证 军官证 
//	        formparams.add(new BasicNameValuePair("certNo", "131126198811040037"));
//	        formparams.add(new BasicNameValuePair("is_async", "true"));
//	        formparams.add(new BasicNameValuePair("partner_id", "100000016031"));
//	        formparams.add(new BasicNameValuePair("service", "AuthIden"));
	        formparams.add(new BasicNameValuePair("certType", "IC"));      // 身份证 军官证 
	        formparams.add(new BasicNameValuePair("img1", Base64Test.strImg));
	        formparams.add(new BasicNameValuePair("img2", Base64Test.strImg));
	        formparams.add(new BasicNameValuePair("img3", Base64Test.strImg));
	        return formparams;
	}
	
	public static ArrayList<BasicNameValuePair> getMuliCertPre(ArrayList<BasicNameValuePair> formparams){
		 
        //formparams.add(new BasicNameValuePair("identity_no", "100000016814"));  // 李福泽
        //formparams.add(new BasicNameValuePair("identity_no", "100038486104"));  
        formparams.add(new BasicNameValuePair("memberId", "100038486104"));  
        //formparams.add(new BasicNameValuePair("identity_type", "MEMBER_ID"));  //必须是MEMBER_ID   MemberConvert.java
        formparams.add(new BasicNameValuePair("realName", "满志远"));  //name必传 实名认证时会验证是否存在提现记录
        formparams.add(new BasicNameValuePair("auth_type", "CERT"));  //必须为CERT  DefaultCertificationFacade 79
        formparams.add(new BasicNameValuePair("certType", "PP"));      // 身份证 军官证 
        formparams.add(new BasicNameValuePair("certNo", "131126198811040037"));
        formparams.add(new BasicNameValuePair("is_async", "true"));
        formparams.add(new BasicNameValuePair("partner_id", "100000016031"));
        formparams.add(new BasicNameValuePair("service", "AuthIden"));
//        formparams.add(new BasicNameValuePair("img1", Base64Test.strImg));
//        formparams.add(new BasicNameValuePair("img2", Base64Test.strImg));
//        formparams.add(new BasicNameValuePair("img3", Base64Test.strImg));
        formparams.add(new BasicNameValuePair("bankCode", "ICBC"));  
      formparams.add(new BasicNameValuePair("bankName", "中国工商银行"));  
      formparams.add(new BasicNameValuePair("bankNum", "6225758319371133"));  
        return formparams;
}
	
	/*formparams.add(new BasicNameValuePair("request_no", "v" + System.currentTimeMillis()));  
    formparams.add(new BasicNameValuePair("identity_no", "100000016814"));  
   // formparams.add(new BasicNameValuePair("memberId", "100000016814"));  
    formparams.add(new BasicNameValuePair("identity_type", "MEMBER_ID"));  //必须是MEMBER_ID   MemberConvert.java
//    formparams.add(new BasicNameValuePair("bank_code", "ICBC"));  
//    formparams.add(new BasicNameValuePair("bank_name", "中国工商银行"));  
//    formparams.add(new BasicNameValuePair("bank_branch", "admin"));  
//    formparams.add(new BasicNameValuePair("bank_account_no", "6225758319371133"));  
//    formparams.add(new BasicNameValuePair("name", "李福泽"));  
//    formparams.add(new BasicNameValuePair("province", "测试"));
//    formparams.add(new BasicNameValuePair("city", "城市"));
  //  formparams.add(new BasicNameValuePair("card_attribute", "0"));
    formparams.add(new BasicNameValuePair("auth_type", "CERT"));  //必须为CERT
  //  formparams.add(new BasicNameValuePair("auth_imgs", "123456"));
    formparams.add(new BasicNameValuePair("cert_type", "IC"));
   // formparams.add(new BasicNameValuePair("notify_url", "123456"));
    formparams.add(new BasicNameValuePair("cert_no", "412345678901234501"));
    formparams.add(new BasicNameValuePair("is_async", "true"));
  //  formparams.add(new BasicNameValuePair("authVoucherNo", "v" + System.currentTimeMillis()));
    formparams.add(new BasicNameValuePair("partner_id", "100000016031"));
    formparams.add(new BasicNameValuePair("service", "AuthIden"));*/
  	
	
}
