//
//package work.metanet.server.usercenter.config;
//
//import java.io.IOException;
//
//import org.springframework.core.type.classreading.MetadataReader;
//import org.springframework.core.type.classreading.MetadataReaderFactory;
//import org.springframework.core.type.filter.TypeFilter;
//
///**
// * @Description 类型过滤器
// * @author EdisonFeng
// * @DateTime 2021年6月17日
// * Copyright(c) 2021. All Rights Reserved
// */
//public class UserCenterTypeFilter implements TypeFilter {
//    @Override
//    public boolean match(MetadataReader metadataReader, MetadataReaderFactory metadataReaderFactory) throws IOException {
//        String className = metadataReader.getClassMetadata().getClassName();
//        if(className.contains("Service")){
//            return true;
//        }
//        return false;
//    }
//}
