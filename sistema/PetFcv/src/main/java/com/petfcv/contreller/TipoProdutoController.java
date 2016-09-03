package com.petfcv.contreller;

import com.petfcv.model.TipoProduto;
import com.petfcv.service.ServiceGenerico;
import java.io.Serializable;
import java.util.List;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class TipoProdutoController implements Serializable {

    @Inject
    private TipoProduto tipoProduto;

    private final ServiceGenerico<TipoProduto> service;

    private List<TipoProduto> listTipoProdutos;

    boolean insert = true;

    public TipoProdutoController() {
        service = new ServiceGenerico<>(TipoProduto.class);
    }

    public void salvar() {
        if (insert) {
            service.salvar(tipoProduto);
        } else {
            service.update(tipoProduto);
        }
        insert = true;
        limpar();
    }

    public void alterar() {
        insert = false;
    }

    public void excluir() {
        service.excluir(tipoProduto, listTipoProdutos);
    }

    public void pesquisar() {
        listTipoProdutos = service.pesquisarTudo();
    }


    public void limpar() {
        tipoProduto = new TipoProduto();
        listTipoProdutos.clear();
    }

    //---------------------------

    public TipoProduto getTipoProduto() {
        return tipoProduto;
    }

    public void setTipoProduto(TipoProduto tipoProduto) {
        this.tipoProduto = tipoProduto;
    }

    public List<TipoProduto> getListTipoProdutos() {
        return listTipoProdutos;
    }

    public void setListTipoProdutos(List<TipoProduto> listTipoProdutos) {
        this.listTipoProdutos = listTipoProdutos;
    }

    public boolean isInsert() {
        return insert;
    }

    public void setInsert(boolean insert) {
        this.insert = insert;
    }
  
    
}
