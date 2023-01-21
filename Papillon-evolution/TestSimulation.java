public class TestSimulation{
    public static void main(String[] args){
        Terrain t = new Terrain(10,10);
        Simulation s = new Simulation(t);

        Chenille c1 = new Chenille(t, 1, 5);
        Chenille c2 = new Chenille(t, 1, 5);
        Papillon p1 = new Papillon(t, 2, 7);
        Papillon p2 = new Papillon(t, 2, 7);
        Araignee a = new Araignee(t, 8, 6);

        s.ajouterAgent(c1);
        s.ajouterAgent(c2);
        s.ajouterAgent(p1);
        s.ajouterAgent(p2);
        s.ajouterAgent(a);
        

       
        int tour = 1;

        System.out.println("Au debut de la simulation :\n" + s.toString());
        s.rafraichir(5,tour);
        t.affiche(5);

        while(tour<11){
            if(tour%2 == 0){s.rafraichir(1, tour);}
            System.out.println("Au "+tour+" iéme tour :");
            s.simuler(tour);
            t.affiche(5);
            System.out.println(s.toString());
            tour++;
        }

    }
}