package fr.dopse.billandfriends.util;

import fr.dopse.billandfriends.exception.BillAndFriendsException;
import org.springframework.util.StringUtils;

/**
 * This class is usefull to avoid empty values.
 * Created by dopse.
 */
public class VerificationUtil {

    public static void mandatoryValue(Object... values) throws BillAndFriendsException {
        for (Object value : values) {
            if (StringUtils.isEmpty(value)) {
                throw new BillAndFriendsException("Value is mandatory");
            }
        }
    }

}
