package com.saltfish.dailypractice.base.proxy.ticket;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Proxy;

@SpringBootTest
public class TicketSaleTest {

    @Test
    public void directSale() {
        TicketSaleImpl ticketSaleImpl = new TicketSaleImpl();
        ticketSaleImpl.saleTicket();
    }

    @Test
    public void staticProxySale() {
        TicketSaleStaticProxy ticketSaleStaticProxy = new TicketSaleStaticProxy(new TicketSaleImpl());
        ticketSaleStaticProxy.saleTicket();
    }

    @Test
    public void dynamicProxySale() {
        TicketSale ticketSale = new TicketSaleImpl();
        InvocationHandler dynamicProxy = new TicketSaltDynamicProxy(ticketSale);

        ClassLoader classLoader = ticketSale.getClass().getClassLoader();
        Class<?>[] interfaces = ticketSale.getClass().getInterfaces();

        TicketSale proxy = (TicketSale) Proxy.newProxyInstance(classLoader, interfaces, dynamicProxy);
        proxy.saleTicket();
    }
}


