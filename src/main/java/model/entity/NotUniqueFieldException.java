package model.entity;

import model.dto.NotUniqueData;

public class NotUniqueFieldException extends Exception {
    private String message;
    private NotUniqueData notUniqueData;

    public NotUniqueData getNotUniqueData() {return notUniqueData;}

    public NotUniqueFieldException(String message, NotUniqueData notUniqueData) {
        super(message);
        this.notUniqueData = notUniqueData;
    }
}