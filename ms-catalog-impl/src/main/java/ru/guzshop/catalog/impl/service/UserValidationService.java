package ru.guzshop.catalog.impl.service;

import static org.apache.commons.lang3.StringUtils.isNoneBlank;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.guzshop.catalog.impl.model.data.user.UserData;

/**
 * Example of implementation specific service (FOR DEMONSTRATION).
 */
@Service
@RequiredArgsConstructor
public class UserValidationService {

    /**
     * Example of working with external user data for some business login (FOR DEMONStRATION).
     */
    public boolean isAllowedForRegisteringOrder(UserData userData) {
        return isNoneBlank(userData.getMainPhoneNumber());
    }
}
