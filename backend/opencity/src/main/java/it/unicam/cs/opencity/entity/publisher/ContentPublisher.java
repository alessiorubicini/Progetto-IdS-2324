package it.unicam.cs.opencity.entity.publisher;

import it.unicam.cs.opencity.entity.Content;
import org.springframework.web.util.HtmlUtils;

// This class is responsible of content publication
public abstract class ContentPublisher {

    protected Integer cityId;
    /**
     * This method calls the step methods in a specific order.
     * @param content the content to publish
     * @param cityId the id of the city
     */
    public void publish(Content content, Integer cityId) {
        this.cityId = cityId;
        sanitizeContent(content);
        sendContent(content);
        notifyResponsible();
    }

    /**
     * This method is responsible for validating and cleaning various content attributes to prevent the insertion of malicious characters or scripts.
     * It ensures that the content is safe.
     * @param content the content to publish
     */
    public void sanitizeContent(Content content) {
        content.setTitle(HtmlUtils.htmlEscape(content.getTitle()));
        content.setDescription(HtmlUtils.htmlEscape(content.getDescription()));
        content.setMediaUrl(HtmlUtils.htmlEscape(content.getMediaUrl()));
    }

    public abstract void sendContent(Content content);

    public abstract void notifyResponsible();

}
//https://media.wired.co.uk/photos/606dadf3938ecee6e930efe0/master/w_1600%2Cc_limit/Doge_01.jpg