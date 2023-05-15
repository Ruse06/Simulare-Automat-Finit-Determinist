public class Tranzitie {
    private String st_inceput;
    private char simbol;
    private String st_sfarsit;
    Tranzitie(String st_inceput,char simbol,String st_sfarsit){
        this.st_inceput=st_inceput;
        this.simbol=simbol;
        this.st_sfarsit=st_sfarsit;
    }

    public String getSt_inceput() {
        return st_inceput;
    }

    public char getSimbol() {
        return simbol;
    }

    public String getSt_sfarsit() {
        return st_sfarsit;
    }
}