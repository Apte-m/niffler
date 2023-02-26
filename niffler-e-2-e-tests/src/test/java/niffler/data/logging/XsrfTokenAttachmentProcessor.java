package niffler.data.logging;


import io.qameta.allure.Allure;
import io.qameta.allure.attachment.AttachmentProcessor;
import io.qameta.allure.attachment.AttachmentRenderer;

public class XsrfTokenAttachmentProcessor implements AttachmentProcessor<APIRequestAttachment>  {

    @Override
    public void addAttachment(APIRequestAttachment attachmentData, AttachmentRenderer<APIRequestAttachment> renderer) {
        Allure.addAttachment(attachmentData.getName(), attachmentData.getPreparedStatement());




    }


}