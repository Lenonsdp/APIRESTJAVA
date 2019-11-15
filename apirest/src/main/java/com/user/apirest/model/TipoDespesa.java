package com.user.apirest.model;

public enum TipoDespesa {
	GASOLINA("gasolina"), 
    LAVAGEM("lavagem"),  
	SEGURO("seguro"), 
    MECANICA("mecanica"),
	IMPOSTOS("impostos"), 
    OUTRAS("outras");

    private final String status;
    TipoDespesa(String status){
        this.status = status;
    }
    public String getStatus() {
        return status;
    }
}
