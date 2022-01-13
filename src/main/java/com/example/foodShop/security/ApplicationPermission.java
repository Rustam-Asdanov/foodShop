package com.example.foodShop.security;

public enum ApplicationPermission {

    DATA_READ("read all data"),
    DATA_EDIT("edit all data");

    private final String permissionInfo;

    ApplicationPermission(String permissionInfo) {
        this.permissionInfo = permissionInfo;
    }

    public String getPermissionInfo() {
        return permissionInfo;
    }
}
