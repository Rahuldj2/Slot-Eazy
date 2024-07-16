package com.sloteazy.app.models;


import jakarta.persistence.*;

@Entity
@Table(name = "SlotBookings")
public class SlotBooking {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "slot_booking_id")
    private Long slotBookingId;

    @ManyToOne
    @JoinColumn(name = "slot_id", referencedColumnName = "slot_id")
    private Slot slot;

    @ManyToOne
    @JoinColumn(name = "assignee_id", referencedColumnName = "user_id")
    private User assignee;

    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private BookingStatus status;

    // Getters and setters
    public Long getSlotBookingId() {
        return slotBookingId;
    }

    public void setSlotBookingId(Long slotBookingId) {
        this.slotBookingId = slotBookingId;
    }

    public Slot getSlot() {
        return slot;
    }

    public void setSlot(Slot slot) {
        this.slot = slot;
    }

    public User getAssignee() {
        return assignee;
    }

    public void setAssignee(User assignee) {
        this.assignee = assignee;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }
}
