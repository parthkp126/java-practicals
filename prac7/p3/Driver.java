public class Driver {
    public static void main(String[] args)
            throws ReflectiveOperationException {
        String[] headers = {"name", "age"};
        String[] values = {"Riya", "20"};

        StudentRow student =
                ColumnMapper.map(headers, values, StudentRow.class);

        System.out.println(student);
    }
}