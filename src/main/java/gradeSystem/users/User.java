package users;

public abstract class User {
    protected String firstName;
    protected String secondName;
    protected String password;
    protected String userType;

    public User(String firstName, String secondName, String password, String userType) {
        this.firstName = firstName;
        this.secondName = secondName;
        this.password = password;
        this.userType = userType;
    }

    public boolean login(String password){
        return this.password.equals(password);
    }


}
