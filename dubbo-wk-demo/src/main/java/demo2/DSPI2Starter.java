package demo2;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.Set;

public class DSPI2Starter {
    public static void main(String[] args) {
        /**
         * 这里注意? 后面:
         * hello.service=HelloService= 后面就是在配置文件中的key
         */
        final URL url = URL.valueOf("test://localhost/hello?hello.service=human");
        //final URL url = URL.valueOf("test://localhost/hello");
        final ExtensionLoader<HelloService> extensionLoader = ExtensionLoader.getExtensionLoader(HelloService.class);
        // 前提是使用test://localhost/hello这个没有参数的URL: 因为在 HelloService 中 SPI指定了默认值为dog,
        // 所以这里会加载dog对应的实现类
        // 如果使用了test://localhost/hello?hello.service=human, 那这里就会使用 human对应的实现类
        // 此是获取自适应的 类
        System.out.println("=====================adaptive================================");
        HelloService adaptive = extensionLoader.getAdaptiveExtension();
        adaptive.sayHello(url);
        System.out.println("======================default===============================");
        // 获取默认的实现
        HelloService defaultExtension = extensionLoader.getDefaultExtension();
        defaultExtension.sayHello(url);
        System.out.println("=======================all impl==============================");
        // 获取所有的实现
        Set<String> supportedExtensions = extensionLoader.getSupportedExtensions();
        supportedExtensions.forEach( s-> {
            System.out.println(s);
            extensionLoader.getExtension(s).sayHello(url);
        });
    }
}
