public enum Constants {

    NO_INSRUCTIONS("No instructions given"),
    QUESTION("Please input instructions");


    private String description;


    Constants(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
