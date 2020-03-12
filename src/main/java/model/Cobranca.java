package model;

/*
 * Cobranca.java
 *
 * Created on 27 de Setembro de 2006, 16:25
 *
 * To change this template, choose Tools | Template Manager
 * and open the template in the editor.
 */



import biblioteca.InterfaceObjeto;


/**
 *
 * @author Wallace
 */
public class Cobranca implements InterfaceObjeto{
    
    private ContaReceber contaReceber;
    private ParcelaContaReceber parcelaContaReceber;
    private PagtoParcialContaReceber pagtoParcialContaReceber;
    private SubConta subConta;
    private Cliente cliente;
    
    /** Creates a new instance of Cobranca */
    public Cobranca() {
        contaReceber = new ContaReceber();
        parcelaContaReceber = new ParcelaContaReceber();
        pagtoParcialContaReceber = new PagtoParcialContaReceber();
        subConta = new SubConta();
        cliente = new Cliente();
    }

    public ContaReceber getContaReceber() {
        return contaReceber;
    }

    public void setContaReceber(ContaReceber contaReceber) {
        this.contaReceber = contaReceber;
    }

    public ParcelaContaReceber getParcelaContaReceber() {
        return parcelaContaReceber;
    }

    public void setParcelaContaReceber(ParcelaContaReceber parcelaContaReceber) {
        this.parcelaContaReceber = parcelaContaReceber;
    }

    public PagtoParcialContaReceber getPagtoParcialContaReceber() {
        return pagtoParcialContaReceber;
    }

    public void setPagtoParcialContaReceber(PagtoParcialContaReceber pagtoParcialContaReceber) {
        this.pagtoParcialContaReceber = pagtoParcialContaReceber;
    }

    public SubConta getSubConta() {
        return subConta;
    }

    public void setSubConta(SubConta subConta) {
        this.subConta = subConta;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public String toXML() {
        return "<co>" +
                "<ncr>" + getContaReceber().getNumero() + "</ncr>" +
                "<np>"  + getContaReceber().getPedido().getNumero() + "</np>" +
                "<npcr>"+ getParcelaContaReceber().getNumero() + "</npcr>" +
                "<nd>"  + getParcelaContaReceber().getNumeroDoc() + "</nd>" +
                "<tc>"  + getParcelaContaReceber().getTipoCobranca() + "</tc>" +
                "<ns>"  + getSubConta().getNome() + "</ns>" +
                "<v>"   + getParcelaContaReceber().getVencimento() + "</v>" +
                //"<ccid>"+ getCliente().getEndereco().getCidade().getCodigo() +"</ccid>" +
                //"<ncid>"+ getCliente().getEndereco().getCidade().getNome() +"</ncid>" +
                "<ccli>" + getCliente().getCodigo() + "</ccli>" +
                //"<ncli>"+ getCliente().getNome() +"</ncli><credc>"+ getCliente().getCredito() +"</credc>" +
               // "<cv>"+ getContaReceber().getVendedor().getCodigo() +"</cv><nv>"+ getContaReceber().getVendedor().getNome() +"</nv>" +
               // "<cs>"+ getContaReceber().getVendedor().getSupervisor().getCodigo() +"<cs><nsup>"+ getContaReceber().getVendedor().getSupervisor().getNome() +"</nsup>" +
                "<d>" + getContaReceber().getData() +"</d>" +
                "<valcr>" + getParcelaContaReceber().getValor() + "</valcr>" +
                "<valppcr>" + getPagtoParcialContaReceber().getValor() + "</valppcr>" + 
                "<juros>" + getParcelaContaReceber().getJuros() + "</juros>" +
                "<lib>" + getParcelaContaReceber().getLiberado() + "</lib>" +  
                "<dataserv>" + getContaReceber().getDataServidor() + "</dataserv>" +
                "<tolerancia>" + getContaReceber().getTolerancia() + "</tolerancia>" +
                "</co>"; 
               // "<t>"+ getCliente().getTelefone() +"</t></co>";
    }
    
}
