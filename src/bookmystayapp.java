import java.util.*;

class BookingRequest {
    String guestName;
    String roomType;
    // Represents an add-on service
    class AddOnService {
        String serviceName;
        double cost;

        AddOnService(String serviceName, double cost) {
            this.serviceName = serviceName;
            this.cost = cost;
        }

        BookingRequest(String guestName, String roomType) {
            this.guestName = guestName;
            this.roomType = roomType;
            public double getCost() {
                return cost;
            }
        }

        class BookStayApp{

            // Queue for FIFO booking processing
            private Queue<BookingRequest> bookingQueue = new LinkedList<>();

            // Set to ensure unique room IDs
            private Set<String> allocatedRooms = new HashSet<>();

            // Map room type -> allocated room IDs
            private Map<String, Set<String>> roomTypeMap = new HashMap<>();
            // Manages add-on services for reservations
            class AddOnServiceManager {

                // Track room numbers per type
                private Map<String, Integer> roomCounter = new HashMap<>();
                // Map: Reservation ID -> List of services
                private Map<String, List<AddOnService>> reservationServices = new HashMap<>();

                public void addBooking(String guest, String roomType) {
                    bookingQueue.add(new BookingRequest(guest, roomType));
                    // Add service to a reservation
                    public void addService(String reservationId, AddOnService service) {
                        reservationServices
                                .computeIfAbsent(reservationId, k -> new ArrayList<>())
                                .add(service);
                    }

                    private String generateRoomId(String roomType) {
                        // Calculate total cost of services for a reservation
                        public double calculateTotalCost(String reservationId) {

                            int count = roomCounter.getOrDefault(roomType, 0) + 1;
                            roomCounter.put(roomType, count);
                            double total = 0;

                            String roomId = roomType + "-" + count;
                            List<AddOnService> services = reservationServices.get(reservationId);

                            allocatedRooms.add(roomId);

                            roomTypeMap
                                    .computeIfAbsent(roomType, k -> new HashSet<>())
                                    .add(roomId);
                            if (services != null) {
                                for (AddOnService s : services) {
                                    total += s.getCost();
                                }
                            }

                            return roomId;
                            return total;
                        }
                    }

                    public void processBookings() {

                        System.out.println("Room Allocation Processing");

                        while (!bookingQueue.isEmpty()) {
                            class BookStayApp {

                                BookingRequest request = bookingQueue.poll();
                                public static void main(String[] args) {

                                    String roomId = generateRoomId(request.roomType);
                                    AddOnServiceManager manager = new AddOnServiceManager();

                                    System.out.println(
                                            "Booking confirmed for Guest: " +
                                                    request.guestName +
                                                    ", Room ID: " +
                                                    roomId
                                    );
                                }
                            }

                            public static void main(String[] args) {
                                String reservationId = "Single-1";

                                BookStayApp service = new BookStayApp();
                                // Guest selects services
                                manager.addService(reservationId, new AddOnService("Breakfast", 500));
                                manager.addService(reservationId, new AddOnService("Airport Pickup", 1000));

                                service.addBooking("Abhi", "Single");
                                service.addBooking("Shlok", "Single");
                                service.addBooking("Vani", "Suite");
                                double totalCost = manager.calculateTotalCost(reservationId);

                                service.processBookings();
                                System.out.println("Add-On Service Selection");
                                System.out.println("Reservation ID: " + reservationId);
                                System.out.println("Total Add-On Cost: " + totalCost);
                            }
                        }