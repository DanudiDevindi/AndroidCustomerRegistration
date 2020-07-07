package com.dnk.beginner.model;

public class CustomerDTO {

    private int customer_id;
    private String customer_name;
    private int customer_telephone;
    private String customer_password;

    public CustomerDTO() {
    }

    public CustomerDTO(int customer_id, String customer_name, int customer_telephone, String customer_password) {
        this.customer_id = customer_id;
        this.customer_name = customer_name;
        this.customer_telephone = customer_telephone;
        this.customer_password = customer_password;
    }

    public CustomerDTO(String customer_name, int customer_telephone, String customer_password) {
        this.customer_name = customer_name;
        this.customer_telephone = customer_telephone;
        this.customer_password = customer_password;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public String getCustomer_name() {
        return customer_name;
    }

    public void setCustomer_name(String customer_name) {
        this.customer_name = customer_name;
    }

    public int getCustomer_telephone() {
        return customer_telephone;
    }

    public void setCustomer_telephone(int customer_telephone) {
        this.customer_telephone = customer_telephone;
    }

    public String getCustomer_password() {
        return customer_password;
    }

    public void setCustomer_password(String customer_password) {
        this.customer_password = customer_password;
    }
}
