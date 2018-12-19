package br.ufma.lsdi.arlimpo.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.io.Serializable;
import java.util.List;

import br.ufma.lsdi.arlimpo.domain.auxiliar.CapabilityDataAuxiliar;

@JsonIgnoreProperties
public class Balneabilidade implements Serializable {

    private Object Balneabilidade;

    public Object getBalneabilidade() {
        return Balneabilidade;
    }

    public void setBalneabilidade(Object balneabilidade) {
        Balneabilidade = balneabilidade;
    }
}
