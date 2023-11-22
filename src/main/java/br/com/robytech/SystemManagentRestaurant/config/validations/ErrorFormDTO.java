package br.com.robytech.SystemManagentRestaurant.config.validations;

public class ErrorFormDTO {
    private String field;
    private String errorMessage;

    public ErrorFormDTO(String field, String error) {
        this.field = field;
        this.errorMessage = error;
    }

    public String getField() {
        return field;
    }

    public String getError() {
        return errorMessage;
    }

}
