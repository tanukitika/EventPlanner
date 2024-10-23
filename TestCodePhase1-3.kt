// Updated Contact Class with RSVPStatus Enum
data class Contact(
    val name: String,
    val email: String,
    val phone: String,
    var rsvpStatus: RSVPStatus = RSVPStatus.PENDING
)

// Updated RSVP Manager to Use RSVPStatus Enum
class RSVPManager {
    fun updateRSVP(contact: Contact, status: RSVPStatus) {
        contact.rsvpStatus = status
    }

    fun getRSVPStatus(contact: Contact): RSVPStatus {
        return contact.rsvpStatus
    }

    fun generateRSVPReport(event: Event): Map<RSVPStatus, Int> {
        val report = mutableMapOf(
            RSVPStatus.ATTENDING to 0,
            RSVPStatus.NOT_ATTENDING to 0,
            RSVPStatus.PENDING to 0
        )

        for (guest in event.guestList) {
            report[guest.rsvpStatus] = report[guest.rsvpStatus]?.plus(1) ?: 0
        }
        return report
    }
}
