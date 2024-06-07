package ru.guzshop.catalog.impl.model.data.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * Example of internal data transfer object (FOR DEMONSTRATION).
 */
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class UserData {

    private String firstName;
    private String lastName;
    private String mainPhoneNumber;
}
