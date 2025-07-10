package model.nopcommerce;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class AddAddressPOJO {
    private String firstName;
    private String lastName;
    private String email;
    private String company;
    private String country;
    private String stateProvince;
    private String city;
    private String address1;
    private String address2;
    private String zipPostalCode;
    private String phoneNumber;
    private String faxNumber;
}
