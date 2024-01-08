package entity;

import lombok.Data;
import uk.co.jemos.podam.common.PodamStringValue;

@Data
public class LoginDetails
{
    private LoginDetails () {}

    @PodamStringValue(strValue = "bob@example.com")
    private String userName;

    @PodamStringValue(strValue = "10203040")
    private String password;
}
