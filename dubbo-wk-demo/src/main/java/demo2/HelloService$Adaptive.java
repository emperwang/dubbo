package demo2;
import com.alibaba.dubbo.common.extension.ExtensionLoader;
public class HelloService$Adaptive implements demo2.HelloService {
    public void sayHello() {
        throw new UnsupportedOperationException("method public abstract void demo2.HelloService.sayHello() of " +
                "interface demo2.HelloService is not adaptive method!");
    }
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