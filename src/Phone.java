public class Phone extends Contact {

    public Phone(String number, boolean authentic) {
        super(number, authentic);
    }

    @Override
    public String getFormattedNumber() {
        switch (super.getType()) {
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

}
