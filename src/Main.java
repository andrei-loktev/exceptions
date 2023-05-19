public class Main {

    private static final String REGEX = "^[a-zA-Z0-9_]*$";

    public static void main(String[] args) {

        try {
            check("demo", "20131", "2013");
        } catch (WrongLoginException | WrongPasswordException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void check(String login, String password, String confirmPassword)
            throws WrongLoginException, WrongPasswordException {
        if (!login.matches(REGEX)) {
            throw new WrongLoginException("неверный логин");
        }
        if (login.length() > 20) {
            throw new WrongLoginException("логин должен содержать не более 20 символов");
        }
        if (!password.matches(REGEX)) {
            throw new WrongPasswordException("неверный пароль");
        }
        if (password.length() > 20) {
            throw new WrongPasswordException("пароль должен быть строго меньше 20 символов");
        }
        if (!password.equals(confirmPassword)) {
            throw new WrongPasswordException("пароли не совпадают");
        }
    }
}