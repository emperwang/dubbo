package demo2;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class HelloService$Adaptive implements demo2.HelloService {
    public void sayHello() {
        throw new UnsupportedOperationException("method public abstract void demo2.HelloService.sayHello() of " +
                "interface demo2.HelloService is not adaptive method!");
    }
    // 这里生产的自适应方法
    // 何为自适应?
    // 对于在方法上标记了 Adaptive 注解的方法,会根据其参数去调用具体的实现类,此称为自适应
    // 确定具体实现类方式:
    // 1. 在url中 Parameter 中指定了此服务的实现类对应的key,则调用key对应的实现类
    // 2. 在 url parameter中没有指定的话,会使用@SPI注解中指定的默认的实现类key
    public void sayHello(com.alibaba.dubbo.common.URL arg0) {
        if (arg0 == null) throw new IllegalArgumentException("url == null");
        com.alibaba.dubbo.common.URL url = arg0;
        String extName = url.getParameter("hello.service", "dog");
        if(extName == null)
            throw new IllegalStateException("Fail to get extension(demo2.HelloService) name from url(" + url.toString() + ") use keys([hello.service])");
        demo2.HelloService extension = (demo2.HelloService)ExtensionLoader.getExtensionLoader(demo2.HelloService.class).getExtension(extName);
        extension.sayHello(arg0);
    }
}