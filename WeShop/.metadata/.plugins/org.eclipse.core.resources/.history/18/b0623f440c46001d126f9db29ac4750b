package com.alipay.config;

import java.io.FileWriter;
import java.io.IOException;

/* *
 *类名：AlipayConfig
 *功能：基础配置类
 *详细：设置帐户有关信息及返回路径
 *修改日期：2017-04-05
 *说明：
 *以下代码只是为了方便商户测试而提供的样例代码，商户可以根据自己网站的需要，按照技术文档编写,并非一定要使用该代码。
 *该代码仅供学习和研究支付宝接口使用，只是提供一个参考。
 */

public class AlipayConfig {
	
//↓↓↓↓↓↓↓↓↓↓请在这里配置您的基本信息↓↓↓↓↓↓↓↓↓↓↓↓↓↓↓

	// 应用ID,您的APPID，收款账号既是您的APPID对应支付宝账号
	public static String app_id = "2021000121673889";
	
	// 商户私钥，您的PKCS8格式RSA2私钥
    public static String merchant_private_key = "MIIEvwIBADANBgkqhkiG9w0BAQEFAASCBKkwggSlAgEAAoIBAQCb71NS3kc6R6YO4/IG03M39BABxBM9lNGGx4ST4VWSPp3WqUT7/6JNTl0DvM5sIjF57gpTTX6zOJb/zHmMHNX3rCDq6DUhCmlnYiM4bfrD/4HOrvXH4s8tK7wj9+Vg1Qu3PjAx9LSXDGOvhlU2dUfBDIESFBIRSXqd/Hng5EX2nrRaLhzqZDogbTLXyG37ZDoe4oIBCTdc9wswI8W1G3ZWY0y3ZG+fLJ6Oq/EPhmqWhUmS+QXSROQJk+ykIh24QvkDg3YlK1Gw7X3QfpdjYV2dWUqPALPmt5CL56ddHQHDHMDefb0kabXQyEGHzC/A5nCPFsldqeINQdoHzR5VYEwpAgMBAAECggEBAIfTueLPF4AedPk3eNSVTyGICIFhR9k2TiR2mnctqpoOzPH009Al5jwsbD0bMzthtXMd9ASH1jtKqcz7UUzIuWBZoPq9dbnoFdQl2cQHmI0tfOaJ5DFO0WPpWqKCBl2IdgIRu21oV/3Snup/uq4LDouL1snmja5dMN940rkgXgjo6+sJ+Q9wpXYalSJ/jUo9Q05sf/M/L9ZKB4QXNK7t0UYFYKVAb9oSJabtECLxQWoH+vJe+Ll1SePgzUD8o9DoIvSywDvs+6d5yLGwRb+WSBfo3WfVf6naBERrW0hKa7rF94+ewGjs5r/viam19A8t8EpycIHpbHX5mjPD9twoJ1kCgYEA1zddAw5K+VDbYADXL7Ay2J41LxjJjA9dbpJnDfXrjNwJGltC32C3AJp05x4/ixg9wJlo6XUsWPraiSmsOPgqOmGOeF4BA9ZgwzCZZlmLy/TXQnkqS4DwIkXvXfH7L8uLpzhrhqBrh/t69/zGJSedq9ExMLDI0uRahmq19Ofyl5cCgYEAuXwVwfeJMLVO9GfL3utLcAig/WqkjkOb+LMWxXEXrVVDThbHTeFxVw8L+7VyqF+bwgG1A1RXlrPyU8QIeBW9uoe0zjZ20eRkIogtVxE5eapegj0phmti02eq9UPAOq7P71pmIEYsVabHX8MwUB7r1bx1ZA/g4M+iuPceqn+qsj8CgYEAlReEdu563/a00vAiIqZEwy3umB7q2P1383a2r8QylxWDtN+OFyNwA5n87HNW/+weM4PTWw/SVh4KMMVOyvSYhHM6+IXe3CKyS+YqDu5v2y5VxXYc58t+D7A1H/bX1YeDyqdaThxqAf0kdhGFzw1/vByioCGILhkF4WKhhPT+aScCgYEAifq0dMYfWAyH32gXUIzYYU8J83oRT4Mb07XliprGcjqrBrwLJvQ9y/V1hJlF4dq9k2SRsxhaz9Csw4NgiXQi3090QLJjUWAE3WtPzyURDGCgTWISMdxQd9L2ad0scnr4U6V7syaAdHbMeYBJwFBAP48iBH2LW7EZ615pgYvW/yECgYA82mGnuqtbxgcPGnrrJmVMJ/6ZZ0P5fA7fsIMz4Yv18EE5aK7Jvaeb7RmXg3o9VyYHe0h/HO+HcKrjwZExYx3PEuC2LpBWgIr8Fh4FWF73A2OPKZ+PsadwUe4Sryg4bpaQvHaS8VzdYeff1nFE9Dwp1FeXakyrgyu4NZxNFbFtGg==";
	
	// 支付宝公钥,查看地址：https://openhome.alipay.com/platform/keyManage.htm 对应APPID下的支付宝公钥。
    public static String alipay_public_key = "MIIBIjANBgkqhkiG9w0BAQEFAAOCAQ8AMIIBCgKCAQEAic8SyuTpjIB0jOxP8ifqAMEjBWcIOE5z3/bt1ZQ7YjOD1QG6CqBSAeANksy6HfdlqaTk4/IaHpzROPMV0XSaYn6Q2ipkiKI9yoHTaizwSrxJnTIzNyaFAR4ebKjoOaY1n1guvFtN5XokZDSthFQi5uf5qL6spxkxU+bKANFIOtoa9u72hoJwyoZsYCNBSIFZFawAro4iRlOY/JZ+h2XqU7Y1hP5nAcljxIC8orrgD2agiJIrOm6A6oIOBbLgS4uYDo3TTFn85G122jtXTNfZFbIyeuhN7UoffTQS+YI/aK91mTpDcdER01zxn14DDbgYBfsOwLVjw+r4kmg/HZ2sKwIDAQAB";

	// 服务器异步通知页面路径  需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String notify_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/notify_url.jsp";
    public static String notify_url = "http://localhost:8080/weshop/notify_url.jsp";
	// 页面跳转同步通知页面路径 需http://格式的完整路径，不能加?id=123这类自定义参数，必须外网可以正常访问
	//public static String return_url = "http://工程公网访问地址/alipay.trade.page.pay-JAVA-UTF-8/return_url.jsp";
	public static String return_url = "http://localhost:8080/weshop/return_url.jsp";
	//public static String return_url = "http://localhost:8080/weshop/ShoppingHomePageServlet";
	// 签名方式
	public static String sign_type = "RSA2";
	
	// 字符编码格式
	public static String charset = "utf-8";
	
	// 支付宝网关
	public static String gatewayUrl = "https://openapi.alipaydev.com/gateway.do";
	
	// 支付宝网关
	public static String log_path = "C:\\";

//↑↑↑↑↑↑↑↑↑↑请在这里配置您的基本信息↑↑↑↑↑↑↑↑↑↑↑↑↑↑↑

    /** 
     * 写日志，方便测试（看网站需求，也可以改成把记录存入数据库）
     * @param sWord 要写入日志里的文本内容
     */
	
    public static void logResult(String sWord) {
        FileWriter writer = null;
        try {
            writer = new FileWriter(log_path + "alipay_log_" + System.currentTimeMillis()+".txt");
            writer.write(sWord);
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

