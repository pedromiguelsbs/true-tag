package com.truetag.model;

import jakarta.persistence.*;
import lombok.NoArgsConstructor;

@Entity
@DiscriminatorValue("Telefone")
@Table(name = "contatos")
@NoArgsConstructor
public class Phone extends Contact {

    private String number;

    @Enumerated(EnumType.STRING)
    private PhoneType type;

    public Phone(String number, Boolean authentic) {
        super(authentic);
        this.number = number;
        this.type = identifyType(number);
    }

    private PhoneType identifyType(String number) {
        if (number.startsWith("0900") || number.startsWith("0800") || number.startsWith("0500") || number.startsWith("0300") || number.startsWith("400") || number.startsWith("300")) {
            return PhoneType.ESPECIAL;
        } else if (number.length() == 11 && number.charAt(2) == '9') {
            return PhoneType.CELULAR;
        } else if (number.length() == 10) {
            return PhoneType.FIXO;
        } else {
            return PhoneType.DESCONHECIDO;
        }
    }

}