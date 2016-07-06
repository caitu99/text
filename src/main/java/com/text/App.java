package com.text;

import java.io.BufferedOutputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Base64;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

/**
 * Hello world!
 *
 */
public class App {
    public static void main( String[] args ) throws Exception{
//    	getToken();
//    	sendSms();
//    	login();
//    	loginThird();
//    	analysisImage();
//    	aa();
//    	loginAnonymous();
    	textPort();
//    	bb();
//    	cc();
//    	dd();
    	
//    	Map<String,Object> orderMap = new HashMap<String,Object>();
//    	if(null != orderMap){
//    		String orderNO = (String)orderMap.get("ORDER_ID");
//    	}
    	
//    	ThreadPoolExecutor t = new ThreadPoolExecutor(8,8,60L,TimeUnit.SECONDS,new LinkedBlockingQueue<Runnable>());
//    	
//    	t.execute(new Runnable() {
//			@Override
//			public void run() {
//				try {
//					Thread t = new Thread();
//					t.sleep(60000000000L);
//				} catch (InterruptedException e) {
//					e.printStackTrace();
//				}
//			}
//		});
    }

	private static void aa() throws Exception{
    	String jsonString = FileNIOCommon.readFileToString("D:\\JavaProject\\SpringToolSuite\\text\\src\\main\\java\\com\\text\\aaa.txt");
    	
    	JSONArray json = JSON.parseArray(JSON.parseObject(jsonString).getString("data"));
    	
    	double s = 0d;
    	
    	for(int i=0;i<json.size();i++){
    		JSONObject j = json.getJSONObject(i);
        	Integer integralBalance = j.getInteger("integralBalance");
        	double scale = j.getDouble("scale");
        	
        	if(integralBalance.equals(-1) || integralBalance==null){
        		continue;
        	}
        	
        	s += 0.01 * scale * integralBalance;
    	}
    	
    	System.out.println(s);
    	
    }
    
    private static void getToken() throws Exception{
    	String url = "http://gateway.caitu99.com/oauth/token";
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("client_id", "1");
    	paramMap.put("grant_type", "client_credentials");
    	paramMap.put("client_secret", "832103d85bad45c495c2a82e5d1928f9");
        String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);

