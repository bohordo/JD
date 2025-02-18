package com.juannas.jd.enums;

import lombok.Getter;

@Getter
public enum TipoOrdenServicio {

    INFORMATIVA("Informativa"),
    FINAL("Final");

    private final String tipoOrden;

    TipoOrdenServicio(String tipoOrden) {
        this.tipoOrden = tipoOrden;
    }

    @Override
    public String toString() {
        return tipoOrden;
    }

}
