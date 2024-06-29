package com.kkorkunc.notifier.domain.message;

import com.kkorkunc.notifier.domain.message.exception.ContentLengthExceededException;
import com.kkorkunc.notifier.domain.message.sender.Sender;
import com.kkorkunc.notifier.domain.message.exception.MessageAlreadySentException;
import lombok.*;
import lombok.experimental.FieldDefaults;

@FieldDefaults(level = AccessLevel.PRIVATE)
@NoArgsConstructor
@RequiredArgsConstructor
@Getter
public class Message {
    private static final int MAX_CONTENT_LENGTH = 500;

    @NonNull Long id;
    @NonNull String recipientPhoneNumber;
    @NonNull String content;
    @NonNull MessageStatus status;

    public void send(Sender sender) {
        if (MessageStatus.SENT.equals(status)) {
            throw new MessageAlreadySentException("Message already sent!");
        }

        if (MAX_CONTENT_LENGTH < content.length()) {
            throw new ContentLengthExceededException(String.valueOf(MAX_CONTENT_LENGTH));
        }
        sender.send(this);
    }

    public void markAsSent() {
        this.status = MessageStatus.SENT;
    }
}
