/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username.scriptname;
import java.util.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.GameObject;

public class Mine extends Task<ClientContext>
{
    private int[] rockId = {7455,7488};
    
    public Mine(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate()
    {
        Random rand = new Random();
        int n = rand.nextInt(30)+1;
        return ctx.inventory.select().count()<28 
                && !ctx.objects.select().id(rockId).isEmpty() 
                && ctx.players.local().animation()==-1 
                && !ctx.players.local().inMotion() 
                &&ctx.inventory.select().count()!=28
                && (n==12 || n == 22);
    }
    
    @Override
    public void execute()
    {
        GameObject rock = ctx.objects.nearest().poll();
        if (rock.inViewport())
        {
            rock.interact("Mine");
        }
        else
        {
            ctx.movement.step(rock);
            ctx.camera.turnTo(rock);
        }
    }
}