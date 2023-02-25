package niffler.data.logging;


import io.qameta.allure.Allure;
import io.qameta.allure.attachment.AttachmentProcessor;
import io.qameta.allure.attachment.AttachmentRenderer;
import niffler.api.interceptops.ReceivedCookieRespInterceptor;

public class XsrfTokenAttachmentProcessor implements AttachmentProcessor<APIRequestAttachment> {



    @Override
    public void addAttachment(APIRequestAttachment attachmentData, AttachmentRenderer<APIRequestAttachment> renderer) {

        System.out.println(attachmentData.getName());
        System.out.println(attachmentData.getPreparedStatement());
        System.out.println(renderer);
        Allure.addAttachment(attachmentData.getName(), String.valueOf(new ReceivedCookieRespInterceptor()));

    }
}