package com.truetag.model;

public abstract class Contact implements Verifiable {

    protected boolean authentic;

    public Contact(boolean authentic) {
        this.authentic = authentic;
    }

    public boolean isAuthentic() {
        return authentic;
    }

}
