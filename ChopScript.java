
package username.scriptname;

import org.powerbot.script.PollingScript;
import org.powerbot.script.Script;
import org.powerbot.script.rt4.ClientContext;
import java.util.*;

@Script.Manifest(name="ChopScript",description="This chops stuff",properties="client=4; topic =123456789; author=Kevin;")
public class ChopScript extends PollingScript<ClientContext>{
    private List<Task> taskList = new ArrayList<Task>();
    @Override
    public void start(){
        taskList.addAll(Arrays.asList(new Chop(ctx), new Drop(ctx)));
    }
    
    @Override
    public void poll()
    {
        for (Task task: taskList)
        {
            if(task.activate())
            {
                task.execute();
            }
        }
    }
    
}
