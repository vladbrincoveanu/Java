import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Model {
    private static List<String> stringCollection = new ArrayList<>();
    private static List<MonitoredData> monitoredData = new ArrayList<>();

    public static void main(String args[]) {
        String fileName = "aaa.txt";
        String[] info;
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss", Locale.ENGLISH);

        //read file into stream, try-with-resources
        try (Stream<String> stream = Files.lines(Paths.get(fileName))) {
            stream.forEach(s -> stringCollection.add(s));
        } catch ( IOException e ) {
            e.printStackTrace();
        }

        //populate list with monitoredData objects
        for (String s : stringCollection) {
            info = s.split("\\t");
            monitoredData.add(new MonitoredData(LocalDateTime.parse(info[0], formatter), LocalDateTime.parse(info[2], formatter), info[4]));
        }

        //1.count distinct days that appear
        Long nbOfdates =
                monitoredData
                        .stream()
                        .map(m -> m.getStartTime().getDayOfMonth())
                        .distinct()
                        .count();

        nbOfdates = nbOfdates +
                monitoredData
                        .stream()
                        .filter(m -> m.getEndTime().getDayOfMonth() != m.getStartTime().getDayOfMonth())
                        .distinct()
                        .count();
        System.out.println(nbOfdates);

        //2.map activites by occurrences
        Map<String, Long> countActivities =
                monitoredData
                        .stream()
                        .map(MonitoredData::getActivityLabel)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        try {
            PrintWriter writer = new PrintWriter("2.txt", "UTF-8");
            countActivities.forEach((key, value) -> writer.println("Nume: " + key + " Nr aparitii: " + value));
            writer.close();
        } catch ( IOException ignored ) {
        }

        //3.Generates a data structure of type Map<Integer, Map<String, Integer>>
        // that contains the activity count for each day of the log (task number 2 applied for each day
        // of the log)and writes the result in a text file
        Map<Integer, Map<String, Long>> countAct =
                monitoredData
                        .stream()
                        .collect(Collectors.groupingBy(m -> m.getStartTime().getDayOfMonth(), Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting())));
        try {
            PrintWriter writer = new PrintWriter("3.txt", "UTF-8");
            for (Map.Entry<Integer, Map<String, Long>> a : countAct.entrySet()) {
                writer.println("Day: " + a.getKey());
                for (Map.Entry<String, Long> b : a.getValue().entrySet()) {
                    writer.println("Activity: " + b.getKey() + " Nb/day: " + b.getValue());
                }
            }
            writer.close();
        } catch ( IOException ignored ) {
        }

        //4.Determine a data structure of the form Map<String, DateTime> that maps
        //for each activity the total duration computed over the monitoring period. Filter the activities
        //with total duration larger than 10 hours. Write the result in a text file.
        Map<String, Duration> durationMap = monitoredData
                .stream()
                .collect(Collectors.groupingBy(MonitoredData::getActivityLabel,
                        Collectors.mapping(m -> Duration.between(m.getStartTime(), m.getEndTime()),
                                Collectors.reducing(Duration.ZERO, Duration::plus))));
        Map<String, Duration> durationMap1 =
                durationMap
                        .entrySet()
                        .stream()
                        .filter(m -> m.getValue().toHours() > 10)
                        .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue));
        try {
            PrintWriter writer = new PrintWriter("4.txt", "UTF-8");
            durationMap1.forEach((key, value) -> writer.println("Name :" + key + "  Total duration(hours) : " + value.toHours()));
            writer.close();
        } catch ( IOException ignored ) {
        }

        //5.Filter the activities that have 90% of the monitoring samples with duration less
        // than 5 minutes, collect the results in a List<String> containing
        // only the distinct activity names and write the result in a text file.
        Map<String, Long> totalAparition =
                monitoredData
                        .stream()
                        .map(MonitoredData::getActivityLabel)
                        .collect(Collectors.groupingBy(Function.identity(), Collectors.counting()));

        Map<String, Long> sub5Aparition =
                monitoredData
                        .stream()
                        .filter(m -> Duration.between(m.getStartTime(), m.getEndTime()).compareTo(Duration.ofMinutes(5)) < 0)
                        .collect(Collectors.groupingBy(MonitoredData::getActivityLabel, Collectors.counting()));

        List<String> results =
                sub5Aparition
                        .entrySet()
                        .stream()
                        .filter(m -> m.getValue() / totalAparition.get(m.getKey()) > 0.9)
                        .map(Map.Entry::getKey)
                        .collect(Collectors.toList());

        try {
            PrintWriter writer = new PrintWriter("5.txt", "UTF-8");
            results.forEach(a -> writer.println("Name: " + a));
            writer.close();
        } catch ( IOException ignored ) {
        }
        // results.stream().forEach(a-> System.out.println(a));
    }
}