//package work.metanet.filter;
//
//import org.apache.dubbo.rpc.Constants;
//import org.apache.dubbo.rpc.Filter;
//import org.apache.dubbo.rpc.Invocation;
//import org.apache.dubbo.rpc.Invoker;
//import org.apache.dubbo.rpc.Result;
//import org.apache.dubbo.rpc.RpcContext;
//import org.apache.dubbo.rpc.RpcException;
//
///**dubbo异步调用传递性问题待解决*/
////@Activate(group = {Constants.PROVIDER}, order = -999)
//public class DubboSyncFilter implements Filter {
//    public Result invoke(Invoker<?> invoker, Invocation invocation) throws RpcException {
//        //避免RpcContext透传,使用配置文件的async
//        boolean isAsync = invoker.getUrl().getMethodParameter(invocation.getMethodName(), Constants.ASYNC_KEY, false);
//        RpcContext.getContext().setAttachment(Constants.ASYNC_KEY, String.valueOf(isAsync));
//        return invoker.invoke(invocation);
//    }
//}