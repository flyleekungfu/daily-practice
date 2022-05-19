package com.saltfish.dailypractice.base.proxy.ticket;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

public class TicketSaltDynamicProxy implements InvocationHandler {

    private final TicketSale ticketSale;

    public TicketSaltDynamicProxy(TicketSale ticketSale) {
        this.ticketSale = ticketSale;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println(" ---- 售票前准备 ---- ");
        Object obj = method.invoke(ticketSale, args);
        System.out.println(" ---- 售票后处理 ---- ");
        return obj;
    }
}
