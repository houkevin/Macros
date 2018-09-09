/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username.scriptname;
import java.util.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Chop extends Task<ClientContext>
{
    private int[] treeId = {1750};
    
    public Chop(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate()
    {
        Random rand = new Random();
        int n = rand.nextInt(30)+1;
        return ctx.inventory.select().count()<28 
                && !ctx.objects.select().id(treeId).isEmpty() 
                && ctx.players.local().animation()==-1 
                && !ctx.players.local().inMotion() 
                &&ctx.inventory.select().count()!=28
                && (n==12 || n == 22);
    }
    
    @Override
    public void execute()
    {
        GameObject tree = ctx.objects.nearest().poll();
        if (tree.inViewport())
        {
            tree.interact("Chop");
        }
        else
        {
            ctx.movement.step(tree);
            ctx.camera.turnTo(tree);
        }
    }
}
