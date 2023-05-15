import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.Set;
public class Automat {
    private String st_initiala="q0";
    private String st_initiala1="";
    private String st_finale_str;
    private ListaTranzitii lt=new ListaTranzitii();
    private ArrayList<String> st_finale=new ArrayList<>();
    private Tranzitie tranz1;
    private Set<String> multime1 = new LinkedHashSet();
    private Set<String> multime2 = new LinkedHashSet();
    
    
    Automat(String nume_fisier) throws Exception{
        BufferedReader buf=new BufferedReader(new FileReader(nume_fisier));
        this.st_initiala=buf.readLine();
        st_initiala1=st_initiala;
        st_finale_str=buf.readLine();
        String tbl[] = st_finale_str.split(" ");
        System.out.println("tbl[0]= " + tbl[0] + " tbl[1]= " + tbl[1]);
        for(int i=0;i<tbl.length;++i)
            st_finale.add(tbl[i]);
        while(true)
        {
            String tmp=buf.readLine();
            if(tmp==null)
                break;
            String tmpbl[]=tmp.split(" ");
            Tranzitie tr=new Tranzitie(tmpbl[0],tmpbl[1].charAt(0),tmpbl[2]);
            lt.adaugaTranzitii(tr);
        }
    }
    
    
    boolean analizeazaCuvant(String word) throws Exception{
        for(int i=0;i<word.length();i++)
        {
            Tranzitie tranz=lt.gasesteTranzitie(st_initiala,word.charAt(i));
            if(tranz!=null){
                this.tranz1=tranz;
                multime1.add(tranz.getSt_inceput());
                multime2.add(tranz.getSt_sfarsit());
                st_initiala=tranz.getSt_sfarsit();
            }else return false;
        }
        System.out.println(multime1);
        System.out.println(multime2);
        String[] stare=st_finale_str.split(" ");
        for(int i=0;i<stare.length;i++)
        {
            if(st_initiala.equals(stare[i]))
                return true;
        }
        return false;
    }
    
    
    void print() throws Exception{
        ArrayList<Tranzitie> list=lt.getLista();
        System.out.println("Stari initiala existente/posibile:"+st_initiala1);
        System.out.println("Stari finale existente/posibile:" + st_finale_str);
        int i;
        System.out.println("Tranzitiile posibile:");
        for( i=0;i<list.size();i++)
        {
            System.out.println(list.get(i).getSt_inceput()+" "+list.get(i).getSimbol()+ " " + list.get(i).getSt_sfarsit());
        }
        System.out.println("Stare initiala:"+st_initiala1);
        System.out.println("Stare finala:" + this.tranz1.getSt_sfarsit());
    }
}