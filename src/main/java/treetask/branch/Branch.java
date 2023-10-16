package treetask.branch;
import java.util.*;

import treetask.enums.TreeType;
import treetask.photosynthesizer.Leaf;
import treetask.photosynthesizer.Needle;
import treetask.photosynthesizer.Photosynthesizer;
import treetask.tree.Tree;

public class Branch {
    private final Tree parentTree;
    private ArrayList<Photosynthesizer> leafList;
    private int length;
    final int height;
    private boolean hasFruit;
    private boolean isDead;
    final Random rand;

    public Branch(Tree parent, int height){
        parentTree = parent;
        leafList = new ArrayList<>();
        length = 1;
        this.height = height;
        hasFruit = false;
        isDead = false;
        rand = parent.getRandom();
    }

    public List<Photosynthesizer> getLeafList()
    {
        return leafList;
    }

    public int getLength()
    {
        return length;
    }

    public int getHeight()
    {
        return height;
    }

    public boolean hasFruit()
    {
        return hasFruit;
    }

    public boolean isDead()
    {
        return isDead;
    }

    public Random getRandom()
    {
        return rand;
    }

    public void setLeafList(List<Photosynthesizer> newLeafList)
    {
        this.leafList.clear();
        for(Photosynthesizer element : newLeafList)
        {
            leafList.add(element);
        }
    }
    
    public void setLength(int newLength)
    {
        this.length = newLength;
    }

    public void setHasFruit(boolean hasFruit)
    {
        this.hasFruit = hasFruit;
    }

    public void setIsDead(boolean isDead)
    {
        this.isDead = isDead;
    }



    public void dropLeaves(boolean death)
    {
        isDead = death;
        for(Iterator<Photosynthesizer> iter = leafList.iterator(); iter.hasNext();) //zmienic na fora
        {
            Photosynthesizer element = iter.next();
            leafList.remove(element);
        }
        if(hasFruit)
        {
            dropFruit();
        }
    }

    public void transferNutrients(){
        parentTree.receiveNutrients();
    }

    public void growLeaves(boolean all,TreeType treeType)
    {
        for(int i=0;i<rand.nextInt(all ? length : 5);i++)
        {
            if(leafList.size()-1>=length)
            {
                break;
            }

            if(treeType == TreeType.DECIDUOUS)
            {
                leafList.add(new Leaf(this));
            }
            else
            {
                leafList.add(new Needle(this));
            }
        }
    }

    public void sproutFruit()
    {
        if(rand.nextInt()%4==0)
        {
            hasFruit=true;
        }
    }

    public void dropFruit(){
        hasFruit = false;
    }
}
