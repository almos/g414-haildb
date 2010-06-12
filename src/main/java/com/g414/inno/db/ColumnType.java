package com.g414.inno.db;

import com.g414.inno.jna.impl.InnoDB;

public enum ColumnType {
    /* see InnoDB.ib_col_type_t */
    UNUSED(0), VARCHAR(InnoDB.ib_col_type_t.IB_VARCHAR), CHAR(
            InnoDB.ib_col_type_t.IB_CHAR), BINARY(
            InnoDB.ib_col_type_t.IB_BINARY), VARBINARY(
            InnoDB.ib_col_type_t.IB_VARBINARY), BLOB(
            InnoDB.ib_col_type_t.IB_BLOB), INT(InnoDB.ib_col_type_t.IB_INT), SYS(
            InnoDB.ib_col_type_t.IB_SYS), FLOAT(InnoDB.ib_col_type_t.IB_FLOAT), DOUBLE(
            InnoDB.ib_col_type_t.IB_DOUBLE), DECIMAL(
            InnoDB.ib_col_type_t.IB_DECIMAL), VARCHAR_ANYCHARSET(
            InnoDB.ib_col_type_t.IB_VARCHAR_ANYCHARSET), CHAR_ANYCHARSET(
            InnoDB.ib_col_type_t.IB_CHAR_ANYCHARSET);

    private final int code;

    private ColumnType(int code) {
        this.code = code;
    }

    public int getCode() {
        return code;
    }

    public static ColumnType fromCode(int code) {
        return ColumnType.values()[code];
    }

    public boolean isByteArrayType() {
        switch (this.code) {
        case InnoDB.ib_col_type_t.IB_BINARY:
        case InnoDB.ib_col_type_t.IB_VARBINARY:
        case InnoDB.ib_col_type_t.IB_BLOB:
            return true;
        default:
            return false;
        }
    }

    public boolean isStringType() {
        switch (this.code) {
        case InnoDB.ib_col_type_t.IB_VARCHAR:
        case InnoDB.ib_col_type_t.IB_CHAR:
        case InnoDB.ib_col_type_t.IB_VARCHAR_ANYCHARSET:
        case InnoDB.ib_col_type_t.IB_CHAR_ANYCHARSET:
            return true;
        default:
            return false;
        }
    }

    public boolean isIntegerType() {
        return this.code == InnoDB.ib_col_type_t.IB_INT;
    }
}
