
create table if not exists  oauth_client_details (
                                                     client_id varchar(255) not null,
                                                     client_secret varchar(255) not null,
                                                     web_server_redirect_uri varchar(2048) default null,
                                                     scope varchar(255) default null,
                                                     access_token_validity bigint default null,
                                                     refresh_token_validity bigint default null,
                                                     resource_ids varchar(1024) default null,
                                                     authorized_grant_types varchar(1024) default null,
                                                     authorities varchar(1024) default null,
                                                     additional_information varchar(4096) default null,
                                                     autoapprove varchar(255) default null,
                                                     primary key (client_id)
);

create table if not exists  permission (
                                           id bigint not null primary key ,
                                           name varchar(512) default null
) ;

create unique index permission_name_uindex
    on permission (name);

create table if not exists role (
                                    id bigint not null primary key ,
                                    name varchar(255) default null
) ;

create unique index role_name_uindex
    on role (name);


create table if not exists  users (
                                     id bigint not null primary key ,
                                     username varchar(100) not null,
                                     password varchar(1024) not null,
                                     email varchar(1024) not null,
                                     employee_number varchar (7) not null,
                                     birth_date date not null,
                                     birth_place varchar(50) not null,
                                     enabled boolean not null,
                                     accountNonExpired boolean not null,
                                     credentialsNonExpired boolean not null,
                                     accountNonLocked boolean not null
) ;

create unique index users_username_uindex
    on users (username);

create table  if not exists permission_role (
                                                permission_id bigint default null,
                                                role_id bigint default null,
                                                foreign key (permission_id) references permission (id),
                                                foreign key (role_id) references role (id),
                                                constraint permission_role_ibfk_1 foreign key (permission_id) references permission (id),
                                                constraint permission_role_ibfk_2 foreign key (role_id) references role (id)
) ;



create table if not exists role_user (
                                         role_id int default null,
                                         user_id int default null,
                                         foreign key (role_id) references role (id),
                                         foreign key (user_id) references users (id),
                                         constraint role_user_ibfk_1 foreign key (role_id) references role (id),
                                         constraint role_user_ibfk_2 foreign key (user_id) references users (id)
) ;

-- token store
create table if not exists oauth_client_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256)
);

create table if not exists oauth_access_token (
  token_id VARCHAR(256),
  token bytea,
  authentication_id VARCHAR(256) PRIMARY KEY,
  user_name VARCHAR(256),
  client_id VARCHAR(256),
  authentication bytea,
  refresh_token VARCHAR(256)
);

create table if not exists oauth_refresh_token (
  token_id VARCHAR(256),
  token bytea,
  authentication bytea
);

create table if not exists oauth_code (
  code VARCHAR(256), authentication bytea
);

create table if not exists oauth_approvals (
	userId VARCHAR(256),
	clientId VARCHAR(256),
	scope VARCHAR(256),
	status VARCHAR(10),
	expiresAt TIMESTAMP,
	lastModifiedAt TIMESTAMP
);








