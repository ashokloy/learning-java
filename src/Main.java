import java.util.*;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Map<String, String > n = new HashMap<>();
        List<Employee> employeeList = new ArrayList<>();
        employeeList.add(new Employee(111, "Jiya Brein", 32, "Female", "HR", 2011, 25000.0));
        employeeList.add(new Employee(122, "Paul Niksui", 25, "Male", "Sales And Marketing", 2015, 13500.0));
        employeeList.add(new Employee(133, "Martin Theron", 29, "Male", "Infrastructure", 2012, 18000.0));
        employeeList.add(new Employee(144, "Murali Gowda", 28, "Male", "Product Development", 2014, 32500.0));
        employeeList.add(new Employee(155, "Nima Roy", 27, "Female", "HR", 2013, 22700.0));
        employeeList.add(new Employee(166, "Iqbal Hussain", 43, "Male", "Security And Transport", 2016, 10500.0));
        employeeList.add(new Employee(177, "Manu Sharma", 35, "Male", "Account And Finance", 2010, 27000.0));
        employeeList.add(new Employee(188, "Wang Liu", 31, "Male", "Product Development", 2015, 34500.0));
        employeeList.add(new Employee(199, "Amelia Zoe", 24, "Female", "Sales And Marketing", 2016, 11500.0));
        employeeList.add(new Employee(200, "Jaden Dough", 38, "Male", "Security And Transport", 2015, 11000.5));
        employeeList.add(new Employee(211, "Jasna Kaur", 27, "Female", "Infrastructure", 2014, 15700.0));
        employeeList.add(new Employee(222, "Nitin Joshi", 25, "Male", "Product Development", 2016, 28200.0));
        employeeList.add(new Employee(233, "Jyothi Reddy", 27, "Female", "Account And Finance", 2013, 21300.0));
        employeeList.add(new Employee(244, "Nicolus Den", 24, "Male", "Sales And Marketing", 2017, 10700.5));
        employeeList.add(new Employee(255, "Ali Baig", 23, "Male", "Infrastructure", 2018, 12700.0));
        employeeList.add(new Employee(266, "Sanvi Pandey", 26, "Female", "Product Development", 2015, 28900.0));
        employeeList.add(new Employee(277, "Anuj Chettiar", 31, "Male", "Product Development", 2012, 35700.0));

        List<Integer> numbers = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);
        List<String> words = Arrays.asList("apple", "banana", "cherry", "date");
        List<List<String>> listOfLists = Arrays.asList(Arrays.asList("one","two"), Arrays.asList("three", "four"));
        List<Integer> numbersDup = Arrays.asList(1, 1, 2, 2, 3, 4);
        List<String> wordsTwo = Arrays.asList("John", "Aryan", "Bob");

        /*convertListToMap(employeeList);
        collectorGroupingBy(employeeList);
        countMaleAndFemaleEmployees(employeeList);
        printAllDepartment(employeeList);
        avgAgeOfMaleAndFemale(employeeList);
        getHighestPaidEmployee(employeeList);
        getEmpWhoJoinedAfter2015(employeeList);
        getCountOfNumOfEmpInEachDept(employeeList);
        getAvgSalaryOfEachDept(employeeList);
        youngMaleEmpInProductDevDept(employeeList);
        mostExpPersonInOrg(employeeList);
        fetchAllNumberGreaterThanFive(numbers);
        transformStringIntoUpperCase(words);
        transformListOfLists(listOfLists);
        removeDuplicateNumbers(numbersDup);
        sortTheElements(wordsTwo);
        printElementToUpperCaseUsePeek(words);
        limitElement(numbers);
        skipTheElements(numbers);
        useForEach(words);
        useReduce(numbersDup);
        useAllMatch(numbers);
        useAnyMatch(numbers);
        userFindFirst(words);
        userFindAny(words);
        findMax(numbers);
        findMin(numbers);
        convertToArray(words);
        useJoiningBy(words);
        usePartitioningBy(numbers);
        useCounting(words);
        useSummarizingInt(numbers);
        useMapping(words);
        useMappingOnEmployee(employeeList);
        useJoining(words);
        useGrouping(words);
        useFiltering(numbers);
        useCollectingAndThen(employeeList);
        useMappingAgain(words);
        createConcurrentMap(words);*/
    }

    private static void createConcurrentMap(List<String> words) {
        System.out.println(words.stream().collect(Collectors.toConcurrentMap(Function.identity(), String::length)));
    }

    private static void useMappingAgain(List<String> words) {
        IntSummaryStatistics summaryStatistics = words.stream().map(String::length).collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics.getSum()
        );
    }

    private static void useCollectingAndThen(List<Employee> employeeList) {
        List<String> empNameList = employeeList.stream().map(Employee::getName).collect(Collectors.collectingAndThen(Collectors.toList(), Collections::unmodifiableList));
        empNameList.forEach(System.out::println);
    }

    private static void useFiltering(List<Integer> numbers) {
        List<Integer> filterList = numbers.stream().collect(Collectors.filtering(num -> num % 2 != 0, Collectors.toList()));
        System.out.println(filterList);
    }

    private static void useGrouping(List<String> words) {
        Map<Integer, Long> mapEle = words.stream().collect(Collectors.groupingBy(String::length, Collectors.counting()));
        /*mapEle.forEach((k, v)-> System.out.println(k +": "+v));*/
        System.out.println(mapEle);
    }

    private static void useJoining(List<String> words) {
        System.out.println(words.stream().collect(Collectors.joining(", ", "{", "}")));
    }

    private static void useMappingOnEmployee(List<Employee> employeeList) {
        List<String> listName = employeeList.stream().map(Employee::getName).collect(Collectors.toList());
        System.out.println(listName);
    }

    private static void useMapping(List<String> words) {
        List<Integer> sizeList = words.stream().collect(Collectors.mapping(String::length, Collectors.toList()));
        System.out.println(sizeList);
    }

    private static void useSummarizingInt(List<Integer> numbers) {
        IntSummaryStatistics summaryStatistics = numbers.stream().collect(Collectors.summarizingInt(Integer::intValue));
        System.out.println(summaryStatistics);
    }

    private static void useCounting(List<String> words) {
        long totalCount = words.stream().collect(Collectors.counting());
        System.out.println(totalCount);
    }

    private static void usePartitioningBy(List<Integer> numbers) {
        Map<Boolean, List<Integer>> partMap = numbers.stream().collect(Collectors.partitioningBy(n -> n % 2 == 0));
        System.out.println("Even numbers: "+partMap.get(true));
        System.out.println("Odd numbers: "+partMap.get(false));
    }

    private static void useJoiningBy(List<String> words) {
        System.out.println(words.stream().collect(Collectors.joining(":")));
    }

    private static void convertToArray(List<String> words) {
        String [] res = words.stream().toArray(String[]::new);
        System.out.println(res[0]);
    }

    private static void findMin(List<Integer> numbers) {
        System.out.println(numbers.stream().min(Integer::compareTo));
    }

    private static void findMax(List<Integer> numbers) {
        System.out.println(numbers.stream().max(Integer::compareTo));
    }

    private static void userFindAny(List<String> words) {
        System.out.println(words.stream().filter(w -> w.startsWith("c")).findAny());
    }

    private static void userFindFirst(List<String> words) {
        System.out.println(words.stream().filter(w->w.startsWith("b")).findFirst());
    }

    private static void useAnyMatch(List<Integer> numbers) {
        System.out.println(numbers.stream().anyMatch(n -> n > 9));
    }

    private static void useAllMatch(List<Integer> numbers) {
        System.out.println(numbers.stream().allMatch(n->n > 0));
    }

    private static void useReduce(List<Integer> numbersDup) {
        System.out.println(numbersDup.stream().reduce(Integer::sum));
    }

    private static void useForEach(List<String> words) {
        words.forEach(System.out::println);
    }

    private static void skipTheElements(List<Integer> numbers) {
        System.out.println(numbers.stream().skip(4).toList());
    }

    private static void limitElement(List<Integer> numbers) {
        System.out.println(numbers.stream().limit(3).toList());
    }

    private static void printElementToUpperCaseUsePeek(List<String> words) {
        System.out.println(words.stream().peek(System.out::println).map(String::toUpperCase).toList());
    }

    private static void sortTheElements(List<String> wordsTwo) {
        System.out.println(wordsTwo.stream().sorted(Comparator.reverseOrder()).toList());
    }

    private static void removeDuplicateNumbers(List<Integer> numbersDup) {
        System.out.println(numbersDup.stream().distinct().toList());
    }

    private static void transformListOfLists(List<List<String>> listOfLists) {
        System.out.println(listOfLists.stream().flatMap(Collection::stream).toList());
    }

    private static void transformStringIntoUpperCase(List<String> words) {
        System.out.println(words.stream().map(String::toUpperCase).toList());
    }

    private static void fetchAllNumberGreaterThanFive(List<Integer> numbers) {
        System.out.println(numbers.stream().filter(n -> n > 5).toList());
    }

    private static void mostExpPersonInOrg(List<Employee> employeeList) {
        Optional<Employee> employee = employeeList.stream().sorted(Comparator.comparing(Employee::getYearOfJoining)).findFirst();
        employee.ifPresent(System.out::println);
    }

    private static void youngMaleEmpInProductDevDept(List<Employee> employeeList) {
        Optional<Employee> empObj = employeeList.stream().filter(emp -> emp.getGender().equals("Male") && emp.getDepartment().equals("Product Development")).min(Comparator.comparingInt(Employee::getAge));
        empObj.ifPresent(System.out::println);
    }

    private static void getAvgSalaryOfEachDept(List<Employee> employeeList) {
        Map<String, Double> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.averagingDouble(Employee::getSalary)));
        empMap.forEach((k, v)-> System.out.println(k +": "+v));
    }

    private static void getCountOfNumOfEmpInEachDept(List<Employee> employeeList) {
        Map<String, Long> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment, Collectors.counting()));
        empMap.forEach((dept, count)-> System.out.println(dept +": "+ count));
    }

    private static void getEmpWhoJoinedAfter2015(List<Employee> employeeList) {
        employeeList.stream().filter(employee -> employee.getYearOfJoining() > 2015).toList().stream().sorted(Comparator.comparing(Employee::getName)).forEach(System.out::println);
    }

    private static void getHighestPaidEmployee(List<Employee> employeeList) {
        employeeList.stream().max(Comparator.comparingDouble(Employee::getSalary)).ifPresent(System.out::println);
    }

    private static void avgAgeOfMaleAndFemale(List<Employee> employeeList) {
        Map<String, Double> avgAgeMaleAndFemale = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.averagingInt(Employee::getAge)));
        avgAgeMaleAndFemale.forEach((key, value)-> System.out.println(key+": "+value));
    }

    private static void printAllDepartment(List<Employee> employeeList) {
        Set<String> deptList = employeeList.stream().map(Employee::getDepartment).collect(Collectors.toSet());
        deptList.stream().sorted().forEach(System.out::println);
    }

    private static void countMaleAndFemaleEmployees(List<Employee> employeeList) {
        Map<String, Long> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getGender, Collectors.counting()));
        empMap.forEach((gender, count) -> {
            System.out.println(gender);
            System.out.println(count);
        });
    }

    private static void convertListToMap(List<Employee> employeeList) {
        Map<Integer, Employee> empMap = employeeList.stream().collect(Collectors.toMap(Employee::getId, employee -> employee));
        System.out.println(empMap);
    }

    private static void collectorGroupingBy(List<Employee> employeeList) {
        Map<String, List<Employee>> empMap = employeeList.stream().collect(Collectors.groupingBy(Employee::getDepartment));
        empMap.forEach((emp, empList) -> {
            System.out.println(emp);
            System.out.println(empList);
        });

    }

    private static void testStreamApi() {
        List<Integer> intList = List.of(50, 35, 65, 25, 15, 35);
        System.out.println("\n" + "--------findFirst");
        intList.stream().findFirst().ifPresent(System.out::println);
        System.out.println("\n" + "--------even numbers");
        intList.stream().filter(n -> n % 2 == 0).forEach(System.out::println);
        System.out.println("\n" + "--------odd numbers");
        intList.stream().filter(n -> n % 2 != 0).forEach(System.out::println);
        System.out.println("\n" + "--------");
        intList.stream().filter(n -> n.toString().endsWith("5")).forEach(System.out::println);
        System.out.println("\n" + "--------duplaicates");
        Set<Integer> mySet = new HashSet<>();
        intList.stream().filter(n -> !mySet.add(n)).forEach(System.out::println);
        System.out.println("\n" + "--------");
        Optional<Integer> maxEle = intList.stream().max(Integer::compareTo);
        Optional<Integer> minEle = intList.stream().min(Integer::compareTo);
        System.out.println("Max is :" + maxEle.orElse(null) + " Min is : " + minEle.orElse(null));
        System.out.println("\n" + "--------");
        intList.stream().sorted(Comparator.naturalOrder()).forEach(System.out::println);
        System.out.println("\n" + "--------");
        intList.stream().sorted(Comparator.reverseOrder()).forEach(System.out::println);
        System.out.println("\n" + "--------");
        int[] intArray = {1, 3, 2};
        System.out.println(Arrays.stream(intArray).distinct().count() != intArray.length ? "Duplicates Present" : "Duplcates not present");
        System.out.println("\n" + "--------");
        intList.stream().map(n -> n * n).filter(n -> n > 400).forEach(System.out::println);
        System.out.println("\n" + "--------");
        Arrays.sort(intArray);
        Arrays.stream(intArray).forEach(System.out::println);
        System.out.println("\n" + "--------");
        List<String> listStr = List.of("Dev", "Test", "Support");
        listStr.stream().map(String::toUpperCase).forEach(System.out::println);
        System.out.println("\n" + "--------");
        Arrays.stream(intArray).max().ifPresent(System.out::println);
        System.out.println("\n" + "--------");
        Stream<Integer> s1 = Stream.of(1, 2, 3);
        Stream<Integer> s2 = Stream.of(6, 4, 5);
        Stream.concat(s1, s2).forEach(System.out::println);
    }


    private static void test() {
        /*System.out.println("Hello, World!");
        String s = "Test Ashok";
        System.out.println(s.replace("Aok", "Anu"));
        String s1 = "Test";
        System.out.println(s.equals(s1));
        List<String> listOfStr = List.of("Name1", "Name4", "Name3", "Name2", "Name5");
        System.out.println();*/
        BiConsumer<String, String> biConsumer = (a, b) -> {
            System.out.println(a + b);
        };
        biConsumer.accept("Hello", "Ashok");

        BiFunction<Integer, Float, Float> biFunction = (d, e) -> (d + e);
        Float f = biFunction.apply(1, 2.5f);
        System.out.println(f);
    }

}