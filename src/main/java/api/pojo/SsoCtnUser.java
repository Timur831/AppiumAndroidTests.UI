package api.pojo;

public class SsoCtnUser {
    public String linkedAccountPassword;
    public String linkedAccountLogin;
    public String userType;
    public String nickName;
    public String login;

    public SsoCtnUser() {
    }

    public SsoCtnUser(String linkedAccountPassword, String linkedAccountLogin, String login) {
        this.linkedAccountPassword = linkedAccountPassword;
        this.linkedAccountLogin = linkedAccountLogin;
        this.login = login;
    }

    public SsoCtnUser(String linkedAccountPassword, String login) {
        this.linkedAccountPassword = linkedAccountPassword;
        this.login = login;
    }
}
