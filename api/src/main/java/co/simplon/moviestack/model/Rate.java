package co.simplon.moviestack.model;

public enum Rate {
    G("G"),
    PG("PG"),
    PG_13("PG-13"),
    R("R"),
    NC_17("NC-17");

    private String rate;

    Rate(String rate){
        this.rate = rate;
    }

    public String toString(){
        return rate;
    }
}
