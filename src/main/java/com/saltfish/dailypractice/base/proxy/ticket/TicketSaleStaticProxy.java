package com.saltfish.dailypractice.base.proxy.ticket;

public class TicketSaleStaticProxy implements TicketSale{

    private final TicketSale ticketSale;

    public TicketSaleStaticProxy(TicketSale ticketSale) {
        this.ticketSale = ticketSale;
    }

    @Override
    public void saleTicket() {
        System.out.println(" ---- 售票前准备 ---- ");
        ticketSale.saleTicket();
        System.out.println(" ---- 售票后操作 ---- ");
    }
}
