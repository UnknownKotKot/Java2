package ServerSide.service;

import ServerSide.interfaces.AuthenticationService;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class AuthenticationServiceImpl implements AuthenticationService {

    private List<User> usersList;

    public AuthenticationServiceImpl() {
        usersList =  new ArrayList<>();///далее это будет делаться через БД
        usersList.add(new User("A", "A", "A"));
        usersList.add(new User("B", "B", "B"));
        usersList.add(new User("C", "C", "C"));
    }

    @Override
    public void start() {
        System.out.println("Start");
    }

    @Override
    public void stop() {
        System.out.println("Stop");
    }

    @Override
    public String getNickByLoginAndPassword(String login, String password) {
        return usersList.stream()
                .map(a->{
                    if(a.login.equals(login) && a.password.equals(password) ){
                        return a.nickName;
                    }
                    return "";
                })
                .collect(Collectors.joining());
    }

    private class User{
        private String login;
        private String password;
        private String nickName;

        public User(String login, String password, String nickName) {
            this.login = login;
            this.password = password;
            this.nickName = nickName;
        }
    }

}