    	System.out.println(jsonString);
    }
    
    private static void sendSms() throws Exception{
    	String url = "http://gateway.caitu99.com/gw/oauthentry/sms/1.0/send";
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("mobile", "15157146726");
    	paramMap.put("access_token", "14799e56b60438e39b8dfe9cf71f1f7d");
        String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);

    	System.out.println(jsonString);
    }
    
    private static void login() throws Exception{
    	String url = "http://gateway.caitu99.com/oauth/token";
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("client_id", "1");
    	paramMap.put("grant_type", "password");
    	paramMap.put("client_secret", "832103d85bad45c495c2a82e5d1928f9");
    	paramMap.put("mobile", "15157146726");
    	paramMap.put("vcode", "1234");
    	paramMap.put("type", "0");
        String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);

    	System.out.println(jsonString);
    }
    
    private static void loginAnonymous() throws Exception{
    	String url = "http://gateway.caitu99.com/oauth/token";
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("client_id", "1");
    	paramMap.put("grant_type", "client_credentials");
    	paramMap.put("client_secret", "832103d85bad45c495c2a82e5d1928f9");
        String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);

    	System.out.println(jsonString);
    }
    
    private static void loginThird() throws Exception{
    	String url = "http://gateway.caitu99.com/oauth/token";
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("grant_type", "password");
    	paramMap.put("client_id", "1");
    	paramMap.put("client_secret", "832103d85bad45c495c2a82e5d1928f9");
    	paramMap.put("uid", "15157146726");
    	paramMap.put("nickname", "1234");
    	paramMap.put("profileimg", "0");
    	paramMap.put("type", "5");
        String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);

    	System.out.println(jsonString);
    }
    
    private static void analysisImage() throws Exception{
    	String iamgeCode = "";
    	
    	iamgeCode = FileNIOCommon.readFileToString("D:\\JavaProject\\SpringToolSuite\\text\\src\\main\\java\\com\\text\\imageCode.txt");
    	
    	byte[] tbytes = Base64.getDecoder().decode(iamgeCode);
		FileOutputStream fs = new FileOutputStream("D://imgCode.jpg");
		fs.write(tbytes);
		fs.close();
    }
    
	private static void textPort() {
//    	String url = "http://gateway.caitu99.com/gw/oauthentry/user.realization.user/1.0/list";
//    	String url = "http://p.gateway.caitu99.com/gw/oauthentry/user.realization.user/1.0/list";
//    	String url = "http://192.168.25.158:8080/api/realization/user/list/1.0";
//    	String url = "http://192.168.25.158:8080/api/realization/platform/list/1.0";
//    	String url = "http://127.0.0.1:8080/api/integral/card/expire/5.0";
//		String url = "http://p.gateway.caitu99.com/gw/oauthentry/user.realization.user/1.0/list";
//    	String url = "http://p.gateway.caitu99.com/gw/oauthentry/integral.card/5.0/expire";
//    	String url = "http://gateway.caitu99.com/gw/oauthentry/user.realization.realize/1.0/list";
//    	String url = "http://127.0.0.1:8080/api/realization/realize/list/1.0";
//    	String url = "http://192.168.25.158:8080/api/phone/recharge//account/list/1.0";
//		String url = "http://127.0.0.1:8080/api/realization/realize/redirect/1.0";
//		String url = "http://gateway.caitu99.com/oauth/enterprise/login";
//		String url = "http://gateway.caitu99.com/oauth/token";
//		String url = "http://127.0.0.1:8080/api/merchant/manage/insert/1.0";
//		String url = "http://127.0.0.1:8080/api/merchant/manage/update/1.0";
		

//		String url = "http://gateway.caitu99.com/gw/oauthentry/merchant.manage/1.0/list";
//		String url = "http://gateway.caitu99.com/gw/oauthentry/merchant.manage/1.0/detail";
		String url = "http://p.gateway.caitu99.com/gw/oauthentry/merchant.manage/1.0/insert";
		
		
//		String url = "http://127.0.0.1:28080/oauth/business/login";
//		String url = "http://127.0.0.1:28080/oauth/token";
    	
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
//    	paramMap.put("access_token", "c213047a1b2030feacbe944d95150e55");
//    	paramMap.put("userid", "262");
//    	paramMap.put("userId", "336");
//    	paramMap.put("cardId", "771");
//    	paramMap.put("importType", "1");
//    	paramMap.put("platformId", "4");
//
//    	paramMap.put("realizeId", "8");
//    	paramMap.put("isAddUserTerm", "1");
//    	
//    	paramMap.put("account", "15157146000");
//    	paramMap.put("password", "888888");
    	
//    	paramMap.put("client_id", "1002");
//    	paramMap.put("grant_type", "password");
//    	paramMap.put("client_secret", "i1ca29dfd57a49axa519q95o84d9aed8");
//    	paramMap.put("username", "212121");
//    	paramMap.put("password", "123456");
//    	paramMap.put("type", "4");
//    	
    	
//    	paramMap.put("userid", "1110");
//    	paramMap.put("id", "3");
    	paramMap.put("type", "1");
    	paramMap.put("name", "测试账号");
    	paramMap.put("contacts", "1500000000");
    	paramMap.put("province", "浙江省");
    	paramMap.put("city", "杭州市");
    	paramMap.put("rate", "81");
    	paramMap.put("loginAccount", "abcd");
    	
    	paramMap.put("access_token", "e44f43002288367b8ad4c84fe542e096");
//    	paramMap.put("id", "3");
//    	paramMap.put("curPage", "1");
//    	paramMap.put("pageSize", "10");
    	
//    	paramMap.put("account", "212121");
//    	paramMap.put("password", "123456");
    	
        try {
			String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);
//			String jsonString = HttpClientUtils.getInstances().doSSLPost(url, charset, paramMap);
			System.out.println(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void bb() throws Exception{
    	String iamgeCode = "";
    	
    	iamgeCode = FileNIOCommon.readFileToString("D:\\JavaProject\\SpringToolSuite\\text\\src\\main\\java\\com\\text\\imageCode.txt");
    	
    	String url = "http://127.0.0.1:8080/api/user/photo/save/1.0";
//    	String url = "http://gateway.caitu99.com/gw/oauthentry/user.photo/1.0/save";
    	
    	String charset = "UTF-8";
    	Map<String,String> paramMap = new HashMap<String,String>();
    	paramMap.put("access_token", "5a8d57a0a1f63541b9e6d296b5281e46");
    	paramMap.put("userid", "336");
    	paramMap.put("imgstr", iamgeCode);
    	paramMap.put("imgStr", iamgeCode);
        try {
			String jsonString = HttpClientUtils.getInstances().doPost(url, charset, paramMap);
			System.out.println(jsonString);
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	public static void cc() {
		String str="http://static.caitu99.com/img/headimg/";
        String filePath="C:\\Users\\Lenovo\\Desktop\\lALOCST_Dc0EAM0EAA_1024_1024.png";
        String fileName="lALOCST_Dc0EAM0EAA_1024_1024.png";
        try {
        	URL url=new URL(str);
            HttpURLConnection connection=(HttpURLConnection)url.openConnection();
            connection.setDoInput(true);
            connection.setDoOutput(true);
            connection.setRequestMethod("POST");
            connection.addRequestProperty("FileName", fileName);
            connection.setRequestProperty("content-type", "text/html");
            BufferedOutputStream  out=new BufferedOutputStream(connection.getOutputStream());
            
            //读取文件上传到服务器
            File file=new File(filePath);
            FileInputStream fileInputStream=new FileInputStream(file);
            byte[]bytes = new byte[1024];
            int numReadByte = 0;
            while((numReadByte=fileInputStream.read(bytes,0,1024))>0){
                out.write(bytes, 0, numReadByte);
            }

            out.flush();
            fileInputStream.close();
            //读取URLConnection的响应
            DataInputStream in=new DataInputStream(connection.getInputStream());
        } catch (Exception e) {
            e.printStackTrace();
        }
	}
	
	public static void dd(){
		String url = "https://attend.dingtalk.com/attend/index.html?corpId=ding0a2bc2418f46d5f4&showmenu=false&dd_share=false&dd_nav_bgcolor=FF4B8DFA&dd_progress=false";
		Map<String,String> paramMap = new HashMap<String,String>();
		try {
			String reslut = HttpClientUtils.getInstances().doSSLPost(url, "utf-8",paramMap);
			System.out.println(reslut);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
