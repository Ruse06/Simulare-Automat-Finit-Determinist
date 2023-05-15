public class TestDFA {
    public static void main(String[] args) throws Exception{
        Automat automat=new Automat("D:\\Java Problems\\ProiectLFC\\auto.txt");
        if(automat.analizeazaCuvant("ababb"))
        {
            System.out.println("Cuvantul este acceptat");
            automat.print();
        }
        else
            System.out.println("Cuvantul este neacceptat");
    }
}