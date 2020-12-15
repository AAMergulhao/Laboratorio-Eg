package model;

import com.google.gson.annotations.Expose;

public class Retorno {
    
    @Expose
    private Long status;

    @Expose
    private Object retorno;

    public Long getStatus() {
        return status;
    }

    public void setStatus(Long status) {
        this.status = status;
    }

    public Object getRetorno() {
        return retorno;
    }

    public void setRetorno(Object retorno) {
        this.retorno = retorno;
    }
}
