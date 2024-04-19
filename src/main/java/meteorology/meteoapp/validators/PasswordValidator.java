package meteorology.meteoapp.validators;

public class PasswordValidator {
    public static boolean isValid(String password, String confirmPassword) {
        if (password.equals(confirmPassword) ) {
            return password.length() >= 8
                    && password.matches(".*[A-Z].*")
                    && password.matches(".*[a-z].*")
                    && password.matches(".*[0-9].*");
        }
        return false;
    }

    public static void main(String[] args) {
        System.out.println(isValid("password", "password"));
        System.out.println(isValid("password", "password1"));
        System.out.println(isValid("Password1", "Password1"));
    }
}