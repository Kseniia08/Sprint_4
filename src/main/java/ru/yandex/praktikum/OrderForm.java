package ru.yandex.praktikum;
//Класс для формы заказа Самоката
public class OrderForm {
    private  String name;
    private  String surname;
    private  String address;
    private  String numberOfMetroStation;
    private  String phoneNumber;
    private  String orderDate ;
    private  String rentalPeriod;
    private  String scooterColour;
    private  String orderComment;
    //Конструктор для заказа Самоката
    public OrderForm(String name, String surname, String address, String numberOfMetroStation, String phoneNumber, String orderDate,
                     String rentalPeriod, String scooterColour, String orderComment) {
        this.name = name;
        this.surname = surname;
        this.address = address;
        this.numberOfMetroStation = numberOfMetroStation;
        this.phoneNumber = phoneNumber;
        this.orderDate = orderDate;
        this.rentalPeriod = rentalPeriod;
        this.scooterColour = scooterColour;
        this.orderComment = orderComment;}


    //Геттеры на све параметры
    public  String getName() {
        return name;
    }
    public  String getSurname() {
        return surname;
    }
    public String getAddress() {
        return address;
    }
    public  String getNumberOfMetroStation() {
        return numberOfMetroStation;
    }
    public  String getPhoneNumber() {
        return phoneNumber;
    }
    public  String getOrderDate() {
        return orderDate;
    }
    public  String getRentalPeriod() {
        return rentalPeriod;
    }
    public  String getScooterColour() {
        return scooterColour;
    }
    public  String getOrderComment() {
        return orderComment;
    }
}
