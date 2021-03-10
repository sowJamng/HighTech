package rest.api.shop.model;

import java.util.Objects;

public final class Categorie {

    public final Categorie parent;
    public final String name;

    public Categorie(String name) {
        this(name, null);
    }

    public Categorie(String name, Categorie parent) {
        this.name = name;
        this.parent = parent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Categorie categorie = (Categorie) o;
        return Objects.equals(name, categorie.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }
}
