package treetask.tree;

import java.util.*;

import treetask.branch.Branch;
import treetask.photosynthesizer.Photosynthesizer;


public abstract class Tree { //zmienic na wirtualna
    private int trunkHeight;
    private int trunkThickness;
    private ArrayList<Branch> branchList;
    private int nutrients;
    private boolean isDead;
    private final Random rand;


    Tree(){
        trunkHeight=1;
        trunkThickness=1;
        branchList = new ArrayList<>();
        nutrients=0;
        isDead = false;
        rand = new Random();
    }

    
    public List<Branch> getBranchList()
    {
        return branchList;
    }

    public boolean isDead()
    {
        return isDead;
    }

    public Random getRandom()
    {
        return rand;
    }

    public void grow(){
        trunkHeight++;
        trunkThickness++;  
        if(rand.nextBoolean())
        {
            branchList.add(new Branch(this,rand.nextInt(trunkHeight)));
            nutrients--;
        }
        boolean fruit = isFruitingSeason();
        for(Branch element: branchList)
        {
            element.setLength(element.getLength()+1);
            if (fruit)
            {
                element.sproutFruit();
                nutrients--;
            }
            else if(element.hasFruit()){
                element.dropFruit();
            }
        }
    }

    public void receiveNutrients(){
        nutrients++;
    }

    public boolean update(){
        if (isDead)
        {
            return false;
        }
        for(Branch element:branchList)
        {
            for(Photosynthesizer leafElement:element.getLeafList())
            {
                leafElement.photosynthesize();
            }
        }
        nutrients = nutrients - trunkHeight;

        if(nutrients>trunkHeight)
        {
            grow();
        }
        if(nutrients<0)
        {
            die();
            return false;
        }
        return true;
    }

    public void die()
    {
        isDead = true;
        for(Branch element: branchList)
        {
            element.dropLeaves(true);
        }
    }

    public boolean isFruitingSeason(){
        return rand.nextInt(4) == 1;
    }
}
