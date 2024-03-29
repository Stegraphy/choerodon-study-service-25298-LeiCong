package script.db

databaseChangeLog(logicalFilePath: 'script/db/study_user.groovy') {
    changeSet(author: 'jcalaz@163.com', id: '2018-03-21-iam-iam') {
        if (helper.dbType().isSupportSequence()) {
            createSequence(sequenceName: 'STUDY_USER_S', startValue: "1")
        }
        createTable(tableName: "STUDY_USER") {
            column(name: 'ID', type: 'BIGINT UNSIGNED', autoIncrement: true, remarks: '表ID，主键，供其他表做外键，unsigned bigint、单表时自增、步长为 1') {
                constraints(primaryKey: true, primaryKeyName: 'PK_STUDY_USER')
            }
            column(name: 'LOGIN_NAME', type: 'VARCHAR(128)', remarks: '用户名') {
                constraints(nullable: false)
                constraints(unique: true, uniqueConstraintName: 'UK_STUDY_USER_U1')
            }
            column(name: 'EMAIL', type: 'VARCHAR(128)', remarks: '电子邮箱地址') {
                constraints(nullable: false)
                constraints(unique: true, uniqueConstraintName: 'UK_STUDY_USER_U2')
            }

            column(name: 'ORGANIZATION_ID', type: 'BIGINT UNSIGNED', remarks: '组织ID') {
                constraints(nullable: false)
            }
            column(name: 'PASSWORD', type: 'VARCHAR(128)', remarks: 'Hash后的用户密码') {
                constraints(nullable: false)
            }
            column(name: 'REAL_NAME', type: 'VARCHAR(32)', remarks: '用户真实姓名')
            column(name: 'PHONE', type: 'VARCHAR(32)', remarks: '手机号')
            column(name: 'IMAGE_URL', type: 'VARCHAR(255)', remarks: '用户头像地址')
            column(name: 'PROFILE_PHOTO', type: 'MEDIUMTEXT', remarks: '用户二进制头像')
            column(name: 'LANGUAGE', type: 'VARCHAR(16)', defaultValue: "zh_CN", remarks: '语言') {
                constraints(nullable: false)
            }
            column(name: 'TIME_ZONE', type: 'VARCHAR(16)', defaultValue: "CTT", remarks: '时区') {
                constraints(nullable: false)
            }
            column(name: 'LAST_PASSWORD_UPDATED_AT', type: 'DATETIME', defaultValueComputed: "CURRENT_TIMESTAMP", remarks: '上一次密码更新时间') {
                constraints(nullable: false)
            }
            column(name: 'LAST_LOGIN_AT', type: 'DATETIME', remarks: '上一次登陆时间')
            column(name: 'IS_ENABLED', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '用户是否启用。1启用，0未启用') {
                constraints(nullable: false)
            }
            column(name: 'IS_LOCKED', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否锁定账户') {
                constraints(nullable: false)
            }
            column(name: 'IS_LDAP', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否是LDAP来源。1是，0不是')
            column(name: 'LOCKED_UNTIL_AT', type: 'DATETIME', remarks: '锁定账户截止时间')
            column(name: 'PASSWORD_ATTEMPT', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '密码输错累积次数')

            column(name: "OBJECT_VERSION_NUMBER", type: "BIGINT UNSIGNED", defaultValue: "1") {
                constraints(nullable: true)
            }
            column(name: "CREATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }
            column(name: "CREATION_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
            column(name: "LAST_UPDATED_BY", type: "BIGINT UNSIGNED", defaultValue: "0") {
                constraints(nullable: true)
            }
            column(name: "LAST_UPDATE_DATE", type: "DATETIME", defaultValueComputed: "CURRENT_TIMESTAMP")
        }
    }
    changeSet(author: 'jcalaz@163.com', id: '2018-05-28-add_column_is_admin') {
        addColumn(tableName: 'STUDY_USER') {
            column(name: 'IS_ADMIN', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否为管理员用户。1表示是，0表示不是')
        }
    }

    changeSet(author: 'superleader8@gmail.com', id: '2018-05-30-drop-is-admin') {
        dropDefaultValue(tableName: 'STUDY_USER', columnName: 'IS_ADMIN', columnDataType: 'TINYINT UNSIGNED')
        dropColumn(tableName: 'STUDY_USER', ColumnName: 'IS_ADMIN')
        addColumn(tableName: 'STUDY_USER') {
            column(name: 'IS_ADMIN', type: 'TINYINT UNSIGNED', defaultValue: "0", remarks: '是否为管理员用户。1表示是，0表示不是', afterColumn: 'IS_LDAP')
        }
    }

    changeSet(author: 'longhe1996@icloud.com', id: '2018-12-03-add_column_international_tel_code') {
        addColumn(tableName: 'STUDY_USER') {
            column(name: 'INTERNATIONAL_TEL_CODE', type: 'VARCHAR(16)', defaultValue: "+86", remarks: '国际电话区号。',afterColumn: 'PHONE')
        }
    }

    changeSet(author: 'superlee', id: '2019-03-20-rename-password-column') {
        renameColumn(columnDataType: 'VARCHAR(128)', newColumnName: "HASH_PASSWORD", oldColumnName: "PASSWORD", remarks: 'Hash后的用户密码', tableName: 'STUDY_USER')
    }

    changeSet(author: 'superlee', id: '2019-07-18-iam-user-add-remark') {
        setTableRemarks(tableName:"STUDY_USER",remarks: "用户表")
    }
}