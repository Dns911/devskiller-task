package pl.allegro.tech.recruit.calc;

import java.util.List;

public class Developer {
    private String name;
    private List<Developer> followers;

    public void setName(String name) {
        this.name = name;
    }

    public Developer(
            String name,
            List<Developer> followers
    ) {
        this.name = name;
        this.followers = followers;
    }

    String getName() {
        return name;
    }

    public List<Developer> getFollowers() {
        return followers;
    }

    @Override
    public String toString() {
        return "Developer{" +
                "name='" + name + '\'' +
                '}';
    }
}
