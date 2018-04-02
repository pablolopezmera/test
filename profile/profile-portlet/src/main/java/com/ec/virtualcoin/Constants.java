package com.ec.virtualcoin;

public enum Constants {
    
    PROFILE_FOLDER_LOCATION;
    
    public String getPropertyName() {
        return this.name().toLowerCase().replace("_", ".");
    }
    
}
