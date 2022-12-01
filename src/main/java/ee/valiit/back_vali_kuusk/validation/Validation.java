package ee.valiit.back_vali_kuusk.validation;

import ee.valiit.back_vali_kuusk.domain.userrole.user.User;
import ee.valiit.back_vali_kuusk.infrastructure.exception.BusinessException;

import java.util.Optional;

public class Validation {
    public static void validateUserCredentials(Optional<User> userOptional) {
        if (userOptional.isEmpty()) {
            throw new BusinessException(
                    ValiKuuskError.INCORRECT_CREDENTIALS.getMessage(),
                    ValiKuuskError.INCORRECT_CREDENTIALS.getErrorCode());
        }
    }

    public static void validateUsernameAvailable(boolean userNameExists) {
        if (userNameExists) {
            throw  new BusinessException(
                    ValiKuuskError.USERNAME_TAKEN.getMessage(),
                    ValiKuuskError.USERNAME_TAKEN.getErrorCode());

            // 11/30/2022 throw error
        } 
    }
}
