package niffler.data.logging;

import io.qameta.allure.attachment.AttachmentData;

public class APIRequestAttachment implements AttachmentData {

    private final String preparedStatement;
    private final String name;
;

    public APIRequestAttachment(String preparedStatement,String name) {

        this.preparedStatement = preparedStatement;
        this.name = name;

    }

    public String getPreparedStatement() {
        return preparedStatement;
    }

    @Override
    public String getName() {
        return name;
    }





}
