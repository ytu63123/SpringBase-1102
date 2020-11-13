package com.mycompany.springbasic1102.proxy.dyn;

public class DynProxyDemo {

    public static void main(String[] args) {
        DymProxy dymProxy = new DymProxy(new CalcImpl());
        Object object = dymProxy.getProxy();
        if (object instanceof Calc) {
            Calc calc = (Calc) object;
            int result1 = calc.add(2, 3);
            System.out.println(result1);
            int result2 = calc.sub(5, 7);
            System.out.println(result2);
        }
    }
}
