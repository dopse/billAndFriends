package fr.dopse.billandfriends.util;

import fr.dopse.billandfriends.exception.BillAndFriendsException;
import org.springframework.util.StringUtils;

/**
 * This class is usefull to avoid empty values.
 * Created by dopse.
 */
public class VerificationUtil {

    public static void mandatoryValue(Object... strings) throws BillAndFriendsException {
        for (Object string : strings) {
            if (StringUtils.isEmpty(string)) {
                throw new BillAndFriendsException("Value is mandatory");
            }
        }
    }

}
