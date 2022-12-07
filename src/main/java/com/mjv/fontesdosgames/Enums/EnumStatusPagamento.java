package com.mjv.fontesdosgames.Enums;

public enum EnumStatusPagamento {
    PENDENTE("pendente"),
    CONFIRMADO("confirmado");


    private String confirmação;

    EnumStatusPagamento(String confirmação) {
        this.confirmação = confirmação;
    }

    public String getConfirmação() {
        return confirmação;
    }
}
