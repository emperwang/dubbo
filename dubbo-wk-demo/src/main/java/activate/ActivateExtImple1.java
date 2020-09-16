package activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(group = "default_group")
public class ActivateExtImple1 implements ActivateExt{
    @Override
    public String echo(String msg) {
        System.out.println("ActivateExtImple1 ");
        return msg;
    }
}
