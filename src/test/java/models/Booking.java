package models;

import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.util.Date;

@Data
@Builder
@EqualsAndHashCode
public class Booking {
    private String firstname;
    private String lastname;
    private Number totalprice;
    private boolean depositpaid;
    private Date checkin;
    private Date checkout;
    private String additionalneeds;
}
