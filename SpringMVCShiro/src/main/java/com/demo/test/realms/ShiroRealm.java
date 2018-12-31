package com.demo.test.realms;

import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.realm.Realm;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.util.ByteSource;

import javax.naming.ldap.HasControls;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class ShiroRealm extends AuthorizingRealm {
    private static HashMap<String,String> users = new HashMap<String, String>();
    static {
        users.put("a","462e234451b570ea1ce73238dac4cd79");
        users.put("b","828a0869c6e6f6b4702dbfdb5addd4e5");
     }
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("Authorize by username");
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
        String username = (String) principalCollection.getPrimaryPrincipal();
        SimpleAuthorizationInfo authorizationInfo = new SimpleAuthorizationInfo();
        Set<String> roles = new HashSet<String>();
        roles.add("user");
        if (username.equals("a"))
            roles.add("admin");
        authorizationInfo.setRoles(roles);
        return authorizationInfo;
    }
}
