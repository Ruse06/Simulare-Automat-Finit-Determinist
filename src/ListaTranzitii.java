import java.util.ArrayList;

public class ListaTranzitii {
    private ArrayList<Tranzitie> lista;
    ListaTranzitii(){
        this.lista=new ArrayList<>();
    }

    void adaugaTranzitii(Tranzitie tr){
        this.lista.add(tr);
    }


    Tranzitie gasesteTranzitie(String stare,char simbol ) throws Exception{
        for(int i=0;i<this.lista.size();++i){
            Tranzitie tmp=this.lista.get(i);
            if(tmp.getSt_inceput().equals(stare)&&tmp.getSimbol()==simbol){
                return tmp;
            }
        }
        return null;
        //throw new Exception("Nu am gasit tranzitia");
    }

    public ArrayList<Tranzitie> getLista() {
        return lista;
    }
}
