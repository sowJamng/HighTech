package rest.api.shop.dao;

import rest.api.shop.model.Categorie;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.function.Function;
import java.util.stream.Collectors;

public enum CategorieDAO {
    instance;

    private final List<Categorie> contentProvider = new ArrayList<>();

    CategorieDAO() {

        contentProvider.add(new Categorie("Ordinateur"));
        contentProvider.add(new Categorie("Telephonie"));
        contentProvider.add(new Categorie("Accessoire"));
        contentProvider.add(new Categorie("Stockage"));


        contentProvider.add(new Categorie("PCPortable", getByName("Ordinateur")));
        contentProvider.add(new Categorie("PCUltraPortable", getByName("PCPortable")));
        contentProvider.add(new Categorie("PCBureau", getByName("Ordinateur")));
        contentProvider.add(new Categorie("AccessoiresOrdi", getByName("Accessoire")));

        contentProvider.add(new Categorie("Smartphone", getByName("Telephonie")));
        contentProvider.add(new Categorie("TelFixe", getByName("Telephonie")));
        contentProvider.add(new Categorie("AccessoiresTel", getByName("Accessoire")));

        contentProvider.add(new Categorie("DisqueDur", getByName("Stockage")));
        contentProvider.add(new Categorie("CleUSB", getByName("Stockage")));


    }

    public Optional<Categorie> findByName(String cn) {
        return contentProvider.stream().filter(c -> c.name.equalsIgnoreCase(cn)).findFirst();
    }

    public Categorie getByName(String cn) {
        return findByName(cn).get();
    }

    public List<Categorie> findChildren(Categorie parent) {
        return contentProvider.stream().filter(it -> parent.equals(it.parent)).collect(Collectors.toList());
    }
}
