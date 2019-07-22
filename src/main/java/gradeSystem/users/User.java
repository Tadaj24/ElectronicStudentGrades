package gradeSystem.users;


import java.util.Objects;

public abstract class User {

    protected String firstName;

    protected String lastName;

    protected String password;

    protected String userType;

    public User(String firstName, String lastName, String password, String userType) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.password = password;
        this.userType = userType;
    }

    public boolean login(String password){
        return this.password.equals(password);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(firstName, user.firstName) &&
                Objects.equals(lastName, user.lastName) &&
                Objects.equals(userType, user.userType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, userType);
    }

    @Override
    public String toString() {
        return String.format("%s %s, %s", firstName, lastName, userType);
    }
}
