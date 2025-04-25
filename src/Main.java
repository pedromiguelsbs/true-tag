public class Main {
    public static void main(String[] args) {

        Company company = new Company("Banco XPTO");

        company.addPhone(new Phone("1130031000", true));
        company.addPhone(new Phone("1140040022", true));
        company.addPhone(new Phone("0800570022", false));
        company.addPhone(new Phone("1140020022", false));
        company.addPhone(new Phone("1133350237", true));

        for (Phone p : company.getVerifiedPhones()) {
            System.out.println(p);
        }

    }
}
