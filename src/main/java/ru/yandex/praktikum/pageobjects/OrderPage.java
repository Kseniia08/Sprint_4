package ru.yandex.praktikum.pageobjects;
import org.openqa.selenium.By;
import ru.yandex.praktikum.BaseSeleniumPage;
import ru.yandex.praktikum.OrderForm;


public class OrderPage extends BaseSeleniumPage {
    //Форма заказа самоката
    //Поле Имя
    private final By nameField = By.xpath("//input[@placeholder='* Имя']");
    //Поле Фамилия
    private final By surnameField = By.xpath("//input[@placeholder='* Фамилия']");
    //Поле Адрес
    private final By addressField = By.xpath("//input[@placeholder='* Адрес: куда привезти заказ']");
    //Поле Станция метро
    private final  By metroStationField = By.xpath("//input[@placeholder='* Станция метро']");
    //Базовый локатор для станции метро
    private static String numberMetroStationFromMetroStationList = "//li[@class='select-search__row' and @data-value='%s']";
    //Поле Телефон
    private final By phoneNumberField = By.xpath("//input[@placeholder='* Телефон: на него позвонит курьер']");

    //Кнопка Далее
    private final By nextButtonField = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Поле Когда привезти самокат
    private final By startRentDateField = By.xpath("//input[@placeholder='* Когда привезти самокат']");
    //Поле Срок аренды
    private final By rentDurationField = By.xpath("//div[@class='Dropdown-placeholder']");
    //Базовый локатор для Периода аренды самоката
    private String xpathRentalPeriodDropDown = "//div[@class='Dropdown-option' and text() = '%s']";


    //Базовый локатор для поля Цвет самоката
    private static String scooterColourFromMainPage = "//input[@id='%s']";

    //Комментарий для курьера
    private final By commentForCourier = By.xpath("//input[@class='Input_Input__1iN_Z Input_Responsible__1jDKN']");
    //Кнопка заказать
    private final By orderButtonOnOrderPage = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM']");

    //Предупреждение Хотите оформить заказ?
    //Кнопка Да
    private By yesOrderButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Да']");

    //Кнопка после оформления заказа "Посмотреть статус"
    private By checkOrderStatusButton = By.xpath("//button[@class='Button_Button__ra12g Button_Middle__1CSJM' and text()='Посмотреть статус']");

    //Локатор номера заказа на Странице с успешным заказом
    private static final By finalInformationAboutOrder = By.xpath("//div[@class='Track_OrderInfo__2fpDL']");


    //Метод заполнения поля Имя
    public OrderPage writeNameOnNameField(String name) {
        driver.findElement(nameField).sendKeys(name);
        return this;
    }

    //Метод заполнения поля Фамилия
    public OrderPage writeSurnameOnSurnameField(String surname) {
        driver.findElement(surnameField).sendKeys(surname);
        return this;
    }

    //Метод заполнения адреса
    public OrderPage writeAddressOnAddressField(String address) {
        driver.findElement(addressField).sendKeys(address);
        return this;
    }
    //Базовый метод получения Станции метро для заполнения заказа
    public static By metroStationNumberForOrderForm(String numberOfMetroStation){
        return By.xpath(String.format(numberMetroStationFromMetroStationList, numberOfMetroStation));
    }

    //Метод  выбора станции Станции метро
    public OrderPage chooseMetroStation(String numberOfMetroStation) {
        driver.findElement(metroStationField).click();
        driver.findElement(metroStationNumberForOrderForm(numberOfMetroStation)).click();
        return this;
    }

    //Метод заполнения номер телефона
    public OrderPage writePhoneNumberField(String phoneNumber) {
        driver.findElement(phoneNumberField).sendKeys(phoneNumber);
        return this;
    }

    //Метод который наживает на кнопку далее
    public OrderPage clickOnNextButtonForNextOrderPage() {
        driver.findElement(nextButtonField).click();
        return this;
    }

    //Метод выбора даты для самоката
    public OrderPage writeOrderDate(String orderDate) {
        driver.findElement(startRentDateField).sendKeys(orderDate);
        return this;
    }

    //Метод выбора срока аренды
    public OrderPage chooseDurationOfOrder(String rentalPeriod) {
        driver.findElement(rentDurationField).click();
        driver.findElement(By.xpath(String.format(xpathRentalPeriodDropDown, rentalPeriod))).click();
        return this;
    }
    //Базовый метод для получения цвета самоката
    public static By scooterColourForMainPageFromOrderForm(String scooterColour) {
        return By.xpath(String.format(scooterColourFromMainPage, scooterColour));
    }

    //Метод клика на цвет самоката
    public OrderPage chooseColourOfScooter(String scooterColour) {
        driver.findElement(scooterColourForMainPageFromOrderForm(scooterColour)).click();
        return this;
    }

    //Метод записи комментария курьеру
    public OrderPage writeCommentForDeliveryMan(String orderComment) {
        driver.findElement(commentForCourier).sendKeys(orderComment);
        return this;
    }

    //Метод клика на итоговую кнопку заказать в конце оформления заказа
    public OrderPage  clickOnFinalOrderButton() {
        driver.findElement(orderButtonOnOrderPage).click();
        driver.findElement(yesOrderButton).click();
        return this;
    }

    //Метод клика на Посмотреть информацию о заказе
    public OrderPage clickOnOrderStatusButton() {
        driver.findElement(checkOrderStatusButton).click();
        return this;
    }

    //Метод проверки открылась ли информация об оформленном заказе самоката
    public static boolean isFinalInformationAboutOrderPageDisplayed() {
         return driver.findElement(finalInformationAboutOrder).isDisplayed();
    }

    //Метод заполнения формы заказа самоката
    public OrderPage fillOrderForScooter(OrderForm orderForm) {
        writeNameOnNameField(orderForm.getName());
        writeSurnameOnSurnameField(orderForm.getSurname());
        writeAddressOnAddressField(orderForm.getAddress());
        chooseMetroStation(orderForm.getNumberOfMetroStation());
        writePhoneNumberField(orderForm.getPhoneNumber());
        clickOnNextButtonForNextOrderPage();
        chooseDurationOfOrder(orderForm.getRentalPeriod());
        writeOrderDate(orderForm.getOrderDate());
        writeCommentForDeliveryMan(orderForm.getOrderComment());
        chooseColourOfScooter(orderForm.getScooterColour());
        return this;
    }

}
