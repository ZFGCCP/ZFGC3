package com.zfgc.mappers;

import java.sql.JDBCType;
import javax.annotation.Generated;
import org.mybatis.dynamic.sql.SqlColumn;
import org.mybatis.dynamic.sql.SqlTable;

public final class LkupAllViewDbObjDynamicSqlSupport {
    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3329467-04:00", comments="Source Table: LKUP_ALL_VIEW")
    public static final LkupAllViewDbObj lkupAllViewDbObj = new LkupAllViewDbObj();

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3329467-04:00", comments="Source field: LKUP_ALL_VIEW.LKUP_TABLE")
    public static final SqlColumn<String> lkupTable = lkupAllViewDbObj.lkupTable;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3339473-04:00", comments="Source field: LKUP_ALL_VIEW.LKUP_NAME")
    public static final SqlColumn<String> lkupName = lkupAllViewDbObj.lkupName;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3339473-04:00", comments="Source field: LKUP_ALL_VIEW.LKUP_ID")
    public static final SqlColumn<Integer> lkupId = lkupAllViewDbObj.lkupId;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3339473-04:00", comments="Source field: LKUP_ALL_VIEW.LKUP_DESC")
    public static final SqlColumn<String> lkupDesc = lkupAllViewDbObj.lkupDesc;

    @Generated(value="org.mybatis.generator.api.MyBatisGenerator", date="2021-03-15T00:01:15.3329467-04:00", comments="Source Table: LKUP_ALL_VIEW")
    public static final class LkupAllViewDbObj extends SqlTable {
        public final SqlColumn<String> lkupTable = column("LKUP_TABLE", JDBCType.VARCHAR);

        public final SqlColumn<String> lkupName = column("LKUP_NAME", JDBCType.VARCHAR);

        public final SqlColumn<Integer> lkupId = column("LKUP_ID", JDBCType.INTEGER);

        public final SqlColumn<String> lkupDesc = column("LKUP_DESC", JDBCType.VARCHAR);

        public LkupAllViewDbObj() {
            super("LKUP_ALL_VIEW");
        }
    }
}