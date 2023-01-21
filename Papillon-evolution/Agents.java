public abstract class Agents{
    private Terrain terrain;
    private int posx, posy;
    private int age;
    private int energie;
    private int id;
    protected static int cpt=0;
    private String type;

    public Agents(Terrain t, int x, int y, String type){
        id = cpt;
        cpt++;
        terrain = t;
        posx = x;
        posy = y;
        age = 0;
        energie = 30;
        this.type = type;
    }
    
    public int distance(int x, int y){
        return (int)(Math.sqrt((posx-x)*(posx-x) + (posy-y)*(posy-y)));
    }

    public boolean estVivant(){
        if (posx == -1 && posy == -1 || energie <= 0){
            return false; 
        }
        return true;
    }

    public void meurt(Simulation s){
        age = -1;
        setPosx(-1);
        setPosy(-1);
        s.getAgents().removeIf(a ->(!this.estVivant()));
    }
    
    public abstract void seDeplacer(int xnew, int ynew);
    public abstract void mange(Simulation s);
    public abstract void vieillir(Simulation s);

    public String toString(){
        return id + " à " + age + " de jours, " + energie + " d'energie";
    }
    
    //Tous les accesseurs
    public int getEnergie() {
        return energie;
    }

    public int getAge() {
        return age;
    }

    public Terrain getTerrain() {
        return terrain;
    }

    public int getPosx() {
        return posx;
    }

    public int getPosy() {
        return posy;
    }
    
    public int getId(){
        return id;
    }
    public String getType(){
        return type;
    }

    //Tous les mutateurs
    public void setEnergie(int energie) {
        this.energie = energie;
    }
    
    public void setAge(int age) {
        this.age = age;
    }

    public void setPosx(int posx) {
        this.posx = posx;
    }

    public void setPosy(int posy) {
        this.posy = posy;
    }
}