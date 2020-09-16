package activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(order = 1, group = {"order"})
public class OrderActivateImpl1 implements  ActivateExt{
    @Override
    public String echo(String msg) {
        System.out.println("OrderActivateImpl1");
        return msg;
    }
}
