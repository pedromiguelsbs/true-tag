package com.truetag.model;

public class Phone extends Contact {

    private String number;
    private PhoneType type;

    public Phone(String number, boolean authentic) {
        super(authentic);
        this.number = number;
        this.type = identifyType(number);
    }

    public String getNumber() {
        return number;
    }
    public PhoneType getType() {
        return type;
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

    public String formattedNumber() {
        switch (getType()) {
            case FIXO:
                return String.format("(%s) %s-%s",
                        number.substring(0,2),
                        number.substring(2,6),
                        number.substring(6));
            case CELULAR:
                return String.format("(%s) %s-%s",
                        number.substring(0,2),
                        number.substring(2,7),
                        number.substring(7));
            case ESPECIAL:
                return String.format("%s %s %s",
                        number.substring(0,4),
                        number.substring(4,7),
                        number.substring(7));
            default:
                return number;
        }
    }

    @Override
    public String toString() {
        return (authentic ? "✅" : "❌") + " " + type + " - " + formattedNumber();
    }

}
