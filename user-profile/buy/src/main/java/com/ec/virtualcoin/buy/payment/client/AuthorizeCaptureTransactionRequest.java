package com.ec.virtualcoin.buy.payment.client;

public class AuthorizeCaptureTransactionRequest {
    private String Reference;
    private float Amount;
    private String Currency;
    private String Email;
    private String IPAddress;
    private String Phone;
    private String FirstName;
    private String LastName;
    private int DOB;
    private short SSN;
    private String Address;
    private String City;
    private String State;
    private short PostCode;
    private String Country;
    private long CardNumber;
    private byte CardExpMonth;
    private short CardExpYear;
    private byte CardCVV;
    private ShipTo ShipTo;

    public static class Builder {
        private String Reference;
        private float Amount;
        private String Currency;
        private String Email;
        private String IPAddress;
        private String Phone;
        private String FirstName;
        private String LastName;
        private int DOB;
        private short SSN;
        private String Address;
        private String City;
        private String State;
        private short PostCode;
        private String Country;
        private long CardNumber;
        private byte CardExpMonth;
        private short CardExpYear;
        private byte CardCVV;
        private ShipTo ShipTo;

        public Builder Reference(String Reference) {
            this.Reference = Reference;
            return this;
        }

        public Builder Amount(float Amount) {
            this.Amount = Amount;
            return this;
        }

        public Builder Currency(String Currency) {
            this.Currency = Currency;
            return this;
        }

        public Builder Email(String Email) {
            this.Email = Email;
            return this;
        }

        public Builder IPAddress(String IPAddress) {
            this.IPAddress = IPAddress;
            return this;
        }

        public Builder Phone(String Phone) {
            this.Phone = Phone;
            return this;
        }

        public Builder FirstName(String FirstName) {
            this.FirstName = FirstName;
            return this;
        }

        public Builder LastName(String LastName) {
            this.LastName = LastName;
            return this;
        }

        public Builder DOB(int DOB) {
            this.DOB = DOB;
            return this;
        }

        public Builder SSN(short SSN) {
            this.SSN = SSN;
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

        public Builder PostCode(short PostCode) {
            this.PostCode = PostCode;
            return this;
        }

        public Builder Country(String Country) {
            this.Country = Country;
            return this;
        }

        public Builder CardNumber(long CardNumber) {
            this.CardNumber = CardNumber;
            return this;
        }

        public Builder CardExpMonth(byte CardExpMonth) {
            this.CardExpMonth = CardExpMonth;
            return this;
        }

        public Builder CardExpYear(short CardExpYear) {
            this.CardExpYear = CardExpYear;
            return this;
        }

        public Builder CardCVV(byte CardCVV) {
            this.CardCVV = CardCVV;
            return this;
        }

        public Builder ShipTo(ShipTo ShipTo) {
            this.ShipTo = ShipTo;
            return this;
        }

        public AuthorizeCaptureTransactionRequest build() {
            return new AuthorizeCaptureTransactionRequest(this);
        }

        public Builder PostCode(String postCode) {
            if (postCode!=null && !postCode.isEmpty()) {
                this.PostCode = Short.valueOf(postCode);
            }
            return this;
        }
    }

    private AuthorizeCaptureTransactionRequest(Builder builder) {
        this.Reference = builder.Reference;
        this.Amount = builder.Amount;
        this.Currency = builder.Currency;
        this.Email = builder.Email;
        this.IPAddress = builder.IPAddress;
        this.Phone = builder.Phone;
        this.FirstName = builder.FirstName;
        this.LastName = builder.LastName;
        this.DOB = builder.DOB;
        this.SSN = builder.SSN;
        this.Address = builder.Address;
        this.City = builder.City;
        this.State = builder.State;
        this.PostCode = builder.PostCode;
        this.Country = builder.Country;
        this.CardNumber = builder.CardNumber;
        this.CardExpMonth = builder.CardExpMonth;
        this.CardExpYear = builder.CardExpYear;
        this.CardCVV = builder.CardCVV;
        this.ShipTo = builder.ShipTo;
    }

    public String getReference() {
        return Reference;
    }

    public float getAmount() {
        return Amount;
    }

    public String getCurrency() {
        return Currency;
    }

    public String getEmail() {
        return Email;
    }

    public String getIPAddress() {
        return IPAddress;
    }

    public String getPhone() {
        return Phone;
    }

    public String getFirstName() {
        return FirstName;
    }

    public String getLastName() {
        return LastName;
    }

    public int getDOB() {
        return DOB;
    }

    public void setDOB(int dob) {
        DOB = dob;
    }

    public short getSSN() {
        return SSN;
    }

    public String getAddress() {
        return Address;
    }

    public String getCity() {
        return City;
    }

    public String getState() {
        return State;
    }

    public short getPostCode() {
        return PostCode;
    }

    public String getCountry() {
        return Country;
    }

    public long getCardNumber() {
        return CardNumber;
    }

    public byte getCardExpMonth() {
        return CardExpMonth;
    }

    public short getCardExpYear() {
        return CardExpYear;
    }

    public byte getCardCVV() {
        return CardCVV;
    }

    public ShipTo getShipTo() {
        return ShipTo;
    }
}
