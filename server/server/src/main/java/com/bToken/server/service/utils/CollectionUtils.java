package com.bToken.server.service.utils;

import java.util.List;

public class CollectionUtils {
 
    public static Boolean isEmpty(List<?> list){
        return list == null || list.isEmpty();
    }

}
