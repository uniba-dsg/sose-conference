package de.uniba.dsg.reviews;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringJoiner;

class Entry {
    public final String title;
    public final String authors;
    public final String year;
    public final String doi;
    public final String link;

    public List<String> relevance;
    public String comment;

    public Entry(String title, String authors, String year, String doi, String link) {
        this.title = title;
        this.authors = authors;
        this.year = year;
        this.doi = doi;
        this.link = link;
        this.relevance = new ArrayList<>(3);
        relevance.add(0, "");
        relevance.add(1, "");
        relevance.add(2, "");
        this.comment = "";
    }

    public void setComment(String comment) {
        StringJoiner joiner = new StringJoiner(":");
        joiner.add(this.comment).add(comment);
        this.comment = joiner.toString();
    }

    public void setRelevance(String relevance, int reviewer) {
        this.relevance.add(reviewer, relevance);
    }

    List<String> getFields() {
        return Arrays.asList(relevance.get(0), relevance.get(1), relevance.get(2), title, authors, String.valueOf(year), doi, link, comment);
    }
}
