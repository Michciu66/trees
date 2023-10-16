package treetask.photosynthesizer;
import treetask.branch.Branch;

public class Leaf extends Photosynthesizer{

    public Leaf(Branch parent)
    {
        super(parent);
        width = rand.nextInt(5);
        length = rand.nextInt(5);
    }

    

}
