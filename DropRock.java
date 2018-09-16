/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username.scriptname;

import java.util.Random;
import org.powerbot.script.rt4.ClientContext;
import org.powerbot.script.rt4.Item;

public class Drop extends Task<ClientContext>
{
    private int rockId = 440;
    public Drop(ClientContext ctx)
    {
        super(ctx);
    }
    
    @Override
    public boolean activate()
    {
       // Random rand = new Random();
       // int n = rand.nextInt(30)+1;
        return ctx.inventory.select().count() == 28; //&& ((n==5) || (n==23));
    }
    
    @Override
    public void execute()
    {
        while(!drop());
    }
    
    public boolean drop()
    {
            ctx.input.send("{VK_SHIFT down}");
            for(Item i: ctx.inventory.select().id(rockId))
            {
                if(!i.click(true))
                {
                    ctx.input.send("{VK_SHIFT up}");
                    return false;
                }
            }
            ctx.input.send("{VK_SHIFT up}");
            return true;
        
       /* for(Item i: ctx.inventory.select().id(rockId))
        {
            if(!i.interact("Drop"))
                return false;
        }
        return true;*/
    }
}

