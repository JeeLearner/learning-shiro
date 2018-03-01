DELIMITER ;
delete from sys_user;
delete from sys_role;
delete from sys_resource;
delete from sys_organization;
delete from sys_url_filter;
delete from sys_user_runas;

insert into sys_user values(1,1,'admin','d3c59d25033dbf980d29554025c23a75','8d78869f470951332959580424d4bf4f', '1', false);
insert into sys_user values(2,1,'zhang','c6a02f6c9a5aaf311ec94009b6b024d0','588ae709311808bd7e5fade1c84407c7', '1', false);
insert into sys_user values(3,1,'wang','2e6f83bdaef108d4f23b2a1f2b9928cc','bd647b15f6724ea711272c4a3c6d16c0', '1', false);

insert into sys_organization values(1, '总公司', 0, '0/', true);
insert into sys_organization values(2, '分公司1', 1, '0/1/', true);
insert into sys_organization values(3, '分公司2', 1, '0/1/', true);
insert into sys_organization values(4, '分公司11', 2, '0/1/2/', true);

insert into sys_resource values(1, '资源', 'menu', '', 0, '0/', '', true);

insert into sys_resource values(11, '组织机构管理', 'menu', '/organization', 1, '0/1/', 'organization:*', true);
insert into sys_resource values(12, '组织机构新增', 'button', '', 11, '0/1/11/', 'organization:create', true);
insert into sys_resource values(13, '组织机构修改', 'button', '', 11, '0/1/11/', 'organization:update', true);
insert into sys_resource values(14, '组织机构删除', 'button', '', 11, '0/1/11/', 'organization:delete', true);
insert into sys_resource values(15, '组织机构查看', 'button', '', 11, '0/1/11/', 'organization:view', true);

insert into sys_resource values(21, '用户管理', 'menu', '/user', 1, '0/1/', 'user:*', true);
insert into sys_resource values(22, '用户新增', 'button', '', 21, '0/1/21/', 'user:create', true);
insert into sys_resource values(23, '用户修改', 'button', '', 21, '0/1/21/', 'user:update', true);
insert into sys_resource values(24, '用户删除', 'button', '', 21, '0/1/21/', 'user:delete', true);
insert into sys_resource values(25, '用户查看', 'button', '', 21, '0/1/21/', 'user:view', true);

insert into sys_resource values(31, '资源管理', 'menu', '/resource', 1, '0/1/', 'resource:*', true);
insert into sys_resource values(32, '资源新增', 'button', '', 31, '0/1/31/', 'resource:create', true);
insert into sys_resource values(33, '资源修改', 'button', '', 31, '0/1/31/', 'resource:update', true);
insert into sys_resource values(34, '资源删除', 'button', '', 31, '0/1/31/', 'resource:delete', true);
insert into sys_resource values(35, '资源查看', 'button', '', 31, '0/1/31/', 'resource:view', true);

insert into sys_resource values(41, '角色管理', 'menu', '/role', 1, '0/1/', 'role:*', true);
insert into sys_resource values(42, '角色新增', 'button', '', 41, '0/1/41/', 'role:create', true);
insert into sys_resource values(43, '角色修改', 'button', '', 41, '0/1/41/', 'role:update', true);
insert into sys_resource values(44, '角色删除', 'button', '', 41, '0/1/41/', 'role:delete', true);
insert into sys_resource values(45, '角色查看', 'button', '', 41, '0/1/41/', 'role:view', true);

insert into sys_resource values(46, 'URL管理', 'menu', '/urlFilter', 1, '0/1/', 'urlFilter:*', true);
insert into sys_resource values(47, 'URL新增', 'button', '', 46, '0/1/46/', 'urlFilter:create', true);
insert into sys_resource values(48, 'URL修改', 'button', '', 46, '0/1/46/', 'urlFilter:update', true);
insert into sys_resource values(49, 'URL删除', 'button', '', 46, '0/1/46/', 'urlFilter:delete', true);
insert into sys_resource values(50, 'URL查看', 'button', '', 46, '0/1/46/', 'urlFilter:view', true);

INSERT INTO sys_resource VALUES(51, '会话管理', 'menu', '/sessions', 1, '0/1/', 'session:*', TRUE);

insert into sys_role values(1, 'admin', '超级管理员', '11,21,31,41,46', true);