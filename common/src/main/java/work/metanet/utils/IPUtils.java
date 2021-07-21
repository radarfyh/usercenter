package work.metanet.utils;

import java.net.InetAddress;
import java.net.UnknownHostException;

import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;

/**
 * IP相关工具类
 */
public class IPUtils {
	private static Logger logger = LoggerFactory.getLogger(IPUtils.class);

	/**
	 * 获取IP地址
	 * 
	 * 使用Nginx等反向代理软件， 则不能通过request.getRemoteAddr()获取IP地址
	 * 如果使用了多级反向代理的话，X-Forwarded-For的值并不止一个，而是一串IP地址，X-Forwarded-For中第一个非unknown的有效IP字符串，则为真实IP地址
	 */
	public static String getIpAddr(HttpServletRequest request) {
    	String ip = null;
        try {
            ip = request.getHeader("x-forwarded-for");
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || ip.length() == 0 || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("WL-Proxy-Client-IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_CLIENT_IP");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getHeader("HTTP_X_FORWARDED_FOR");
            }
            if (StringUtils.isEmpty(ip) || "unknown".equalsIgnoreCase(ip)) {
                ip = request.getRemoteAddr();
            }
        } catch (Exception e) {
        	logger.error("IPUtils ERROR ", e);
        }
        
//        //使用代理，则获取第一个IP地址
//        if(StringUtils.isEmpty(ip) && ip.length() > 15) {
//			if(ip.indexOf(",") > 0) {
//				ip = ip.substring(0, ip.indexOf(","));
//			}
//		}
        
        return ip;
    }
//	public static String getIpAddr(HttpServletRequest request){  
//        String ipAddress = request.getHeader("x-forwarded-for");  
//            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
//                ipAddress = request.getHeader("Proxy-Client-IP");  
//            }  
//            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
//                ipAddress = request.getHeader("WL-Proxy-Client-IP");  
//            }  
//            if(ipAddress == null || ipAddress.length() == 0 || "unknown".equalsIgnoreCase(ipAddress)) {  
//                ipAddress = request.getRemoteAddr();  
//                if("127.0.0.1".equals(ipAddress) || "0:0:0:0:0:0:0:1".equals(ipAddress)){
//                    //根据网卡取本机配置的IP  
//                    InetAddress inet=null;  
//                    try {  
//                        inet = InetAddress.getLocalHost();  
//                    } catch (UnknownHostException e) {  
//                        e.printStackTrace();  
//                    }  
//                    ipAddress= inet.getHostAddress();  
//                }  
//            }  
//            //对于通过多个代理的情况，第一个IP为客户端真实IP,多个IP按照','分割  
//            if(ipAddress!=null && ipAddress.length()>15){ //"***.***.***.***".length() = 15  
//                if(ipAddress.indexOf(",")>0){  
//                    ipAddress = ipAddress.substring(0,ipAddress.indexOf(","));  
//                }  
//            }  
//            return ipAddress;   
//    }
	
	/**
	 * 获取客户端ip地址
	 * @param request
	 * @return
	 */
	 public static String getClientIpAddress(HttpServletRequest request){
	    String ip = request.getHeader("X-Forwarded-For");
	    if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	      ip = request.getHeader("Proxy-Client-IP");
	    }
	    if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	      ip = request.getHeader("WL-Proxy-Client-IP");
	    }
	    if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	      ip = request.getHeader("HTTP_CLIENT_IP");
	    }if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	      ip = request.getHeader("HTTP_X_FORWARDED_FOR");
	    }
	    if (ip==null || ip.length()==0 || "unknown".equalsIgnoreCase(ip)){
	      ip = request.getRemoteAddr();
	    }
	    return ip;
	  }	
}
