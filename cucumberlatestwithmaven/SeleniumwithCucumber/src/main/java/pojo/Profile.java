package pojo;

public class Profile {
    private String firstName;

    public String getFirstName ()
    {
        return firstName;
    }

    public void setFirstName (String firstName)
    {
        this.firstName = firstName;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [firstName = "+firstName+"]";
    }

}
