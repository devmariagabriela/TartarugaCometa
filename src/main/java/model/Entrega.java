package model;
import java.util.Date;

public class Entrega {

    private int id;
    private Cliente cliente;
    private Cliente remetente;
    private Produto produto;
    private String status;
    private Date dataEntrega;
    private Date dataCriacao;
    private String observacoes;
    private double valorFrete;



    // CONS

    public Entrega () {

    }
    public Entrega(int id, Cliente cliente, Cliente remetente,  Produto produto, String status, Date dataEntrega, Date dataCriacao, String observacoes, double valorFrete ) {
        this.id = id;
        this.cliente = cliente;
        this.remetente= remetente;
        this.produto = produto;
        this.dataCriacao = dataCriacao;
        this.dataEntrega = dataEntrega;
        this.status = status;
        this.observacoes = observacoes;
        this.valorFrete = valorFrete;
    }

    /// GS

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }


    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente  cliente) { this.cliente = cliente;}

    public Cliente getRemetente (){ return remetente;}
    public void setRemetente (Cliente remetente) { this.remetente = remetente;}

    public Produto getProduto() {return  produto;}
    public void setProduto(Produto produto) { this.produto = produto;}

    public Date getDataCriacao() { return dataCriacao; }
    public void setDataCriacao(Date dataCriacao) { this.dataCriacao = dataCriacao; }

    public Date getDataEntrega() { return dataEntrega; }
    public void setDataEntrega(Date dataEntrega) { this.dataEntrega = dataEntrega; }

    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }

    public String getObservacoes() { return observacoes; }
    public void setObservacoes(String observacoes) { this.observacoes = observacoes; }

    public double getValorFrete() { return valorFrete; }
    public void setValorFrete(double valorFrete) { this.valorFrete = valorFrete; }




}
