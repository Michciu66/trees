package treetask.tree;
import treetask.branch.Branch;
import treetask.enums.TreeType;

public class Deciduous extends Tree{
    boolean isHibernating;
    private final TreeType treeType; 

    Deciduous(){
        isHibernating = false;
        this.treeType = TreeType.DECIDUOUS;
    }

    @Override
    public void grow(){
        super.grow();

        for(Branch element:super.getBranchList())
        {
            element.growLeaves(false,treeType);
        }
    }

    @Override
    public boolean update(){ 
        
        if (super.isDead())
        {
            return false;
        }

        if(isWinter() && !isHibernating)
        {
            isHibernating = true;
            for(Branch element:super.getBranchList())
            {
                element.dropLeaves(false);
            }
        }
        
        if(!isWinter() && isHibernating)
        {
                isHibernating = false;
                for(Branch element:super.getBranchList())
            {
                element.growLeaves(true,treeType);
            }
        }
        
        if(isHibernating)
        {
            return true;
        }

        return super.update();
    }
    
    public boolean isWinter(){
        return super.getRandom().nextInt(4) == 1;
    }
}

