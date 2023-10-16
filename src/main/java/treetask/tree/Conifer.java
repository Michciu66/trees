package treetask.tree;
import treetask.branch.Branch;
import treetask.enums.TreeType;

public class Conifer extends Tree {

    private final TreeType treeType;
    
    Conifer()
    {
        super();
        this.treeType = TreeType.CONIFER;
    }

    @Override
    public void grow(){
        super.grow();

        for(Branch element:super.getBranchList())
        {
            element.growLeaves(false,treeType);
        }
    }
}



