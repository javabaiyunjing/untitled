import java.awt.*;
import java.util.HashMap;
import java.util.Map;

public class ChatWindowContext {
    public static ChatWindowContext _self1 = null;

    public Map<String ,Object> map1 = new HashMap<String,Object>();

    private ChatWindowContext () {}

    public static ChatWindowContext getInstance1 () {
        if ( _self1 == null ){
            _self1 = new ChatWindowContext();
        }
        return _self1;
    }

    public Object getContext (String name ){
        return  map1.get(name);
     }
    public ChatWindowContext setContext (String name ,Object val) {
        map1.put(name,val);
        return  this ;
    }

}
