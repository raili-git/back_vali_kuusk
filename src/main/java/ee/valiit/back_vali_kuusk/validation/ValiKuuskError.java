package ee.valiit.back_vali_kuusk.validation;

import lombok.Getter;

@Getter
public enum ValiKuuskError {
    INCORRECT_CREDENTIALS("Sellist kasutajanime või parooli ei leitud","666");

    private final String message;
    private final String errorCode;

    ValiKuuskError(String message, String errorCode) {
        this.message = message;

        this.errorCode = errorCode;
    }
}
