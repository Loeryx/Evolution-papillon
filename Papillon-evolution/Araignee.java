public class Araignee extends Mechants{
    private Terrain t;

    public Araignee(Terrain t, int x, int y){
        super(t, x, y, "Araignee");
        this.t = t;
    }

    public void seDeplacer(int xnew, int ynew){
        setPosx(xnew);
        setPosy(ynew);
        setEnergie(getEnergie()-1);
    }

    public void mange(Simulation s){
        int x = -1;
        int y = -1;
        int d = 0;
        int q = 0;
        int id = 0;
        for (Ressource i : s.getRessources()){
            if(i instanceof Oeuf){
                d = distance(i.getX(), i.getY());
                id = i.ident;
                if( d < getEnergie()){
                    x = i.getX();
                    y = i.getY();
                }
            }
        }
        if(x>=0 &&  y>=0){
            seDeplacer(x, y);
            setEnergie(getEnergie() - d + 2);
            System.out.println("L'Araignée " + getId() + " a mangé l'oeuf "+ id +" !!");
            s.getRessources().remove(t.getCase(x,y));
            t.lesRessources().remove(t.getCase(x,y));
            t.videCase(x,y);
        }
        else{
            setEnergie(getEnergie() - 1);
            System.out.println("L'Araignée " + getId() + " a perdu de l'energie!");

        }
    }

    public void vieillir(Simulation s){
        setAge(getAge()+1);
        if(getEnergie() == 0 || getAge() > 5){
            System.out.println("L'Araignée "+ getId()+" meurt.");
            meurt(s);
        }
    }

    public String toString(){
        return "L'araignée " + super.toString();
    }
    
}