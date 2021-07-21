
package work.metanet.client.gateway.utils;

/**
 * @Description 根据类名创建对象
 * @author EdisonFeng
 * @DateTime 2021年6月30日
 * Copyright(c) 2021. All Rights Reserved
 */
public enum BeanFactory {
    INSTANCE;
    public <T> T getBean(Class<T> checkType, String className){
    	//传递一个类的全新类名来调用对象
        try {
            Class<T> clz = (Class<T>) Class.forName(className);
            
            Object obj = clz.newInstance();
            
            //需要检查checkType是不是obj的字节码对象
            if (!checkType.isInstance(obj)) {
                throw new Exception("对象跟字节码不兼容");
            }
            
            return (T)obj;
            
        } catch (Exception e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         
        return null;
    }
}
