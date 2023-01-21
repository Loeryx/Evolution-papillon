public class Chenille extends Gentils{
    private Terrain t;
    
    public Chenille(Terrain t, int x, int y) {
        super(t,x,y, "Chenille");
        this.t = t;
    }
    
    public void seDeplacer(int xnew, int ynew){
        setPosx(xnew);
        setPosy(ynew);
        setEnergie(getEnergie()-1);
    }

    public void vieillir(Simulation s) {
        //On fait vieillir notre chenille
        setAge(getAge() + 1);

        //On teste si elle a encore de l'energie si non elle meurt
        if(getEnergie() <= 0){
            System.out.println("La chenille "+ getId() +" meurt");
            meurt(s);
        }
    }

    public void mange(Simulation s){
        int x = -1;
        int y = -1;
        int d = 0;
        int q = 0;
        int id = 0;
        for (Ressource i : t.lesRessources()){
            if(i != null && i instanceof Feuille){
                d = distance(i.getX(), i.getY());
                q = i.getQuantite();
                id = i.ident;
                if( d < getEnergie()){
                    x = i.getX();
                    y = i.getY();
                }
            }
        }
        if(x>=0 &&  y>=0){
            seDeplacer(x, y);
            setEnergie(getEnergie() - d + q);
            System.out.println("La chenille " + getId() + " a mangé la feuille "+ id +"!");
            s.getRessources().remove(t.getCase(x,y));
            t.lesRessources().remove(t.getCase(x,y));
            t.videCase(x,y);
        }
        else{
            setEnergie(getEnergie() - 1);
        }
    }

    public String toString(){
        return "la Chenille " + super.toString() +" et se transforme dans "+ (5-getAge())+" jours!";
    }
    
}
 