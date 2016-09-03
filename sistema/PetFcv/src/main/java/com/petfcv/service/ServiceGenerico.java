package com.petfcv.service;


import com.petfcv.repository.RepositorioGenerico;
import java.io.Serializable;
import java.util.List;

public class ServiceGenerico<T extends Serializable>  implements Serializable {

    protected final Class<T> clazz;
    protected final RepositorioGenerico<T> repository;

    public ServiceGenerico(Class<T> clazz) {
        this.clazz = clazz;
        repository = getRepositorioGenerico();
    }

    protected RepositorioGenerico<T> getRepositorioGenerico() {
        return new RepositorioGenerico<>(clazz);
    }

    public void salvar(T objeto) {
        try {
            repository.save(objeto);
        } catch (Exception e) {
            System.out.println("Erro no Gravar getRepositorioGenerico \n"
                    + "\n--------------------------------------------------------------------------\n"
                    + e
                    + "\n--------------------------------------------------------------------------\n");
        }
    }

    public void update(T objeto) {
        try {
            repository.update(objeto);
        } catch (Exception e) {
            System.out.println("Erro no update getRepositorioGenerico \n"
                    + "\n--------------------------------------------------------------------------\n"
                    + e
                    + "\n--------------------------------------------------------------------------\n");
        }
    }

    public void excluir(T object, List<T> list) {
        try {
           
            repository.delete(object);
            list.remove(object);
        } catch (Exception e) {
            System.out.println("erro --> "+ e);
        }

    }

     public List<T> pesquisarTudo() {
        return repository.findAll();
    }
}
