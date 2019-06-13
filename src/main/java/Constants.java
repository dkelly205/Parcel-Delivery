public enum Constants {

    INVALID_INSRUCTIONS("Invalid instructions"),
    QUESTION("Please input instructions");


    private String description;


    Constants(String description) {
        this.description = description;
    }

    public String getDescription() {
        return description;
    }
}
