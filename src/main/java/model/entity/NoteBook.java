package model.entity;

import model.dto.NotUniqueData;

import java.util.ArrayList;
import java.util.List;

public class NoteBook {
    private List<User> userList = new ArrayList<>();

    public List<User> getUserList() {
        return userList;
    }

    private NotUniqueData notUniqueData = new NotUniqueData();

    public void tryToAddUser(User user) throws NotUniqueFieldException {
        boolean isUserUnique = true;
        for (DBEmulation note : DBEmulation.values()) {
            if (note.getLogin().equals(user.getLogin())) {
                isUserUnique = false;
                notUniqueData.setLogin(user.getLogin());
            }
            else notUniqueData.setLogin(null);
            if (note.getEmail().equals(user.getEmail())) {
                isUserUnique = false;
                notUniqueData.setEmail(user.getEmail());
            }
            else notUniqueData.setEmail(null);
        }

        if (!isUserUnique) {
            throw new NotUniqueFieldException("Вказаний логін або електронна пошта вже зайняті", notUniqueData); }
        else userList.add(user);
    }
}






