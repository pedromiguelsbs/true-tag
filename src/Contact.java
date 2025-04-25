public abstract class Contact implements Verifiable {

    protected String number;
    protected PhoneType type;
    protected boolean authentic;

    public Contact(String number, boolean authentic) {
        this.number = number;
        this.type = identifyType(number);
        this.authentic = authentic;
    }

    public String getNumber() {
        return number;
    }
    public PhoneType getType() {
        return type;
    }
    public boolean getAuthentic() {
        return authentic;
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

    public boolean verifyAutenticity() {
        return authentic;
    }

    public abstract String getFormattedNumber();

    @Override
    public String toString() {
        return (authentic ? "✅" : "❌") + " " + type + " - " + getFormattedNumber();
    }

}
