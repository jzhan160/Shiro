package com.demo.test.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import java.util.HashMap;

public class AnotherRealm extends AuthorizingRealm {
    private static HashMap<String,String> users = new HashMap<String, String>();
    static {
        users.put("a","37f53556c97b55daa3622f4a41958c2bec5fa283");
        users.put("b","4961965cf2a1609a25961deb7e912ee058e13e26");
    }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Authorize by other way");

        String username = (String) authenticationToken.getPrincipal();
        if (!users.containsKey(username))
            throw new UnknownAccountException();
        //add salt
        ByteSource credentialSalt = ByteSource.Util.bytes(username);
        AuthenticationInfo info = new SimpleAuthenticationInfo(
                username, users.get(username), credentialSalt,getName());
        //username, password, salt, realmName
        return info;
    }

    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        return null;
    }
}

