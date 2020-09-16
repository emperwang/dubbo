package activate;

import com.alibaba.dubbo.common.URL;
import com.alibaba.dubbo.common.extension.ExtensionLoader;

import java.util.List;

public class ActivateStarter {
    public static void main(String[] args) {
        //final URL url = URL.valueOf("test://localhost/hello?hello.service=human");
        final URL url = URL.valueOf("test://localhost/hello");
        ExtensionLoader<ActivateExt> extensionLoader = ExtensionLoader.getExtensionLoader(ActivateExt.class);
        List<ActivateExt> defaultGroup = extensionLoader.getActivateExtension(url, new String[]{}, "default_group");
        System.out.println("====================================default_group=====================================================");
        System.out.println(defaultGroup.size());
        defaultGroup.forEach(s->{
            System.out.println(s.getClass().getName());
            s.echo("default group");
        });
        System.out.println("=========================================================================================");
        List<ActivateExt> group1 = extensionLoader.getActivateExtension(url, new String[]{}, "group1");
        System.out.println(group1.size());
        group1.forEach(s->{
            System.out.println(s.getClass().getName());
            s.echo("group1");
        });

        System.out.println("======================================order===================================================");
        // 看到这里 多个实现类,根据设置的order进行了排序
        List<ActivateExt> order = extensionLoader.getActivateExtension(url, new String[]{}, "order");
        System.out.println("order size:" + order.size());
        order.forEach(s -> {
            System.out.println(s.getClass().getName());
            s.echo("order");
        });

        System.out.println("===============================value==========================================================");
        // 这里有点问题 ？？？？？？？？？？？
        // 这里激活value, 要配置参数
        url.addParameter("value1","value");
        List<ActivateExt> value = extensionLoader.getActivateExtension(url, new String[]{}, "value");
        System.out.println("value size: " + value.size());
        value.forEach(s -> {
            System.out.println(s.getClass().getName());
            s.echo("value");
        });
    }
}
