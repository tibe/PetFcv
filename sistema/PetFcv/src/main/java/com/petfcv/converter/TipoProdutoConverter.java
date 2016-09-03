package com.petfcv.converter;

import com.petfcv.model.TipoProduto;
import com.petfcv.repository.RepositorioGenerico;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

@FacesConverter(forClass = TipoProduto.class, value = "TipoProdutoConverter")
public class TipoProdutoConverter implements Converter, Serializable {

    private final RepositorioGenerico<TipoProduto> dao = new RepositorioGenerico<>(TipoProduto.class);

    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        try {

            return dao.findForCodigoUnico(Long.valueOf(string));
        } catch (NumberFormatException e) {
            System.out.println("deu erro aqui no vonverter UfConverter ");
            System.out.println(e);
            return null;
        }
    }

    @Override
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        TipoProduto obj = (TipoProduto) o;
        try {
            return String.valueOf(obj.getId());
        } catch (Exception e) {
            return null;
        }
    }
}
