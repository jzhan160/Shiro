package com.demo.test.factory;

import java.util.LinkedHashMap;

public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String,String> buildMap(){
        //ensure the order
        LinkedHashMap<String,String> map = new LinkedHashMap<String, String>();
        /*
        * /index = anon
                /logout = logout
                /user = roles[user]
                /admin = roles[admin]
                # everything else requires authentication:
                /** = authc

        * */
        map.put("/index","anon");
        map.put("/logout","logout");
        map.put("/user","authc,roles[user]");
        map.put("/admin","authc,roles[admin]");
        map.put("/success","user");
        map.put("/**","authc");
        return map;
    }
}
