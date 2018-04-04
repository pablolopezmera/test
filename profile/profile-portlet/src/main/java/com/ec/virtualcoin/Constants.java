package com.ec.virtualcoin;

public enum Constants {
    
    PROFILE_FOLDER_LOCATION, PROFILE_DEFAULT_IMAGE;
    
    public String getPropertyName() {
        return this.name().toLowerCase().replace("_", ".");
    }
    
}
