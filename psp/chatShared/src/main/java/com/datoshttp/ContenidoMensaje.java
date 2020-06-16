package com.datoshttp;


import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

@JsonTypeInfo(
    use = JsonTypeInfo.Id.NAME,
    include = JsonTypeInfo.As.PROPERTY,
    property = "type")
@JsonSubTypes({
    @JsonSubTypes.Type(value = Mensaje.class, name = "mensaje"),
    @JsonSubTypes.Type(value = OrdenRoomsWS.class, name = "orden")
})
public abstract class ContenidoMensaje {

}
