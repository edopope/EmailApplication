package EmailApplication2.EmailApplication2.exceptions;

public class LoginExceptionForUsers extends Exception{
    public LoginExceptionForUsers() {
    }

    public LoginExceptionForUsers(String message) {
        super(message);
    }
}
