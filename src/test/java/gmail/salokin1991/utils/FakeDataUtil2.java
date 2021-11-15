package gmail.salokin1991.utils;

import com.github.javafaker.Faker;

public class FakeDataUtil2 {

    Faker faker = new Faker();

    int stateFake = faker.random().nextInt(0, 3);
    String birthDayFake = faker.date().birthday(18, 118).toString();
    String finalMonth;
    //    String finalSubject;
    String finalHobby;
    String finalGender;
    String finalState;
    String finalCity;

    public String fakeYear() {

        return birthDayFake.substring(24);
    }

    public String fakeMonth() {

        switch (birthDayFake.substring(4, 7)) {
            case "Jan":
                finalMonth = "January";
                break;
            case "Feb":
                finalMonth = "February";
                break;
            case "Mar":
                finalMonth = "March";
                break;
            case "Apr":
                finalMonth = "April";
                break;
            case "May":
                finalMonth = "May";
                break;
            case "Jun":
                finalMonth = "June";
                break;
            case "Jul":
                finalMonth = "July";
                break;
            case "Aug":
                finalMonth = "August";
                break;
            case "Sep":
                finalMonth = "September";
                break;
            case "Oct":
                finalMonth = "October";
                break;
            case "Nov":
                finalMonth = "November";
                break;
            case "Dec":
                finalMonth = "December";
                break;
        }
        return finalMonth;
    }

    public String fakeDay() {

        return birthDayFake.substring(8, 10);
    }

    public String fakeName() {

        return faker.name().firstName();
    }

    public String fakeLastName() {

        return faker.name().lastName();
    }

    public String fakeEmail() {

        return faker.internet().emailAddress();
    }

    public String fakeMobNumber() {

        return faker.phoneNumber().subscriberNumber(10);
    }

//    public String fakeSubject() {
//
//        System.out.println());
//    }

    public String fakeHobby() {

        switch (faker.random().nextInt(0, 2)) {
            case 0:
                finalHobby = "Sports";
                break;
            case 1:
                finalHobby = "Reading";
                break;
            case 2:
                finalHobby = "Music";
                break;
        }
        return finalHobby;
    }

    public String fakeAddress() {

        return faker.address().fullAddress();
    }

    public String fakeGender() {

        switch (faker.random().nextInt(0, 2)) {
            case 0:
                finalGender = "Male";
                break;
            case 1:
                finalGender = "Female";
                break;
            case 2:
                finalGender = "Other";
                break;

        }
        return finalGender;
    }

    public String fakeState() {

        switch (stateFake) {
            case 0:
                finalState = "NCR";
                break;
            case 1:
                finalState = "Uttar Pradesh";
                break;
            case 2:
                finalState = "Haryana";
                break;
            case 3:
                finalState = "Rajasthan";
                break;
        }
        return finalState;
    }

    public String fakeCity() {

        int c12 = faker.random().nextInt(0, 2);
        int c34 = faker.random().nextInt(0, 1);

        switch (stateFake) {
            case 0:
                switch (c12) {
                    case 0:
                        finalCity = "Delhi";
                        break;
                    case 1:
                        finalCity = "Gurgaon";
                        break;
                    case 2:
                        finalCity = "Noida";
                        break;
                }
                break;
            case 1:
                switch (c12) {
                    case 0:
                        finalCity = "Agra";
                        break;
                    case 1:
                        finalCity = "Lucknow";
                        break;
                    case 2:
                        finalCity = "Merrut";
                        break;
                }
                break;
            case 2:
                switch (c34) {
                    case 0:
                        finalCity = "Karnal";
                        break;
                    case 1:
                        finalCity = "Panipat";
                        break;
                }
                break;
            case 3:
                switch (c34) {
                    case 0:
                        finalCity = "Jaipur";
                        break;
                    case 1:
                        finalCity = "Jaiselmer";
                        break;
                }
                break;
        }
        return finalCity;
    }
}