package testdata;

import entity.LoginDetails;
import uk.co.jemos.podam.api.PodamFactory;
import uk.co.jemos.podam.api.PodamFactoryImpl;

public class LoginTestData
{
    private LoginTestData () {}

    private static final PodamFactory FACTORY = new PodamFactoryImpl();

    public static LoginDetails getLogindetails()
    {
        return FACTORY.manufacturePojo(LoginDetails.class);
    }

}
