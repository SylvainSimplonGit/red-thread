package co.simplon.moviestack.model;

public enum Genre {
    ACTION("Action"),
    AVENTURE("Adventure"),
    ANIME("Animation"),
    COMEDIE("Comedy"),
    CRIME("Crime"),
    DOCU("Documentary"),
    DRAME("Drama"),
    FAMILLE("Family"),
    FANTASTIQUE("Fantasy"),
    HISTOIRE("History"),
    HORREUR("Horror"),
    MUSIQUE("Music"),
    MYSTERE("Mystery"),
    ROMANCE("Romance"),
    SCIENCE_FICTION("Sci-Fi"),
    THRILLER("Thriller"),
    WAR("War"),
    WESTERN("Western");


    private String genre;

    Genre (String genre) {this.genre = genre;}

    @Override
    public String toString(){
        return genre;
    }








}
