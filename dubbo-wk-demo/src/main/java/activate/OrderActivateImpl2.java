package activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(order = 2, group = {"order"})
public class OrderActivateImpl2 implements ActivateExt {
    @Override
    public String echo(String msg) {
        System.out.println("OrderActivateImpl2");
        return msg;
    }
}
