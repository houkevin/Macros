/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package username.scriptname;

import org.powerbot.script.ClientAccessor;
import org.powerbot.script.ClientContext;

public abstract class Task<C extends ClientContext> extends ClientAccessor<C>
{
    public Task(C ctx)
    {
        super(ctx);
    }
    
    public abstract boolean activate();
    public abstract void execute();
}
