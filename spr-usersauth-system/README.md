做一个通用的用户中心
# 用户中心微服务

### 设计思想

- 使用redis做二级缓存。
- 查询时，先查询redis，如果redis中没有数据，再查询数据库，并将查询结果缓存到redis中。 
- 权限通过在方法上添加注解@Permission(menu="菜单编码",value="操作编码")，由PermissionAop拦截器拦截验证。
- 全局统一异常处理，提高接口健壮性。
- 服务层分为两类，一类DAO服务用于访问数据库，一类Redis服务用于访问缓存。业务逻辑Service用于控制数据访问。
- 统一redis操作工具类RedisHashUtils。
- 统一redis服务操作接口RedisService。


### 数据库设计

- sys_user（用户表）
- sys_role（角色表）
- sys_permission（权限表）
- sys_role_permission（角色权限表）
- sys_user_log（用户访问日志表）

说明：一个用户只能属于一个角色。

### Redis Key的设计

- USERS（用户HASH类型）
- USERS_PAGES（用户分页HASH类型）
- ROLES（角色HASH类型）
- ROLES_PAGES（角色分页HASH类型）
- PERMISSIONS（权限HASH类型）
- PERMISSIONSTREE（权限树HASH类型）
- PERMISSIONS_PAGES（权限分页HASH类型）
- TREE-ROLE（权限角色HASH类型）
- TREE（权限树HASH类型）
- NODE（权限节点HASH类型）

每种业务类型都可以包含分页数据：

- PAGE-...（存储每页数据缓存前缀）
- PAGE-ALL（存储全部数据缓存）




