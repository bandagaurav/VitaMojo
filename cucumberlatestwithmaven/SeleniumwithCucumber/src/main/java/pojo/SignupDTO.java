package pojo;

public class SignupDTO {

    private String[] subscriptions;

    private String password;

    private String storeUUID;

    private Profile profile;

    private String locale;

    private String email;

    public String[] getSubscriptions ()
    {
        return subscriptions;
    }

    public void setSubscriptions (String[] subscriptions)
    {
        this.subscriptions = subscriptions;
    }

    public String getPassword ()
    {
        return password;
    }

    public void setPassword (String password)
    {
        this.password = password;
    }

    public String getStoreUUID ()
    {
        return storeUUID;
    }

    public void setStoreUUID (String storeUUID)
    {
        this.storeUUID = storeUUID;
    }

    public Profile getProfile ()
    {
        return profile;
    }

    public void setProfile (Profile profile)
    {
        this.profile = profile;
    }

    public String getLocale ()
    {
        return locale;
    }

    public void setLocale (String locale)
    {
        this.locale = locale;
    }

    public String getEmail ()
    {
        return email;
    }

    public void setEmail (String email)
    {
        this.email = email;
    }

    @Override
    public String toString()
    {
        return "ClassPojo [subscriptions = "+subscriptions+", password = "+password+", storeUUID = "+storeUUID+", profile = "+profile+", locale = "+locale+", email = "+email+"]";
    }
}
