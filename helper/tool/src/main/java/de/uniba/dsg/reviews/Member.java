package de.uniba.dsg.reviews;

import java.util.List;
import java.util.Map;

public class Member {
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public boolean isPc() {
        return pc;
    }

    public void setPc(boolean pc) {
        this.pc = pc;
    }

    public List<Map> getSocial() {
        return social;
    }

    public void setSocial(List<Map> social) {
        this.social = social;
    }

    public String name;

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String surname;
    public String title;
    public boolean pc;
    public List<Map> social;
}
