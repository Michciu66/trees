package treetask.photosynthesizer;
import java.util.Random;

import treetask.branch.Branch;

public class Photosynthesizer {
    final Branch parentBranch;
    int width;
    int length;
    final Random rand;

    Photosynthesizer()
    {
        rand = new Random();
        parentBranch = null;
    }

    public Photosynthesizer(Branch parentBranch)
    {
        rand = parentBranch.getRandom();
        this.parentBranch = parentBranch;
    }
    public void photosynthesize(){
        if(rand.nextBoolean())
        {
            parentBranch.transferNutrients();
        }
    } 
}


//lookup tests with random