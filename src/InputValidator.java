public class InputValidator 
{
    public static String validCreateUser(String username, String password, String passwordConfirm)
    {
        if (!username.matches("^[a-zA-Z0-9]*$"))
        {
            return "Invalid characters in username";
        }

        if(username.length() < 10 || username.length() > 20)
        {
            return "bad username length, 10 < N < 20";
        }

        if (password.compareTo(passwordConfirm) != 0)
        {
            return "Passwords do not match";
        }

        if (password.length() <= 6 || password.length() >= 24)
        {
            return "Bad passowrd length, 6 < N <24";
        }

        if(!password.matches("\\A\\p{ASCII}*\\z"))
        {
            return "Invalid characters in Password";
        }

        return "";
    }

    public static String validLogin(String username, String password)
    {
        if (!username.matches("^[a-zA-Z0-9]*$"))
        {
            return "Wrong username or password";
        }

        if(username.length() < 5 || username.length() > 20)
        {
            return "Wrong username or password";
        }

        if (password.length() <= 6 || password.length() >= 24)
        {
            return "Wrong username or password";
        }

        if(!password.matches("\\A\\p{ASCII}*\\z"))
        {
            return "Wrong username or password";
        }

        return "";
    }
}
