package user;

public class User {
    public String getUesername() {
        return uesername;
    }

    public void setUesername(String uesername) {
        this.uesername = uesername;
    }

    public String getPasswoed() {
        return passwoed;
    }

    public void setPasswoed(String passwoed) {
        this.passwoed = passwoed;
    }

    String uesername,passwoed;
    public boolean userLogin(String username,String passwoed){
        return false;
    }

}
