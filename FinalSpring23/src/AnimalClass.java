import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Random;

public class AnimalClass {
    private String uniqueID;
    private String species;
    private int age;
    private String birthDate;
    private String gender;
    private String birthSeason;
    private int weight;
    private String origin;
    private String color;
    private String animalName;
    private String getDay;

    public AnimalClass (String species, int age, String gender, String birthSeason, int weight, String origin, String color) {
        this.species = species;
        this.age = age;
        this.gender = gender;
        this.birthSeason = birthSeason;
        this.weight = weight;
        this.origin = origin;
        this.color = color;
    }
    @Override
    public String toString() {
        return uniqueID + "; " + animalName + "; " + age + " years old; birth date " + birthDate + "; " + color + "; " + gender + "; " + weight + " pounds; " + origin + "; arrived " + getDay;
    }
    public String getUniqueID() {
        return uniqueID;
    }
    public String getSpecies() {
        return species;
    }
    public int getAge() {
        return age;
    }
    public String getBirthDate() {
        return birthDate;
    }
    public String getGender() {
        return gender;
    }
    public String getBirthSeason() {
        return birthSeason;
    }
    public int getWeight() {
        return weight;
    }
    public String getOrigin() {
        return origin;
    }
    public String getColor() {
        return color;
    }
    public String getAnimalName() {
        return animalName;
    }
    public String getGetDay() {
        return getDay;
    }
    public void setUniqueID(String uniqueID) {
        this.uniqueID = uniqueID;
    }
    public void setSpecies(String species) {
        this.species = species;
    }
    public void setAge(int age) {
        this.age = age;
    }
    public void setBirthDate(String birthDate) {
        this.birthDate = birthDate;
    }
    public void setGender(String gender) {
        this.gender = gender;
    }
    public void setBirthSeason(String birthSeason) {
        this.birthSeason = birthSeason;
    }
    public void setWeight(int weight) {
        this.weight = weight;
    }
    public void setOrigin(String origin) {
        this.origin = origin;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setAnimalName(String animalName) {
        this.animalName = animalName;
    }
    public void setGetDay(String getDay) {
        this.getDay = getDay;
    }
    public String generateBirthDay(int age, String birthSeason) {
        Random random = new Random();
        int birthYear = 2023 - age;
        int birthMonth = 0;
        int birthDay = 0;

        if (birthSeason.equals("Spring")){
            birthMonth = 3 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        } else if (birthSeason.equals("Summer")) {
            birthMonth = 5 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        } else if (birthSeason.equals("Spring")) {
            birthMonth = 8 + random.nextInt(3);
            birthDay = 1 + random.nextInt(30);
        } else if (birthSeason.equals("Spring")) {
            birthMonth = 11 + random.nextInt(2);
            birthDay = 1 + random.nextInt(30);
        } else {
            birthMonth = random.nextInt(12) + 1;
            birthDay = random.nextInt(30) + 1;
        }
        if(birthMonth == 2 && (birthDay == 29 || birthDay == 30)){
            birthDay = 28;
        }
        LocalDate birthdate = LocalDate.of(birthYear, birthMonth, birthDay);
        return birthdate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
    public String generateGetDay() {
        LocalDate getDate = java.time.LocalDate.now();
        return getDate.format(DateTimeFormatter.ofPattern("MMM dd, yyyy"));
    }
    public String generateID(String species, int Counter) {
        return species.substring(0,2) + "0" + Counter;
    }
    public String generateName(String[] names) {
        Random random = new Random();
        return names[random.nextInt(names.length)];
    }
}
