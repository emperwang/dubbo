package activate;

import com.alibaba.dubbo.common.extension.Activate;

@Activate(value = {"value1"}, group = {"value"})
public class ValueActivatImpl implements ActivateExt{

    @Override
    public String echo(String msg) {
        System.out.println("ValueActivatImpl");
        return msg;
    }
}
