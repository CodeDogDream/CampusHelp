//package unuse;
//
//import org.apache.shiro.SecurityUtils;
//import org.apache.shiro.authc.AuthenticationException;
//import org.apache.shiro.authc.AuthenticationInfo;
//import org.apache.shiro.authc.AuthenticationToken;
//import org.apache.shiro.authc.UsernamePasswordToken;
//import org.apache.shiro.authz.AuthorizationInfo;
//import org.apache.shiro.realm.AuthorizingRealm;
//import org.apache.shiro.subject.PrincipalCollection;
//import org.apache.shiro.subject.Subject;
//
///**
// * Created by Dream on 2017/3/10.
// */
//public class MyRealm extends AuthorizingRealm {
//
//    /***
//     * 授权方法
//     * @param principals
//     * @return
//     */
//    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principals) {
//        return null;
//    }
//
//    /****
//     * 认证方法
//     * @param token
//     * @return
//     * @throws AuthenticationException
//     */
//    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken token) throws AuthenticationException {
//       Subject subject= SecurityUtils.getSubject();
//       subject.login(token);
//        return null;
//    }
//}
