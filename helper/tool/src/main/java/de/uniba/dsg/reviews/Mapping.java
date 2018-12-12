package de.uniba.dsg.reviews;

class Mapping {
    public final int title;
    public final int authors;
    public final int year;
    public final int doi;
    public final int link;

    public Mapping(int title, int authors, int year, int doi, int link) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.doi = doi;
        this.link = link;
    }
}
