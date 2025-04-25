import java.util.ArrayList;
import java.util.List;

public class Company {

    private String name;
    private List<Phone> verifiedPhones;

    public Company(String name) {
        this.name = name;
        this.verifiedPhones = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
    public List<Phone> getVerifiedPhones() {
        return verifiedPhones;
    }
    public List<Phone> getAuthenticPhones() {
        List<Phone> auth = new ArrayList<>();
        for (Phone p : verifiedPhones) {
            if (p.getAuthentic()) {
                auth.add(p);
            }
        }
        return auth;
    }
    public List<Phone> getNotAuthenticPhones() {
        List<Phone> notAuth = new ArrayList<>();
        for (Phone p : verifiedPhones) {
            if (!p.getAuthentic()) {
                notAuth.add(p);
            }
        }
        return notAuth;
    }

    public void addPhone(Phone phone) {
        if (!verifiedPhones.contains(phone)) {
            verifiedPhones.add(phone);
        }
    }

}
