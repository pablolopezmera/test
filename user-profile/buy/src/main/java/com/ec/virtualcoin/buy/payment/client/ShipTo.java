package com.ec.virtualcoin.buy.payment.client;

public class ShipTo {
    private String FirstName;
    private String LastName;
    private String Address;
    private String City;
    private String State;
    private String PostCode;
    private String Country;

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getCity() {
        return City;
    }

    public void setCity(String city) {
        City = city;
    }

    public String getState() {
        return State;
    }

    public void setState(String state) {
        State = state;
    }

    public String getPostCode() {
        return PostCode;
    }

    public void setPostCode(String postCode) {
        PostCode = postCode;
    }

    public String getCountry() {
        return Country;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public static class Builder {
        private String FirstName;
        private String LastName;
        private String Address;
        private String City;
        private String State;
        private String PostCode;
        private String Country;

        public Builder FirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public Builder LastName(String LastName) {
            this.LastName = LastName;
            return this;
        }

        public Builder Address(String Address) {
            this.Address = Address;
            return this;
        }

        public Builder City(String City) {
            this.City = City;
            return this;
        }

        public Builder State(String State) {
            this.State = State;
            return this;
        }

        public Builder PostCode(String PostCode) {
            this.PostCode = PostCode;
            return this;
        }

        public Builder Country(String Country) {
            this.Country = Country;
            return this;
        }

        public ShipTo build() {
            return new ShipTo(this);
        }
    }

    private ShipTo(Builder builder) {
        this.FirstName = builder.FirstName;
        this.LastName = builder.LastName;
        this.Address = builder.Address;
        this.City = builder.City;
        this.State = builder.State;
        this.PostCode = builder.PostCode;
        this.Country = builder.Country;
    }
}
