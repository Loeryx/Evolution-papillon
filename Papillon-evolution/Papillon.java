public class Papillon extends Gentils{
    private Terrain t;

    public Papillon(Terrain t, int x, int y){
        super(t, x, y, "Papillon");
        this.t = t;
    }

    public void seDeplacer(int xnew, int ynew){
        setPosx(xnew);
        setPosy(ynew);
        setEnergie(getEnergie()-1);
    }

    public void vieillir(Simulation s){
        //On fait vieillir notre papillon
        setAge(getAge()+1);

        //On teste si il a encore de l'energie si non il meurt
        if(getEnergie() <= 0){
            System.out.println("Le papillon "+ getId()+" meurt.");
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
            if(i != null && i instanceof Fleur){
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
            System.out.println("Le Papillon " + getId() + " a mangé la feuille "+ id +"!");
            t.lesRessources().remove(t.getCase(x,y));
            t.videCase(x,y);
            s.getRessources().remove(t.getCase(x,y));
        }
        else{
            setEnergie(getEnergie() - 1);
        }
    }
    

    public String toString(){
        return "Le papillon " + super.toString();
    }
    
}
