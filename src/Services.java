public enum Services {
    PRELUARE_COLET,
    LIVRARE_COLET,
    PLATI_FACTURI,
    MANDATE_POSTALE;

    //Services randomService = Services.getRandomService();
    public static Services getRandomService() {
        return values()[(int) (Math.random() * values().length)];
    }
}
