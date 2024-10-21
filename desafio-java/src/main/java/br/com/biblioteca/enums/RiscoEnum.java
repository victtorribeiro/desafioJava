package br.com.biblioteca.enums;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonValue;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public enum RiscoEnum {
    BAIXO("Risco Baixo"),
    MEDIO("Risco Médio"),
    ALTO("Risco Alto");


    private final String value;

    @JsonCreator
    public static RiscoEnum fromValue(String value) {
        for (RiscoEnum risco : RiscoEnum.values()) {
            if (risco.value.equalsIgnoreCase(value) || risco.name().equalsIgnoreCase(value)) {
                return risco;
            }
        }
        throw new IllegalArgumentException("Invalid StatusEnum value: " + value);
    }

    @JsonValue
    public String getValue(){
        return value;
    }

}
