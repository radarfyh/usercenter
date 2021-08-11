package work.metanet.interceptor;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang3.StringUtils;
import org.apache.dubbo.config.annotation.DubboReference;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import cn.hutool.core.util.StrUtil;
import work.metanet.api.deviceApp.IDeviceAppService;
import work.metanet.exception.MetanetExceptionAssert;
import work.metanet.exception.ResultResponseEnum;

@Component
public class HeaderInterceptor implements HandlerInterceptor {
	
	@DubboReference
	private IDeviceAppService deviceAppService;
	
    //该方法在action执行前执行，可以实现对数据的预处理，  
    //比如：编码、安全控制等。如果方法返回true，则继续执行action。
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
    	String timestamp = request.getHeader("timestamp");
    	String nonce = request.getHeader("nonce");
    	String sign = request.getHeader("sign");
    	
        MetanetExceptionAssert.assertTrue(StringUtils.isBlank(timestamp)
        		, ResultResponseEnum.INVALID_REQUEST.getResponseCode()
        		, "%s", "timestamp不能为空");
        MetanetExceptionAssert.assertTrue(StringUtils.isBlank(nonce)
        		, ResultResponseEnum.INVALID_REQUEST.getResponseCode()
        		, "%s", "nonce不能为空");
        MetanetExceptionAssert.assertTrue(StringUtils.isBlank(nonce)
        		, ResultResponseEnum.INVALID_REQUEST.getResponseCode()
        		, "%s", "nonce不能为空");
       
        return true;
    }
    
    //该方法在action执行后，生成视图前执行。在这里，我们有机会修改视图层数据。  
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView  
            modelAndView) throws Exception {  
        //System.out.println("action执行之后，生成视图之前执行！！");  
    }  
  
    //最后执行，通常用于释放资源，处理异常。我们可以根据ex是否为空，来进行相关的异常处理。  
    //因为我们在平时处理异常时，都是从底层向上抛出异常，最后到了spring框架从而到了这个方法中。  
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {  
        //System.out.println("最后执行！！！一般用于释放资源！！");  
    }  
}