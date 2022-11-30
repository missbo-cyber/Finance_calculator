import java.util.HashMap;

public class IDandPasswords {
    HashMap <String,String> logininfo = new HashMap<String,String>();
    IDandPasswords (){
        logininfo.put("missbo","pizza");// the name of a user and his password
        logininfo.put("missbo1","hotdog");
        logininfo.put("missbo2","hamburger");
    }
    protected HashMap getlogininfo(){
        return logininfo;
    }


}
