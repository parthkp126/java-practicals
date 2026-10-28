class SampleResource implements AutoCloseable {
    public void use() throws Exception {
        System.out.println("Using resource.");
        throw new Exception("Example error inside resource block.");
    }

    @Override
    public void close() {
        System.out.println("Resource closed.");
    }
}

public class Driver {
    public static void main(String[] args) {
        try (SampleResource resource = new SampleResource()) {
            resource.use();
        } catch (Exception exception) {
            System.out.println("Caught: " + exception.getMessage());
        }
    }
}