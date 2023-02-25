package niffler.data.logging;

import io.qameta.allure.attachment.AttachmentData;

public class APIRequestAttachment implements AttachmentData {

    private final String preparedStatement;
;

    public APIRequestAttachment( String preparedStatement) {

        this.preparedStatement = preparedStatement;

    }

    public String getPreparedStatement() {
        return preparedStatement;
    }



    @Override
    public String getName() {
        return "XSRF-TOKEN";
    }
}
