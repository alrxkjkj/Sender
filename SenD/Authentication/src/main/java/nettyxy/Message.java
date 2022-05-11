package nettyxy;

import java.io.Serializable;

public abstract class Message implements Serializable {
    public static final int UserLogin = 1;
    public static final int Userzc = 2;
    public abstract int getMessage();
}
