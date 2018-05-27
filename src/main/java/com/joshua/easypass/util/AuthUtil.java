package com.joshua.easypass.util;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.apache.commons.lang.StringUtils;

import com.joshua.easypass.entity.Authlist;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class AuthUtil {
    private final static Logger logger = LoggerFactory.getLogger(AuthUtil.class);

    public static boolean hasAuthByAuthUrl(Authlist[] allAuthList, List<Authlist> authList, String servletPath) {
        boolean flag = false;
        Pattern pattern = null;
        if (allAuthList == null || allAuthList.length == 0) {
            return true;
        }
        for (Authlist auth : allAuthList) {
            if (StringUtils.isNotBlank(auth.getAuthUrl())) {
                pattern = Pattern.compile(auth.getAuthUrl());
                Matcher matcher = pattern.matcher(servletPath);
                if (matcher.matches()) {
                    flag = true;
                    break;
                }
            }
        }
        if (!flag) {
            return false;
        }
        if (authList != null && !authList.isEmpty()) {
            for (Authlist auth : authList) {
                if (StringUtils.isNotBlank(auth.getAuthUrl())) {
                    pattern = Pattern.compile(auth.getAuthUrl());
                    Matcher matcher = pattern.matcher(servletPath);
                    if (matcher.matches()) {
                        return true;
                    }
                }
                continue;
            }

        }
        return false;
    }


    public static boolean hasAuthByAuthData(List<Authlist> authList, String authData) {
        if (authList != null && !authList.isEmpty()) {
            for (Authlist auth : authList) {
                if (StringUtils.isNotBlank(auth.getAuthData())) {
                    if (auth.getAuthData().equalsIgnoreCase(authData)) {
                        return true;
                    } else {
                        continue;
                    }
                }
            }

        }
        return false;
    }


}
