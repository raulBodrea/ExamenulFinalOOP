//package Test.Repo;
//
//import Domain.Car;
//import Repo.Repo;
//import org.junit.jupiter.api.Test;
//
//import static org.junit.jupiter.api.Assertions.*;
//
//class RepoTest {
//
//    @Test
//    void testRepoFunctionality() {
//        Repo repo = new Repo();
//        repo.add("id", new Car("123", 123, "asd", "11.11.1111"));
//        assertEquals(1, repo.getAll().size());
//        Car car = repo.get("id");
//        assertEquals(123, car.getPrice());
//        repo.remove("id");
//        assertEquals(0, repo.getAll().size());
//    }
//}