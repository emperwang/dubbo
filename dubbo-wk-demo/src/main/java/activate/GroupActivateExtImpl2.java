package activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = {"group1","group2"})
public class GroupActivateExtImpl2 implements ActivateExt {
    @Override
    public String echo(String msg) {
        System.out.println("ActivateExtImpl2 ");
        return msg;
    }
}
