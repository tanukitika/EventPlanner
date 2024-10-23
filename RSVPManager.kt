// RSVP Manager Class
class RSVPManager {
    fun updateRSVP(contact: Contact, status: RSVPStatus) {
        contact.rsvpStatus = status
    }

    fun getRSVPStatus(contact: Contact): RSVPStatus {
        return contact.rsvpStatus
    }

    fun generateRSVPReport(event: Event): Map<RSVPStatus, Int> {
        val report: MutableMap<RSVPStatus, Int> = mutableMapOf(
            RSVPStatus.ATTENDING to 0,
            RSVPStatus.NOT_ATTENDING to 0,
            RSVPStatus.PENDING to 0,
            RSVPStatus.MAYBE to 0,           // Track new statuses
            RSVPStatus.WAITLISTED to 0       // Track new statuses
        )

        for (guest in event.guestList) {
            report[guest.rsvpStatus] = report[guest.rsvpStatus]?.plus(1) ?: 0
        }

        return report
    }
}
