package Model.Entities;

import java.util.Date;

public class Venda {
    private Long Id;
    private Pedido pedido;
    private Date Data;
    private Double ValorTotal;

    public Venda() {
        this.Id = (long) Core.IDGenerator.getNextId();
    }

    public Venda(Pedido pedido) {
        this.Id = (long) Core.IDGenerator.getNextId();
        this.pedido = pedido;
        this.pedido = pedido;
        this.Data = new Date();
        this.ValorTotal = pedido.getValorTotal();
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }

    public Date getData() {
        return Data;
    }

    public void setData(Date data) {
        Data = data;
    }

    public Double getValorTotal() {
        return ValorTotal;
    }

    public void setValorTotal(Double valorTotal) {
        ValorTotal = valorTotal;
    }
}
