import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.LinkedList;
import java.util.Scanner;

public class Spring23Final {
    private static Object IOException;

    public static void main(String[] args) throws RuntimeException, IOException {


        //Create linked lists for the habitats
        LinkedList<AnimalClass> hyenaHabitat = new LinkedList<>();
        LinkedList<AnimalClass> lionHabitat = new LinkedList<>();
        LinkedList<AnimalClass> tigerHabitat = new LinkedList<>();
        LinkedList<AnimalClass> bearHabitat = new LinkedList<>();

        String[] hyenaNames = {"Shenzi", "Banzai", "Ed", "Zig", "Bud", "Lou", "Kamari", "Wema", "Nne", "Madoa", "Prince Nevarah"};
        String[] lionNames = {"Scar", "Mufasa", "Simba", "Kiara", "King", "Drooper", "Kimba", "Nala", "Leo", "Samson", "Elsa", "Cecil"};
        String[] tigerNames = {"Tony", "Tigger", "Amber", "Cosimia", "Cuddles", "Dave", "Jiba", "Rajah", "Rayas", "Ryker"};
        String[] bearNames = {"Yogi", "Smokey", "Paddington", "Lippy", "Bungle", "Baloo", "Rupert", "Winnie the Pooh", "Snuggles", "Bert"};

        int hyenaCounter = 1;
        int lionCounter = 1;
        int tigerCounter = 1;
        int bearCounter = 1;

        File inputFile = new File("/Users/Vanessa/MyGitDir/final-program-vbarajas95/arrivingAnimals.txt");
        FileWriter writer;
        try (Scanner scanner = new Scanner(inputFile)) {
            try {
                writer = new FileWriter("zooPopulation.txt");
            } catch (java.io.IOException e) {
                throw new RuntimeException(e);
            }
            writer.write("Final Program Output by Vanessa Barajas, Spring 2023\n\n");

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] data = line.split(", ");
                String[] ageData = data[0].split(" ");

                int age = Integer.parseInt(ageData[0]);
                String sex = ageData[3];
                String species = ageData[4];
                String birthSeason = "unknown";
                String animalName = "";
                if (ageData.length == 6) {
                    birthSeason = ageData[5];
                }
                String color = data[2];
                int weight = Integer.parseInt(data[3].split("")[0]);
                String origin = data[4] + ", " + data[5];

                AnimalClass temp = new AnimalClass(species, age, sex, birthSeason, weight, origin, color);

                switch (species) {
                    case "hyena":
                        temp.setAnimalName(temp.generateName(hyenaNames));
                        hyenaHabitat.add(temp);
                        temp.setUniqueID(temp.generateID(temp.getSpecies(), hyenaCounter));
                        hyenaCounter++;
                        break;
                    case "lion":
                        temp.setAnimalName(temp.generateName(lionNames));
                        lionHabitat.add(temp);
                        temp.setUniqueID(temp.generateID(temp.getSpecies(), lionCounter));
                        lionCounter++;
                        break;
                    case "tiger":
                        temp.setAnimalName(temp.generateName(tigerNames));
                        tigerHabitat.add(temp);
                        temp.setUniqueID(temp.generateID(temp.getSpecies(), tigerCounter));
                        tigerCounter++;
                        break;
                    case "bear":
                        temp.setAnimalName(temp.generateName(bearNames));
                        bearHabitat.add(temp);
                        temp.setUniqueID(temp.generateID(temp.getSpecies(), bearCounter));
                        bearCounter++;
                        break;
                }
                temp.setBirthDate(temp.generateBirthDay(age, birthSeason));
                temp.setGetDay(temp.generateGetDay());
            }
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
        writer.write("\n\nHyena Habitat:\n\n");
        for (AnimalClass animal : hyenaHabitat) {
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nLion Habitat:\n\n");
        for (AnimalClass animal : lionHabitat) {
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nTiger Habitat:\n\n");
        for (AnimalClass animal : tigerHabitat) {
            writer.write(animal.toString() + "\n");
        }
        writer.write("\n\nBear Habitat:\n\n");
        for (AnimalClass animal : bearHabitat) {
            writer.write(animal.toString() + "\n");
        }
        writer.close();
    }
}