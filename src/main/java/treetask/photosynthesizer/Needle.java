package treetask.photosynthesizer;

import treetask.branch.Branch;

public class Needle extends Photosynthesizer{

    public Needle(Branch parent)
    {
        super(parent);
        width = 1;
        length = rand.nextInt(5);
    }

    public void poke(){
        System.out.println("Ow.");
    }

}
