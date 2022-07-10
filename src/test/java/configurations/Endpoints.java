package configurations;

public class Endpoints {

    public static final String POST_CREATE_TOKEN = "/auth";
    public static final String POST_CREATE_BOOKING = "/booking";
    public static final String GET_BOOKING_IDS = "/booking";
    public static final String GET_BOOKING = "/booking/:id";
    public static final String PUT_UPDATE_BOOKING = "/booking/{bookingid}";
    public static final String PATCH_PARTIAL_UPDATE_BOOKING = "/booking/:id";
    public static final String DELETE_BOOKING = "/booking/{bookingid}";
}
